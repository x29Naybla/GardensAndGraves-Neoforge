package com.x29naybla.gardensandgraves.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class Peashooting extends Plant {
    protected static final EntityDataAccessor<Boolean> SHOOTING = SynchedEntityData.defineId(PeashooterEntity.class, EntityDataSerializers.BOOLEAN);

    public Peashooting(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOTING, false);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        getEntityData().set(SHOOTING, compound.getBoolean("Shooting"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
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
