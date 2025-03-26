package com.x29naybla.gardensandgraves.client.model.entity;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.WallNutEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class WallNutEntityModel extends GeoModel {
    private final ResourceLocation model = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "geo/entity/wall_nut.geo.json");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "animations/entity/wall_nut.animation.json");

    @Override
    public ResourceLocation getModelResource(GeoAnimatable animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(GeoAnimatable animatable) {
        if (((WallNutEntity) animatable).getHealth() <= 133) {
            return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/wall_nut_dying.png");
        } else if (((WallNutEntity) animatable).getHealth() <= 266) {
            return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/wall_nut_hurt.png");
        } else
            return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/wall_nut.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable animatable) {
        return null;
    }
}
