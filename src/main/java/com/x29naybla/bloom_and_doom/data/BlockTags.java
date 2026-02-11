package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import com.x29naybla.bloom_and_doom.common.tag.CommonTags;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BloomAndDoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //Bloom and Doom Tags
        tag(BnDTags.Blocks.PLANTERS)
                .add(BnDBlocks.PLANTER.get())
                .add(BnDBlocks.WHITE_PLANTER.get())
                .add(BnDBlocks.LIGHT_GRAY_PLANTER.get())
                .add(BnDBlocks.GRAY_PLANTER.get())
                .add(BnDBlocks.BLACK_PLANTER.get())
                .add(BnDBlocks.BROWN_PLANTER.get())
                .add(BnDBlocks.RED_PLANTER.get())
                .add(BnDBlocks.ORANGE_PLANTER.get())
                .add(BnDBlocks.YELLOW_PLANTER.get())
                .add(BnDBlocks.LIME_PLANTER.get())
                .add(BnDBlocks.GREEN_PLANTER.get())
                .add(BnDBlocks.CYAN_PLANTER.get())
                .add(BnDBlocks.LIGHT_BLUE_PLANTER.get())
                .add(BnDBlocks.BLUE_PLANTER.get())
                .add(BnDBlocks.PURPLE_PLANTER.get())
                .add(BnDBlocks.MAGENTA_PLANTER.get())
                .add(BnDBlocks.PINK_PLANTER.get());

        tag(BnDTags.Blocks.PLASTIC_BLOCKS)
                .add(BnDBlocks.WHITE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get())
                .add(BnDBlocks.GRAY_PLASTIC_BLOCK.get())
                .add(BnDBlocks.BLACK_PLASTIC_BLOCK.get())
                .add(BnDBlocks.BROWN_PLASTIC_BLOCK.get())
                .add(BnDBlocks.RED_PLASTIC_BLOCK.get())
                .add(BnDBlocks.ORANGE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.YELLOW_PLASTIC_BLOCK.get())
                .add(BnDBlocks.LIME_PLASTIC_BLOCK.get())
                .add(BnDBlocks.GREEN_PLASTIC_BLOCK.get())
                .add(BnDBlocks.CYAN_PLASTIC_BLOCK.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.BLUE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.PURPLE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_BLOCK.get())
                .add(BnDBlocks.PINK_PLASTIC_BLOCK.get());

        tag(BnDTags.Blocks.PLASTIC_STAIRS)
                .add(BnDBlocks.WHITE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS.get())
                .add(BnDBlocks.GRAY_PLASTIC_STAIRS.get())
                .add(BnDBlocks.BLACK_PLASTIC_STAIRS.get())
                .add(BnDBlocks.BROWN_PLASTIC_STAIRS.get())
                .add(BnDBlocks.RED_PLASTIC_STAIRS.get())
                .add(BnDBlocks.ORANGE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.YELLOW_PLASTIC_STAIRS.get())
                .add(BnDBlocks.LIME_PLASTIC_STAIRS.get())
                .add(BnDBlocks.GREEN_PLASTIC_STAIRS.get())
                .add(BnDBlocks.CYAN_PLASTIC_STAIRS.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.BLUE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.PURPLE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_STAIRS.get())
                .add(BnDBlocks.PINK_PLASTIC_STAIRS.get());

        tag(BnDTags.Blocks.PLASTIC_SLABS)
                .add(BnDBlocks.WHITE_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_SLAB.get())
                .add(BnDBlocks.GRAY_PLASTIC_SLAB.get())
                .add(BnDBlocks.BLACK_PLASTIC_SLAB.get())
                .add(BnDBlocks.BROWN_PLASTIC_SLAB.get())
                .add(BnDBlocks.RED_PLASTIC_SLAB.get())
                .add(BnDBlocks.ORANGE_PLASTIC_SLAB.get())
                .add(BnDBlocks.YELLOW_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIME_PLASTIC_SLAB.get())
                .add(BnDBlocks.GREEN_PLASTIC_SLAB.get())
                .add(BnDBlocks.CYAN_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_SLAB.get())
                .add(BnDBlocks.BLUE_PLASTIC_SLAB.get())
                .add(BnDBlocks.PURPLE_PLASTIC_SLAB.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_SLAB.get())
                .add(BnDBlocks.PINK_PLASTIC_SLAB.get());

        tag(BnDTags.Blocks.PLASTIC_WALLS)
                .add(BnDBlocks.WHITE_PLASTIC_WALL.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_WALL.get())
                .add(BnDBlocks.GRAY_PLASTIC_WALL.get())
                .add(BnDBlocks.BLACK_PLASTIC_WALL.get())
                .add(BnDBlocks.BROWN_PLASTIC_WALL.get())
                .add(BnDBlocks.RED_PLASTIC_WALL.get())
                .add(BnDBlocks.ORANGE_PLASTIC_WALL.get())
                .add(BnDBlocks.YELLOW_PLASTIC_WALL.get())
                .add(BnDBlocks.LIME_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIME_PLASTIC_WALL.get())
                .add(BnDBlocks.GREEN_PLASTIC_WALL.get())
                .add(BnDBlocks.CYAN_PLASTIC_WALL.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_WALL.get())
                .add(BnDBlocks.BLUE_PLASTIC_WALL.get())
                .add(BnDBlocks.PURPLE_PLASTIC_WALL.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_WALL.get())
                .add(BnDBlocks.PINK_PLASTIC_WALL.get());

        tag(BnDTags.Blocks.SUPPORTS_PLANTS)
                .addTag(net.minecraft.tags.BlockTags.DIRT)
                .addTag(net.minecraft.tags.BlockTags.SAND)
                .add(Blocks.SANDSTONE)
                .add(Blocks.RED_SANDSTONE)
                .addTag(net.minecraft.tags.BlockTags.PLANKS)
                .addTag(net.minecraft.tags.BlockTags.LOGS)
                .add(Blocks.LILY_PAD)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_GRAVEL);

        tag(BnDTags.Blocks.SUSTAINS_MUSHROOMS)
                .addTag(net.minecraft.tags.BlockTags.MUSHROOM_GROW_BLOCK);

        tag(BnDTags.Blocks.DIRT_SUSTAINS)
                .addTag(net.minecraft.tags.BlockTags.SAPLINGS)
                .addTag(CommonTags.Blocks.MUSHROOMS)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.WARPED_FUNGUS)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.DEAD_BUSH)
                .addTag(net.minecraft.tags.BlockTags.SMALL_FLOWERS)
                .add(Blocks.BAMBOO_SAPLING)
                .add(Blocks.BAMBOO)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.WARPED_ROOTS)
                .add(Blocks.NETHER_SPROUTS)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.LARGE_FERN)
                .addTag(net.minecraft.tags.BlockTags.TALL_FLOWERS)
                .add(Blocks.BIG_DRIPLEAF)
                .add(Blocks.SMALL_DRIPLEAF)
                .addTag(net.minecraft.tags.BlockTags.CROPS)
                .add(Blocks.SWEET_BERRY_BUSH);

        tag(BnDTags.Blocks.MYCELIUM_SUSTAINS)
                .addTag(BnDTags.Blocks.DIRT_SUSTAINS);

        tag(BnDTags.Blocks.SAND_SUSTAINS)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.BAMBOO_SAPLING)
                .add(Blocks.BAMBOO)
                .add(Blocks.CACTUS);

        tag(BnDTags.Blocks.SOUL_SAND_SUSTAINS)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.NETHER_WART);

        tag(BnDTags.Blocks.NYLIUM_SUSTAINS)
                .addTag(CommonTags.Blocks.MUSHROOMS)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.WARPED_FUNGUS)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.WARPED_ROOTS)
                .add(Blocks.NETHER_SPROUTS);

        tag(BnDTags.Blocks.END_STONE_SUSTAINS)
                .add(Blocks.CHORUS_FLOWER);

        tag(BnDTags.Blocks.GRAVESTONES)
                .add(BnDBlocks.GRAVESTONE.get())
                .add(BnDBlocks.GRAVESTONE_SANDSTONE.get());

        //Common Tags
        tag(Tags.Blocks.DYED_WHITE)
                .add(BnDBlocks.WHITE_PLANTER.get())
                .add(BnDBlocks.WHITE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.WHITE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.WHITE_PLASTIC_SLAB.get())
                .add(BnDBlocks.WHITE_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_LIGHT_GRAY)
                .add(BnDBlocks.LIGHT_GRAY_PLANTER.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_GRAY)
                .add(BnDBlocks.GRAY_PLANTER.get())
                .add(BnDBlocks.GRAY_PLASTIC_BLOCK.get())
                .add(BnDBlocks.GRAY_PLASTIC_STAIRS.get())
                .add(BnDBlocks.GRAY_PLASTIC_SLAB.get())
                .add(BnDBlocks.GRAY_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_BLACK)
                .add(BnDBlocks.BLACK_PLANTER.get())
                .add(BnDBlocks.BLACK_PLASTIC_BLOCK.get())
                .add(BnDBlocks.BLACK_PLASTIC_STAIRS.get())
                .add(BnDBlocks.BLACK_PLASTIC_SLAB.get())
                .add(BnDBlocks.BLACK_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_BROWN)
                .add(BnDBlocks.BROWN_PLANTER.get())
                .add(BnDBlocks.BROWN_PLASTIC_BLOCK.get())
                .add(BnDBlocks.BROWN_PLASTIC_STAIRS.get())
                .add(BnDBlocks.BROWN_PLASTIC_SLAB.get())
                .add(BnDBlocks.BROWN_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_RED)
                .add(BnDBlocks.RED_PLANTER.get())
                .add(BnDBlocks.RED_PLASTIC_BLOCK.get())
                .add(BnDBlocks.RED_PLASTIC_STAIRS.get())
                .add(BnDBlocks.RED_PLASTIC_SLAB.get())
                .add(BnDBlocks.RED_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_ORANGE)
                .add(BnDBlocks.ORANGE_PLANTER.get())
                .add(BnDBlocks.ORANGE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.ORANGE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.ORANGE_PLASTIC_SLAB.get())
                .add(BnDBlocks.ORANGE_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_YELLOW)
                .add(BnDBlocks.YELLOW_PLANTER.get())
                .add(BnDBlocks.YELLOW_PLASTIC_BLOCK.get())
                .add(BnDBlocks.YELLOW_PLASTIC_STAIRS.get())
                .add(BnDBlocks.YELLOW_PLASTIC_SLAB.get())
                .add(BnDBlocks.YELLOW_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_LIME)
                .add(BnDBlocks.LIME_PLANTER.get())
                .add(BnDBlocks.LIME_PLASTIC_BLOCK.get())
                .add(BnDBlocks.LIME_PLASTIC_STAIRS.get())
                .add(BnDBlocks.LIME_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIME_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_GREEN)
                .add(BnDBlocks.GREEN_PLANTER.get())
                .add(BnDBlocks.GREEN_PLASTIC_BLOCK.get())
                .add(BnDBlocks.GREEN_PLASTIC_STAIRS.get())
                .add(BnDBlocks.GREEN_PLASTIC_SLAB.get())
                .add(BnDBlocks.GREEN_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_CYAN)
                .add(BnDBlocks.CYAN_PLANTER.get())
                .add(BnDBlocks.CYAN_PLASTIC_BLOCK.get())
                .add(BnDBlocks.CYAN_PLASTIC_STAIRS.get())
                .add(BnDBlocks.CYAN_PLASTIC_SLAB.get())
                .add(BnDBlocks.CYAN_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_LIGHT_BLUE)
                .add(BnDBlocks.LIGHT_BLUE_PLANTER.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_SLAB.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_BLUE)
                .add(BnDBlocks.BLUE_PLANTER.get())
                .add(BnDBlocks.BLUE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.BLUE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.BLUE_PLASTIC_SLAB.get())
                .add(BnDBlocks.BLUE_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_PURPLE)
                .add(BnDBlocks.PURPLE_PLANTER.get())
                .add(BnDBlocks.PURPLE_PLASTIC_BLOCK.get())
                .add(BnDBlocks.PURPLE_PLASTIC_STAIRS.get())
                .add(BnDBlocks.PURPLE_PLASTIC_SLAB.get())
                .add(BnDBlocks.PURPLE_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_MAGENTA)
                .add(BnDBlocks.MAGENTA_PLANTER.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_BLOCK.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_STAIRS.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_SLAB.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_WALL.get());
        tag(Tags.Blocks.DYED_PINK)
                .add(BnDBlocks.PINK_PLANTER.get())
                .add(BnDBlocks.PINK_PLASTIC_BLOCK.get())
                .add(BnDBlocks.PINK_PLASTIC_STAIRS.get())
                .add(BnDBlocks.PINK_PLASTIC_SLAB.get())
                .add(BnDBlocks.PINK_PLASTIC_WALL.get());

        tag(CommonTags.Blocks.MUSHROOMS)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .addOptional(ResourceLocation.parse("farmersdelight:brown_mushroom_colony"))
                .addOptional(ResourceLocation.parse("farmersdelight:red_mushroom_colony"));

        //Vanilla Tags
        tag(net.minecraft.tags.BlockTags.WALLS)
                .add(BnDBlocks.WHITE_PLASTIC_WALL.get())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_WALL.get())
                .add(BnDBlocks.GRAY_PLASTIC_WALL.get())
                .add(BnDBlocks.BLACK_PLASTIC_WALL.get())
                .add(BnDBlocks.BROWN_PLASTIC_WALL.get())
                .add(BnDBlocks.RED_PLASTIC_WALL.get())
                .add(BnDBlocks.ORANGE_PLASTIC_WALL.get())
                .add(BnDBlocks.YELLOW_PLASTIC_WALL.get())
                .add(BnDBlocks.LIME_PLASTIC_WALL.get())
                .add(BnDBlocks.GREEN_PLASTIC_WALL.get())
                .add(BnDBlocks.CYAN_PLASTIC_WALL.get())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_WALL.get())
                .add(BnDBlocks.BLUE_PLASTIC_WALL.get())
                .add(BnDBlocks.PURPLE_PLASTIC_WALL.get())
                .add(BnDBlocks.MAGENTA_PLASTIC_WALL.get())
                .add(BnDBlocks.PINK_PLASTIC_WALL.get());
    }
}
