package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
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
        tag(BnDTags.Items.PLANTER_SUBSTRATES)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .addTag(net.minecraft.tags.ItemTags.SMELTS_TO_GLASS)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM)
                .add(Items.SOUL_SAND)
                .add(Items.END_STONE);

        tag(BnDTags.Items.SUSTAINS_MUSHROOMS)
                .add(Items.MYCELIUM)
                .add(Items.PODZOL)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM)
                .addOptional(ResourceLocation.parse("farmersdelight:organic_compost"))
                .addOptional(ResourceLocation.parse("farmersdelight:rich_soil"));

        tag(BnDTags.Items.SUSTAINS_SPROUTS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_SUNFLOWERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_MARIGOLDS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_PEASHOOTERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_SNOW_PEAS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_REPEATERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_WALL_NUTS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_CHOMPERS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_BONK_CHOYS)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_POTATO_MINES)
                .addTag(net.minecraft.tags.ItemTags.DIRT);
        tag(BnDTags.Items.SUSTAINS_SUN_SHROOMS)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);
        tag(BnDTags.Items.SUSTAINS_PUFF_SHROOMS)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);
        tag(BnDTags.Items.SUSTAINS_DOOM_SHROOMS)
                .addTag(net.minecraft.tags.ItemTags.DIRT)
                .add(Items.CRIMSON_NYLIUM)
                .add(Items.WARPED_NYLIUM);

        tag(BnDTags.Items.WATERING_CANS)
                .add(BnDItems.WHITE_WATERING_CAN.get())
                .add(BnDItems.LIGHT_GRAY_WATERING_CAN.get())
                .add(BnDItems.GRAY_WATERING_CAN.get())
                .add(BnDItems.BLACK_WATERING_CAN.get())
                .add(BnDItems.BROWN_WATERING_CAN.get())
                .add(BnDItems.RED_WATERING_CAN.get())
                .add(BnDItems.ORANGE_WATERING_CAN.get())
                .add(BnDItems.YELLOW_WATERING_CAN.get())
                .add(BnDItems.LIME_WATERING_CAN.get())
                .add(BnDItems.GREEN_WATERING_CAN.get())
                .add(BnDItems.CYAN_WATERING_CAN.get())
                .add(BnDItems.LIGHT_BLUE_WATERING_CAN.get())
                .add(BnDItems.BLUE_WATERING_CAN.get())
                .add(BnDItems.PURPLE_WATERING_CAN.get())
                .add(BnDItems.MAGENTA_WATERING_CAN.get())
                .add(BnDItems.PINK_WATERING_CAN.get());

        tag(BnDTags.Items.ZOMBIE_ANTIDOTE)
                .add(Items.GOLDEN_APPLE);

        //Common Tags
        tag(Tags.Items.DYED_WHITE)
                .add(BnDBlocks.WHITE_PLANTER.asItem())
                .add(BnDBlocks.WHITE_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.WHITE_PLASTIC_STAIRS.asItem())
                .add(BnDItems.WHITE_WATERING_CAN.get());
        tag(Tags.Items.DYED_LIGHT_GRAY)
                .add(BnDBlocks.LIGHT_GRAY_PLANTER.asItem())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS.asItem())
                .add(BnDItems.LIGHT_GRAY_WATERING_CAN.get());
        tag(Tags.Items.DYED_GRAY)
                .add(BnDBlocks.GRAY_PLANTER.asItem())
                .add(BnDBlocks.GRAY_PLASTIC_BLOCK.asItem())
                .add(BnDItems.GRAY_WATERING_CAN.get());
        tag(Tags.Items.DYED_BLACK)
                .add(BnDBlocks.BLACK_PLANTER.asItem())
                .add(BnDBlocks.BLACK_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.GRAY_PLASTIC_STAIRS.asItem())
                .add(BnDItems.BLACK_WATERING_CAN.get());
        tag(Tags.Items.DYED_BROWN)
                .add(BnDBlocks.BROWN_PLANTER.asItem())
                .add(BnDBlocks.BROWN_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.BROWN_PLASTIC_STAIRS.asItem())
                .add(BnDItems.BROWN_WATERING_CAN.get());
        tag(Tags.Items.DYED_RED)
                .add(BnDBlocks.RED_PLANTER.asItem())
                .add(BnDBlocks.RED_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.RED_PLASTIC_STAIRS.asItem())
                .add(BnDItems.RED_WATERING_CAN.get());
        tag(Tags.Items.DYED_ORANGE)
                .add(BnDBlocks.ORANGE_PLANTER.asItem())
                .add(BnDBlocks.ORANGE_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.ORANGE_PLASTIC_STAIRS.asItem())
                .add(BnDItems.ORANGE_WATERING_CAN.get());
        tag(Tags.Items.DYED_YELLOW)
                .add(BnDBlocks.YELLOW_PLANTER.asItem())
                .add(BnDBlocks.YELLOW_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.YELLOW_PLASTIC_STAIRS.asItem())
                .add(BnDItems.YELLOW_WATERING_CAN.get());
        tag(Tags.Items.DYED_LIME)
                .add(BnDBlocks.LIME_PLANTER.asItem())
                .add(BnDBlocks.LIME_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.LIME_PLASTIC_STAIRS.asItem())
                .add(BnDItems.LIME_WATERING_CAN.get());
        tag(Tags.Items.DYED_GREEN)
                .add(BnDBlocks.GREEN_PLANTER.asItem())
                .add(BnDBlocks.GREEN_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.GREEN_PLASTIC_STAIRS.asItem())
                .add(BnDItems.GREEN_WATERING_CAN.get());
        tag(Tags.Items.DYED_CYAN)
                .add(BnDBlocks.CYAN_PLANTER.asItem())
                .add(BnDBlocks.CYAN_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.CYAN_PLASTIC_STAIRS.asItem())
                .add(BnDItems.CYAN_WATERING_CAN.get());
        tag(Tags.Items.DYED_LIGHT_BLUE)
                .add(BnDBlocks.LIGHT_BLUE_PLANTER.asItem())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS.asItem())
                .add(BnDItems.LIGHT_BLUE_WATERING_CAN.get());
        tag(Tags.Items.DYED_BLUE)
                .add(BnDBlocks.BLUE_PLANTER.asItem())
                .add(BnDBlocks.BLUE_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.BLUE_PLASTIC_STAIRS.asItem())
                .add(BnDItems.BLUE_WATERING_CAN.get());
        tag(Tags.Items.DYED_PURPLE)
                .add(BnDBlocks.PURPLE_PLANTER.asItem())
                .add(BnDBlocks.PURPLE_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.PURPLE_PLASTIC_STAIRS.asItem())
                .add(BnDItems.PURPLE_WATERING_CAN.get());
        tag(Tags.Items.DYED_MAGENTA)
                .add(BnDBlocks.MAGENTA_PLANTER.asItem())
                .add(BnDBlocks.MAGENTA_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.MAGENTA_PLASTIC_STAIRS.asItem())
                .add(BnDItems.MAGENTA_WATERING_CAN.get());
        tag(Tags.Items.DYED_PINK)
                .add(BnDBlocks.PINK_PLANTER.asItem())
                .add(BnDBlocks.PINK_PLASTIC_BLOCK.asItem())
                .add(BnDBlocks.PINK_PLASTIC_STAIRS.asItem())
                .add(BnDItems.PINK_WATERING_CAN.get());


        tag(Tags.Items.MUSIC_DISCS)
                .add(BnDItems.MUSIC_DISC_WABBY_WABBO.get());
        tag(Tags.Items.TOOLS)
                .addTag(BnDTags.Items.WATERING_CANS);
        tag(Tags.Items.FOODS_RAW_MEAT)
                .add(BnDItems.BRAIN.get());

        //Vanilla Tags
        tag(net.minecraft.tags.ItemTags.MEAT)
                .add(BnDItems.BRAIN.get());

        tag(net.minecraft.tags.ItemTags.DIRT)
                .addOptional(ResourceLocation.parse("farmersdelight:rich_soil"));
    }
}
