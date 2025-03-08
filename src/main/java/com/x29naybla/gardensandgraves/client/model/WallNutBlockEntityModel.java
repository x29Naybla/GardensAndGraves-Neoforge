package com.x29naybla.gardensandgraves.client.model;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.WallNutBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WallNutBlockEntityModel extends GeoModel<WallNutBlockEntity> {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/block/wall_nut.geo.json");
    private final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/block/wall_nut.png");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/block/wall_nut.animation.json");

    @Override
    public ResourceLocation getModelResource(WallNutBlockEntity animatable) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(WallNutBlockEntity animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(WallNutBlockEntity animatable) {
        return animations;
    }
}
