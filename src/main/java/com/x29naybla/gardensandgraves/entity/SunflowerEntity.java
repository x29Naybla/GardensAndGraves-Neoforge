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

public class SunflowerEntity extends SolarPlant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.flower.idle");
    protected static final RawAnimation GENERATE = RawAnimation.begin().thenPlayAndHold("animation.flower.generate");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public SunflowerEntity(EntityType<? extends SunflowerEntity> entityType, Level level) {
        super(entityType, level, ModItems.SEED_PACKET_SUNFLOWER.toStack(), ModItems.POTTED_SUNFLOWER.toStack());
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new ModGenerateSunGoal(this, true, false));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends SunflowerEntity> PlayState animController(final AnimationState<E> event) {
        if (this.isGenerated()) {
            event.setAnimation(GENERATE);

            return PlayState.CONTINUE;
        } else
            event.setAnimation(IDLE);

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
