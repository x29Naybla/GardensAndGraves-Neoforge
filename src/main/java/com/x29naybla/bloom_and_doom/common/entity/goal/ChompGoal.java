package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.entity.ChomperEntity;
import com.x29naybla.bloom_and_doom.common.registry.BnDDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public final class ChompGoal extends Goal {
    private final ChomperEntity chomper;

    private final double radius;

    private Entity chomping;

    public ChompGoal(ChomperEntity chomper, double radius) {
        this.chomper = chomper;
        this.radius = radius;
        var flags = getFlags();
        flags.add(Flag.TARGET);
        flags.add(Flag.LOOK);
    }

    @Override
    public boolean canUse() {
        return chomper.isAlive() && chomper.isNotChewing() && (chomping = findChomping()) != null;
    }

    @Override
    public void start() {
        chomper.startChewing();
    }

    @Override
    public void tick() {
        if (chomping != null) {
            chomper.getLookControl().setLookAt(chomping, 30.0f, 30.0f);
            chomper.eat(chomping);
            chomping = null;
        }
    }

    public Entity findChomping() {
        var entities = chomper.level().getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT, chomper, chomper.getBoundingBox().inflate(6.0));

        for (var entity : entities) {
            if (canChomp(entity) && chomper.distanceToSqr(entity) < radius && chomper.getSensing().hasLineOfSight(entity)) {
                return entity;
            }
        }
        return null;
    }

    public boolean canChomp(Entity entity) {
        return (entity.getType().is(BnDTags.Entities.CAN_BE_CHOMPED) || entity.getData(BnDDataAttachments.ZOMBIE));
    }
}
