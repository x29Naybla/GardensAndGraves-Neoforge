package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.registry.ModDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.entity.goal.PlantShootGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class ShootingPlant extends Plant implements RangedAttackMob {
    protected static final EntityDataAccessor<Boolean> SHOOTING = SynchedEntityData.defineId(ShootingPlant.class, EntityDataSerializers.BOOLEAN);

    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.peashooter.idle");
    protected static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("animation.peashooter.shoot");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    //Properties
    public ShootingPlant(EntityType<? extends ShootingPlant> entityType, Level level, TagKey<Item> substrate, ItemStack seedPacket, @Nullable ItemStack pottedItem) {
        super(entityType, level, substrate, seedPacket, pottedItem);
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new PlantShootGoal(this, 1.5F, 20, 8));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, false, false,
                (target) -> target instanceof LivingEntity livingEntity && (livingEntity.getType().is(ModTags.Entities.PLANT_ENEMIES) || livingEntity.getData(ModDataAttachments.ZOMBIE))));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends ShootingPlant> PlayState animController(final AnimationState<E> event) {
        if(this.isShooting()){
            event.setAnimation(SHOOT);
            return PlayState.CONTINUE;

        }else
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
        builder.define(SHOOTING, false);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        getEntityData().set(SHOOTING, compound.getBoolean("Shooting"));
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Shooting", getEntityData().get(SHOOTING));
    }

    public boolean isShooting(){
        return getEntityData().get(SHOOTING);
    }

    public void setShooting(boolean bool) {
        getEntityData().set(SHOOTING, bool);
    }
}
