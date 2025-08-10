package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.SnowPeaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class SnowPeaModel extends GeoModel<SnowPeaEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/snow_peashooter.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/snow_pea.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/peashooter.animation.json");

    @Override
    public ResourceLocation getModelResource(SnowPeaEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(SnowPeaEntity animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SnowPeaEntity animatable) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(SnowPeaEntity animatable, long instanceId, AnimationState animationState) {
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
