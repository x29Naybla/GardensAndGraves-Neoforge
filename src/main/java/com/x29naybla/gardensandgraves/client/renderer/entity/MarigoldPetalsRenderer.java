package com.x29naybla.gardensandgraves.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.MarigoldEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeColor;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class MarigoldPetalsRenderer extends GeoRenderLayer<MarigoldEntity> {
    public MarigoldPetalsRenderer(GeoRenderer<MarigoldEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    public ResourceLocation getTextureResource() {
        return ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "textures/entity/marigold_petals.png");
    }

    @Override
    public void render(PoseStack poseStack, MarigoldEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        int color;

        if (animatable.hasCustomName() && "jeb_".equals(animatable.getName().getString())) {
            int n = animatable.tickCount / 50 + animatable.getId();
            int o = DyeColor.values().length;
            int p = n % o;
            int q = (n + 1) % o;
            float r = ((float)(animatable.tickCount % 50) + partialTick) / 50.0F;
            int fs = MarigoldEntity.getColor(DyeColor.byId(p));
            int gs = MarigoldEntity.getColor(DyeColor.byId(q));
            color = FastColor.ARGB32.lerp(r, fs, gs);
        } else {
            color = animatable.getColor().getTextureDiffuseColor();
        }


        RenderType renderType1 = RenderType.entityCutoutNoCull(getTextureResource());
        this.getRenderer().actuallyRender(poseStack, animatable, bakedModel, renderType, bufferSource, bufferSource.getBuffer(renderType1), true, partialTick, packedLight, OverlayTexture.NO_OVERLAY, color);
    }
}
