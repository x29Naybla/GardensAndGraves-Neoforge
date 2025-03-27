package com.x29naybla.gardensandgraves.event;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.SNAIL_SPAWN_EGG);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
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
