package com.x29naybla.gardensandgraves.item;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GardensAndGraves.MOD_ID);

    public static final Supplier<CreativeModeTab> GARDENSANDGRAVES_ITEMS_TAB = CREATIVE_MODE_TAB.register("bloomingdefense_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SUN.get()))
                    .title(Component.translatable("creativetab.gardensandgraves.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SUN);
                        output.accept(ModItems.SEED_PACKET_SUNFLOWER);
                        output.accept(ModItems.SEED_PACKET_MARIGOLD);
                        output.accept(ModItems.SEED_PACKET_PEASHOOTER);
                        output.accept(ModItems.SEED_PACKET_SNOW_PEA);
                        output.accept(ModItems.SEED_PACKET_REPEATER);
                        output.accept(ModItems.SEED_PACKET_WALL_NUT);
                        output.accept(ModItems.SEED_PACKET_POTATO_MINE);
                        output.accept(ModItems.SEED_PACKET_JALAPENO);
                        output.accept(ModItems.SEED_PACKET_CHOMPER);
                        output.accept(ModItems.SEED_PACKET_BONK_CHOY);
                        output.accept(ModItems.SEED_PACKET_SUN_SHROOM);
                        output.accept(ModItems.SEED_PACKET_PUFF_SHROOM);
                        output.accept(ModItems.SEED_PACKET_FUME_SHROOM);
                        output.accept(ModItems.SEED_PACKET_HYPNO_SHROOM);
                        output.accept(ModItems.SEED_PACKET_DOOM_SHROOM);
                        output.accept(ModItems.POTTED_SUNFLOWER);
                        output.accept(ModItems.POTTED_MARIGOLD);
                        output.accept(ModItems.POTTED_PEASHOOTER);
                        output.accept(ModItems.POTTED_SNOW_PEA);
                        output.accept(ModItems.POTTED_REPEATER);
                        output.accept(ModItems.POTTED_POTATO_MINE);
                        output.accept(ModItems.POTTED_SUN_SHROOM);
                        output.accept(ModItems.POTTED_PUFF_SHROOM);
                        output.accept(ModItems.WATERING_CAN_WHITE);
                        output.accept(ModItems.WATERING_CAN_LIGHT_GRAY);
                        output.accept(ModItems.WATERING_CAN_GRAY);
                        output.accept(ModItems.WATERING_CAN_BLACK);
                        output.accept(ModItems.WATERING_CAN_BROWN);
                        output.accept(ModItems.WATERING_CAN_RED);
                        output.accept(ModItems.WATERING_CAN_ORANGE);
                        output.accept(ModItems.WATERING_CAN_YELLOW);
                        output.accept(ModItems.WATERING_CAN_LIME);
                        output.accept(ModItems.WATERING_CAN_GREEN);
                        output.accept(ModItems.WATERING_CAN_CYAN);
                        output.accept(ModItems.WATERING_CAN_LIGHT_BLUE);
                        output.accept(ModItems.WATERING_CAN_BLUE);
                        output.accept(ModItems.WATERING_CAN_PURPLE);
                        output.accept(ModItems.WATERING_CAN_MAGENTA);
                        output.accept(ModItems.WATERING_CAN_PINK);
                        output.accept(ModItems.MUSIC_DISC_WABBY_WABBO);
                        output.accept(ModItems.PEA);
                        output.accept(ModItems.FROZEN_PEA);
                        output.accept(ModItems.SPORE);
                        output.accept(ModItems.SNAIL_SPAWN_EGG);
                        output.accept(ModItems.BRAIN);
                        output.accept(ModItems.BRAINZ_BANNER_PATTERN);

                    }).build());

    public static final Supplier<CreativeModeTab> GARDENSANDGRAVES_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bloomingdefense_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PLANTER.get()))
                    .title(Component.translatable("creativetab.gardensandgraves.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.POTTING_TABLE);
                        output.accept(ModBlocks.PLANTER);
                        output.accept(ModBlocks.PLANTER_WHITE);
                        output.accept(ModBlocks.PLANTER_LIGHT_GRAY);
                        output.accept(ModBlocks.PLANTER_GRAY);
                        output.accept(ModBlocks.PLANTER_BLACK);
                        output.accept(ModBlocks.PLANTER_BROWN);
                        output.accept(ModBlocks.PLANTER_RED);
                        output.accept(ModBlocks.PLANTER_ORANGE);
                        output.accept(ModBlocks.PLANTER_YELLOW);
                        output.accept(ModBlocks.PLANTER_LIME);
                        output.accept(ModBlocks.PLANTER_GREEN);
                        output.accept(ModBlocks.PLANTER_CYAN);
                        output.accept(ModBlocks.PLANTER_LIGHT_BLUE);
                        output.accept(ModBlocks.PLANTER_BLUE);
                        output.accept(ModBlocks.PLANTER_PURPLE);
                        output.accept(ModBlocks.PLANTER_MAGENTA);
                        output.accept(ModBlocks.PLANTER_PINK);

                        output.accept(ModBlocks.WHITE_PLASTIC_BLOCK);
                        output.accept(ModBlocks.LIGHT_GRAY_PLASTIC_BLOCK);
                        output.accept(ModBlocks.GRAY_PLASTIC_BLOCK);
                        output.accept(ModBlocks.BLACK_PLASTIC_BLOCK);
                        output.accept(ModBlocks.BROWN_PLASTIC_BLOCK);
                        output.accept(ModBlocks.RED_PLASTIC_BLOCK);
                        output.accept(ModBlocks.ORANGE_PLASTIC_BLOCK);
                        output.accept(ModBlocks.YELLOW_PLASTIC_BLOCK);
                        output.accept(ModBlocks.LIME_PLASTIC_BLOCK);
                        output.accept(ModBlocks.GREEN_PLASTIC_BLOCK);
                        output.accept(ModBlocks.CYAN_PLASTIC_BLOCK);
                        output.accept(ModBlocks.LIGHT_BLUE_PLASTIC_BLOCK);
                        output.accept(ModBlocks.BLUE_PLASTIC_BLOCK);
                        output.accept(ModBlocks.PURPLE_PLASTIC_BLOCK);
                        output.accept(ModBlocks.MAGENTA_PLASTIC_BLOCK);
                        output.accept(ModBlocks.PINK_PLASTIC_BLOCK);

                        output.accept(ModBlocks.GRAVESTONE);
                        output.accept(ModBlocks.GRAVESTONE_SANDSTONE);

                    }).build());


                        public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
