package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BloomAndDoom.MOD_ID);

    public static final Supplier<CreativeModeTab> BLOOM_AND_DOOM_ITEMS_TAB = CREATIVE_MODE_TAB.register("bloom_and_doom_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SUN.get()))
                    .title(Component.translatable("creativetab.bloom_and_doom.items"))
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
                        output.accept(ModItems.WHITE_WATERING_CAN);
                        output.accept(ModItems.LIGHT_GRAY_WATERING_CAN);
                        output.accept(ModItems.GRAY_WATERING_CAN);
                        output.accept(ModItems.BLACK_WATERING_CAN);
                        output.accept(ModItems.BROWN_WATERING_CAN);
                        output.accept(ModItems.RED_WATERING_CAN);
                        output.accept(ModItems.ORANGE_WATERING_CAN);
                        output.accept(ModItems.YELLOW_WATERING_CAN);
                        output.accept(ModItems.LIME_WATERING_CAN);
                        output.accept(ModItems.GREEN_WATERING_CAN);
                        output.accept(ModItems.CYAN_WATERING_CAN);
                        output.accept(ModItems.LIGHT_BLUE_WATERING_CAN);
                        output.accept(ModItems.BLUE_WATERING_CAN);
                        output.accept(ModItems.PURPLE_WATERING_CAN);
                        output.accept(ModItems.MAGENTA_WATERING_CAN);
                        output.accept(ModItems.PINK_WATERING_CAN);
                        output.accept(ModItems.MUSIC_DISC_WABBY_WABBO);
                        output.accept(ModItems.PEA);
                        output.accept(ModItems.FROZEN_PEA);
                        output.accept(ModItems.SPORE);
                        output.accept(ModItems.ALMANAC);
                        output.accept(ModItems.BRAIN);
                        output.accept(ModItems.BRAINZ_BANNER_PATTERN);

                    }).build());

    public static final Supplier<CreativeModeTab> BLOOM_AND_DOOM_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bloom_and_doom_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PLANTER.get()))
                    .title(Component.translatable("creativetab.bloom_and_doom.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.POTTING_TABLE);
                        output.accept(ModBlocks.PLANTER);
                        output.accept(ModBlocks.WHITE_PLANTER);
                        output.accept(ModBlocks.LIGHT_GRAY_PLANTER);
                        output.accept(ModBlocks.GRAY_PLANTER);
                        output.accept(ModBlocks.BLACK_PLANTER);
                        output.accept(ModBlocks.BROWN_PLANTER);
                        output.accept(ModBlocks.RED_PLANTER);
                        output.accept(ModBlocks.ORANGE_PLANTER);
                        output.accept(ModBlocks.YELLOW_PLANTER);
                        output.accept(ModBlocks.LIME_PLANTER);
                        output.accept(ModBlocks.GREEN_PLANTER);
                        output.accept(ModBlocks.CYAN_PLANTER);
                        output.accept(ModBlocks.LIGHT_BLUE_PLANTER);
                        output.accept(ModBlocks.BLUE_PLANTER);
                        output.accept(ModBlocks.PURPLE_PLANTER);
                        output.accept(ModBlocks.MAGENTA_PLANTER);
                        output.accept(ModBlocks.PINK_PLANTER);

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
