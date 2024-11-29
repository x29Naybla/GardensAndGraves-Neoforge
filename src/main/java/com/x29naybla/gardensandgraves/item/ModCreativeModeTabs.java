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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SEED_PACKET_SUNFLOWER.get()))
                    .title(Component.translatable("creativetab.gardensandgraves.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SEED_PACKET_SUNFLOWER);
                        output.accept(ModItems.SEED_PACKET_MARIGOLD);
                        output.accept(ModItems.SEED_PACKET_PEASHOOTER);
                        output.accept(ModItems.SEED_PACKET_REPEATER);
                        output.accept(ModItems.SEED_PACKET_SNOW_PEA);
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
                        output.accept(ModItems.BRAINZ_BANNER_PATTERN);
                        output.accept(ModItems.MUSIC_DISC_WABBY_WABBO);

                    }).build());

    public static final Supplier<CreativeModeTab> GARDENSANDGRAVES_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bloomingdefense_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PLANTER.get()))
                    .title(Component.translatable("creativetab.gardensandgraves.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
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

                    }).build());


                        public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
