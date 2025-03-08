package com.x29naybla.gardensandgraves.client.events;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.entity.ModBlockEntities;
import com.x29naybla.gardensandgraves.client.renderer.block.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetUpEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.MARIGOLD.get(), MarigoldRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SUNFLOWER.get(), SunflowerRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.PEASHOOTER.get(), PeashooterRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.REPEATER.get(), RepeaterRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SNOW_PEA.get(), SnowPeaRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.WALL_NUT.get(), WallNutRenderer::new);
    }
}
