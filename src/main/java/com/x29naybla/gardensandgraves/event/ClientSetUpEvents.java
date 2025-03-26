package com.x29naybla.gardensandgraves.event;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import com.x29naybla.gardensandgraves.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetUpEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.SUNFLOWER.get(), SunflowerRenderer::new);
        event.registerEntityRenderer(ModEntities.MARIGOLD.get(), MarigoldRenderer::new);
        event.registerEntityRenderer(ModEntities.PEASHOOTER.get(), PeashooterRenderer::new);
        event.registerEntityRenderer(ModEntities.SNOW_PEA.get(), SnowPeashooterRenderer::new);
        event.registerEntityRenderer(ModEntities.REPEATER.get(), RepeaterRenderer::new);
        event.registerEntityRenderer(ModEntities.WALL_NUT.get(), WallNutRenderer::new);
        event.registerEntityRenderer(ModEntities.SUN_SHROOM.get(), SunShroomRenderer::new);
        event.registerEntityRenderer(ModEntities.PUFF_SHROOM.get(), PuffShroomRenderer::new);
        event.registerEntityRenderer(ModEntities.DOOM_SHROOM.get(), DoomShroomRenderer::new);

        event.registerEntityRenderer(ModEntities.SNAIL.get(), SnailRenderer::new);

        event.registerEntityRenderer(ModEntities.PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.FROZEN_PEA_PROJECTILE.get(), ThrownItemRenderer::new);
    }
}
