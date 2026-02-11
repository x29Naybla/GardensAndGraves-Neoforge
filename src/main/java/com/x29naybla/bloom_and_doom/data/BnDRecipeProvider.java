package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BnDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public BnDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput){
        List<ItemLike> PLASTIC_SMELTABLES = List.of(BnDItems.PLASTIC_CHUNKS,
                BnDBlocks.PLASTIC_ORE);

        oreSmelting(recipeOutput, PLASTIC_SMELTABLES, RecipeCategory.MISC, BnDItems.WHITE_PLASTIC, 0.25f, 200, "plastic");
        oreBlasting(recipeOutput, PLASTIC_SMELTABLES, RecipeCategory.MISC, BnDItems.WHITE_PLASTIC, 0.25f, 100, "plastic");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.BRAINZ_BANNER_PATTERN, 1)
                .requires(BnDItems.BRAIN)
                .requires(Items.PAPER)
                .unlockedBy("has_brain", has(BnDItems.BRAIN))
                .unlockedBy("has_brainz_banner_pattern", has(BnDItems.BRAINZ_BANNER_PATTERN)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.WHITE_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.WHITE_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.WHITE_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.LIGHT_GRAY_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.LIGHT_GRAY_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.GRAY_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.GRAY_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.GRAY_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.BLACK_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.BLACK_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.BLACK_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.BROWN_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.BROWN_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.BROWN_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.RED_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.RED_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.RED_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.ORANGE_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.ORANGE_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.ORANGE_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.YELLOW_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.YELLOW_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.YELLOW_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.LIME_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.LIME_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.LIME_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.GREEN_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.GREEN_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.GREEN_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.CYAN_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.CYAN_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.CYAN_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.LIGHT_BLUE_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.LIGHT_BLUE_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.BLUE_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.BLUE_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.BLUE_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.PURPLE_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.PURPLE_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.PURPLE_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.MAGENTA_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.MAGENTA_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.MAGENTA_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BnDBlocks.PINK_PLASTIC_BLOCK, 4)
                .pattern("##")
                .pattern("##")
                .define('#', BnDItems.PINK_PLASTIC)
                .unlockedBy("has_plastic", has(BnDItems.PINK_PLASTIC))
                .group("plastic_block").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.WHITE_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.WHITE_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.WHITE_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.LIGHT_GRAY_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.LIGHT_GRAY_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.LIGHT_GRAY_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.GRAY_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.GRAY_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.GRAY_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.BLACK_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.BLACK_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.BLACK_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.BROWN_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.BROWN_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.BROWN_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.RED_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.RED_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.RED_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.ORANGE_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.ORANGE_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.ORANGE_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.YELLOW_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.YELLOW_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.YELLOW_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.LIME_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.LIME_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.LIME_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.GREEN_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.GREEN_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.GREEN_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.CYAN_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.CYAN_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.CYAN_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.LIGHT_BLUE_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.LIGHT_BLUE_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.LIGHT_BLUE_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.BLUE_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.BLUE_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.BLUE_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.PURPLE_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.PURPLE_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.PURPLE_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.MAGENTA_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.MAGENTA_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.MAGENTA_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BnDItems.PINK_WATERING_CAN, 1)
                .pattern("  #")
                .pattern("#@ ")
                .pattern("## ")
                .define('#', BnDItems.PINK_PLASTIC)
                .define('@', Items.WATER_BUCKET)
                .unlockedBy("has_plastic", has(BnDItems.PINK_PLASTIC))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
                .group("watering_can").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.WHITE_PLASTIC, 1)
                .requires(BnDBlocks.WHITE_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.WHITE_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.LIGHT_GRAY_PLASTIC, 1)
                .requires(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.GRAY_PLASTIC, 1)
                .requires(BnDBlocks.GRAY_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.GRAY_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.BLACK_PLASTIC, 1)
                .requires(BnDBlocks.BLACK_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLACK_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.BROWN_PLASTIC, 1)
                .requires(BnDBlocks.BROWN_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.BROWN_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.RED_PLASTIC, 1)
                .requires(BnDBlocks.RED_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.RED_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.ORANGE_PLASTIC, 1)
                .requires(BnDBlocks.ORANGE_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.ORANGE_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.YELLOW_PLASTIC, 1)
                .requires(BnDBlocks.YELLOW_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.YELLOW_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.LIME_PLASTIC, 1)
                .requires(BnDBlocks.LIME_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIME_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.GREEN_PLASTIC, 1)
                .requires(BnDBlocks.GREEN_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.GREEN_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.CYAN_PLASTIC, 1)
                .requires(BnDBlocks.CYAN_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.CYAN_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.LIGHT_BLUE_PLASTIC, 1)
                .requires(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.BLUE_PLASTIC, 1)
                .requires(BnDBlocks.BLUE_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLUE_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.PURPLE_PLASTIC, 1)
                .requires(BnDBlocks.PURPLE_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.PURPLE_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.MAGENTA_PLASTIC, 1)
                .requires(BnDBlocks.MAGENTA_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.MAGENTA_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BnDItems.PINK_PLASTIC, 1)
                .requires(BnDBlocks.PINK_PLASTIC_BLOCK)
                .unlockedBy("has_plastic_block", has(BnDBlocks.PINK_PLASTIC_BLOCK))
                .group("plastic").save(recipeOutput);

        stairBuilder(BnDBlocks.WHITE_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.WHITE_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.WHITE_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.GRAY_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.GRAY_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.GRAY_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.BLACK_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.BLACK_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLACK_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.BROWN_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.BROWN_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BROWN_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.RED_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.RED_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.RED_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.ORANGE_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.ORANGE_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.ORANGE_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.YELLOW_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.YELLOW_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.YELLOW_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.LIME_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.LIME_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIME_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.GREEN_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.GREEN_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.GREEN_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.CYAN_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.CYAN_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.CYAN_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.BLUE_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.BLUE_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLUE_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.PURPLE_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.PURPLE_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.PURPLE_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.MAGENTA_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.MAGENTA_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.MAGENTA_PLASTIC_BLOCK)).save(recipeOutput);
        stairBuilder(BnDBlocks.PINK_PLASTIC_STAIRS, Ingredient.of(BnDBlocks.PINK_PLASTIC_BLOCK)).group("plastic_stairs")
                .unlockedBy("has_plastic_block", has(BnDBlocks.PINK_PLASTIC_BLOCK)).save(recipeOutput);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.WHITE_PLASTIC_SLAB, Ingredient.of(BnDBlocks.WHITE_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.WHITE_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_GRAY_PLASTIC_SLAB, Ingredient.of(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GRAY_PLASTIC_SLAB, Ingredient.of(BnDBlocks.GRAY_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.GRAY_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLACK_PLASTIC_SLAB, Ingredient.of(BnDBlocks.BLACK_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLACK_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BROWN_PLASTIC_SLAB, Ingredient.of(BnDBlocks.BROWN_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BROWN_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.RED_PLASTIC_SLAB, Ingredient.of(BnDBlocks.RED_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.RED_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.ORANGE_PLASTIC_SLAB, Ingredient.of(BnDBlocks.ORANGE_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.ORANGE_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.YELLOW_PLASTIC_SLAB, Ingredient.of(BnDBlocks.YELLOW_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.YELLOW_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIME_PLASTIC_SLAB, Ingredient.of(BnDBlocks.LIME_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIME_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GREEN_PLASTIC_SLAB, Ingredient.of(BnDBlocks.GREEN_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.GREEN_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.CYAN_PLASTIC_SLAB, Ingredient.of(BnDBlocks.CYAN_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.CYAN_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_BLUE_PLASTIC_SLAB, Ingredient.of(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLUE_PLASTIC_SLAB, Ingredient.of(BnDBlocks.BLUE_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLUE_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PURPLE_PLASTIC_SLAB, Ingredient.of(BnDBlocks.PURPLE_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.PURPLE_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.MAGENTA_PLASTIC_SLAB, Ingredient.of(BnDBlocks.MAGENTA_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.MAGENTA_PLASTIC_BLOCK)).save(recipeOutput);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PINK_PLASTIC_SLAB, Ingredient.of(BnDBlocks.PINK_PLASTIC_BLOCK)).group("plastic_slab")
                .unlockedBy("has_plastic_block", has(BnDBlocks.PINK_PLASTIC_BLOCK)).save(recipeOutput);

        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.WHITE_PLASTIC_WALL, Ingredient.of(BnDBlocks.WHITE_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.WHITE_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_GRAY_PLASTIC_WALL, Ingredient.of(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GRAY_PLASTIC_WALL, Ingredient.of(BnDBlocks.GRAY_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.GRAY_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLACK_PLASTIC_WALL, Ingredient.of(BnDBlocks.BLACK_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLACK_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BROWN_PLASTIC_WALL, Ingredient.of(BnDBlocks.BROWN_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BROWN_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.RED_PLASTIC_WALL, Ingredient.of(BnDBlocks.RED_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.RED_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.ORANGE_PLASTIC_WALL, Ingredient.of(BnDBlocks.ORANGE_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.ORANGE_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.YELLOW_PLASTIC_WALL, Ingredient.of(BnDBlocks.YELLOW_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.YELLOW_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIME_PLASTIC_WALL, Ingredient.of(BnDBlocks.LIME_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIME_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GREEN_PLASTIC_WALL, Ingredient.of(BnDBlocks.GREEN_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.GREEN_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.CYAN_PLASTIC_WALL, Ingredient.of(BnDBlocks.CYAN_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.CYAN_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_BLUE_PLASTIC_WALL, Ingredient.of(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLUE_PLASTIC_WALL, Ingredient.of(BnDBlocks.BLUE_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.BLUE_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PURPLE_PLASTIC_WALL, Ingredient.of(BnDBlocks.PURPLE_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.PURPLE_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.MAGENTA_PLASTIC_WALL, Ingredient.of(BnDBlocks.MAGENTA_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.MAGENTA_PLASTIC_BLOCK)).save(recipeOutput);
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PINK_PLASTIC_WALL, Ingredient.of(BnDBlocks.PINK_PLASTIC_BLOCK)).group("plastic_wall")
                .unlockedBy("has_plastic_block", has(BnDBlocks.PINK_PLASTIC_BLOCK)).save(recipeOutput);

        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.WHITE_PLASTIC_STAIRS, BnDBlocks.WHITE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS, BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GRAY_PLASTIC_STAIRS, BnDBlocks.GRAY_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLACK_PLASTIC_STAIRS, BnDBlocks.BLACK_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BROWN_PLASTIC_STAIRS, BnDBlocks.BROWN_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.RED_PLASTIC_STAIRS, BnDBlocks.RED_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.ORANGE_PLASTIC_STAIRS, BnDBlocks.ORANGE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.YELLOW_PLASTIC_STAIRS, BnDBlocks.YELLOW_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIME_PLASTIC_STAIRS, BnDBlocks.LIME_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GREEN_PLASTIC_STAIRS, BnDBlocks.GREEN_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.CYAN_PLASTIC_STAIRS, BnDBlocks.CYAN_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS, BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLUE_PLASTIC_STAIRS, BnDBlocks.BLUE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PURPLE_PLASTIC_STAIRS, BnDBlocks.PURPLE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.MAGENTA_PLASTIC_STAIRS, BnDBlocks.MAGENTA_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PINK_PLASTIC_STAIRS, BnDBlocks.PINK_PLASTIC_BLOCK, 1);

        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.WHITE_PLASTIC_SLAB, BnDBlocks.WHITE_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_GRAY_PLASTIC_SLAB, BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GRAY_PLASTIC_SLAB, BnDBlocks.GRAY_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLACK_PLASTIC_SLAB, BnDBlocks.BLACK_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BROWN_PLASTIC_SLAB, BnDBlocks.BROWN_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.RED_PLASTIC_SLAB, BnDBlocks.RED_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.ORANGE_PLASTIC_SLAB, BnDBlocks.ORANGE_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.YELLOW_PLASTIC_SLAB, BnDBlocks.YELLOW_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIME_PLASTIC_SLAB, BnDBlocks.LIME_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GREEN_PLASTIC_SLAB, BnDBlocks.GREEN_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.CYAN_PLASTIC_SLAB, BnDBlocks.CYAN_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_BLUE_PLASTIC_SLAB, BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLUE_PLASTIC_SLAB, BnDBlocks.BLUE_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PURPLE_PLASTIC_SLAB, BnDBlocks.PURPLE_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.MAGENTA_PLASTIC_SLAB, BnDBlocks.MAGENTA_PLASTIC_BLOCK, 2);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PINK_PLASTIC_SLAB, BnDBlocks.PINK_PLASTIC_BLOCK, 2);

        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.WHITE_PLASTIC_WALL, BnDBlocks.WHITE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_GRAY_PLASTIC_WALL, BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GRAY_PLASTIC_WALL, BnDBlocks.GRAY_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLACK_PLASTIC_WALL, BnDBlocks.BLACK_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BROWN_PLASTIC_WALL, BnDBlocks.BROWN_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.RED_PLASTIC_WALL, BnDBlocks.RED_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.ORANGE_PLASTIC_WALL, BnDBlocks.ORANGE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.YELLOW_PLASTIC_WALL, BnDBlocks.YELLOW_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIME_PLASTIC_WALL, BnDBlocks.LIME_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.GREEN_PLASTIC_WALL, BnDBlocks.GREEN_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.CYAN_PLASTIC_WALL, BnDBlocks.CYAN_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.LIGHT_BLUE_PLASTIC_WALL, BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.BLUE_PLASTIC_WALL, BnDBlocks.BLUE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PURPLE_PLASTIC_WALL, BnDBlocks.PURPLE_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.MAGENTA_PLASTIC_WALL, BnDBlocks.MAGENTA_PLASTIC_BLOCK, 1);
        stonecutterBuilder(recipeOutput, RecipeCategory.BUILDING_BLOCKS, BnDBlocks.PINK_PLASTIC_WALL, BnDBlocks.PINK_PLASTIC_BLOCK, 1);

    }

    protected void stonecutterBuilder(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, int resultCount){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, getItemName(result) + "_from_" + getItemName(material) + "_stonecutting"));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, BloomAndDoom.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
