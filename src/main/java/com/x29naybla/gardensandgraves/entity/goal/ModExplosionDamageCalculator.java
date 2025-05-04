package com.x29naybla.gardensandgraves.entity.goal;

import com.x29naybla.gardensandgraves.data.ModTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;

import javax.annotation.Nullable;

public class ModExplosionDamageCalculator extends ExplosionDamageCalculator {
    private int damage;

    public float setDamage(int Damage){
        damage = Damage;
        return damage;
    }

    @Override
    public float getKnockbackMultiplier(Entity entity) {
        return 0;
    }

    @Override
    public boolean shouldDamageEntity(Explosion explosion, Entity entity) {
        if (entity.getType().is(ModTags.Entities.PLANT_ENEMIES)){
            return true;
        } else return false;
    }

    @Override
    public float getEntityDamageAmount(@Nullable Explosion explosion, @Nullable Entity entity) {
        return damage;
    }
}
