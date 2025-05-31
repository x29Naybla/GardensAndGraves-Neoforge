package com.x29naybla.gardensandgraves;

import com.x29naybla.gardensandgraves.block.ModBlocks;
import com.x29naybla.gardensandgraves.block.entity.ModBlockEntities;
import com.x29naybla.gardensandgraves.data.ModDataAttachments;
import com.x29naybla.gardensandgraves.data.ModDataComponents;
import com.x29naybla.gardensandgraves.effect.ModEffects;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import com.x29naybla.gardensandgraves.item.ModCreativeModeTabs;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.loot.LootModifierInit;
import com.x29naybla.gardensandgraves.particle.ModParticles;
import com.x29naybla.gardensandgraves.potion.ModPotions;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import com.x29naybla.gardensandgraves.villager.ModVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(GardensAndGraves.MOD_ID)
public class GardensAndGraves {
    public static final String MOD_ID = "gardensandgraves";


    public GardensAndGraves(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);


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

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
