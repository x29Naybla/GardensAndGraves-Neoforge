package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.entity.ShootingPlant;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PlantShootGoal extends Goal {
    private final ShootingPlant shootingPlant;
    @Nullable
    private LivingEntity target;
    private int attackTime;
    private int seeTime;
    private final int attackIntervalMin;
    private final int attackIntervalMax;
    private final float attackRadius;
    private final float attackRadiusSqr;

    private int shootTimer;
    private final float timerCap;

    public PlantShootGoal(ShootingPlant shootingPlant, float timeInSeconds, int attackInterval, float attackRadius){
        this(shootingPlant, timeInSeconds, attackInterval, attackInterval, attackRadius);
    }

    public PlantShootGoal(ShootingPlant shootingPlant, float timeInSeconds, int attackIntervalMin, int attackIntervalMax, float attackRadius){
        this.attackTime = -1;
        if (shootingPlant == null) {
            throw new IllegalArgumentException("PlantShootGoal requires Mob extends ShootingPlant");
        } else {
            this.shootingPlant = shootingPlant;
            this.timerCap = timeInSeconds * 20;
            this.attackIntervalMin = attackIntervalMin;
            this.attackIntervalMax = attackIntervalMax;
            this.attackRadius = attackRadius;
            this.attackRadiusSqr = attackRadius * attackRadius;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
    }

    @Override
    public boolean canUse() {
        LivingEntity livingentity = this.shootingPlant.getTarget();
        if (livingentity != null && livingentity.isAlive() && !this.shootingPlant.isBaby()) {
            this.target = livingentity;
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        super.start();
        shootTimer = 0;
        shootingPlant.setShooting(true);
    }

    @Override
    public boolean canContinueToUse() {
        if (this.target != null) return this.canUse() || this.target.isAlive() && !this.shootingPlant.getNavigation().isDone() && shootTimer++ <= timerCap;
        else return false;
    }

    public void stop() {
        shootingPlant.setShooting(false);
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target != null) {
            double d0 = this.shootingPlant.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
            boolean flag = this.shootingPlant.getSensing().hasLineOfSight(this.target);
            if (flag) {
                ++this.seeTime;
            } else {
                this.seeTime = 0;
            }

            if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
                this.shootingPlant.getNavigation().stop();
            }

            this.shootingPlant.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            if (--this.attackTime == 3) {
                if (!flag) {
                    return;
                }

                float f = (float)Math.sqrt(d0) / this.attackRadius;
                float f1 = Mth.clamp(f, 0.1F, 1.0F);
                this.shootingPlant.performRangedAttack(this.target, f1);
                this.attackTime = Mth.floor(f * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
            } else if (this.attackTime < 0) {
                this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, this.attackIntervalMin, this.attackIntervalMax));
            }
        }
    }
}
