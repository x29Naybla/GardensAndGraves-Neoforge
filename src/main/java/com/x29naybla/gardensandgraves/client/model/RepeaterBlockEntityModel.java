package com.x29naybla.gardensandgraves.client.model;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.RepeaterBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RepeaterBlockEntityModel extends GeoModel<RepeaterBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/block/repeater.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/block/repeater.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/block/peashooter.animation.json");

    @Override
    public ResourceLocation getModelResource(RepeaterBlockEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(RepeaterBlockEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(RepeaterBlockEntity animatable) {
        return animations;
    }
}
