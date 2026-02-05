package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.entity.goal.ChompGoal;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
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
    public static final EntityDataAccessor<Integer> CHEWING = SynchedEntityData.defineId(ChomperEntity.class, EntityDataSerializers.INT);
    public final int maxChewTime = 350;

    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chomper.idle");
    protected static final RawAnimation CHOMP = RawAnimation.begin().thenPlay("animation.chomper.chomp");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public ChomperEntity(EntityType<? extends Plant> entityType, Level level) {
        super(entityType, level, BnDTags.Items.SUSTAINS_CHOMPERS, BnDItems.CHOMPER_SEED_PACKET.toStack(), null);
    }

    //Goals and AI
    protected void registerGoals(){
        goalSelector.addGoal(1, new ChompGoal(this, 2.0d));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        if (!level().isClientSide) {
            if (getChewing() >= 1) {
                setChewing(getChewing()-1);
            } else
                setChewing(0);
        }
        super.tick();
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends ChomperEntity> PlayState animController(final AnimationState<E> event) {
        if (getChewing() > 15) {
            event.setAnimation(CHOMP.thenLoop("animation.chomper.chew"));
        } else
            event.setAnimation(IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    //Data
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CHEWING, 0);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Chewing")) {
            setChewing(compound.getInt("Chewing"));
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Chewing", getEntityData().get(CHEWING));
    }

    public int getChewing() {
        return entityData.get(CHEWING);
    }

    public void setChewing(int chomping) {
        entityData.set(CHEWING, chomping);
    }

    public boolean isNotChewing() {
        return entityData.get(CHEWING) == 0;
    }

    public void startChewing() {
        entityData.set(CHEWING, maxChewTime);
    }

    public void eat(Entity entity) {
        entity.kill();
        entity.remove(RemovalReason.KILLED);
    }
}
