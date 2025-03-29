package com.x29naybla.gardensandgraves.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.x29naybla.gardensandgraves.client.model.entity.PotatoMineModel;
import com.x29naybla.gardensandgraves.entity.PotatoMineEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PotatoMineRenderer extends GeoEntityRenderer<PotatoMineEntity> {
    public PotatoMineRenderer(EntityRendererProvider.Context context) {
        super(context, new PotatoMineModel());
    }

    @Override
    public void render(PotatoMineEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(1F, 1F, 1F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
