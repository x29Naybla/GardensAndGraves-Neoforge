package com.x29naybla.bloom_and_doom.item;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Unit;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

public class ZombieBanner {

    public static ItemStack getZombieLeaderBannerInstance(HolderGetter<BannerPattern> patternRegistry) {
        ItemStack itemstack = new ItemStack(Items.RED_BANNER);
        BannerPatternLayers bannerpatternlayers = (new BannerPatternLayers.Builder()).addIfRegistered(patternRegistry, ResourceKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID,"brainz")), DyeColor.PINK).build();
        itemstack.set(DataComponents.BANNER_PATTERNS, bannerpatternlayers);
        itemstack.set(DataComponents.HIDE_ADDITIONAL_TOOLTIP, Unit.INSTANCE);
        itemstack.set(DataComponents.ITEM_NAME, Component.translatable(BloomAndDoom.MOD_ID+".items.brainz_banner"));
        itemstack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        return itemstack;
    }

}
