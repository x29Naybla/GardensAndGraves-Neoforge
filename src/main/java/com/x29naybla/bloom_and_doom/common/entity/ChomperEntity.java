package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.entity.goal.ChompGoal;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ChomperEntity extends Plant {
    public static final EntityDataAccessor<Integer> CHOMPING = SynchedEntityData.defineId(ChomperEntity.class, EntityDataSerializers.INT);

    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chomper.idle");
    protected static final RawAnimation CHOMP = RawAnimation.begin().thenPlay("animation.chomper.chomp").thenPlayXTimes("animation.chomper.chew", 22);

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public ChomperEntity(EntityType<? extends Plant> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_CHOMPERS, ModItems.CHOMPER_SEED_PACKET.toStack(), null);
    }

    protected void registerGoals(){
        goalSelector.addGoal(1, new ChompGoal(this, 2.0d));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CHOMPING, 0);
    }

    @Override
    public void tick() {
        if (!level().isClientSide && tickCount % 20 == 0) {
            int chomping = getChomping();
            if (chomping > 0) {
                setChomping(chomping - 1);
            }

        }
        super.tick();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends ChomperEntity> PlayState animController(final AnimationState<E> event) {
        event.setAnimation(getChomping() > 15 ? CHOMP : IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        tag.putInt("Chomping", getChomping());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        setChomping(tag.getInt("Chomping"));
    }

    public int getChomping() {
        return entityData.get(CHOMPING);
    }

    public void setChomping(int chomping) {
        entityData.set(CHOMPING, chomping);
    }

    public boolean isNotChomping() {
        return entityData.get(CHOMPING) == 0;
    }

    public void startChomping() {
        entityData.set(CHOMPING, 50);
    }

    public void eat(Entity entity) {
        entity.remove(RemovalReason.KILLED);
    }
}
