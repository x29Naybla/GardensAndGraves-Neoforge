package com.x29naybla.gardensandgraves.client.model.entity;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.WallNutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class WallNutModel extends GeoModel {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/entity/wall_nut.geo.json");

    @Override
    public ResourceLocation getModelResource(GeoAnimatable animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(GeoAnimatable animatable) {
        if (((WallNutEntity) animatable).getHealth() <= 72) {
            return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/wall_nut_dying.png");
        } else if (((WallNutEntity) animatable).getHealth() <= 144) {
            return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/wall_nut_hurt.png");
        } else
            return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/wall_nut.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable animatable) {
        return null;
    }
}
