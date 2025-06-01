package com.x29naybla.bloom_and_doom;

import com.x29naybla.bloom_and_doom.block.ModBlocks;
import com.x29naybla.bloom_and_doom.block.entity.ModBlockEntities;
import com.x29naybla.bloom_and_doom.data.ModDataAttachments;
import com.x29naybla.bloom_and_doom.data.ModDataComponents;
import com.x29naybla.bloom_and_doom.effect.ModEffects;
import com.x29naybla.bloom_and_doom.entity.ModEntities;
import com.x29naybla.bloom_and_doom.item.ModCreativeModeTabs;
import com.x29naybla.bloom_and_doom.item.ModItems;
import com.x29naybla.bloom_and_doom.loot.LootModifierInit;
import com.x29naybla.bloom_and_doom.particle.ModParticles;
import com.x29naybla.bloom_and_doom.potion.ModPotions;
import com.x29naybla.bloom_and_doom.sound.ModSounds;
import com.x29naybla.bloom_and_doom.villager.ModVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

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

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
