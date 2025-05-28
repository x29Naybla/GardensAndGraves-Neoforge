package com.x29naybla.gardensandgraves.event;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.item.ZombieBanner;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Blocks.SMITHING_TABLE.asItem().getDefaultInstance(), ModBlocks.POTTING_TABLE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Raid.getLeaderBannerInstance(event.getParameters().holders().lookupOrThrow(Registries.BANNER_PATTERN)), ZombieBanner.getZombieLeaderBannerInstance(event.getParameters().holders().lookupOrThrow(Registries.BANNER_PATTERN)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.insertAfter(Items.MUSIC_DISC_PIGSTEP.getDefaultInstance(), ModItems.MUSIC_DISC_WABBY_WABBO.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(ModItems.WATERING_CAN_WHITE);
            event.accept(ModItems.WATERING_CAN_LIGHT_GRAY);
            event.accept(ModItems.WATERING_CAN_GRAY);
            event.accept(ModItems.WATERING_CAN_BLACK);
            event.accept(ModItems.WATERING_CAN_BROWN);
            event.accept(ModItems.WATERING_CAN_RED);
            event.accept(ModItems.WATERING_CAN_ORANGE);
            event.accept(ModItems.WATERING_CAN_YELLOW);
            event.accept(ModItems.WATERING_CAN_LIME);
            event.accept(ModItems.WATERING_CAN_GREEN);
            event.accept(ModItems.WATERING_CAN_CYAN);
            event.accept(ModItems.WATERING_CAN_LIGHT_BLUE);
            event.accept(ModItems.WATERING_CAN_BLUE);
            event.accept(ModItems.WATERING_CAN_PURPLE);
            event.accept(ModItems.WATERING_CAN_MAGENTA);
            event.accept(ModItems.WATERING_CAN_PINK);
        }
    }
}
