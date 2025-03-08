package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.SunflowerBlockEntity;
import com.x29naybla.gardensandgraves.client.model.SunflowerBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SunflowerRenderer extends GeoBlockRenderer<SunflowerBlockEntity> {
    public SunflowerRenderer(BlockEntityRendererProvider.Context context) {
        super(new SunflowerBlockEntityModel());
    }
}
