package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BloomAndDoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Gardens and Graves Tags
        tag(ModTags.Blocks.PLANTERS)
                .add(ModBlocks.PLANTER.get())
                .add(ModBlocks.WHITE_PLANTER.get())
                .add(ModBlocks.LIGHT_GRAY_PLANTER.get())
                .add(ModBlocks.GRAY_PLANTER.get())
                .add(ModBlocks.BLACK_PLANTER.get())
                .add(ModBlocks.BROWN_PLANTER.get())
                .add(ModBlocks.RED_PLANTER.get())
                .add(ModBlocks.ORANGE_PLANTER.get())
                .add(ModBlocks.YELLOW_PLANTER.get())
                .add(ModBlocks.LIME_PLANTER.get())
                .add(ModBlocks.GREEN_PLANTER.get())
                .add(ModBlocks.CYAN_PLANTER.get())
                .add(ModBlocks.LIGHT_BLUE_PLANTER.get())
                .add(ModBlocks.BLUE_PLANTER.get())
                .add(ModBlocks.PURPLE_PLANTER.get())
                .add(ModBlocks.MAGENTA_PLANTER.get())
                .add(ModBlocks.PINK_PLANTER.get());

        tag(ModTags.Blocks.SUPPORTS_PLANTS)
                .addTag(BlockTags.DIRT)
                .addTag(BlockTags.SAND)
                .add(Blocks.SANDSTONE)
                .add(Blocks.RED_SANDSTONE)
                .addTag(BlockTags.PLANKS)
                .addTag(BlockTags.LOGS)
                .add(Blocks.LILY_PAD)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_GRAVEL);

        tag(ModTags.Blocks.SUSTAINS_MUSHROOMS)
                .addTag(BlockTags.MUSHROOM_GROW_BLOCK);

        tag(ModTags.Blocks.DIRT_SUSTAINS)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.LARGE_FERN)
                .add(Blocks.BAMBOO_SAPLING)
                .add(Blocks.BAMBOO)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.SMALL_DRIPLEAF)
                .add(Blocks.BIG_DRIPLEAF)
                .addTag(BlockTags.CROPS)
                .addTag(BlockTags.FLOWERS)
                .addTag(BlockTags.SAPLINGS)
                .addTag(ModTags.Blocks.MUSHROOMS)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.WARPED_FUNGUS)
                .add(Blocks.WARPED_ROOTS)
                .add(Blocks.NETHER_SPROUTS);

        tag(ModTags.Blocks.MYCELIUM_SUSTAINS)
                .addTag(ModTags.Blocks.DIRT_SUSTAINS);

        tag(ModTags.Blocks.SAND_SUSTAINS)
                .add(Blocks.CACTUS)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.BAMBOO_SAPLING)
                .add(Blocks.BAMBOO);

        tag(ModTags.Blocks.SOUL_SAND_SUSTAINS)
                .add(Blocks.NETHER_WART)
                .add(Blocks.WITHER_ROSE);

        tag(ModTags.Blocks.NYLIUM_SUSTAINS)
                .addTag(ModTags.Blocks.MUSHROOMS)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.WARPED_FUNGUS)
                .add(Blocks.WARPED_ROOTS)
                .add(Blocks.NETHER_SPROUTS);

        tag(ModTags.Blocks.END_STONE_SUSTAINS)
                .add(Blocks.CHORUS_FLOWER);

        tag(ModTags.Blocks.GRAVESTONES)
                .add(ModBlocks.GRAVESTONE.get())
                .add(ModBlocks.GRAVESTONE_SANDSTONE.get());

        //Common Tags
        tag(Tags.Blocks.DYED_WHITE)
                .add(ModBlocks.WHITE_PLANTER.get())
                .add(ModBlocks.WHITE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_LIGHT_GRAY)
                .add(ModBlocks.LIGHT_GRAY_PLANTER.get())
                .add(ModBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_GRAY)
                .add(ModBlocks.GRAY_PLANTER.get())
                .add(ModBlocks.GRAY_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_BLACK)
                .add(ModBlocks.BLACK_PLANTER.get())
                .add(ModBlocks.BLACK_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_BROWN)
                .add(ModBlocks.BROWN_PLANTER.get())
                .add(ModBlocks.BROWN_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_RED)
                .add(ModBlocks.RED_PLANTER.get())
                .add(ModBlocks.RED_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_ORANGE)
                .add(ModBlocks.ORANGE_PLANTER.get())
                .add(ModBlocks.ORANGE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_YELLOW)
                .add(ModBlocks.YELLOW_PLANTER.get())
                .add(ModBlocks.YELLOW_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_LIME)
                .add(ModBlocks.LIME_PLANTER.get())
                .add(ModBlocks.LIME_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_GREEN)
                .add(ModBlocks.GREEN_PLANTER.get())
                .add(ModBlocks.GREEN_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_CYAN)
                .add(ModBlocks.CYAN_PLANTER.get())
                .add(ModBlocks.CYAN_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_LIGHT_BLUE)
                .add(ModBlocks.LIGHT_BLUE_PLANTER.get())
                .add(ModBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_BLUE)
                .add(ModBlocks.BLUE_PLANTER.get())
                .add(ModBlocks.BLUE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_PURPLE)
                .add(ModBlocks.PURPLE_PLANTER.get())
                .add(ModBlocks.PURPLE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_MAGENTA)
                .add(ModBlocks.MAGENTA_PLANTER.get())
                .add(ModBlocks.MAGENTA_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_PINK)
                .add(ModBlocks.PINK_PLANTER.get())
                .add(ModBlocks.PINK_PLASTIC_BLOCK.get());

        tag(ModTags.Blocks.MUSHROOMS)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.RED_MUSHROOM);
    }
}
