package com.x29naybla.gardensandgraves.client.model;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.MarigoldBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MarigoldBlockEntityModel extends GeoModel<MarigoldBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/block/marigold.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/block/marigold.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/block/sunflower.animation.json");

    @Override
    public ResourceLocation getModelResource(MarigoldBlockEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(MarigoldBlockEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(MarigoldBlockEntity animatable) {
        return animations;
    }
}
