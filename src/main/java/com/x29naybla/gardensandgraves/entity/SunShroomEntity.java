package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.entity.goal.ModGenerateSunGoal;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SunShroomEntity extends SolarPlant {
    protected static final RawAnimation GENERATE = RawAnimation.begin().thenLoop("animation.flower.generate");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public SunShroomEntity(EntityType<? extends SunShroomEntity> entityType, Level level) {
        super(entityType, level, ModItems.SEED_PACKET_SUN_SHROOM.toStack(), ModItems.POTTED_SUN_SHROOM.toStack());
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ModGenerateSunGoal(this, false, false));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends SunShroomEntity> PlayState animController(final AnimationState<E> event) {
        if (this.isGenerated()) {
            event.setAnimation(GENERATE);

            return PlayState.CONTINUE;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    //Data
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
