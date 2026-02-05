package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import com.x29naybla.bloom_and_doom.common.entity.goal.PlantGenerateSunGoal;
import com.x29naybla.bloom_and_doom.common.registry.BnDSounds;
import net.minecraft.world.entity.EntityType;
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
        super(entityType, level, BnDTags.Items.SUSTAINS_SUNFLOWERS, BnDItems.SUNFLOWER_SEED_PACKET.toStack(), BnDItems.POTTED_SUNFLOWER.toStack(), false);
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new PlantGenerateSunGoal(this, BnDSounds.SUNFLOWER_SUN.get()));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
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
        }
        event.setAnimation(IDLE);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}
