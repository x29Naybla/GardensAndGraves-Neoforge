package com.x29naybla.bloom_and_doom.common.tag;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;

public class ModTags {
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

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, name));
        }

        private static TagKey<Block> externalBlockTag(String modId, String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class Items {
        public static final TagKey<Item> PLANTER_SUBSTRATES = createTag("planter_substrates");
        public static final TagKey<Item> SUSTAINS_MUSHROOMS = createTag("sustains_mushrooms");

        public static final TagKey<Item> SUSTAINS_SUNFLOWERS = createTag("sustains_sunflowers");
        public static final TagKey<Item> SUSTAINS_MARIGOLDS = createTag("sustains_marigolds");
        public static final TagKey<Item> SUSTAINS_PEASHOOTERS = createTag("sustains_peashooters");
        public static final TagKey<Item> SUSTAINS_SNOW_PEAS = createTag("sustains_snow_peas");
        public static final TagKey<Item> SUSTAINS_REPEATERS = createTag("sustains_repeaters");
        public static final TagKey<Item> SUSTAINS_WALL_NUTS = createTag("sustains_wall_nuts");
        public static final TagKey<Item> SUSTAINS_POTATO_MINES = createTag("sustains_potato_mines");
        public static final TagKey<Item> SUSTAINS_CHOMPERS = createTag("sustains_chompers");
        public static final TagKey<Item> SUSTAINS_SUN_SHROOMS = createTag("sustains_sun_shrooms");
        public static final TagKey<Item> SUSTAINS_PUFF_SHROOMS = createTag("sustains_puff_shrooms");
        public static final TagKey<Item> SUSTAINS_DOOM_SHROOMS = createTag("sustains_doom_shrooms");

        public static final TagKey<Item> FLOWER_POTS = createTag("flower_pots");

        public static final TagKey<Item> WATERING_CANS = createTag("watering_cans");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, name));
        }

        private static TagKey<Item> externalItemTag(String modId, String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(modId, path));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> FLOWERS = createTag("flowers");
        public static final TagKey<EntityType<?>> PEASHOOTERS = createTag("peashooters");
        public static final TagKey<EntityType<?>> MUSHROOMS = createTag("mushrooms");
        public static final TagKey<EntityType<?>> PLANTS = createTag("plants");

        public static final TagKey<EntityType<?>> POTTABLE_PLANTS = createTag("pottable_plants");

        public static final TagKey<EntityType<?>> PLANT_ENEMIES = createTag("plant_enemies");
        public static final TagKey<EntityType<?>> CAN_BE_CHOMPED = createTag("can_be_chomped");

        public static final TagKey<EntityType<?>> PLANT_ALLAYS = createTag("plant_allays");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, name));
        }
    }

    public static class BannerPatterns{
        public static final TagKey<BannerPattern> BRAINZ = createTag("pattern_item/brainz");

        private static TagKey<BannerPattern> createTag(String name){
            return TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, name));
        }
    }

}
