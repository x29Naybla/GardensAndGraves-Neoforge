package com.x29naybla.bloom_and_doom;

import com.x29naybla.bloom_and_doom.client.HiResPackSource;
import com.x29naybla.bloom_and_doom.common.registry.*;
import com.x29naybla.bloom_and_doom.common.loot.LootModifierInit;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforgespi.locating.IModFile;

@Mod(BloomAndDoom.MOD_ID)
public class BloomAndDoom {
    public static final String MOD_ID = "bloom_and_doom";

    public BloomAndDoom(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        BnDEntities.ENTITY_TYPES.register(modEventBus);
        BnDEffects.MOB_EFFECTS.register(modEventBus);
        BnDPotions.POTIONS.register(modEventBus);
        BnDParticles.PARTICLE_TYPES.register(modEventBus);
        BnDDataAttachments.ATTACHMENT_TYPES.register(modEventBus);

        BnDItems.register(modEventBus);
        BnDDataComponents.register(modEventBus);

        BnDBlocks.register(modEventBus);
        BnDBlockEntities.register(modEventBus);

        BnDVillagers.POI_TYPES.register(modEventBus);
        BnDVillagers.VILLAGER_PROFESSIONS.register(modEventBus);

        BnDSounds.register(modEventBus);
        BnDCreativeModeTabs.register(modEventBus);
        LootModifierInit.LOOT_MODIFIERS.register(modEventBus);

        IModFile modFile = ModLoadingContext.get().getActiveContainer().getModInfo().getOwningFile().getFile();
        modEventBus.addListener((AddPackFindersEvent event) -> {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                event.addRepositorySource(new HiResPackSource(modFile, PackType.CLIENT_RESOURCES, "GardenerPixels", Component.translatable("pack.bloom_and_doom.gardener_pixels")));
            }
        });

        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC);
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
