package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.SunShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SunShroomModel extends GeoModel<SunShroomEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/sun_shroom/sun_shroom.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sun_shroom/sun_shroom.png");
    private final ResourceLocation texture_sleeping = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sun_shroom/sun_shroom_sleeping.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/flower.animation.json");

    @Override
    public ResourceLocation getModelResource(SunShroomEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(SunShroomEntity animatable) {
        if (animatable.getSleeping()) return texture_sleeping; else return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SunShroomEntity animatable) {
        return this.animations;
    }
}
