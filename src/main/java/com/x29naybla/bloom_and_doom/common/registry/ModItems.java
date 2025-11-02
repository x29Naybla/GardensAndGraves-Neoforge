package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.FoodValues;
import com.x29naybla.bloom_and_doom.common.item.*;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.x29naybla.bloom_and_doom.common.tag.ModTags.BannerPatterns.BRAINZ;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BloomAndDoom.MOD_ID);

    public static final DeferredItem<Item> SUN = ITEMS.register("sun",
            () -> new SunItem(new Item.Properties()));
    public static final DeferredItem<Item> BRAIN = ITEMS.register("brain",
            () -> new Item(new Item.Properties().food(FoodValues.BRAIN)));

    public static final DeferredItem<Item> SUNFLOWER_SEED_PACKET = ITEMS.register("sunflower_seed_packet",
            () -> new SeedPacketItem(ModEntities.SUNFLOWER.get(), 2, 5, new Item.Properties()));
    public static final DeferredItem<Item> MARIGOLD_SEED_PACKET = ITEMS.register("marigold_seed_packet",
            () -> new SeedPacketItem(ModEntities.MARIGOLD.get(), 2, 10, new Item.Properties()));

    public static final DeferredItem<Item> PEASHOOTER_SEED_PACKET = ITEMS.register("peashooter_seed_packet",
            () -> new SeedPacketItem(ModEntities.PEASHOOTER.get(), 4, 5, new Item.Properties()));
    public static final DeferredItem<Item> SNOW_PEA_SEED_PACKET = ITEMS.register("snow_pea_seed_packet",
            () -> new SeedPacketItem(ModEntities.SNOW_PEA.get(), 6, 5, new Item.Properties()));
    public static final DeferredItem<Item> REPEATER_SEED_PACKET = ITEMS.register("repeater_seed_packet",
            () -> new SeedPacketItem(ModEntities.REPEATER.get(), 8, 5, new Item.Properties()));

    public static final DeferredItem<Item> WALL_NUT_SEED_PACKET = ITEMS.register("wall_nut_seed_packet",
            () -> new SeedPacketItem(ModEntities.WALL_NUT.get(), 4, 20, new Item.Properties()));

    public static final DeferredItem<Item> POTATO_MINE_SEED_PACKET = ITEMS.register("potato_mine_seed_packet",
            () -> new SeedPacketItem(ModEntities.POTATO_MINE.get(), 1, 20, new Item.Properties()));
    public static final DeferredItem<Item> JALAPENO_SEED_PACKET = ITEMS.register("jalapeno_seed_packet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COFFEE_BEAN_SEED_PACKET = ITEMS.register("coffee_bean_seed_packet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHOMPER_SEED_PACKET = ITEMS.register("chomper_seed_packet",
            () -> new SeedPacketItem(ModEntities.CHOMPER.get(), 6, 5, new Item.Properties()));
    public static final DeferredItem<Item> BONK_CHOY_SEED_PACKET = ITEMS.register("bonk_choy_seed_packet",
            () -> new SeedPacketItem(ModEntities.BONK_CHOY.get(), 6,5, new Item.Properties()));

    public static final DeferredItem<Item> SUN_SHROOM_SEED_PACKET = ITEMS.register("sun_shroom_seed_packet",
            () -> new SeedPacketItem(ModEntities.SUN_SHROOM.get(), 1, 5, new Item.Properties()));
    public static final DeferredItem<Item> PUFF_SHROOM_SEED_PACKET = ITEMS.register("puff_shroom_seed_packet",
            () -> new SeedPacketItem(ModEntities.PUFF_SHROOM.get(), 0, 5, new Item.Properties()));
    public static final DeferredItem<Item> FUME_SHROOM_SEED_PACKET = ITEMS.register("fume_shroom_seed_packet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HYPNO_SHROOM_SEED_PACKET = ITEMS.register("hypno_shroom_seed_packet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DOOM_SHROOM_SEED_PACKET = ITEMS.register("doom_shroom_seed_packet",
            () -> new SeedPacketItem(ModEntities.DOOM_SHROOM.get(), 7, 35, new Item.Properties()));

    public static final DeferredItem<Item> POTTED_SUNFLOWER = ITEMS.register("potted_sunflower",
            () -> new PottedPlantItem(ModEntities.SUNFLOWER.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_MARIGOLD = ITEMS.register("potted_marigold",
            () -> new PottedPlantItem(ModEntities.MARIGOLD.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_PEASHOOTER = ITEMS.register("potted_peashooter",
            () -> new PottedPlantItem(ModEntities.PEASHOOTER.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_SNOW_PEA = ITEMS.register("potted_snow_pea",
            () -> new PottedPlantItem(ModEntities.SNOW_PEA.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_REPEATER = ITEMS.register("potted_repeater",
            () -> new PottedPlantItem(ModEntities.REPEATER.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_POTATO_MINE = ITEMS.register("potted_potato_mine",
            () -> new PottedPlantItem(ModEntities.POTATO_MINE.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_BONK_CHOY = ITEMS.register("potted_bonk_choy",
            () -> new PottedPlantItem(ModEntities.BONK_CHOY.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_SUN_SHROOM = ITEMS.register("potted_sun_shroom",
            () -> new PottedPlantItem(ModEntities.SUN_SHROOM.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_PUFF_SHROOM = ITEMS.register("potted_puff_shroom",
            () -> new PottedPlantItem(ModEntities.PUFF_SHROOM.get(), new Item.Properties()));

    public static final DeferredItem<Item> WHITE_WATERING_CAN = ITEMS.register("white_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LIGHT_GRAY_WATERING_CAN = ITEMS.register("light_gray_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GRAY_WATERING_CAN = ITEMS.register("gray_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BLACK_WATERING_CAN = ITEMS.register("black_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BROWN_WATERING_CAN = ITEMS.register("brown_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> RED_WATERING_CAN = ITEMS.register("red_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ORANGE_WATERING_CAN = ITEMS.register("orange_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_WATERING_CAN = ITEMS.register("yellow_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LIME_WATERING_CAN = ITEMS.register("lime_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GREEN_WATERING_CAN = ITEMS.register("green_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CYAN_WATERING_CAN = ITEMS.register("cyan_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LIGHT_BLUE_WATERING_CAN = ITEMS.register("light_blue_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BLUE_WATERING_CAN = ITEMS.register("blue_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PURPLE_WATERING_CAN = ITEMS.register("purple_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MAGENTA_WATERING_CAN = ITEMS.register("magenta_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> PINK_WATERING_CAN = ITEMS.register("pink_watering_can",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> PEA = ITEMS.register("pea",
            () -> new PeaItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> FROZEN_PEA = ITEMS.register("frozen_pea",
            () -> new FrozenPeaItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> SPORE = ITEMS.register("spore",
            () -> new SporeItem(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> MUSIC_DISC_WABBY_WABBO = ITEMS.register("music_disc_wabby_wabbo",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.WABBY_WABBO_KEY).stacksTo(1)));
    public static final DeferredItem<Item> ALMANAC = ITEMS.register("almanac",
            () -> new AlmanacItem(new Item.Properties()));
    public static final DeferredItem<Item> BRAINZ_BANNER_PATTERN = ITEMS.register("brainz_banner_pattern",
            () -> new BannerPatternItem(BRAINZ, new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

    public static final DeferredItem<SpawnEggItem> ZOMBIE_WOLF_SPAWN_EGG = ITEMS.register("zombie_wolf_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ZOMBIE_WOLF, 14144467, 7969893, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
