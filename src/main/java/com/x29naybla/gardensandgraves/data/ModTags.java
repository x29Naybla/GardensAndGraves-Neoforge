package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModTags {
    //Gardens and Graves Tags
    public static class Blocks {
        public static final TagKey<Block> PLANTERS = createTag("planters");
        public static final TagKey<Block> SUPPORTS_PLANTS = createTag("supports_plants");

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
        public static final TagKey<Item> PLANTER_SUBSTRATES = createTag("planter_substrates");

        public static final TagKey<Item> SEED_PACKET_FLOWERS = createTag("seed_packet_flowers");
        public static final TagKey<Item> SEED_PACKET_PEASHOOTERS = createTag("seed_packet_peashooters");
        public static final TagKey<Item> SEED_PACKET_MUSHROOMS = createTag("seed_packet_mushrooms");

        public static final TagKey<Item> WATERING_CANS = createTag("watering_cans");
        public static final TagKey<Item> SNAIL_FOOD = createTag("snail_food");

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

    public static class Entities {
        //Gardens and Graves Tags
        public static final TagKey<EntityType<?>> FLOWERS = createTag("flowers");
        public static final TagKey<EntityType<?>> PEASHOOTERS = createTag("peashooters");
        public static final TagKey<EntityType<?>> MUSHROOMS = createTag("mushrooms");
        public static final TagKey<EntityType<?>> PLANTS = createTag("plants");

        public static final TagKey<EntityType<?>> PLANT_ENEMIES = createTag("plant_enemies");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }
    }

    public static class Biomes {
        //Gardens and Graves Tags
        public static final TagKey<Biome> SNAIL_HOMES = createTag("snail_homes");

        private static TagKey<Biome> createTag(String name){
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }

        private static TagKey<Biome> commonItemTag(String path) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Biome> externalItemTag(String modId, String path) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class BannerPatterns{
        //Gardens and Graves tags
        public static final TagKey<BannerPattern> BRAINZ = createTag("pattern_item/brainz");

        private static TagKey<BannerPattern> createTag(String name){
            return TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }
    }

}
