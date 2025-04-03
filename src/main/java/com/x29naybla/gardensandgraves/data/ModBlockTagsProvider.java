package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
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
        super(output, lookupProvider, GardensAndGraves.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Gardens and Graves Tags
        tag(ModTags.Blocks.PLANTERS)
                .add(ModBlocks.PLANTER.get())
                .add(ModBlocks.PLANTER_WHITE.get())
                .add(ModBlocks.PLANTER_LIGHT_GRAY.get())
                .add(ModBlocks.PLANTER_GRAY.get())
                .add(ModBlocks.PLANTER_BLACK.get())
                .add(ModBlocks.PLANTER_BROWN.get())
                .add(ModBlocks.PLANTER_RED.get())
                .add(ModBlocks.PLANTER_ORANGE.get())
                .add(ModBlocks.PLANTER_YELLOW.get())
                .add(ModBlocks.PLANTER_LIME.get())
                .add(ModBlocks.PLANTER_GREEN.get())
                .add(ModBlocks.PLANTER_CYAN.get())
                .add(ModBlocks.PLANTER_LIGHT_BLUE.get())
                .add(ModBlocks.PLANTER_BLUE.get())
                .add(ModBlocks.PLANTER_PURPLE.get())
                .add(ModBlocks.PLANTER_MAGENTA.get())
                .add(ModBlocks.PLANTER_PINK.get());

        tag(ModTags.Blocks.SUPPORTS_PLANTS)
                .addTags(BlockTags.DIRT)
                .addTags(BlockTags.SAND)
                .add(Blocks.SANDSTONE)
                .add(Blocks.RED_SANDSTONE)
                .addTags(BlockTags.PLANKS)
                .addTags(BlockTags.LOGS)
                .add(Blocks.LILY_PAD)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_GRAVEL)
                .addTags(ModTags.Blocks.PLANTERS);

        //Common Tags
        tag(Tags.Blocks.DYED_WHITE)
                .add(ModBlocks.PLANTER_WHITE.get())
                .add(ModBlocks.WHITE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_LIGHT_GRAY)
                .add(ModBlocks.PLANTER_LIGHT_GRAY.get())
                .add(ModBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_GRAY)
                .add(ModBlocks.PLANTER_GRAY.get())
                .add(ModBlocks.GRAY_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_BLACK)
                .add(ModBlocks.PLANTER_BLACK.get())
                .add(ModBlocks.BLACK_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_BROWN)
                .add(ModBlocks.PLANTER_BROWN.get())
                .add(ModBlocks.BROWN_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_RED)
                .add(ModBlocks.PLANTER_RED.get())
                .add(ModBlocks.RED_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_ORANGE)
                .add(ModBlocks.PLANTER_ORANGE.get())
                .add(ModBlocks.ORANGE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_YELLOW)
                .add(ModBlocks.PLANTER_YELLOW.get())
                .add(ModBlocks.YELLOW_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_LIME)
                .add(ModBlocks.PLANTER_LIME.get())
                .add(ModBlocks.LIME_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_GREEN)
                .add(ModBlocks.PLANTER_GREEN.get())
                .add(ModBlocks.GREEN_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_CYAN)
                .add(ModBlocks.PLANTER_CYAN.get())
                .add(ModBlocks.CYAN_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_LIGHT_BLUE)
                .add(ModBlocks.PLANTER_LIGHT_BLUE.get())
                .add(ModBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_BLUE)
                .add(ModBlocks.PLANTER_BLUE.get())
                .add(ModBlocks.BLUE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_PURPLE)
                .add(ModBlocks.PLANTER_PURPLE.get())
                .add(ModBlocks.PURPLE_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_MAGENTA)
                .add(ModBlocks.PLANTER_MAGENTA.get())
                .add(ModBlocks.MAGENTA_PLASTIC_BLOCK.get());
        tag(Tags.Blocks.DYED_PINK)
                .add(ModBlocks.PLANTER_PINK.get())
                .add(ModBlocks.PINK_PLASTIC_BLOCK.get());

        //Vanilla Tags
        tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .addTag(ModTags.Blocks.PLANTERS);

        tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE)
                .addTag(ModTags.Blocks.PLANTERS);

        tag(BlockTags.BIG_DRIPLEAF_PLACEABLE)
                .addTag(ModTags.Blocks.PLANTERS);

        tag(BlockTags.BAMBOO_PLANTABLE_ON)
                .addTag(ModTags.Blocks.PLANTERS);

    }
}
