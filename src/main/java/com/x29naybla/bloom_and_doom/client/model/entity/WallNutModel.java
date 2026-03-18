package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.entity.WallNutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WallNutModel extends GeoModel<WallNutEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/wall_nut/wall_nut.geo.json");
    private final ResourceLocation model_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/wall_nut/wall_nut_baby.geo.json");
    private final ResourceLocation texture_well = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_well.png");
    private final ResourceLocation texture_hurt = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_hurt.png");
    private final ResourceLocation texture_dying = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_dying.png");
    private final ResourceLocation texture_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_baby.png");

    @Override
    public ResourceLocation getModelResource(WallNutEntity animatable) {
        if (animatable.isBaby() && ClientConfigs.NEW_BABY_MODELS.get()) return this.model_baby; else return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(WallNutEntity animatable) {
        if (animatable.isBaby() && ClientConfigs.NEW_BABY_MODELS.get()) return this.texture_baby;
        else if (animatable.getHealth() <= (animatable.getMaxHealth()/3)) return texture_dying; else if (animatable.getHealth() <= ((animatable.getMaxHealth()/3)*2)) return texture_hurt; else return texture_well;
    }

    @Override
    public ResourceLocation getAnimationResource(WallNutEntity animatable) {
        return null;
    }
}
