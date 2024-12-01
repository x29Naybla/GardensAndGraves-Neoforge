package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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

        //C Tags
        tag(Tags.Blocks.DYED_WHITE)
                .add(ModBlocks.PLANTER_WHITE.get());
        tag(Tags.Blocks.DYED_LIGHT_GRAY)
                .add(ModBlocks.PLANTER_LIGHT_GRAY.get());
        tag(Tags.Blocks.DYED_GRAY)
                .add(ModBlocks.PLANTER_GRAY.get());
        tag(Tags.Blocks.DYED_BLACK)
                .add(ModBlocks.PLANTER_BLACK.get());
        tag(Tags.Blocks.DYED_BROWN)
                .add(ModBlocks.PLANTER_BROWN.get());
        tag(Tags.Blocks.DYED_RED)
                .add(ModBlocks.PLANTER_RED.get());
        tag(Tags.Blocks.DYED_ORANGE)
                .add(ModBlocks.PLANTER_ORANGE.get());
        tag(Tags.Blocks.DYED_YELLOW)
                .add(ModBlocks.PLANTER_YELLOW.get());
        tag(Tags.Blocks.DYED_LIME)
                .add(ModBlocks.PLANTER_LIME.get());
        tag(Tags.Blocks.DYED_GREEN)
                .add(ModBlocks.PLANTER_GREEN.get());
        tag(Tags.Blocks.DYED_CYAN)
                .add(ModBlocks.PLANTER_CYAN.get());
        tag(Tags.Blocks.DYED_LIGHT_BLUE)
                .add(ModBlocks.PLANTER_LIGHT_BLUE.get());
        tag(Tags.Blocks.DYED_BLUE)
                .add(ModBlocks.PLANTER_BLUE.get());
        tag(Tags.Blocks.DYED_PURPLE)
                .add(ModBlocks.PLANTER_PURPLE.get());
        tag(Tags.Blocks.DYED_MAGENTA)
                .add(ModBlocks.PLANTER_MAGENTA.get());
        tag(Tags.Blocks.DYED_PINK)
                .add(ModBlocks.PLANTER_PINK.get());
    }
}
