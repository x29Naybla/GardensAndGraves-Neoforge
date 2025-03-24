package com.x29naybla.gardensandgraves.entity.goal;

import com.x29naybla.gardensandgraves.entity.Peashooting;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.RangedAttackMob;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class ModShootGoal extends Goal {
    private final Peashooting peashooting;
    private final RangedAttackMob rangedAttackMob;
    @Nullable
    private LivingEntity target;
    private int attackTime;
    private final double speedModifier;
    private int seeTime;
    private final int attackIntervalMin;
    private final int attackIntervalMax;
    private final float attackRadius;
    private final float attackRadiusSqr;

    private int shootTimer;
    private final int timerCap;

    public ModShootGoal(RangedAttackMob rangedAttackMob, int timeInSeconds, double speedModifier, int attackInterval, float attackRadius){
        this(rangedAttackMob, timeInSeconds, speedModifier, attackInterval, attackInterval, attackRadius);
    }

    public ModShootGoal(RangedAttackMob rangedAttackMob, int timeInSeconds, double speedModifier, int attackIntervalMin, int attackIntervalMax, float attackRadius){
        this.attackTime = -1;
        if (!(rangedAttackMob instanceof LivingEntity)) {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        } else {
            this.rangedAttackMob = rangedAttackMob;
            this.peashooting = (Peashooting) rangedAttackMob;
            this.timerCap = timeInSeconds * 20;
            this.speedModifier = speedModifier;
            this.attackIntervalMin = attackIntervalMin;
            this.attackIntervalMax = attackIntervalMax;
            this.attackRadius = attackRadius;
            this.attackRadiusSqr = attackRadius * attackRadius;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
    }

    @Override
    public boolean canUse() {
        LivingEntity livingentity = this.peashooting.getTarget();
        if (livingentity != null && livingentity.isAlive() && !livingentity.isBaby()) {
            this.target = livingentity;
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        super.start();
        shootTimer = 0;
        peashooting.setShooting(true);
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse() || this.target.isAlive() && !this.peashooting.getNavigation().isDone() && shootTimer++ <= timerCap;
    }

    public void stop() {
        peashooting.setShooting(false);
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        double d0 = this.peashooting.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
        boolean flag = this.peashooting.getSensing().hasLineOfSight(this.target);
        if (flag) {
            ++this.seeTime;
        } else {
            this.seeTime = 0;
        }

        if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
            this.peashooting.getNavigation().stop();
        } else {
            this.peashooting.getNavigation().moveTo(this.target, this.speedModifier);
        }

        this.peashooting.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
        if (--this.attackTime == 3) {
            if (!flag) {
                return;
            }

            float f = (float)Math.sqrt(d0) / this.attackRadius;
            float f1 = Mth.clamp(f, 0.1F, 1.0F);
            this.rangedAttackMob.performRangedAttack(this.target, f1);
            this.attackTime = Mth.floor(f * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
        } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, this.attackIntervalMin, this.attackIntervalMax));
        }

    }
}
