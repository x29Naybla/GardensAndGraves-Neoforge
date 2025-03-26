package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.goal.ModShootGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

public class Peashooting extends Plant implements RangedAttackMob {
    protected static final EntityDataAccessor<Boolean> SHOOTING = SynchedEntityData.defineId(Peashooting.class, EntityDataSerializers.BOOLEAN);

    public Peashooting(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new ModShootGoal(this, 1, 1.25F, 30, 8.5F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Mob.class, 10, true, false, (target) -> target instanceof Entity entity && entity.getType().is(ModTags.Entities.PLANT_ENEMIES)));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOTING, false);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        getEntityData().set(SHOOTING, compound.getBoolean("Shooting"));
    }

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

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
    }
}
