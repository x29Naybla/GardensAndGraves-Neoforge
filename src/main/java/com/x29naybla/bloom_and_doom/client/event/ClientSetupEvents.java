package com.x29naybla.bloom_and_doom.client.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.registry.ModBlockEntities;
import com.x29naybla.bloom_and_doom.client.renderer.block.PlanterBlockEntityRenderer;
import com.x29naybla.bloom_and_doom.client.renderer.entity.*;
import com.x29naybla.bloom_and_doom.common.registry.ModEntities;
import com.x29naybla.bloom_and_doom.common.registry.ModParticles;
import com.x29naybla.bloom_and_doom.client.particle.SleepingParticles;
import net.mehvahdjukaar.amendments.Amendments;
import net.mehvahdjukaar.amendments.client.ClientResourceGenerator;
import net.mehvahdjukaar.amendments.client.renderers.Small3DBallRenderer;
import net.mehvahdjukaar.amendments.integration.CompatHandler;
import net.mehvahdjukaar.amendments.integration.FlywheelCompat;
import net.mehvahdjukaar.moonlight.api.misc.EventCalled;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID, value = Dist.CLIENT)
public class ClientSetupEvents {

    public static final ResourceLocation PEA_TEXTURE = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/projectile/pea_3d.png");
    public static final ResourceLocation FROZEN_PEA_TEXTURE = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/projectile/frozen_pea_3d.png");
    public static final ResourceLocation SPORE_TEXTURE = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/projectile/spore_3d.png");

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.PLANTER_BE.get(), PlanterBlockEntityRenderer::new);
    }

    public static void init() {
        if (ModList.get().isLoaded(Amendments.MOD_ID)) {
            new ClientResourceGenerator().register();

            ClientHelper.addEntityRenderersRegistration(ClientSetupEvents::registerEntityRenderers);

            if (CompatHandler.FLYWHEEL) FlywheelCompat.init();
        }
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
        event.registerEntityRenderer(ModEntities.SUN_SHROOM.get(), SunShroomRenderer::new);
        event.registerEntityRenderer(ModEntities.PUFF_SHROOM.get(), PuffShroomRenderer::new);
        event.registerEntityRenderer(ModEntities.DOOM_SHROOM.get(), DoomShroomRenderer::new);

        if (!ModList.get().isLoaded(Amendments.MOD_ID) || !ClientConfigs.PEAS_3D.get()) {
            event.registerEntityRenderer(ModEntities.PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        }
        if (!ModList.get().isLoaded(Amendments.MOD_ID) || !ClientConfigs.FROZEN_PEAS_3D.get()) {
            event.registerEntityRenderer(ModEntities.FROZEN_PEA_PROJECTILE.get(), ThrownItemRenderer::new);
        }
        if (!ModList.get().isLoaded(Amendments.MOD_ID) || !ClientConfigs.SPORES_3D.get()) {
            event.registerEntityRenderer(ModEntities.SPORE_PROJECTILE.get(), ThrownItemRenderer::new);
        }
    }

    @EventCalled
    private static void registerEntityRenderers(ClientHelper.EntityRendererEvent event) {
       float modelScale = 0.75f;
        if (ClientConfigs.PEAS_3D.get()) {
            event.register(ModEntities.PEA_PROJECTILE.get(), context -> new Small3DBallRenderer(context,
                    modelScale, PEA_TEXTURE, false));
        }

        if (ClientConfigs.FROZEN_PEAS_3D.get()) {
            event.register(ModEntities.FROZEN_PEA_PROJECTILE.get(), context -> new Small3DBallRenderer(context,
                    modelScale, FROZEN_PEA_TEXTURE, false));
        }

        if (ClientConfigs.SPORES_3D.get()) {
            event.register(ModEntities.SPORE_PROJECTILE.get(), context -> new Small3DBallRenderer(context,
                    modelScale, SPORE_TEXTURE, false));
        }
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.SLEEPING_PARTICLES.get(), SleepingParticles.Provider::new);
    }
}
