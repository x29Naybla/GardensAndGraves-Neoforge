package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.entity.goal.ModGenerateSunGoal;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SunShroomEntity extends SolarPlant {
    protected static final RawAnimation GENERATE = RawAnimation.begin().thenLoop("animation.flower.generate");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public SunShroomEntity(EntityType<? extends SunShroomEntity> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_SUN_SHROOMS, ModItems.SEED_PACKET_SUN_SHROOM.toStack(), ModItems.POTTED_SUN_SHROOM.toStack(), true);
        this.isMushroom = true;
        this.sunTime = maxSunTime*2;
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ModGenerateSunGoal(this, ModSounds.SUN_SHROOM_SUN.get()));
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
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("SunGenerateTime")) {
            this.sunTime = compound.getInt("SunGenerateTime");
        }

    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("SunGenerateTime", this.sunTime);
    }
}
