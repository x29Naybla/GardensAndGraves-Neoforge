package com.x29naybla.bloom_and_doom.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SolarPlant extends Plant{
    protected static final EntityDataAccessor<Boolean> GENERATED = SynchedEntityData.defineId(SolarPlant.class, EntityDataSerializers.BOOLEAN);
    public boolean canBaby;
    public int sunTime;
    public final int maxSunTime = 960;

    //Properties
    public SolarPlant(EntityType<? extends SolarPlant> entityType, Level level, TagKey<Item> substrate, ItemStack seedPacket, @Nullable ItemStack pottedItem, Boolean canBaby) {
        super(entityType, level, substrate, seedPacket, pottedItem);
        this.sunTime = maxSunTime;
        this.canBaby = canBaby;
    }

    //Data
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GENERATED, false);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        getEntityData().set(GENERATED, compound.getBoolean("Generated"));
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Generated", getEntityData().get(GENERATED));
    }

    public boolean isGenerated(){
        return getEntityData().get(GENERATED);
    }

    public void setGenerated(boolean bool) {
        getEntityData().set(GENERATED, bool);
    }
}
