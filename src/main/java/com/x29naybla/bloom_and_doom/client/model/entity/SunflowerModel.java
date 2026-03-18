package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.entity.SunflowerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class SunflowerModel extends GeoModel<SunflowerEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/sunflower/sunflower.geo.json");
    private final ResourceLocation model_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/sunflower/sunflower_baby.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sunflower/sunflower.png");
    private final ResourceLocation texture_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sunflower/sunflower_baby.png");
    private final ResourceLocation texture_sleeping = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sunflower/sunflower_sleeping.png");
    private final ResourceLocation texture_sleeping_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/sunflower/sunflower_sleeping_baby.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/flower.animation.json");

    @Override
    public ResourceLocation getModelResource(SunflowerEntity animatable) {
        if (animatable.isBaby() && ClientConfigs.NEW_BABY_MODELS.get()) return this.model_baby; else return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(SunflowerEntity animatable) {
        if (animatable.isBaby() && ClientConfigs.NEW_BABY_MODELS.get()) if (animatable.getSleeping()) return texture_sleeping_baby; else return texture_baby;
        else if (animatable.getSleeping()) return texture_sleeping; else return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SunflowerEntity animatable) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(SunflowerEntity animatable, long instanceId, AnimationState animationState) {
        GeoBone head = this.getAnimationProcessor().getBone("head");

        if (!ClientConfigs.NEW_BABY_MODELS.get()) {
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
}
