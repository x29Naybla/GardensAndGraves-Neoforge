package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.ModBlocks;
import com.x29naybla.bloom_and_doom.common.tag.CommonTags;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
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
                .addTag(net.minecraft.tags.BlockTags.DIRT)
                .addTag(net.minecraft.tags.BlockTags.SAND)
                .add(Blocks.SANDSTONE)
                .add(Blocks.RED_SANDSTONE)
                .addTag(net.minecraft.tags.BlockTags.PLANKS)
                .addTag(net.minecraft.tags.BlockTags.LOGS)
                .add(Blocks.LILY_PAD)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_GRAVEL);

        tag(ModTags.Blocks.SUSTAINS_MUSHROOMS)
                .addTag(net.minecraft.tags.BlockTags.MUSHROOM_GROW_BLOCK);

        tag(ModTags.Blocks.DIRT_SUSTAINS)
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

        tag(ModTags.Blocks.MYCELIUM_SUSTAINS)
                .addTag(ModTags.Blocks.DIRT_SUSTAINS);

        tag(ModTags.Blocks.SAND_SUSTAINS)
                .add(Blocks.DEAD_BUSH)
                .add(Blocks.BAMBOO_SAPLING)
                .add(Blocks.BAMBOO)
                .add(Blocks.CACTUS);

        tag(ModTags.Blocks.SOUL_SAND_SUSTAINS)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.NETHER_WART);

        tag(ModTags.Blocks.NYLIUM_SUSTAINS)
                .addTag(CommonTags.Blocks.MUSHROOMS)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.WARPED_FUNGUS)
                .add(Blocks.CRIMSON_ROOTS)
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

        tag(CommonTags.Blocks.MUSHROOMS)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
                .addOptional(ResourceLocation.parse("farmersdelight:brown_mushroom_colony"))
                .addOptional(ResourceLocation.parse("farmersdelight:red_mushroom_colony"));
    }
}
