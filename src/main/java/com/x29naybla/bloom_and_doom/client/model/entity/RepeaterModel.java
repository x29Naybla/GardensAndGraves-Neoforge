package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.RepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class RepeaterModel extends GeoModel {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/repeater.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/repeater.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/peashooter.animation.json");

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

    @Override
    public void setCustomAnimations(GeoAnimatable animatable, long instanceId, AnimationState animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        if (animationState == null) return;

        GeoBone head = this.getAnimationProcessor().getBone("head");

        if (((RepeaterEntity) animatable).isBaby()) {
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
