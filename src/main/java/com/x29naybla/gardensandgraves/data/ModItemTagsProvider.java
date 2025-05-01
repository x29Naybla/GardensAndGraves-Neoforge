package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
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
        tag(ModTags.Items.WATERING_CANS)
                .add(ModItems.WATERING_CAN_WHITE.get())
                .add(ModItems.WATERING_CAN_LIGHT_GRAY.get())
                .add(ModItems.WATERING_CAN_GRAY.get())
                .add(ModItems.WATERING_CAN_BLACK.get())
                .add(ModItems.WATERING_CAN_BROWN.get())
                .add(ModItems.WATERING_CAN_RED.get())
                .add(ModItems.WATERING_CAN_ORANGE.get())
                .add(ModItems.WATERING_CAN_YELLOW.get())
                .add(ModItems.WATERING_CAN_LIME.get())
                .add(ModItems.WATERING_CAN_GREEN.get())
                .add(ModItems.WATERING_CAN_CYAN.get())
                .add(ModItems.WATERING_CAN_LIGHT_BLUE.get())
                .add(ModItems.WATERING_CAN_BLUE.get())
                .add(ModItems.WATERING_CAN_PURPLE.get())
                .add(ModItems.WATERING_CAN_MAGENTA.get())
                .add(ModItems.WATERING_CAN_PINK.get());


        tag(ModTags.Items.SNAIL_FOOD)
                .addTag(ItemTags.LEAVES)
                .add(Items.SHORT_GRASS)
                .add(Items.TALL_GRASS)
                .add(Items.FERN)
                .add(Items.SWEET_BERRIES)
                .add(Items.MELON_SLICE);;

        //Common Tags
        tag(Tags.Items.DYED_WHITE)
                .add(ModBlocks.PLANTER_WHITE.asItem())
                .add(ModBlocks.WHITE_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_WHITE.get());
        tag(Tags.Items.DYED_LIGHT_GRAY)
                .add(ModBlocks.PLANTER_LIGHT_GRAY.asItem())
                .add(ModBlocks.LIGHT_GRAY_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_LIGHT_GRAY.get());
        tag(Tags.Items.DYED_GRAY)
                .add(ModBlocks.PLANTER_GRAY.asItem())
                .add(ModBlocks.GRAY_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_GRAY.get());
        tag(Tags.Items.DYED_BLACK)
                .add(ModBlocks.PLANTER_BLACK.asItem())
                .add(ModBlocks.BLACK_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_BLACK.get());
        tag(Tags.Items.DYED_BROWN)
                .add(ModBlocks.PLANTER_BROWN.asItem())
                .add(ModBlocks.BROWN_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_BROWN.get());
        tag(Tags.Items.DYED_RED)
                .add(ModBlocks.PLANTER_RED.asItem())
                .add(ModBlocks.RED_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_RED.get());
        tag(Tags.Items.DYED_ORANGE)
                .add(ModBlocks.PLANTER_ORANGE.asItem())
                .add(ModBlocks.ORANGE_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_ORANGE.get());
        tag(Tags.Items.DYED_YELLOW)
                .add(ModBlocks.PLANTER_YELLOW.asItem())
                .add(ModBlocks.YELLOW_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_YELLOW.get());
        tag(Tags.Items.DYED_LIME)
                .add(ModBlocks.PLANTER_LIME.asItem())
                .add(ModBlocks.LIME_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_LIME.get());
        tag(Tags.Items.DYED_GREEN)
                .add(ModBlocks.PLANTER_GREEN.asItem())
                .add(ModBlocks.GREEN_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_GREEN.get());
        tag(Tags.Items.DYED_CYAN)
                .add(ModBlocks.PLANTER_CYAN.asItem())
                .add(ModBlocks.CYAN_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_CYAN.get());
        tag(Tags.Items.DYED_LIGHT_BLUE)
                .add(ModBlocks.PLANTER_LIGHT_BLUE.asItem())
                .add(ModBlocks.LIGHT_BLUE_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_LIGHT_BLUE.get());
        tag(Tags.Items.DYED_BLUE)
                .add(ModBlocks.PLANTER_BLUE.asItem())
                .add(ModBlocks.BLUE_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_BLUE.get());
        tag(Tags.Items.DYED_PURPLE)
                .add(ModBlocks.PLANTER_PURPLE.asItem())
                .add(ModBlocks.PURPLE_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_PURPLE.get());
        tag(Tags.Items.DYED_MAGENTA)
                .add(ModBlocks.PLANTER_MAGENTA.asItem())
                .add(ModBlocks.MAGENTA_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_MAGENTA.get());
        tag(Tags.Items.DYED_PINK)
                .add(ModBlocks.PLANTER_PINK.asItem())
                .add(ModBlocks.PINK_PLASTIC_BLOCK.asItem())
                .add(ModItems.WATERING_CAN_PINK.get());


        tag(Tags.Items.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_WABBY_WABBO.get());
        tag(Tags.Items.TOOLS)
                .addTag(ModTags.Items.WATERING_CANS);
        tag(Tags.Items.FOODS_RAW_MEAT)
                .add(ModItems.BRAIN.get());

        //Vanilla Tags
        tag(ItemTags.MEAT)
                .add(ModItems.BRAIN.get());
    }
}
