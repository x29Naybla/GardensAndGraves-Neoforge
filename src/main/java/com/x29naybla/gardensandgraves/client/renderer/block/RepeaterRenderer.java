package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.RepeaterBlockEntity;
import com.x29naybla.gardensandgraves.client.model.RepeaterBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class RepeaterRenderer extends GeoBlockRenderer<RepeaterBlockEntity> {
    public RepeaterRenderer(BlockEntityRendererProvider.Context context) {
        super(new RepeaterBlockEntityModel());
    }
}
