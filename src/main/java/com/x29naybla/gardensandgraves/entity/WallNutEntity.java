package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WallNutEntity extends Plant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.wall_nut.idle");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public WallNutEntity(EntityType<? extends WallNutEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return ModItems.SEED_PACKET_WALL_NUT.toStack();
    }

    public boolean canCollideWith(Entity entity) {
        return canWallNutCollide(this, entity);
    }

    public static boolean canWallNutCollide(Entity wall_nut, Entity entity) {
        return (entity.canBeCollidedWith() || entity.isPushable());
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherparent) {;
        return ModEntities.WALL_NUT.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends WallNutEntity> PlayState animController(final AnimationState<E> event) {
        event.setAnimation(IDLE);

        return PlayState.CONTINUE;
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}
