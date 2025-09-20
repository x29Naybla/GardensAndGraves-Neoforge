package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class BonkChoyEntity extends Plant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chomper.idle");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public BonkChoyEntity(EntityType<? extends Plant> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_BONK_CHOYS, ModItems.CHOMPER_SEED_PACKET.toStack(), null);
    }

    //Goals and AI
    protected void registerGoals(){
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends BonkChoyEntity> PlayState animController(final AnimationState<E> event) {
        event.setAnimation(IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}
