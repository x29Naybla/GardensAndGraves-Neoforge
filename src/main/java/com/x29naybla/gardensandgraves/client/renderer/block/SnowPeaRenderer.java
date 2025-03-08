package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.SnowPeaBlockEntity;
import com.x29naybla.gardensandgraves.client.model.SnowPeaBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SnowPeaRenderer extends GeoBlockRenderer<SnowPeaBlockEntity> {
    public SnowPeaRenderer(BlockEntityRendererProvider.Context context) {
        super(new SnowPeaBlockEntityModel());
    }
}
