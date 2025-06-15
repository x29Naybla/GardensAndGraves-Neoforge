package com.x29naybla.bloom_and_doom.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.x29naybla.bloom_and_doom.client.model.entity.ChomperModel;
import com.x29naybla.bloom_and_doom.client.model.entity.DoomShroomModel;
import com.x29naybla.bloom_and_doom.common.entity.ChomperEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ChomperRenderer extends GeoEntityRenderer<ChomperEntity> {
    public ChomperRenderer(EntityRendererProvider.Context context) {
        super(context, new ChomperModel());
    }

    @Override
    public void render(ChomperEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
