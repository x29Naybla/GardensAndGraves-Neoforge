package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.ModBlocks;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                    CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, BloomAndDoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //Bloom and Doom Tags
        tag(ModTags.Items.PLANTER_SUBSTRATES)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .addTag(net.minecraft.tags.ItemTags.SMELTS_TO_GLASS)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM)
                .add(Items.SOUL_SAND)
                .add(Items.END_STONE);

        tag(ModTags.Items.SUSTAINS_MUSHROOMS)
                .add(Items.MYCELIUM)
                .add(Items.PODZOL)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM)
                .addOptional(ResourceLocation.parse("farmersdelight:organic_compost"))
                .addOptional(ResourceLocation.parse("farmersdelight:rich_soil"));

        tag(ModTags.Items.SUSTAINS_SUNFLOWERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_MARIGOLDS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_PEASHOOTERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_SNOW_PEAS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_REPEATERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_WALL_NUTS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_CHOMPERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_POTATO_MINES)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(ModTags.Items.SUSTAINS_SUN_SHROOMS)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);
        tag(ModTags.Items.SUSTAINS_PUFF_SHROOMS)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);
        tag(ModTags.Items.SUSTAINS_DOOM_SHROOMS)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);

        tag(ModTags.Items.WATERING_CANS)
                .add(ModItems.WHITE_WATERING_CAN.get())
                .add(ModItems.LIGHT_GRAY_WATERING_CAN.get())
                .add(ModItems.GRAY_WATERING_CAN.get())
                .add(ModItems.BLACK_WATERING_CAN.get())
                .add(ModItems.BROWN_WATERING_CAN.get())
                .add(ModItems.RED_WATERING_CAN.get())
                .add(ModItems.ORANGE_WATERING_CAN.get())
                .add(ModItems.YELLOW_WATERING_CAN.get())
                .add(ModItems.LIME_WATERING_CAN.get())
                .add(ModItems.GREEN_WATERING_CAN.get())
                .add(ModItems.CYAN_WATERING_CAN.get())
                .add(ModItems.LIGHT_BLUE_WATERING_CAN.get())
                .add(ModItems.BLUE_WATERING_CAN.get())
                .add(ModItems.PURPLE_WATERING_CAN.get())
                .add(ModItems.MAGENTA_WATERING_CAN.get())
                .add(ModItems.PINK_WATERING_CAN.get());

        //Common Tags
        tag(Tags.Items.DYED_WHITE)
                .add(ModBlocks.WHITE_PLANTER.asItem())
                .add(ModBlocks.WHITE_PLASTIC_BLOCK.asItem())
                .add(ModItems.WHITE_WATERING_CAN.get());
        tag(Tags.Items.DYED_LIGHT_GRAY)
                .add(ModBlocks.LIGHT_GRAY_PLANTER.asItem())
                .add(ModBlocks.LIGHT_GRAY_PLASTIC_BLOCK.asItem())
                .add(ModItems.LIGHT_GRAY_WATERING_CAN.get());
        tag(Tags.Items.DYED_GRAY)
                .add(ModBlocks.GRAY_PLANTER.asItem())
                .add(ModBlocks.GRAY_PLASTIC_BLOCK.asItem())
                .add(ModItems.GRAY_WATERING_CAN.get());
        tag(Tags.Items.DYED_BLACK)
                .add(ModBlocks.BLACK_PLANTER.asItem())
                .add(ModBlocks.BLACK_PLASTIC_BLOCK.asItem())
                .add(ModItems.BLACK_WATERING_CAN.get());
        tag(Tags.Items.DYED_BROWN)
                .add(ModBlocks.BROWN_PLANTER.asItem())
                .add(ModBlocks.BROWN_PLASTIC_BLOCK.asItem())
                .add(ModItems.BROWN_WATERING_CAN.get());
        tag(Tags.Items.DYED_RED)
                .add(ModBlocks.RED_PLANTER.asItem())
                .add(ModBlocks.RED_PLASTIC_BLOCK.asItem())
                .add(ModItems.RED_WATERING_CAN.get());
        tag(Tags.Items.DYED_ORANGE)
                .add(ModBlocks.ORANGE_PLANTER.asItem())
                .add(ModBlocks.ORANGE_PLASTIC_BLOCK.asItem())
                .add(ModItems.ORANGE_WATERING_CAN.get());
        tag(Tags.Items.DYED_YELLOW)
                .add(ModBlocks.YELLOW_PLANTER.asItem())
                .add(ModBlocks.YELLOW_PLASTIC_BLOCK.asItem())
                .add(ModItems.YELLOW_WATERING_CAN.get());
        tag(Tags.Items.DYED_LIME)
                .add(ModBlocks.LIME_PLANTER.asItem())
                .add(ModBlocks.LIME_PLASTIC_BLOCK.asItem())
                .add(ModItems.LIME_WATERING_CAN.get());
        tag(Tags.Items.DYED_GREEN)
                .add(ModBlocks.GREEN_PLANTER.asItem())
                .add(ModBlocks.GREEN_PLASTIC_BLOCK.asItem())
                .add(ModItems.GREEN_WATERING_CAN.get());
        tag(Tags.Items.DYED_CYAN)
                .add(ModBlocks.CYAN_PLANTER.asItem())
                .add(ModBlocks.CYAN_PLASTIC_BLOCK.asItem())
                .add(ModItems.CYAN_WATERING_CAN.get());
        tag(Tags.Items.DYED_LIGHT_BLUE)
                .add(ModBlocks.LIGHT_BLUE_PLANTER.asItem())
                .add(ModBlocks.LIGHT_BLUE_PLASTIC_BLOCK.asItem())
                .add(ModItems.LIGHT_BLUE_WATERING_CAN.get());
        tag(Tags.Items.DYED_BLUE)
                .add(ModBlocks.BLUE_PLANTER.asItem())
                .add(ModBlocks.BLUE_PLASTIC_BLOCK.asItem())
                .add(ModItems.BLUE_WATERING_CAN.get());
        tag(Tags.Items.DYED_PURPLE)
                .add(ModBlocks.PURPLE_PLANTER.asItem())
                .add(ModBlocks.PURPLE_PLASTIC_BLOCK.asItem())
                .add(ModItems.PURPLE_WATERING_CAN.get());
        tag(Tags.Items.DYED_MAGENTA)
                .add(ModBlocks.MAGENTA_PLANTER.asItem())
                .add(ModBlocks.MAGENTA_PLASTIC_BLOCK.asItem())
                .add(ModItems.MAGENTA_WATERING_CAN.get());
        tag(Tags.Items.DYED_PINK)
                .add(ModBlocks.PINK_PLANTER.asItem())
                .add(ModBlocks.PINK_PLASTIC_BLOCK.asItem())
                .add(ModItems.PINK_WATERING_CAN.get());


        tag(Tags.Items.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_WABBY_WABBO.get());
        tag(Tags.Items.TOOLS)
                .addTag(ModTags.Items.WATERING_CANS);
        tag(Tags.Items.FOODS_RAW_MEAT)
                .add(ModItems.BRAIN.get());

        //Vanilla Tags
        tag(net.minecraft.tags.ItemTags.MEAT)
                .add(ModItems.BRAIN.get());

        tag(net.minecraft.tags.ItemTags.DIRT)
                .addOptional(ResourceLocation.parse("farmersdelight:rich_soil"));
    }
}
