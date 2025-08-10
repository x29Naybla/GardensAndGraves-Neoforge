package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.SunflowerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class SunflowerModel extends GeoModel<SunflowerEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/sunflower.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sunflower.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/flower.animation.json");

    @Override
    public ResourceLocation getModelResource(SunflowerEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(SunflowerEntity animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SunflowerEntity animatable) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(SunflowerEntity animatable, long instanceId, AnimationState animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");

        if (animatable.isBaby()) {
            head.setScaleX(1.6F);
            head.setScaleY(1.6F);
            head.setScaleZ(1.6F);
        } else {
            head.setScaleX(1.0F);
            head.setScaleY(1.0F);
            head.setScaleZ(1.0F);
        }
    }
}
