package com.x29naybla.bloom_and_doom.common.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.ModBlocks;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.item.ZombieBanner;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Blocks.SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.POTTING_TABLE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Raid.getLeaderBannerInstance(event.getParameters().holders().lookupOrThrow(Registries.BANNER_PATTERN)), ZombieBanner.getZombieLeaderBannerInstance(event.getParameters().holders().lookupOrThrow(Registries.BANNER_PATTERN)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.insertAfter(Items.MUSIC_DISC_PIGSTEP.getDefaultInstance(), ModItems.MUSIC_DISC_WABBY_WABBO.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModItems.WHITE_WATERING_CAN);
            event.accept(ModItems.LIGHT_GRAY_WATERING_CAN);
            event.accept(ModItems.GRAY_WATERING_CAN);
            event.accept(ModItems.BLACK_WATERING_CAN);
            event.accept(ModItems.BROWN_WATERING_CAN);
            event.accept(ModItems.RED_WATERING_CAN);
            event.accept(ModItems.ORANGE_WATERING_CAN);
            event.accept(ModItems.YELLOW_WATERING_CAN);
            event.accept(ModItems.LIME_WATERING_CAN);
            event.accept(ModItems.GREEN_WATERING_CAN);
            event.accept(ModItems.CYAN_WATERING_CAN);
            event.accept(ModItems.LIGHT_BLUE_WATERING_CAN);
            event.accept(ModItems.BLUE_WATERING_CAN);
            event.accept(ModItems.PURPLE_WATERING_CAN);
            event.accept(ModItems.MAGENTA_WATERING_CAN);
            event.accept(ModItems.PINK_WATERING_CAN);
        }
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS){
            event.accept(ModItems.ZOMBIE_WOLF_SPAWN_EGG);
        }
    }
}
