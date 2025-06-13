package com.x29naybla.bloom_and_doom.data.loot;

import com.x29naybla.bloom_and_doom.common.registry.ModBlocks;
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
        dropSelf(ModBlocks.POTTING_TABLE.get());

        dropSelf(ModBlocks.PLANTER.get());
        dropSelf(ModBlocks.WHITE_PLANTER.get());
        dropSelf(ModBlocks.LIGHT_GRAY_PLANTER.get());
        dropSelf(ModBlocks.GRAY_PLANTER.get());
        dropSelf(ModBlocks.BLACK_PLANTER.get());
        dropSelf(ModBlocks.BROWN_PLANTER.get());
        dropSelf(ModBlocks.RED_PLANTER.get());
        dropSelf(ModBlocks.ORANGE_PLANTER.get());
        dropSelf(ModBlocks.YELLOW_PLANTER.get());
        dropSelf(ModBlocks.LIME_PLANTER.get());
        dropSelf(ModBlocks.GREEN_PLANTER.get());
        dropSelf(ModBlocks.CYAN_PLANTER.get());
        dropSelf(ModBlocks.LIGHT_BLUE_PLANTER.get());
        dropSelf(ModBlocks.BLUE_PLANTER.get());
        dropSelf(ModBlocks.PURPLE_PLANTER.get());
        dropSelf(ModBlocks.MAGENTA_PLANTER.get());
        dropSelf(ModBlocks.PINK_PLANTER.get());

        dropSelf(ModBlocks.GRAVESTONE.get());
        dropSelf(ModBlocks.GRAVESTONE_SANDSTONE.get());

        dropSelf(ModBlocks.WHITE_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_GRAY_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.GRAY_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.BLACK_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.BROWN_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.RED_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.LIME_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.GREEN_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.CYAN_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_BLUE_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.BLUE_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.MAGENTA_PLASTIC_BLOCK.get());
        dropSelf(ModBlocks.PINK_PLASTIC_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
