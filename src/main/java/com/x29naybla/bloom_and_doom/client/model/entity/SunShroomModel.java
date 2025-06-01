package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class SunShroomModel extends GeoModel {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/sun_shroom.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sun_shroom.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/flower.animation.json");

    @Override
    public ResourceLocation getModelResource(GeoAnimatable animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(GeoAnimatable animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable animatable) {
        return this.animations;
    }
}
