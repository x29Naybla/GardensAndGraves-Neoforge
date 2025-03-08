package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.MarigoldBlockEntity;
import com.x29naybla.gardensandgraves.client.model.MarigoldBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class MarigoldRenderer extends GeoBlockRenderer<MarigoldBlockEntity> {
    public MarigoldRenderer(BlockEntityRendererProvider.Context context) {
        super(new MarigoldBlockEntityModel());
    }
}
