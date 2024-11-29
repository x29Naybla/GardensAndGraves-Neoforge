package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
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
    }
}
