package com.x29naybla.bloom_and_doom.integration;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.ClientConfigs;
import com.x29naybla.bloom_and_doom.common.registry.BnDEntities;
import net.mehvahdjukaar.amendments.client.renderers.Small3DBallRenderer;
import net.mehvahdjukaar.moonlight.api.misc.EventCalled;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.minecraft.resources.ResourceLocation;

public class Ammendments {

    public static final ResourceLocation PEA_TEXTURE = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/projectile/pea_3d.png");
    public static final ResourceLocation FROZEN_PEA_TEXTURE = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/projectile/frozen_pea_3d.png");
    public static final ResourceLocation SPORE_TEXTURE = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/projectile/spore_3d.png");

    public static void init() {
        ClientHelper.addEntityRenderersRegistration(Ammendments::registerEntityRenderers);
    }

    @EventCalled
    private static void registerEntityRenderers(ClientHelper.EntityRendererEvent event) {
        float modelScale = 0.75f;
        if (ClientConfigs.PEAS_3D.get()) {
            event.register(BnDEntities.PEA_PROJECTILE.get(), context -> new Small3DBallRenderer(context,
                    modelScale, PEA_TEXTURE, false));
        }

        if (ClientConfigs.FROZEN_PEAS_3D.get()) {
            event.register(BnDEntities.FROZEN_PEA_PROJECTILE.get(), context -> new Small3DBallRenderer(context,
                    modelScale, FROZEN_PEA_TEXTURE, false));
        }

        if (ClientConfigs.SPORES_3D.get()) {
            event.register(BnDEntities.SPORE_PROJECTILE.get(), context -> new Small3DBallRenderer(context,
                    modelScale, SPORE_TEXTURE, false));
        }
    }
}
