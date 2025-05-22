package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.data.ModDamageTypes;
import com.x29naybla.gardensandgraves.data.ModDataAttachments;
import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.goal.ModExplosionDamageCalculator;
import com.x29naybla.gardensandgraves.entity.goal.ModSwellGoal;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public class ExplosivePlant extends Plant{
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR;
    private int oldSwell;
    private int swell;
    private int maxSwell = 20;
    private int explosionRadius;
    private int damage;
    private Holder<SoundEvent> sound;

    //Properties
    public ExplosivePlant(EntityType<? extends ExplosivePlant> entityType, Level level, ItemStack seedPacket, @Nullable ItemStack pottedItem, int explosionRadius, int damage, Holder<SoundEvent> sound) {
        super(entityType, level, seedPacket, pottedItem);
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
        this.explosionRadius = explosionRadius;
        this.damage = damage;
        this.sound = sound;
        this.sound.value().getRange(2);
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new ModSwellGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, LivingEntity.class, 10, false, false,
                (target) -> target instanceof LivingEntity livingEntity && (livingEntity.getType().is(ModTags.Entities.PLANT_ENEMIES) || livingEntity.getData(ModDataAttachments.ZOMBIE).booleanValue())));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    public void tick() {
        if (this.isAlive()) {
            this.oldSwell = this.swell;

            int i = this.getSwellDir();
            if (i > 0 && this.swell == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                this.gameEvent(GameEvent.PRIME_FUSE);
            }

            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }

            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.explode();
            }
        }

        super.tick();
    }

    public void setTarget(@Nullable LivingEntity target) {
        boolean canExplode = true;
        if (this instanceof PotatoMineEntity){
            PotatoMineEntity entity = (PotatoMineEntity) this;
            if(!entity.armed) {
                canExplode = false;
            }
        }
        if (!(target == null) && (target.hasData(ModDataAttachments.ZOMBIE) || target.getType().is(ModTags.Entities.PLANT_ENEMIES)) && canExplode) {
            super.setTarget(target);
        }
    }

    private void explode() {
        ModExplosionDamageCalculator damageCalculator = new ModExplosionDamageCalculator();
        damageCalculator.setDamage(damage);

        if (!this.level().isClientSide) {
            this.dead = true;
            this.level().explode(this, this.damageSources().source(ModDamageTypes.PLANT_EXPLOSION), damageCalculator, this.getX(), this.getY(), this.getZ(), this.explosionRadius, false, Level.ExplosionInteraction.NONE, ParticleTypes.EXPLOSION, ParticleTypes.EXPLOSION, sound);
            this.triggerOnDeathMobEffects(RemovalReason.KILLED);
            this.discard();
        }

    }

    //Data
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_SWELL_DIR, -1);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putShort("Fuse", (short)this.maxSwell);
        compound.putByte("ExplosionRadius", (byte)this.explosionRadius);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Fuse", 99)) {
            this.maxSwell = compound.getShort("Fuse");
        }

        if (compound.contains("ExplosionRadius", 99)) {
            this.explosionRadius = compound.getByte("ExplosionRadius");
        }

    }

    public float getSwelling(float partialTicks) {
        return Mth.lerp(partialTicks, this.oldSwell, this.swell) / (this.maxSwell - 2);
    }

    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }

    public void setSwellDir(int state) {
        this.entityData.set(DATA_SWELL_DIR, state);
    }

    static {
        DATA_SWELL_DIR = SynchedEntityData.defineId(ExplosivePlant.class, EntityDataSerializers.INT);
    }
}
