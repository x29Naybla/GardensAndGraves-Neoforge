package com.x29naybla.bloom_and_doom.client.model.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.entity.RepeaterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class RepeaterModel extends GeoModel<RepeaterEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/peashooter/repeater.geo.json");
    private final ResourceLocation model_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/peashooter/repeater_baby.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/peashooter/repeater.png");
    private final ResourceLocation texture_baby = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/peashooter/repeater_baby.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "animations/entity/peashooter.animation.json");

    @Override
    public ResourceLocation getModelResource(RepeaterEntity animatable) {
        if (animatable.isBaby() && ClientConfigs.NEW_BABY_MODELS.get()) return this.model_baby; else return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(RepeaterEntity animatable) {
        if (animatable.isBaby() && ClientConfigs.NEW_BABY_MODELS.get()) return this.texture_baby; else return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(RepeaterEntity animatable) {
        return this.animations;
    }

    @Override
    public void setCustomAnimations(RepeaterEntity animatable, long instanceId, AnimationState animationState) {
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
