package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> PEA_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "pea_projectile"));

    public static final ResourceKey<DamageType> FROZEN_PEA_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "frozen_pea_projectile"));

    public static final ResourceKey<DamageType> SPORE_DAMAGE =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "spore_projectile"));

    public static final ResourceKey<DamageType> PLANT_EXPLOSION =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "plant_explosion"));

    public static final ResourceKey<DamageType> PLANT_PUNCH =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "plant_punch"));
}
