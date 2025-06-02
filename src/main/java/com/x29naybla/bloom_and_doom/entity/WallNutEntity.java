package com.x29naybla.bloom_and_doom.entity;

import com.x29naybla.bloom_and_doom.data.ModTags;
import com.x29naybla.bloom_and_doom.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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
        super(entityType, level, ModTags.Items.SUSTAINS_WALL_NUTS, ModItems.SEED_PACKET_WALL_NUT.toStack(), null);
    }

    public boolean canCollideWith(@NotNull Entity entity) {
        return canWallNutCollide(this, entity);
    }

    public static boolean canWallNutCollide(Entity wall_nut, Entity entity) {
        return (entity.canBeCollidedWith() || entity.isPushable());
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
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
