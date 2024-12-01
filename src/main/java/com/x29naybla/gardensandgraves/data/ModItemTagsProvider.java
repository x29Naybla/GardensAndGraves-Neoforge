package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, GardensAndGraves.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Gardens and Graves Tags
        tag(ModTags.Items.PLANTER_SUBSTRATES)
                .add(Items.MYCELIUM)
                .add(Items.MOSS_BLOCK)
                .add(Items.GRASS_BLOCK)
                .add(Items.MUD)
                .add(Items.DIRT)
                .add(Items.COARSE_DIRT)
                .add(Items.SAND)
                .add(Items.RED_SAND)
                .add(Items.SOUL_SAND)
                .add(Items.SOUL_SOIL)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);

        tag(ModTags.Items.SEED_PACKET_PEASHOOTERS)
                .add(ModItems.SEED_PACKET_PEASHOOTER.get())
                .add(ModItems.SEED_PACKET_REPEATER.get())
                .add(ModItems.SEED_PACKET_SNOW_PEA.get());

        tag(ModTags.Items.SEED_PACKET_MUSHROOMS)
                .add(ModItems.SEED_PACKET_SUN_SHROOM.get())
                .add(ModItems.SEED_PACKET_PUFF_SHROOM.get())
                .add(ModItems.SEED_PACKET_FUME_SHROOM.get())
                .add(ModItems.SEED_PACKET_DOOM_SHROOM.get());

        //C Tags
        tag(Tags.Items.DYED_WHITE)
                .add(ModBlocks.PLANTER_WHITE.asItem());
        tag(Tags.Items.DYED_LIGHT_GRAY)
                .add(ModBlocks.PLANTER_LIGHT_GRAY.asItem());
        tag(Tags.Items.DYED_GRAY)
                .add(ModBlocks.PLANTER_GRAY.asItem());
        tag(Tags.Items.DYED_BLACK)
                .add(ModBlocks.PLANTER_BLACK.asItem());
        tag(Tags.Items.DYED_BROWN)
                .add(ModBlocks.PLANTER_BROWN.asItem());
        tag(Tags.Items.DYED_RED)
                .add(ModBlocks.PLANTER_RED.asItem());
        tag(Tags.Items.DYED_ORANGE)
                .add(ModBlocks.PLANTER_ORANGE.asItem());
        tag(Tags.Items.DYED_YELLOW)
                .add(ModBlocks.PLANTER_YELLOW.asItem());
        tag(Tags.Items.DYED_LIME)
                .add(ModBlocks.PLANTER_LIME.asItem());
        tag(Tags.Items.DYED_GREEN)
                .add(ModBlocks.PLANTER_GREEN.asItem());
        tag(Tags.Items.DYED_CYAN)
                .add(ModBlocks.PLANTER_CYAN.asItem());
        tag(Tags.Items.DYED_LIGHT_BLUE)
                .add(ModBlocks.PLANTER_LIGHT_BLUE.asItem());
        tag(Tags.Items.DYED_BLUE)
                .add(ModBlocks.PLANTER_BLUE.asItem());
        tag(Tags.Items.DYED_PURPLE)
                .add(ModBlocks.PLANTER_PURPLE.asItem());
        tag(Tags.Items.DYED_MAGENTA)
                .add(ModBlocks.PLANTER_MAGENTA.asItem());
        tag(Tags.Items.DYED_PINK)
                .add(ModBlocks.PLANTER_PINK.asItem());
    }
}
