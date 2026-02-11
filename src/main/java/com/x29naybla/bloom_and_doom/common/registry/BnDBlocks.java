package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.block.GravestoneBlock;
import com.x29naybla.bloom_and_doom.common.block.PlanterBlock;
import com.x29naybla.bloom_and_doom.common.block.PottingTableBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BnDBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BloomAndDoom.MOD_ID);

    public static final DeferredBlock<Block> PLASTIC_ORE = registerBlock("plastic_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));

    public static final DeferredBlock<Block> POTTING_TABLE = registerBlock("potting_table",
            () -> new PottingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

    public static final DeferredBlock<Block> PLANTER = registerBlock("planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
    public static final DeferredBlock<Block> WHITE_PLANTER = registerBlock("white_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_GRAY_PLANTER = registerBlock("light_gray_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> GRAY_PLANTER = registerBlock("gray_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
    public static final DeferredBlock<Block> BLACK_PLANTER = registerBlock("black_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
    public static final DeferredBlock<Block> BROWN_PLANTER = registerBlock("brown_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
    public static final DeferredBlock<Block> RED_PLANTER = registerBlock("red_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
    public static final DeferredBlock<Block> ORANGE_PLANTER = registerBlock("orange_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
    public static final DeferredBlock<Block> YELLOW_PLANTER = registerBlock("yellow_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
    public static final DeferredBlock<Block> LIME_PLANTER = registerBlock("lime_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
    public static final DeferredBlock<Block> GREEN_PLANTER = registerBlock("green_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
    public static final DeferredBlock<Block> CYAN_PLANTER = registerBlock("cyan_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
    public static final DeferredBlock<Block> LIGHT_BLUE_PLANTER = registerBlock("light_blue_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> BLUE_PLANTER = registerBlock("blue_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
    public static final DeferredBlock<Block> PURPLE_PLANTER = registerBlock("purple_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
    public static final DeferredBlock<Block> MAGENTA_PLANTER = registerBlock("magenta_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
    public static final DeferredBlock<Block> PINK_PLANTER = registerBlock("pink_planter",
            () -> new PlanterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));

    public static final DeferredBlock<Block> GRAVESTONE = registerBlock("gravestone",
            () -> new GravestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
    public static final DeferredBlock<Block> GRAVESTONE_SANDSTONE = registerBlock("gravestone_sandstone",
            () -> new GravestoneBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    public static final DeferredBlock<Block> WHITE_PLASTIC_BLOCK = registerBlock("white_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> WHITE_PLASTIC_STAIRS = registerBlock("white_plastic_stairs",
            () -> new StairBlock(BnDBlocks.WHITE_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> WHITE_PLASTIC_SLAB = registerBlock("white_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> WHITE_PLASTIC_WALL = registerBlock("white_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> LIGHT_GRAY_PLASTIC_BLOCK = registerBlock("light_gray_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> LIGHT_GRAY_PLASTIC_STAIRS = registerBlock("light_gray_plastic_stairs",
            () -> new StairBlock(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> LIGHT_GRAY_PLASTIC_SLAB = registerBlock("light_gray_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> LIGHT_GRAY_PLASTIC_WALL = registerBlock("light_gray_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> GRAY_PLASTIC_BLOCK = registerBlock("gray_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> GRAY_PLASTIC_STAIRS = registerBlock("gray_plastic_stairs",
            () -> new StairBlock(BnDBlocks.GRAY_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> GRAY_PLASTIC_SLAB = registerBlock("gray_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> GRAY_PLASTIC_WALL = registerBlock("gray_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> BLACK_PLASTIC_BLOCK = registerBlock("black_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> BLACK_PLASTIC_STAIRS = registerBlock("black_plastic_stairs",
            () -> new StairBlock(BnDBlocks.BLACK_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> BLACK_PLASTIC_SLAB = registerBlock("black_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> BLACK_PLASTIC_WALL = registerBlock("black_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> BROWN_PLASTIC_BLOCK = registerBlock("brown_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> BROWN_PLASTIC_STAIRS = registerBlock("brown_plastic_stairs",
            () -> new StairBlock(BnDBlocks.BROWN_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> BROWN_PLASTIC_SLAB = registerBlock("brown_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> BROWN_PLASTIC_WALL = registerBlock("brown_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> RED_PLASTIC_BLOCK = registerBlock("red_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> RED_PLASTIC_STAIRS = registerBlock("red_plastic_stairs",
            () -> new StairBlock(BnDBlocks.RED_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> RED_PLASTIC_SLAB = registerBlock("red_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> RED_PLASTIC_WALL = registerBlock("red_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> ORANGE_PLASTIC_BLOCK = registerBlock("orange_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> ORANGE_PLASTIC_STAIRS = registerBlock("orange_plastic_stairs",
            () -> new StairBlock(BnDBlocks.ORANGE_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> ORANGE_PLASTIC_SLAB = registerBlock("orange_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> ORANGE_PLASTIC_WALL = registerBlock("orange_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> YELLOW_PLASTIC_BLOCK = registerBlock("yellow_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> YELLOW_PLASTIC_STAIRS = registerBlock("yellow_plastic_stairs",
            () -> new StairBlock(BnDBlocks.YELLOW_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> YELLOW_PLASTIC_SLAB = registerBlock("yellow_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> YELLOW_PLASTIC_WALL = registerBlock("yellow_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> LIME_PLASTIC_BLOCK = registerBlock("lime_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> LIME_PLASTIC_STAIRS = registerBlock("lime_plastic_stairs",
            () -> new StairBlock(BnDBlocks.LIME_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> LIME_PLASTIC_SLAB = registerBlock("lime_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> LIME_PLASTIC_WALL = registerBlock("lime_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> GREEN_PLASTIC_BLOCK = registerBlock("green_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> GREEN_PLASTIC_STAIRS = registerBlock("green_plastic_stairs",
            () -> new StairBlock(BnDBlocks.GREEN_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> GREEN_PLASTIC_SLAB = registerBlock("green_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> GREEN_PLASTIC_WALL = registerBlock("green_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> CYAN_PLASTIC_BLOCK = registerBlock("cyan_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> CYAN_PLASTIC_STAIRS = registerBlock("cyan_plastic_stairs",
            () -> new StairBlock(BnDBlocks.CYAN_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> CYAN_PLASTIC_SLAB = registerBlock("cyan_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> CYAN_PLASTIC_WALL = registerBlock("cyan_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> LIGHT_BLUE_PLASTIC_BLOCK = registerBlock("light_blue_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> LIGHT_BLUE_PLASTIC_STAIRS = registerBlock("light_blue_plastic_stairs",
            () -> new StairBlock(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> LIGHT_BLUE_PLASTIC_SLAB = registerBlock("light_blue_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> LIGHT_BLUE_PLASTIC_WALL = registerBlock("light_blue_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> BLUE_PLASTIC_BLOCK = registerBlock("blue_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> BLUE_PLASTIC_STAIRS = registerBlock("blue_plastic_stairs",
            () -> new StairBlock(BnDBlocks.BLUE_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> BLUE_PLASTIC_SLAB = registerBlock("blue_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> BLUE_PLASTIC_WALL = registerBlock("blue_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> PURPLE_PLASTIC_BLOCK = registerBlock("purple_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> PURPLE_PLASTIC_STAIRS = registerBlock("purple_plastic_stairs",
            () -> new StairBlock(BnDBlocks.PURPLE_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> PURPLE_PLASTIC_SLAB = registerBlock("purple_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> PURPLE_PLASTIC_WALL = registerBlock("purple_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> MAGENTA_PLASTIC_BLOCK = registerBlock("magenta_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> MAGENTA_PLASTIC_STAIRS = registerBlock("magenta_plastic_stairs",
            () -> new StairBlock(BnDBlocks.MAGENTA_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> MAGENTA_PLASTIC_SLAB = registerBlock("magenta_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> MAGENTA_PLASTIC_WALL = registerBlock("magenta_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    public static final DeferredBlock<Block> PINK_PLASTIC_BLOCK = registerBlock("pink_plastic_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<StairBlock> PINK_PLASTIC_STAIRS = registerBlock("pink_plastic_stairs",
            () -> new StairBlock(BnDBlocks.PINK_PLASTIC_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<SlabBlock> PINK_PLASTIC_SLAB = registerBlock("pink_plastic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<WallBlock> PINK_PLASTIC_WALL = registerBlock("pink_plastic_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        BnDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
