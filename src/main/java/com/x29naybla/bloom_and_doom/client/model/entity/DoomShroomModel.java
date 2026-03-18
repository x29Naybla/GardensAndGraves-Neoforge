package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.DoomShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DoomShroomModel extends GeoModel<DoomShroomEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/doom_shroom/doom_shroom.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/doom_shroom/doom_shroom.png");
    private final ResourceLocation texture_sleeping = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/doom_shroom/doom_shroom_sleeping.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/flower.animation.json");

    @Override
    public ResourceLocation getModelResource(DoomShroomEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(DoomShroomEntity animatable) {
        if (animatable.getSleeping()) return texture_sleeping; else return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(DoomShroomEntity animatable) {
        return this.animations;
    }
}
