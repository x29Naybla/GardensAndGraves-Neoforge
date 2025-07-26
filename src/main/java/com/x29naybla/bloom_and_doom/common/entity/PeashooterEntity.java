package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.entity.projectile.PeaProjectile;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PeashooterEntity extends ShootingPlant {
    //Properties
    public PeashooterEntity(EntityType<? extends PeashooterEntity> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_PEASHOOTERS, ModItems.PEASHOOTER_SEED_PACKET.toStack(), ModItems.POTTED_PEASHOOTER.toStack());
    }

    //Goals and AI
    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float distanceFactor) {
        PeaProjectile pea = new PeaProjectile(this.level(), this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - pea.getY();
        double d3 = target.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        pea.shoot(d1, d2 + d4, d3, 1.6F, 3.0F);
        this.playSound(ModSounds.PEASHOOTER_SHOT.get(), 0.5F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(pea);
    }
}
