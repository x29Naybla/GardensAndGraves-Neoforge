package com.x29naybla.gardensandgraves.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.x29naybla.gardensandgraves.client.model.entity.SunflowerModel;
import com.x29naybla.gardensandgraves.entity.SunflowerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SunflowerRenderer extends GeoEntityRenderer<SunflowerEntity> {
    public SunflowerRenderer(EntityRendererProvider.Context context) {
        super(context, new SunflowerModel());
    }

    @Override
    public void render(SunflowerEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
