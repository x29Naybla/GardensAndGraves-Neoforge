package com.x29naybla.gardensandgraves.client.model;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.PeashooterBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PeashooterBlockEntityModel extends GeoModel<PeashooterBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/block/peashooter.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/block/peashooter.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/block/peashooter.animation.json");

    @Override
    public ResourceLocation getModelResource(PeashooterBlockEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(PeashooterBlockEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(PeashooterBlockEntity animatable) {
        return animations;
    }
}
