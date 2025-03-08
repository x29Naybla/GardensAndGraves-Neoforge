package com.x29naybla.gardensandgraves.client.model;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.SunflowerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SunflowerBlockEntityModel extends GeoModel<SunflowerBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/block/sunflower.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/block/sunflower.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/block/sunflower.animation.json");

    @Override
    public ResourceLocation getModelResource(SunflowerBlockEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(SunflowerBlockEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SunflowerBlockEntity animatable) {
        return animations;
    }
}
