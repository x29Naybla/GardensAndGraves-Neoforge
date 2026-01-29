package com.x29naybla.bloom_and_doom;

import com.x29naybla.bloom_and_doom.client.HiResPackSource;
import com.x29naybla.bloom_and_doom.common.registry.*;
import com.x29naybla.bloom_and_doom.common.loot.LootModifierInit;
import com.x29naybla.bloom_and_doom.integration.Ammendments;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforgespi.locating.IModFile;

@Mod(BloomAndDoom.MOD_ID)
public class BloomAndDoom {
    public static final String MOD_ID = "bloom_and_doom";

    public BloomAndDoom(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModEffects.MOB_EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
        ModParticles.PARTICLE_TYPES.register(modEventBus);
        ModDataAttachments.ATTACHMENT_TYPES.register(modEventBus);

        ModItems.register(modEventBus);
        ModDataComponents.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModVillagers.POI_TYPES.register(modEventBus);
        ModVillagers.VILLAGER_PROFESSIONS.register(modEventBus);

        ModSounds.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        LootModifierInit.LOOT_MODIFIERS.register(modEventBus);

        if (ModList.get().isLoaded("amendments")){
            Ammendments.init();
        }

        IModFile modFile = ModLoadingContext.get().getActiveContainer().getModInfo().getOwningFile().getFile();
        modEventBus.addListener((AddPackFindersEvent event) -> {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                event.addRepositorySource(new HiResPackSource(modFile, PackType.CLIENT_RESOURCES, "BloomAndDoom-ProgrammerArt", Component.translatable("pack.bloom_and_doom.bad_pa")));
            }
        });

        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC);
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
