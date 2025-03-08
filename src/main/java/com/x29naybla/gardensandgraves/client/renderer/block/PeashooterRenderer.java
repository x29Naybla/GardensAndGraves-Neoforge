package com.x29naybla.gardensandgraves.client.renderer.block;

import com.x29naybla.gardensandgraves.block.entity.PeashooterBlockEntity;
import com.x29naybla.gardensandgraves.client.model.PeashooterBlockEntityModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PeashooterRenderer extends GeoBlockRenderer<PeashooterBlockEntity> {
    public PeashooterRenderer(BlockEntityRendererProvider.Context context) {
        super(new PeashooterBlockEntityModel());
    }
}
