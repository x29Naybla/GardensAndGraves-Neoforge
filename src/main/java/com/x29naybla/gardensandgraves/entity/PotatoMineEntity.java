package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.goal.ModSwellGoal;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PotatoMineEntity extends ExplosivePlant {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    protected static final RawAnimation ARMING = RawAnimation.begin().thenPlay("animation.potato_mine.arming");
    protected static final EntityDataAccessor<Boolean> ARMED = SynchedEntityData.defineId(PotatoMineEntity.class, EntityDataSerializers.BOOLEAN);

    public int armingTime = 0;
    public boolean armed;

    public PotatoMineEntity(EntityType<? extends PotatoMineEntity> entityType, Level level) {
        super(entityType, level, ModItems.SEED_PACKET_POTATO_MINE.toStack(), ModItems.POTTED_POTATO_MINE.toStack(), 1, 180, ModSounds.SPUDOW);
        this.armed = false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherparent) {;
        return ModEntities.POTATO_MINE.get().create(level);
    }

    public void tick() {
        if(this.isAlive()){
            if (!this.armed){
                this.armingTime += 1;
            }

            if (this.armingTime < 0) {
                this.armingTime = 0;
            }

            int maxArmingTime = 40;
            if (this.armingTime >= maxArmingTime){
                this.armingTime = maxArmingTime;
                this.armed = true;
                this.setArmed(true);
            }
        }
        super.tick();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends PotatoMineEntity> PlayState animController(final AnimationState<E> event) {
        if (!armed){
            event.setAnimation(ARMING);
        }
        return PlayState.CONTINUE;
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new ModSwellGoal(this));
        this.goalSelector.addGoal(2, new FloatGoal(this));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Mob.class, 10, false, false, (target) -> target instanceof Entity entity && entity.getType().is(ModTags.Entities.PLANT_ENEMIES)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    public void setArmed(boolean bool) {
        getEntityData().set(ARMED, bool);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ARMED, this.armed);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        getEntityData().set(ARMED, compound.getBoolean("Armed"));
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Armed", getEntityData().get(ARMED));
    }
}
