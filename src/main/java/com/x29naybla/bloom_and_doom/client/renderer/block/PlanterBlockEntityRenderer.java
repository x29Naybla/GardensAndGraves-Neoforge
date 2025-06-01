package com.x29naybla.bloom_and_doom.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.x29naybla.bloom_and_doom.block.entity.PlanterBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class PlanterBlockEntityRenderer implements BlockEntityRenderer<PlanterBlockEntity> {

    public PlanterBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(PlanterBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemStack stack = pBlockEntity.content.getStackInSlot(0);

        if(!stack.isEmpty()) {
            BlockItem blockItem = (BlockItem) stack.getItem();

            pPoseStack.pushPose();

            List<BakedQuad> bq = Minecraft.getInstance().getBlockRenderer()
                    .getBlockModel(blockItem.getBlock().defaultBlockState()).getQuads(blockItem.getBlock().defaultBlockState(),
                            Direction.UP, pBlockEntity.getLevel().random, ModelData.EMPTY, RenderType.cutout());


            VertexConsumer vertexconsumer = pBufferSource.getBuffer(RenderType.entityTranslucent(InventoryMenu.BLOCK_ATLAS));

            Vector4f uv = getUVFromSprite(bq.get(0).getSprite(), 2, 2, 14, 14);
            PoseStack.Pose posestack$pose = pPoseStack.last();
            Matrix4f matrix4f = posestack$pose.pose();
            Matrix3f matrix3f = posestack$pose.normal();

            buildPlane(new Vector3f((float) 2 /16,1, (float) 14 /16), new Vector3f((float) 14 /16,1, (float) 14 /16), new Vector3f((float) 14 /16,1, (float) 2 /16),  new Vector3f((float) 2 /16,1, (float) 2 /16),
                    vertexconsumer, matrix4f, matrix3f, 0xFFFFFFFF, uv, Direction.UP.getNormal(), pPackedLight,
                    pPackedOverlay, pPoseStack);
            pPoseStack.popPose();
        }
    }

    public static void buildPlane(Vector3f pos1, Vector3f pos2, Vector3f pos3, Vector3f pos4,
                                  VertexConsumer vertexConsumer, Matrix4f mat, Matrix3f normal, int tint, Vector4f uv, Vec3i vec3i, int light,
                                  int packedOverlay, PoseStack poseStack) {
        vertexConsumer.addVertex(mat, pos1.x, pos1.y, pos1.z).setColor(tint).setUv(uv.x, uv.w).setOverlay(packedOverlay)
                .setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());

        vertexConsumer.addVertex(mat, pos2.x, pos2.y, pos2.z).setColor(tint).setUv(uv.y, uv.w).setOverlay(packedOverlay)
                .setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());

        vertexConsumer.addVertex(mat, pos3.x, pos3.y, pos3.z).setColor(tint).setUv(uv.y, uv.z).setOverlay(packedOverlay)
                .setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());

        vertexConsumer.addVertex(mat, pos4.x, pos4.y, pos4.z).setColor(tint).setUv(uv.x, uv.z).setOverlay(packedOverlay)
                .setLight(light).setNormal(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    public static Vector4f getUVFromSprite(TextureAtlasSprite sprite, float offsetX, float offsetY, float width,
                                           float height) {
        float uUnit = (sprite.getU1() - sprite.getU0()) / 16;
        float vUnit = (sprite.getV1() - sprite.getV0()) / 16;

        float start0 = sprite.getU0() + (uUnit * offsetX);
        float start1 = sprite.getV0() + (vUnit * offsetY);

        float end0 = ((uUnit * width)) + start0;
        float end1 = ((vUnit * height)) + start1;

        return new Vector4f(start0, end0, start1, end1);
    }
}
