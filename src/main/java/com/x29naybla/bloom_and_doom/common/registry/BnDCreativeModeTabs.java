package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.item.PottedPlantItemstacks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BnDCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BloomAndDoom.MOD_ID);

    public static final Supplier<CreativeModeTab> BLOOM_AND_DOOM_ITEMS_TAB = CREATIVE_MODE_TAB.register("bloom_and_doom_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BnDItems.SUN.get()))
                    .title(Component.translatable("creativetab.bloom_and_doom.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BnDItems.SUN);
                        output.accept(BnDItems.SUNFLOWER_SEED_PACKET);
                        output.accept(BnDItems.MARIGOLD_SEED_PACKET);
                        output.accept(BnDItems.PEASHOOTER_SEED_PACKET);
                        output.accept(BnDItems.SNOW_PEA_SEED_PACKET);
                        output.accept(BnDItems.REPEATER_SEED_PACKET);
                        output.accept(BnDItems.WALL_NUT_SEED_PACKET);
                        output.accept(BnDItems.POTATO_MINE_SEED_PACKET);
                        output.accept(BnDItems.JALAPENO_SEED_PACKET);
                        output.accept(BnDItems.COFFEE_BEAN_SEED_PACKET);
                        output.accept(BnDItems.CHOMPER_SEED_PACKET);
                        output.accept(BnDItems.BONK_CHOY_SEED_PACKET);
                        output.accept(BnDItems.SUN_SHROOM_SEED_PACKET);
                        output.accept(BnDItems.PUFF_SHROOM_SEED_PACKET);
                        output.accept(BnDItems.FUME_SHROOM_SEED_PACKET);
                        output.accept(BnDItems.HYPNO_SHROOM_SEED_PACKET);
                        output.accept(BnDItems.DOOM_SHROOM_SEED_PACKET);
                        output.accept(PottedPlantItemstacks.PottedSproutInstance());
                        output.accept(PottedPlantItemstacks.PottedSunflowerInstance());
                        output.accept(PottedPlantItemstacks.PottedMarigoldInstance());
                        output.accept(PottedPlantItemstacks.PottedPeashooterInstance());
                        output.accept(PottedPlantItemstacks.PottedSnowPeaInstance());
                        output.accept(PottedPlantItemstacks.PottedRepeaterInstance());
                        output.accept(PottedPlantItemstacks.PottedPotatoMineInstance());
                        output.accept(PottedPlantItemstacks.PottedBonkChoyInstance());
                        output.accept(PottedPlantItemstacks.PottedSunShroomInstance());
                        output.accept(PottedPlantItemstacks.PottedPuffShroomInstance());
                        output.accept(BnDItems.WHITE_WATERING_CAN);
                        output.accept(BnDItems.LIGHT_GRAY_WATERING_CAN);
                        output.accept(BnDItems.GRAY_WATERING_CAN);
                        output.accept(BnDItems.BLACK_WATERING_CAN);
                        output.accept(BnDItems.BROWN_WATERING_CAN);
                        output.accept(BnDItems.RED_WATERING_CAN);
                        output.accept(BnDItems.ORANGE_WATERING_CAN);
                        output.accept(BnDItems.YELLOW_WATERING_CAN);
                        output.accept(BnDItems.LIME_WATERING_CAN);
                        output.accept(BnDItems.GREEN_WATERING_CAN);
                        output.accept(BnDItems.CYAN_WATERING_CAN);
                        output.accept(BnDItems.LIGHT_BLUE_WATERING_CAN);
                        output.accept(BnDItems.BLUE_WATERING_CAN);
                        output.accept(BnDItems.PURPLE_WATERING_CAN);
                        output.accept(BnDItems.MAGENTA_WATERING_CAN);
                        output.accept(BnDItems.PINK_WATERING_CAN);
                        output.accept(BnDItems.MUSIC_DISC_WABBY_WABBO);
                        output.accept(BnDItems.PEA);
                        output.accept(BnDItems.FROZEN_PEA);
                        output.accept(BnDItems.SPORE);
                        output.accept(BnDItems.ALMANAC);
                        output.accept(BnDItems.BRAIN);
                        output.accept(BnDItems.BRAINZ_BANNER_PATTERN);
                        output.accept(BnDItems.ZOMBIE_WOLF_SPAWN_EGG);

                    }).build());

    public static final Supplier<CreativeModeTab> BLOOM_AND_DOOM_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bloom_and_doom_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BnDBlocks.PLANTER.get()))
                    .title(Component.translatable("creativetab.bloom_and_doom.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BnDBlocks.POTTING_TABLE);
                        output.accept(BnDBlocks.PLANTER);
                        output.accept(BnDBlocks.WHITE_PLANTER);
                        output.accept(BnDBlocks.LIGHT_GRAY_PLANTER);
                        output.accept(BnDBlocks.GRAY_PLANTER);
                        output.accept(BnDBlocks.BLACK_PLANTER);
                        output.accept(BnDBlocks.BROWN_PLANTER);
                        output.accept(BnDBlocks.RED_PLANTER);
                        output.accept(BnDBlocks.ORANGE_PLANTER);
                        output.accept(BnDBlocks.YELLOW_PLANTER);
                        output.accept(BnDBlocks.LIME_PLANTER);
                        output.accept(BnDBlocks.GREEN_PLANTER);
                        output.accept(BnDBlocks.CYAN_PLANTER);
                        output.accept(BnDBlocks.LIGHT_BLUE_PLANTER);
                        output.accept(BnDBlocks.BLUE_PLANTER);
                        output.accept(BnDBlocks.PURPLE_PLANTER);
                        output.accept(BnDBlocks.MAGENTA_PLANTER);
                        output.accept(BnDBlocks.PINK_PLANTER);

                        output.accept(BnDBlocks.WHITE_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.WHITE_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.GRAY_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.GRAY_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.BLACK_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.BLACK_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.BROWN_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.BROWN_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.RED_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.RED_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.ORANGE_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.ORANGE_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.YELLOW_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.YELLOW_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.LIME_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.LIME_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.GREEN_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.GREEN_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.CYAN_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.CYAN_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.BLUE_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.BLUE_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.PURPLE_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.PURPLE_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.MAGENTA_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.MAGENTA_PLASTIC_STAIRS);
                        output.accept(BnDBlocks.PINK_PLASTIC_BLOCK);
                        output.accept(BnDBlocks.PINK_PLASTIC_STAIRS);

                        output.accept(BnDBlocks.GRAVESTONE);
                        output.accept(BnDBlocks.GRAVESTONE_SANDSTONE);

                    }).build());


                        public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
