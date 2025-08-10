package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PuffShroomModel extends GeoModel<PuffShroomEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/puff_shroom.geo.json");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/flower.animation.json");

    @Override
    public ResourceLocation getModelResource(PuffShroomEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(PuffShroomEntity animatable) {
        if (animatable.getSleeping()) {
            return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/puff_shroom/puff_shroom_sleeping.png");
        } else
            return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/puff_shroom/puff_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PuffShroomEntity animatable) {
        return this.animations;
    }
}
