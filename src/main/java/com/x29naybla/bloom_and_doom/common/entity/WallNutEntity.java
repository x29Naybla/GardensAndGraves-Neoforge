package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WallNutEntity extends Plant {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public WallNutEntity(EntityType<? extends WallNutEntity> entityType, Level level) {
        super(entityType, level, BnDTags.Items.SUSTAINS_WALL_NUTS, BnDItems.WALL_NUT_SEED_PACKET.toStack(), null);
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        return canWallNutCollide(entity);
    }

    public static boolean canWallNutCollide(Entity entity) {
        return (entity.canBeCollidedWith() || entity.isPushable());
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends WallNutEntity> PlayState animController(final AnimationState<E> event) {
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}
