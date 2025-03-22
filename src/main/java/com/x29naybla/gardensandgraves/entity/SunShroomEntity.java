package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SunShroomEntity extends Plant implements GeoEntity {
    protected static final RawAnimation GENERATE = RawAnimation.begin().thenLoop("animation.flower.generate");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public int sunTime;

    public SunShroomEntity(EntityType<? extends SunShroomEntity> entityType, Level level) {
        super(entityType, level);
        this.sunTime = 6000;
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return ModItems.SEED_PACKET_SUN_SHROOM.toStack();
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherparent) {;
        return ModEntities.SUN_SHROOM.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends SunShroomEntity> PlayState animController(final AnimationState<E> event) {
        if (this.sunTime <= 20) {
            event.setAnimation(GENERATE);
        }

        return PlayState.CONTINUE;
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide && this.isAlive() && this.level().isNight() && --this.sunTime <= 0) {
            this.playSound(ModSounds.THROW.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(ModItems.SUN);
            if (!this.isBaby()){
                this.spawnAtLocation(ModItems.SUN);
            }
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.sunTime = 6000;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("SunGenerateTime")) {
            this.sunTime = compound.getInt("SunGenerateTime");
        }

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("SunGenerateTime", this.sunTime);
    }
}
