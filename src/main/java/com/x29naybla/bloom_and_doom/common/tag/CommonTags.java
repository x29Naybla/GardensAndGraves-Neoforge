package com.x29naybla.bloom_and_doom.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {
    public static class Blocks {
        public static final TagKey<Block> MUSHROOMS = commonBlockTag("mushrooms");

        public static final TagKey<Block> FLOWER_POTS = commonBlockTag("flower_pots");

        private static TagKey<Block> commonBlockTag(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }

    public static class Items {
        public static final TagKey<Item> FLOWER_POTS = commonItemTag("flower_pots");

        private static TagKey<Item> commonItemTag(String path){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }
}
