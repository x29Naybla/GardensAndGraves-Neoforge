package com.x29naybla.bloom_and_doom.client.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.registry.BnDEntities;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlockEntities;
import com.x29naybla.bloom_and_doom.client.renderer.block.PlanterBlockEntityRenderer;
import com.x29naybla.bloom_and_doom.client.renderer.entity.*;
import com.x29naybla.bloom_and_doom.common.registry.BnDItemProperties;
import com.x29naybla.bloom_and_doom.common.registry.BnDParticles;
import com.x29naybla.bloom_and_doom.client.particle.SleepingParticles;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID, value = Dist.CLIENT)
public class ClientSetupEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        BnDItemProperties.addCustomItemProperties();
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BnDBlockEntities.PLANTER_BE.get(), PlanterBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(BnDEntities.SPROUT.get(), SproutRenderer::new);
        event.registerEntityRenderer(BnDEntities.SUNFLOWER.get(), SunflowerRenderer::new);
        event.registerEntityRenderer(BnDEntities.MARIGOLD.get(), MarigoldRenderer::new);
        event.registerEntityRenderer(BnDEntities.PEASHOOTER.get(), PeashooterRenderer::new);
        event.registerEntityRenderer(BnDEntities.SNOW_PEA.get(), SnowPeashooterRenderer::new);
        event.registerEntityRenderer(BnDEntities.REPEATER.get(), RepeaterRenderer::new);
        event.registerEntityRenderer(BnDEntities.WALL_NUT.get(), WallNutRenderer::new);
        event.registerEntityRenderer(BnDEntities.POTATO_MINE.get(), PotatoMineRenderer::new);
        event.registerEntityRenderer(BnDEntities.CHOMPER.get(), ChomperRenderer::new);
        event.registerEntityRenderer(BnDEntities.BONK_CHOY.get(), BonkChoyRenderer::new);
        event.registerEntityRenderer(BnDEntities.SUN_SHROOM.get(), SunShroomRenderer::new);
        event.registerEntityRenderer(BnDEntities.PUFF_SHROOM.get(), PuffShroomRenderer::new);
        event.registerEntityRenderer(BnDEntities.DOOM_SHROOM.get(), DoomShroomRenderer::new);

        event.registerEntityRenderer(BnDEntities.ZOMBIE_WOLF.get(), WolfRenderer::new);

        if (!ModList.get().isLoaded("amendments") || !ClientConfigs.PEAS_3D.get()) {
            event.registerEntityRenderer(BnDEntities.PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        }
        if (!ModList.get().isLoaded("amendments") || !ClientConfigs.FROZEN_PEAS_3D.get()) {
            event.registerEntityRenderer(BnDEntities.FROZEN_PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        }
        if (!ModList.get().isLoaded("amendments") || !ClientConfigs.SPORES_3D.get()) {
            event.registerEntityRenderer(BnDEntities.SPORE_PROJECTILE.get(), ThrownItemRenderer::new);
        }
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(BnDParticles.SLEEPING_PARTICLES.get(), SleepingParticles.Provider::new);
    }
}
