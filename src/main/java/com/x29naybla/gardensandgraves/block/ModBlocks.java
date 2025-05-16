package com.x29naybla.gardensandgraves.block;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.custom.*;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GardensAndGraves.MOD_ID);

    public static final DeferredBlock<Block> POTTING_TABLE = registerBlock("potting_table",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    public static final DeferredBlock<Block> PLANTER = registerBlock("planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_WHITE = registerBlock("planter_white",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_LIGHT_GRAY = registerBlock("planter_light_gray",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_GRAY = registerBlock("planter_gray",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_BLACK = registerBlock("planter_black",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_BROWN = registerBlock("planter_brown",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_RED = registerBlock("planter_red",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_ORANGE = registerBlock("planter_orange",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_YELLOW = registerBlock("planter_yellow",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_LIME = registerBlock("planter_lime",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_GREEN = registerBlock("planter_green",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_CYAN = registerBlock("planter_cyan",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_LIGHT_BLUE = registerBlock("planter_light_blue",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_BLUE = registerBlock("planter_blue",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_PURPLE = registerBlock("planter_purple",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_MAGENTA = registerBlock("planter_magenta",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA).noOcclusion()));
    public static final DeferredBlock<Block> PLANTER_PINK = registerBlock("planter_pink",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA).noOcclusion()));

    public static final DeferredBlock<Block> GRAVESTONE = registerBlock("gravestone",
            () -> new GravestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS).noOcclusion()));
    public static final DeferredBlock<Block> GRAVESTONE_SANDSTONE = registerBlock("gravestone_sandstone",
            () -> new GravestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).noOcclusion()));

    public static final DeferredBlock<Block> WHITE_PLASTIC_BLOCK = registerBlock("white_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_GRAY_PLASTIC_BLOCK = registerBlock("light_gray_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> GRAY_PLASTIC_BLOCK = registerBlock("gray_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> BLACK_PLASTIC_BLOCK = registerBlock("black_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> BROWN_PLASTIC_BLOCK = registerBlock("brown_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> RED_PLASTIC_BLOCK = registerBlock("red_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> ORANGE_PLASTIC_BLOCK = registerBlock("orange_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> YELLOW_PLASTIC_BLOCK = registerBlock("yellow_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> LIME_PLASTIC_BLOCK = registerBlock("lime_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> GREEN_PLASTIC_BLOCK = registerBlock("green_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> CYAN_PLASTIC_BLOCK = registerBlock("cyan_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> LIGHT_BLUE_PLASTIC_BLOCK = registerBlock("light_blue_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> BLUE_PLASTIC_BLOCK = registerBlock("blue_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> PURPLE_PLASTIC_BLOCK = registerBlock("purple_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> MAGENTA_PLASTIC_BLOCK = registerBlock("magenta_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> PINK_PLASTIC_BLOCK = registerBlock("pink_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
