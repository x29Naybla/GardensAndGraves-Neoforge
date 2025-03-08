package com.x29naybla.gardensandgraves.client.model;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.SnowPeaBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SnowPeaBlockEntityModel extends GeoModel<SnowPeaBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/block/snow_pea.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/block/snow_pea.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/block/peashooter.animation.json");

    @Override
    public ResourceLocation getModelResource(SnowPeaBlockEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(SnowPeaBlockEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(SnowPeaBlockEntity animatable) {
        return animations;
    }
}
