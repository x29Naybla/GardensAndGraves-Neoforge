package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.PotatoMineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PotatoMineModel extends GeoModel<PotatoMineEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/potato_mine.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/potato_mine.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/potato_mine.animation.json");

    @Override
    public ResourceLocation getModelResource(PotatoMineEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(PotatoMineEntity animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(PotatoMineEntity animatable) {
        return this.animations;
    }
}
