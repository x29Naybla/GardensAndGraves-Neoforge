package com.x29naybla.gardensandgraves.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.x29naybla.gardensandgraves.client.model.entity.WallNutEntityModel;
import com.x29naybla.gardensandgraves.entity.WallNutEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WallNutRenderer extends GeoEntityRenderer<WallNutEntity> {
    public WallNutRenderer(EntityRendererProvider.Context context) {
        super(context, new WallNutEntityModel());
    }

    @Override
    public void render(WallNutEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
