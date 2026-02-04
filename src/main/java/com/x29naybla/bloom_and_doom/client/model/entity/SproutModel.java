package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.SproutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SproutModel extends GeoModel<SproutEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/sprout.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sprout.png");

    @Override
    public ResourceLocation getModelResource(SproutEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(SproutEntity animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SproutEntity animatable) {
        return null;
    }
}
