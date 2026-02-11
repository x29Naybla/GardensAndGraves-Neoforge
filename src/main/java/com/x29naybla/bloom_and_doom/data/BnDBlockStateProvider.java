package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BnDBlockStateProvider extends BlockStateProvider {
    public BnDBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BloomAndDoom.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(BnDBlocks.PLASTIC_ORE);

        blockWithItem(BnDBlocks.WHITE_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.GRAY_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.BLACK_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.BROWN_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.RED_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.ORANGE_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.YELLOW_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.LIME_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.GREEN_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.CYAN_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.BLUE_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.PURPLE_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.MAGENTA_PLASTIC_BLOCK);
        blockWithItem(BnDBlocks.PINK_PLASTIC_BLOCK);

        stairsBlock(BnDBlocks.WHITE_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.WHITE_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.GRAY_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.GRAY_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.BLACK_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.BLACK_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.BROWN_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.BROWN_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.RED_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.RED_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.ORANGE_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.ORANGE_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.YELLOW_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.YELLOW_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.LIME_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.LIME_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.GREEN_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.GREEN_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.CYAN_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.CYAN_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.BLUE_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.BLUE_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.PURPLE_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.PURPLE_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.MAGENTA_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.MAGENTA_PLASTIC_BLOCK.get()));
        stairsBlock(BnDBlocks.PINK_PLASTIC_STAIRS.get(), blockTexture(BnDBlocks.PINK_PLASTIC_BLOCK.get()));

        slabBlock(BnDBlocks.WHITE_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/white_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/white_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/white_plastic_slab_double")));

        slabBlock(BnDBlocks.LIGHT_GRAY_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/light_gray_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/light_gray_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/light_gray_plastic_slab_double")));

        slabBlock(BnDBlocks.GRAY_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/gray_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/gray_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/gray_plastic_slab_double")));

        slabBlock(BnDBlocks.BLACK_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/black_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/black_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/black_plastic_slab_double")));

        slabBlock(BnDBlocks.BROWN_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/brown_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/brown_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/brown_plastic_slab_double")));

        slabBlock(BnDBlocks.RED_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/red_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/red_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/red_plastic_slab_double")));

        slabBlock(BnDBlocks.ORANGE_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/orange_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/orange_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/orange_plastic_slab_double")));

        slabBlock(BnDBlocks.YELLOW_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/yellow_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/yellow_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/yellow_plastic_slab_double")));

        slabBlock(BnDBlocks.LIME_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/lime_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/lime_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/lime_plastic_slab_double")));

        slabBlock(BnDBlocks.GREEN_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/green_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/green_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/green_plastic_slab_double")));

        slabBlock(BnDBlocks.CYAN_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/cyan_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/cyan_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/cyan_plastic_slab_double")));

        slabBlock(BnDBlocks.LIGHT_BLUE_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/light_blue_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/light_blue_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/light_blue_plastic_slab_double")));

        slabBlock(BnDBlocks.BLUE_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/blue_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/blue_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/blue_plastic_slab_double")));

        slabBlock(BnDBlocks.PURPLE_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/purple_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/purple_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/purple_plastic_slab_double")));

        slabBlock(BnDBlocks.MAGENTA_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/magenta_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/magenta_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/magenta_plastic_slab_double")));

        slabBlock(BnDBlocks.PINK_PLASTIC_SLAB.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/pink_plastic_slab")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/pink_plastic_slab_top")),
                models().getExistingFile(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "block/pink_plastic_slab_double")));

        wallBlock(BnDBlocks.WHITE_PLASTIC_WALL.get(), blockTexture(BnDBlocks.WHITE_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.LIGHT_GRAY_PLASTIC_WALL.get(), blockTexture(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.GRAY_PLASTIC_WALL.get(), blockTexture(BnDBlocks.GRAY_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.BLACK_PLASTIC_WALL.get(), blockTexture(BnDBlocks.BLACK_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.BROWN_PLASTIC_WALL.get(), blockTexture(BnDBlocks.BROWN_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.RED_PLASTIC_WALL.get(), blockTexture(BnDBlocks.RED_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.ORANGE_PLASTIC_WALL.get(), blockTexture(BnDBlocks.ORANGE_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.YELLOW_PLASTIC_WALL.get(), blockTexture(BnDBlocks.YELLOW_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.LIME_PLASTIC_WALL.get(), blockTexture(BnDBlocks.LIME_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.GREEN_PLASTIC_WALL.get(), blockTexture(BnDBlocks.GREEN_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.CYAN_PLASTIC_WALL.get(), blockTexture(BnDBlocks.CYAN_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.LIGHT_BLUE_PLASTIC_WALL.get(), blockTexture(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.BLUE_PLASTIC_WALL.get(), blockTexture(BnDBlocks.BLUE_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.PURPLE_PLASTIC_WALL.get(), blockTexture(BnDBlocks.PURPLE_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.MAGENTA_PLASTIC_WALL.get(), blockTexture(BnDBlocks.MAGENTA_PLASTIC_BLOCK.get()));
        wallBlock(BnDBlocks.PINK_PLASTIC_WALL.get(), blockTexture(BnDBlocks.PINK_PLASTIC_BLOCK.get()));

        blockItem(BnDBlocks.WHITE_PLASTIC_STAIRS);
        blockItem(BnDBlocks.WHITE_PLASTIC_SLAB);
        blockItem(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS);
        blockItem(BnDBlocks.LIGHT_GRAY_PLASTIC_SLAB);
        blockItem(BnDBlocks.GRAY_PLASTIC_STAIRS);
        blockItem(BnDBlocks.GRAY_PLASTIC_SLAB);
        blockItem(BnDBlocks.BLACK_PLASTIC_STAIRS);
        blockItem(BnDBlocks.BLACK_PLASTIC_SLAB);
        blockItem(BnDBlocks.BROWN_PLASTIC_STAIRS);
        blockItem(BnDBlocks.BROWN_PLASTIC_SLAB);
        blockItem(BnDBlocks.RED_PLASTIC_STAIRS);
        blockItem(BnDBlocks.RED_PLASTIC_SLAB);
        blockItem(BnDBlocks.ORANGE_PLASTIC_STAIRS);
        blockItem(BnDBlocks.ORANGE_PLASTIC_SLAB);
        blockItem(BnDBlocks.YELLOW_PLASTIC_STAIRS);
        blockItem(BnDBlocks.YELLOW_PLASTIC_SLAB);
        blockItem(BnDBlocks.LIME_PLASTIC_STAIRS);
        blockItem(BnDBlocks.LIME_PLASTIC_SLAB);
        blockItem(BnDBlocks.GREEN_PLASTIC_STAIRS);
        blockItem(BnDBlocks.GREEN_PLASTIC_SLAB);
        blockItem(BnDBlocks.CYAN_PLASTIC_STAIRS);
        blockItem(BnDBlocks.CYAN_PLASTIC_SLAB);
        blockItem(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS);
        blockItem(BnDBlocks.LIGHT_BLUE_PLASTIC_SLAB);
        blockItem(BnDBlocks.BLUE_PLASTIC_STAIRS);
        blockItem(BnDBlocks.BLUE_PLASTIC_SLAB);
        blockItem(BnDBlocks.PURPLE_PLASTIC_STAIRS);
        blockItem(BnDBlocks.PURPLE_PLASTIC_SLAB);
        blockItem(BnDBlocks.MAGENTA_PLASTIC_STAIRS);
        blockItem(BnDBlocks.MAGENTA_PLASTIC_SLAB);
        blockItem(BnDBlocks.PINK_PLASTIC_STAIRS);
        blockItem(BnDBlocks.PINK_PLASTIC_SLAB);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("bloom_and_doom:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix){
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("bloom_and_doom:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
