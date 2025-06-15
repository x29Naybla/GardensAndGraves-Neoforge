package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.entity.ChomperEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class PlantChompGoal extends Goal {
    private final ChomperEntity chomper;
    @Nullable
    private LivingEntity target;
    private int attackTime;
    private int seeTime;
    private final float attackRadius;
    private final float attackRadiusSqr;

    private int chewTimer;
    private final int timerCap;

    public PlantChompGoal(ChomperEntity chomper){
        if (chomper == null) {
            throw new IllegalArgumentException("PlantChompGoal requires ChomperEntity or Mob extends ChomperEntity");
        } else {
            this.chomper = chomper;
            this.timerCap = 20;
            this.attackRadius = 2;
            this.attackRadiusSqr = attackRadius * attackRadius;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
    }

    @Override
    public boolean canUse() {
        LivingEntity livingentity = this.chomper.getTarget();
        if (livingentity != null && livingentity.isAlive() && !this.chomper.isBaby()) {
            this.target = livingentity;
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        super.start();
        chewTimer = 0;
        chomper.setChewing(true);
    }

    @Override
    public boolean canContinueToUse() {
        if (this.target != null) return this.canUse() || this.target.isAlive() && !this.chomper.getNavigation().isDone() && chewTimer++ <= timerCap;
        else return false;
    }

    public void stop() {
        chomper.setChewing(false);
        this.target = null;
        this.seeTime = 0;
        this.attackTime = -1;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target != null) {
            double d0 = this.chomper.distanceToSqr(this.target.getX(), this.target.getY(), this.target.getZ());
            boolean flag = this.chomper.getSensing().hasLineOfSight(this.target);
            if (flag) {
                ++this.seeTime;
            } else {
                this.seeTime = 0;
            }

            if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 5) {
                this.chomper.getNavigation().stop();
            }

            this.chomper.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
            if (--this.attackTime == 1) {
                if (!flag) {
                    return;
                }

                float f = (float)Math.sqrt(d0) / this.attackRadius;
                float f1 = Mth.clamp(f, 0.1F, 1.0F);
                this.chomper.performChompAttack(this.target, f1);
                this.attackTime = 350;
            } else if (this.attackTime < 0) {
                this.attackTime = 0;
            }
        }
    }
}
