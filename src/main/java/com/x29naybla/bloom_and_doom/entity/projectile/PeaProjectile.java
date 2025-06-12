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

public class PeaProjectile extends PlantProjectile {
    public PeaProjectile(EntityType<? extends PeaProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public PeaProjectile(Level level, LivingEntity shooter) {
        super(ModEntities.PEA_PROJECTILE.get(), shooter, level);
    }

    public PeaProjectile(Level level, double x, double y, double z) {
        super(ModEntities.PEA_PROJECTILE.get(), x, y, z, level);
    }

    protected @NotNull Item getDefaultItem() {
        return ModItems.PEA.get();
    }

    protected @NotNull ResourceKey<DamageType> setDamageType() {
        return ModDamageTypes.PEA_DAMAGE;
    }
}
