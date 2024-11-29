package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatterns;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> PLANTERS = createTag("planters");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }

        private static TagKey<Block> commonBlockTag(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Block> externalBlockTag(String modId, String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class Items {
        //Gardens and Graves Tags
        public static final TagKey<Item> SEED_PACKET_PEASHOOTERS = createTag("seed_packet_peashooters");
        public static final TagKey<Item> SEED_PACKET_MUSHROOMS = createTag("seed_packet_mushrooms");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }

        private static TagKey<Item> commonItemTag(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Item> externalItemTag(String modId, String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class BannerPatterns{
        public static final TagKey<BannerPattern> BRAINZ = createTag("pattern_item/brainz");

        private static TagKey<BannerPattern> createTag(String name){
            return TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }
    }

}
