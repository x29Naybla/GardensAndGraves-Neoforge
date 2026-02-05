package com.x29naybla.bloom_and_doom.data.loot;

import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BNDBlockLoot extends BlockLootSubProvider {
    public BNDBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(BnDBlocks.POTTING_TABLE.get());

        dropSelf(BnDBlocks.PLANTER.get());
        dropSelf(BnDBlocks.WHITE_PLANTER.get());
        dropSelf(BnDBlocks.LIGHT_GRAY_PLANTER.get());
        dropSelf(BnDBlocks.GRAY_PLANTER.get());
        dropSelf(BnDBlocks.BLACK_PLANTER.get());
        dropSelf(BnDBlocks.BROWN_PLANTER.get());
        dropSelf(BnDBlocks.RED_PLANTER.get());
        dropSelf(BnDBlocks.ORANGE_PLANTER.get());
        dropSelf(BnDBlocks.YELLOW_PLANTER.get());
        dropSelf(BnDBlocks.LIME_PLANTER.get());
        dropSelf(BnDBlocks.GREEN_PLANTER.get());
        dropSelf(BnDBlocks.CYAN_PLANTER.get());
        dropSelf(BnDBlocks.LIGHT_BLUE_PLANTER.get());
        dropSelf(BnDBlocks.BLUE_PLANTER.get());
        dropSelf(BnDBlocks.PURPLE_PLANTER.get());
        dropSelf(BnDBlocks.MAGENTA_PLANTER.get());
        dropSelf(BnDBlocks.PINK_PLANTER.get());

        dropSelf(BnDBlocks.GRAVESTONE.get());
        dropSelf(BnDBlocks.GRAVESTONE_SANDSTONE.get());

        dropSelf(BnDBlocks.WHITE_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.GRAY_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.BLACK_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.BROWN_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.RED_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.ORANGE_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.YELLOW_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.LIME_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.GREEN_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.CYAN_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.BLUE_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.PURPLE_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.MAGENTA_PLASTIC_BLOCK.get());
        dropSelf(BnDBlocks.PINK_PLASTIC_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BnDBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
