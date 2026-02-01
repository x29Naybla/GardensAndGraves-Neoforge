package com.x29naybla.bloom_and_doom.common.item;

import com.x29naybla.bloom_and_doom.common.entity.MarigoldEntity;
import com.x29naybla.bloom_and_doom.common.registry.ModDataComponents;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class PottedPLantItemstacks {

    public static ItemStack PottedSunflowerInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_SUNFLOWER.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedMarigoldInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_MARIGOLD.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(DataComponents.BASE_COLOR, MarigoldEntity.dyedColor);
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedPeashooterInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_PEASHOOTER.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedSnowPeaInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_SNOW_PEA.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedRepeaterInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_REPEATER.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedPotatoMineInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_POTATO_MINE.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedBonkChoyInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_BONK_CHOY.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedSunShroomInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_SUN_SHROOM.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }

    public static ItemStack PottedPuffShroomInstance() {
        ItemStack itemStack = new ItemStack(ModItems.POTTED_PUFF_SHROOM.get());
        itemStack.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(Blocks.FLOWER_POT.asItem().getDefaultInstance())));
        itemStack.set(ModDataComponents.HEALTH, 16F);
        return itemStack;
    }
}
