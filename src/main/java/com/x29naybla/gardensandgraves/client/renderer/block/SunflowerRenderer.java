package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.ModBlockEntities;
import com.x29naybla.gardensandgraves.block.entity.SunflowerBlockEntity;
import com.x29naybla.gardensandgraves.client.model.SunflowerBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SunflowerRenderer extends GeoBlockRenderer<SunflowerBlockEntity> {
    public SunflowerRenderer(BlockEntityRendererProvider.Context context) {
        super(new SunflowerBlockEntityModel());
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SUNFLOWER.get(), SunflowerRenderer::new);
    }
}
