package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.registry.ModDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ModExplosionDamageCalculator extends ExplosionDamageCalculator {
    private int damage;

    public void setDamage(int damage){
        this.damage = damage;
    }

    @Override
    public float getKnockbackMultiplier(@NotNull Entity entity) {
        return 0;
    }

    @Override
    public boolean shouldDamageEntity(@NotNull Explosion explosion, Entity entity) {
        return entity.getType().is(ModTags.Entities.PLANT_ENEMIES) || entity.getData(ModDataAttachments.ZOMBIE);
    }

    @Override
    public float getEntityDamageAmount(@Nullable Explosion explosion, @Nullable Entity entity) {
        return damage;
    }
}
