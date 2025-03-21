package com.x29naybla.gardensandgraves.entity.goal;

import com.x29naybla.gardensandgraves.entity.ExplosivePlant;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class ModSwellGoal extends Goal{
    private final ExplosivePlant explosivePlant;
    @Nullable
    private LivingEntity target;

    public ModSwellGoal(ExplosivePlant explosivePlant) {
        this.explosivePlant = explosivePlant;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.explosivePlant.getTarget();
        return this.explosivePlant.getSwellDir() > 0 || livingentity != null && this.explosivePlant.distanceToSqr(livingentity) < (double)9.0F;
    }

    public void start() {
        this.explosivePlant.getNavigation().stop();
        this.target = this.explosivePlant.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.explosivePlant.setSwellDir(-1);
        } else if (this.explosivePlant.distanceToSqr(this.target) > (double)49.0F) {
            this.explosivePlant.setSwellDir(-1);
        } else if (!this.explosivePlant.getSensing().hasLineOfSight(this.target)) {
            this.explosivePlant.setSwellDir(-1);
        } else {
            this.explosivePlant.setSwellDir(1);
        }

    }
}
