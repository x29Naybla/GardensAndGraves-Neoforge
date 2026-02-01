package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.registry.ModDamageTypes;
import com.x29naybla.bloom_and_doom.common.registry.ModDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.entity.goal.ModExplosionDamageCalculator;
import com.x29naybla.bloom_and_doom.common.entity.goal.ModSwellGoal;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ExplosivePlant extends Plant{
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR;
    private int oldSwell;
    private int swell;
    private int maxSwell = 20;
    private int explosionRadius;
    private final int damage;
    private final Holder<SoundEvent> sound;

    //Properties
    public ExplosivePlant(EntityType<? extends ExplosivePlant> entityType, Level level, TagKey<Item> substrate, ItemStack seedPacket, @Nullable ItemStack pottedItem, int explosionRadius, int damage, Holder<SoundEvent> sound) {
        super(entityType, level, substrate, seedPacket, pottedItem);
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
        this.explosionRadius = explosionRadius;
        this.damage = damage;
        this.sound = sound;
        this.sound.value().getRange(2);
    }

    //Goals and AI
    protected void registerGoals(){
        goalSelector.addGoal(1, new ModSwellGoal(this));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false,
                (target) -> target instanceof LivingEntity livingEntity && (livingEntity.getType().is(ModTags.Entities.PLANT_ENEMIES) || livingEntity.getData(ModDataAttachments.ZOMBIE))));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
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
        if (this instanceof PotatoMineEntity potatoMine && !potatoMine.getArmed() || this.isBaby()){
            return;
        }
        if (target != null && (target.hasData(ModDataAttachments.ZOMBIE) || target.getType().is(ModTags.Entities.PLANT_ENEMIES))) {
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
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_SWELL_DIR, -1);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putShort("Fuse", (short)this.maxSwell);
        compound.putByte("ExplosionRadius", (byte)this.explosionRadius);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
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
