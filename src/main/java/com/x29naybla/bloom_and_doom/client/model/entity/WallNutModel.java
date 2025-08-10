package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.WallNutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WallNutModel extends GeoModel<WallNutEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/wall_nut.geo.json");

    @Override
    public ResourceLocation getModelResource(WallNutEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(WallNutEntity animatable) {
        if (animatable.getHealth() <= 72) {
            return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_dying.png");
        } else if (animatable.getHealth() <= 144) {
            return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_hurt.png");
        } else
            return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/wall_nut/wall_nut_well.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WallNutEntity animatable) {
        return null;
    }
}
