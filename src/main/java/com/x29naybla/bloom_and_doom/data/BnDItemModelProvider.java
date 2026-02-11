package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BnDItemModelProvider extends ItemModelProvider {
    public BnDItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BloomAndDoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(BnDItems.PLASTIC_CHUNKS.get());
        basicItem(BnDItems.WHITE_PLASTIC.get());
        basicItem(BnDItems.LIGHT_GRAY_PLASTIC.get());
        basicItem(BnDItems.GRAY_PLASTIC.get());
        basicItem(BnDItems.BLACK_PLASTIC.get());
        basicItem(BnDItems.BROWN_PLASTIC.get());
        basicItem(BnDItems.RED_PLASTIC.get());
        basicItem(BnDItems.ORANGE_PLASTIC.get());
        basicItem(BnDItems.YELLOW_PLASTIC.get());
        basicItem(BnDItems.LIME_PLASTIC.get());
        basicItem(BnDItems.GREEN_PLASTIC.get());
        basicItem(BnDItems.CYAN_PLASTIC.get());
        basicItem(BnDItems.LIGHT_BLUE_PLASTIC.get());
        basicItem(BnDItems.BLUE_PLASTIC.get());
        basicItem(BnDItems.PURPLE_PLASTIC.get());
        basicItem(BnDItems.MAGENTA_PLASTIC.get());
        basicItem(BnDItems.PINK_PLASTIC.get());

        wallItem(BnDBlocks.WHITE_PLASTIC_WALL, BnDBlocks.WHITE_PLASTIC_BLOCK);
        wallItem(BnDBlocks.LIGHT_GRAY_PLASTIC_WALL, BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK);
        wallItem(BnDBlocks.GRAY_PLASTIC_WALL, BnDBlocks.GRAY_PLASTIC_BLOCK);
        wallItem(BnDBlocks.BLACK_PLASTIC_WALL, BnDBlocks.BLACK_PLASTIC_BLOCK);
        wallItem(BnDBlocks.BROWN_PLASTIC_WALL, BnDBlocks.BROWN_PLASTIC_BLOCK);
        wallItem(BnDBlocks.RED_PLASTIC_WALL, BnDBlocks.RED_PLASTIC_BLOCK);
        wallItem(BnDBlocks.ORANGE_PLASTIC_WALL, BnDBlocks.ORANGE_PLASTIC_BLOCK);
        wallItem(BnDBlocks.YELLOW_PLASTIC_WALL, BnDBlocks.YELLOW_PLASTIC_BLOCK);
        wallItem(BnDBlocks.LIME_PLASTIC_WALL, BnDBlocks.LIME_PLASTIC_BLOCK);
        wallItem(BnDBlocks.GREEN_PLASTIC_WALL, BnDBlocks.GREEN_PLASTIC_BLOCK);
        wallItem(BnDBlocks.CYAN_PLASTIC_WALL, BnDBlocks.CYAN_PLASTIC_BLOCK);
        wallItem(BnDBlocks.LIGHT_BLUE_PLASTIC_WALL, BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK);
        wallItem(BnDBlocks.BLUE_PLASTIC_WALL, BnDBlocks.BLUE_PLASTIC_BLOCK);
        wallItem(BnDBlocks.PURPLE_PLASTIC_WALL, BnDBlocks.PURPLE_PLASTIC_BLOCK);
        wallItem(BnDBlocks.MAGENTA_PLASTIC_WALL, BnDBlocks.MAGENTA_PLASTIC_BLOCK);
        wallItem(BnDBlocks.PINK_PLASTIC_WALL, BnDBlocks.PINK_PLASTIC_BLOCK);

    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
