package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.registry.ModDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.entity.goal.PlantShootDoubleGoal;
import com.x29naybla.bloom_and_doom.common.entity.projectile.PeaProjectile;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class RepeaterEntity extends ShootingPlant {
    //Properties
    public RepeaterEntity(EntityType<? extends RepeaterEntity> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_REPEATERS, ModItems.REPEATER_SEED_PACKET.toStack(), ModItems.POTTED_REPEATER.toStack());
    }

    //Goals and AI
    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new PlantShootDoubleGoal(this, 1.5F, 30, 8));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false,
                (target) -> target instanceof LivingEntity livingEntity && (livingEntity.getType().is(ModTags.Entities.PLANT_ENEMIES) || livingEntity.getData(ModDataAttachments.ZOMBIE))));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {
        PeaProjectile pea = new PeaProjectile(this.level(), this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - pea.getY();
        double d3 = target.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        pea.shoot(d1, d2 + d4, d3, 1.6F, 0F);
        this.playSound(ModSounds.REPEATER_SHOT.get(), 0.5F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(pea);
    }
}
