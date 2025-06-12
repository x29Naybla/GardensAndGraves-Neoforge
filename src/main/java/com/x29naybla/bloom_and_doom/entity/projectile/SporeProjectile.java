package com.x29naybla.bloom_and_doom.entity.projectile;

import com.x29naybla.bloom_and_doom.data.ModDamageTypes;
import com.x29naybla.bloom_and_doom.entity.ModEntities;
import com.x29naybla.bloom_and_doom.item.ModItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SporeProjectile extends PlantProjectile {
    public SporeProjectile(EntityType<? extends SporeProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public SporeProjectile(Level level, LivingEntity shooter) {
        super(ModEntities.SPORE_PROJECTILE.get(), shooter, level);
    }

    public SporeProjectile(Level level, double x, double y, double z) {
        super(ModEntities.SPORE_PROJECTILE.get(), x, y, z, level);
    }

    protected @NotNull Item getDefaultItem() {
        return ModItems.SPORE.get();
    }

    protected @NotNull ResourceKey<DamageType> setDamageType() {
        return ModDamageTypes.SPORE_DAMAGE;
    }
}
