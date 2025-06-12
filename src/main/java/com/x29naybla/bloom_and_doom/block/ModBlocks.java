package com.x29naybla.bloom_and_doom.block;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.block.custom.*;
import com.x29naybla.bloom_and_doom.item.ModItems;
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
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BloomAndDoom.MOD_ID);

    public static final DeferredBlock<Block> POTTING_TABLE = registerBlock("potting_table",
            () -> new PottingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    public static final DeferredBlock<Block> PLANTER = registerBlock("planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> WHITE_PLANTER = registerBlock("white_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> LIGHT_GRAY_PLANTER = registerBlock("light_gray_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> GRAY_PLANTER = registerBlock("gray_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> BLACK_PLANTER = registerBlock("black_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> BROWN_PLANTER = registerBlock("brown_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> RED_PLANTER = registerBlock("red_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> ORANGE_PLANTER = registerBlock("orange_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> YELLOW_PLANTER = registerBlock("yellow_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> LIME_PLANTER = registerBlock("lime_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> GREEN_PLANTER = registerBlock("green_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> CYAN_PLANTER = registerBlock("cyan_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> LIGHT_BLUE_PLANTER = registerBlock("light_blue_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> BLUE_PLANTER = registerBlock("blue_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> PURPLE_PLANTER = registerBlock("purple_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> MAGENTA_PLANTER = registerBlock("magenta_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA).noOcclusion().randomTicks()));
    public static final DeferredBlock<Block> PINK_PLANTER = registerBlock("pink_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA).noOcclusion().randomTicks()));

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
