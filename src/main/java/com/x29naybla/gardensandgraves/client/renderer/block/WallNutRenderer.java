package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.WallNutBlockEntity;
import com.x29naybla.gardensandgraves.client.model.WallNutBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class WallNutRenderer extends GeoBlockRenderer<WallNutBlockEntity> {
    public WallNutRenderer(BlockEntityRendererProvider.Context context) {
        super(new WallNutBlockEntityModel());
    }
}
