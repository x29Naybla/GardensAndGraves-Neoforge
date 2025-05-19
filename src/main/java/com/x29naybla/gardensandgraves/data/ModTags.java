package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
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
        public static final TagKey<Block> SUSTAINS_MUSHROOMS = createTag("sustains_mushrooms");

        public static final TagKey<Block> DIRT_SUSTAINS = createTag("dirt_sustains");
        public static final TagKey<Block> MYCELIUM_SUSTAINS = createTag("mycelium_sustains");
        public static final TagKey<Block> SAND_SUSTAINS = createTag("sand_sustains");
        public static final TagKey<Block> SOUL_SAND_SUSTAINS = createTag("soul_sand_sustains");
        public static final TagKey<Block> NYLIUM_SUSTAINS = createTag("nylium_sustains");
        public static final TagKey<Block> END_STONE_SUSTAINS = createTag("end_stone_sustains");

        public static final TagKey<Block> GRAVESTONES = createTag("gravestones");

        public static final TagKey<Block> MUSHROOMS = commonBlockTag("mushrooms");

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
        public static final TagKey<Item> SUSTAINS_MUSHROOMS = createTag("sustains_mushrooms");

        public static final TagKey<Item> FLOWER_POTS = createTag("flower_pots");

        public static final TagKey<Item> WATERING_CANS = createTag("watering_cans");

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

        public static final TagKey<EntityType<?>> POTTABLE_PLANTS = createTag("pottable_plants");

        public static final TagKey<EntityType<?>> PLANTABLE_ON_DIRT = createTag("plantable_on_dirt");
        public static final TagKey<EntityType<?>> PLANTABLE_ON_MYCELIUM = createTag("plantable_on_mycelium");
        public static final TagKey<EntityType<?>> PLANTABLE_ON_SANDS = createTag("plantable_on_sands");
        public static final TagKey<EntityType<?>> PLANTABLE_ON_SOUL_SAND = createTag("plantable_on_soul_sand");
        public static final TagKey<EntityType<?>> PLANTABLE_ON_NYLIUM = createTag("plantable_on_nylium");
        public static final TagKey<EntityType<?>> PLANTABLE_ON_END_STONE = createTag("plantable_on_end_stone");

        public static final TagKey<EntityType<?>> PLANT_ENEMIES = createTag("plant_enemies");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
        }
    }

    public static class Biomes {
        //Gardens and Graves Tags

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
