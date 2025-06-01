package com.x29naybla.bloom_and_doom.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.x29naybla.bloom_and_doom.client.model.entity.PuffShroomModel;
import com.x29naybla.bloom_and_doom.entity.PuffShroomEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PuffShroomRenderer extends GeoEntityRenderer<PuffShroomEntity> {
    public PuffShroomRenderer(EntityRendererProvider.Context context) {
        super(context, new PuffShroomModel());
    }

    @Override
    public void render(PuffShroomEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
