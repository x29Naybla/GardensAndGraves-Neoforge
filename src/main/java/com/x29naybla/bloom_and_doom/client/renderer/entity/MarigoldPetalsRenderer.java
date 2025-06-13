package com.x29naybla.bloom_and_doom.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.MarigoldEntity;
import net.minecraft.client.Minecraft;
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
    private static final ResourceLocation PETALS = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "geo/entity/marigold.geo.json");


    public ResourceLocation getTextureResource() {
        return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/marigold/marigold_petals.png");
    }

    @Override
    public void render(PoseStack poseStack, MarigoldEntity marigold, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (marigold.isInvisible()) {
            Minecraft minecraft = Minecraft.getInstance();
            boolean flag = minecraft.shouldEntityAppearGlowing(marigold);
            if (flag) {

            }
        } else {
            int i;
            if (marigold.hasCustomName() && "jeb_".equals(marigold.getName().getString())) {
                int j = 25;
                int k = marigold.tickCount / j + marigold.getId();
                int l = DyeColor.values().length;
                int i1 = k % l;
                int j1 = (k + 1) % l;
                float f = ((float)(marigold.tickCount % j) + partialTick) / j;
                int k1 = MarigoldEntity.getColor(DyeColor.byId(i1));
                int l1 = MarigoldEntity.getColor(DyeColor.byId(j1));
                i = FastColor.ARGB32.lerp(f, k1, l1);
            } else {
                i = marigold.getColor().getTextureDiffuseColor();
            }

            RenderType renderType1 = RenderType.entityCutoutNoCull(getTextureResource());
            this.getRenderer().actuallyRender(poseStack, marigold, bakedModel, renderType, bufferSource, bufferSource.getBuffer(renderType1), true, partialTick, packedLight, OverlayTexture.NO_OVERLAY, i);
        }
    }
}
