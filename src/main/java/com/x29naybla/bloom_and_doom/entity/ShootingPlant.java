package com.x29naybla.bloom_and_doom.entity;

import com.x29naybla.bloom_and_doom.data.ModDataAttachments;
import com.x29naybla.bloom_and_doom.data.ModTags;
import com.x29naybla.bloom_and_doom.entity.goal.ModShootGoal;
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

import javax.annotation.Nullable;

public class ShootingPlant extends Plant implements RangedAttackMob {
    protected static final EntityDataAccessor<Boolean> SHOOTING = SynchedEntityData.defineId(ShootingPlant.class, EntityDataSerializers.BOOLEAN);

    //Properties
    public ShootingPlant(EntityType<? extends ShootingPlant> entityType, Level level, TagKey<Item> substrate, ItemStack seedPacket, @Nullable ItemStack pottedItem) {
        super(entityType, level, substrate, seedPacket, pottedItem);
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new ModShootGoal(this, 1, 1.25F, 30, 8.5F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, LivingEntity.class, 10, false, false,
                (target) -> target instanceof LivingEntity livingEntity && (livingEntity.getType().is(ModTags.Entities.PLANT_ENEMIES) || livingEntity.getData(ModDataAttachments.ZOMBIE).booleanValue())));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
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
