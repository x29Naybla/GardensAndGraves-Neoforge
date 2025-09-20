package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.BonkChoyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BonkChoyModel extends GeoModel<BonkChoyEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/bonk_choy.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/bonk_choy.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/bonk_choy.animation.json");

    @Override
    public ResourceLocation getModelResource(BonkChoyEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(BonkChoyEntity animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(BonkChoyEntity animatable) {
        return this.animations;
    }
}
