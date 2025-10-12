package com.x29naybla.bloom_and_doom.client.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.registry.ModBlockEntities;
import com.x29naybla.bloom_and_doom.client.renderer.block.PlanterBlockEntityRenderer;
import com.x29naybla.bloom_and_doom.client.renderer.entity.*;
import com.x29naybla.bloom_and_doom.common.registry.ModEntities;
import com.x29naybla.bloom_and_doom.common.registry.ModParticles;
import com.x29naybla.bloom_and_doom.client.particle.SleepingParticles;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID, value = Dist.CLIENT)
public class ClientSetupEvents {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.PLANTER_BE.get(), PlanterBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.SUNFLOWER.get(), SunflowerRenderer::new);
        event.registerEntityRenderer(ModEntities.MARIGOLD.get(), MarigoldRenderer::new);
        event.registerEntityRenderer(ModEntities.PEASHOOTER.get(), PeashooterRenderer::new);
        event.registerEntityRenderer(ModEntities.SNOW_PEA.get(), SnowPeashooterRenderer::new);
        event.registerEntityRenderer(ModEntities.REPEATER.get(), RepeaterRenderer::new);
        event.registerEntityRenderer(ModEntities.WALL_NUT.get(), WallNutRenderer::new);
        event.registerEntityRenderer(ModEntities.POTATO_MINE.get(), PotatoMineRenderer::new);
        event.registerEntityRenderer(ModEntities.CHOMPER.get(), ChomperRenderer::new);
        event.registerEntityRenderer(ModEntities.BONK_CHOY.get(), BonkChoyRenderer::new);
        event.registerEntityRenderer(ModEntities.SUN_SHROOM.get(), SunShroomRenderer::new);
        event.registerEntityRenderer(ModEntities.PUFF_SHROOM.get(), PuffShroomRenderer::new);
        event.registerEntityRenderer(ModEntities.DOOM_SHROOM.get(), DoomShroomRenderer::new);

        event.registerEntityRenderer(ModEntities.ZOMBIE_WOLF.get(), WolfRenderer::new);

        if (!ModList.get().isLoaded("amendments") || !ClientConfigs.PEAS_3D.get()) {
            event.registerEntityRenderer(ModEntities.PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        }
        if (!ModList.get().isLoaded("amendments") || !ClientConfigs.FROZEN_PEAS_3D.get()) {
            event.registerEntityRenderer(ModEntities.FROZEN_PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        }
        if (!ModList.get().isLoaded("amendments") || !ClientConfigs.SPORES_3D.get()) {
            event.registerEntityRenderer(ModEntities.SPORE_PROJECTILE.get(), ThrownItemRenderer::new);
        }
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.SLEEPING_PARTICLES.get(), SleepingParticles.Provider::new);
    }
}
