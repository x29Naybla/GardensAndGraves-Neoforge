package com.x29naybla.bloom_and_doom.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CommonTags {
    public static class Blocks {
        public static final TagKey<Block> MUSHROOMS = commonBlockTag("mushrooms");

        private static TagKey<Block> commonBlockTag(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }
}
