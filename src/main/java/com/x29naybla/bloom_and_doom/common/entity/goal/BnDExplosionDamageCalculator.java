package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.registry.BnDDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BnDExplosionDamageCalculator extends ExplosionDamageCalculator {
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
        return entity.getType().is(BnDTags.Entities.PLANT_ENEMIES) || entity.getData(BnDDataAttachments.ZOMBIE);
    }

    @Override
    public float getEntityDamageAmount(@Nullable Explosion explosion, @Nullable Entity entity) {
        return damage;
    }
}
