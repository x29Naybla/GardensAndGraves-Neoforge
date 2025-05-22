package com.x29naybla.gardensandgraves.item;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import com.x29naybla.gardensandgraves.item.custom.*;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.x29naybla.gardensandgraves.data.ModTags.BannerPatterns.BRAINZ;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GardensAndGraves.MOD_ID);

    public static final DeferredItem<Item> SUN = ITEMS.register("sun",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRAIN = ITEMS.register("brain",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BRAIN)));

    public static final DeferredItem<Item> SEED_PACKET_SUNFLOWER = ITEMS.register("seed_packet_sunflower",
            () -> new SeedPacketItem(ModEntities.SUNFLOWER.get(), 2, 5, new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_MARIGOLD = ITEMS.register("seed_packet_marigold",
            () -> new SeedPacketItem(ModEntities.MARIGOLD.get(), 2, 10, new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_PEASHOOTER = ITEMS.register("seed_packet_peashooter",
            () -> new SeedPacketItem(ModEntities.PEASHOOTER.get(), 4, 5, new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_SNOW_PEA = ITEMS.register("seed_packet_snow_pea",
            () -> new SeedPacketItem(ModEntities.SNOW_PEA.get(), 6, 5, new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_REPEATER = ITEMS.register("seed_packet_repeater",
            () -> new SeedPacketItem(ModEntities.REPEATER.get(), 8, 5, new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_WALL_NUT = ITEMS.register("seed_packet_wall_nut",
            () -> new SeedPacketItem(ModEntities.WALL_NUT.get(), 4, 20, new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_POTATO_MINE = ITEMS.register("seed_packet_potato_mine",
            () -> new SeedPacketItem(ModEntities.POTATO_MINE.get(), 1, 20, new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_JALAPENO = ITEMS.register("seed_packet_jalapeno",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_CHOMPER = ITEMS.register("seed_packet_chomper",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_BONK_CHOY = ITEMS.register("seed_packet_bonk_choy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_SUN_SHROOM = ITEMS.register("seed_packet_sun_shroom",
            () -> new SeedPacketItem(ModEntities.SUN_SHROOM.get(), 1, 5, new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_PUFF_SHROOM = ITEMS.register("seed_packet_puff_shroom",
            () -> new SeedPacketItem(ModEntities.PUFF_SHROOM.get(), 0, 5, new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_FUME_SHROOM = ITEMS.register("seed_packet_fume_shroom",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_HYPNO_SHROOM = ITEMS.register("seed_packet_hypno_shroom",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_DOOM_SHROOM = ITEMS.register("seed_packet_doom_shroom",
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
    public static final DeferredItem<Item> POTTED_SUN_SHROOM = ITEMS.register("potted_sun_shroom",
            () -> new PottedPlantItem(ModEntities.SUN_SHROOM.get(), new Item.Properties()));
    public static final DeferredItem<Item> POTTED_PUFF_SHROOM = ITEMS.register("potted_puff_shroom",
            () -> new PottedPlantItem(ModEntities.PUFF_SHROOM.get(), new Item.Properties()));

    public static final DeferredItem<Item> PEA = ITEMS.register("pea",
            () -> new PeaItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> FROZEN_PEA = ITEMS.register("frozen_pea",
            () -> new FrozenPeaItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> SPORE = ITEMS.register("spore",
            () -> new SporeItem(new Item.Properties().stacksTo(16)));

    public static final DeferredItem<Item> BRAINZ_BANNER_PATTERN = ITEMS.register("brainz_banner_pattern",
            () -> new BannerPatternItem(BRAINZ, new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_WABBY_WABBO = ITEMS.register("music_disc_wabby_wabbo",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.WABBY_WABBO_KEY).stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_WHITE = ITEMS.register("watering_can_white",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_LIGHT_GRAY = ITEMS.register("watering_can_light_gray",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_GRAY = ITEMS.register("watering_can_gray",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_BLACK = ITEMS.register("watering_can_black",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_BROWN = ITEMS.register("watering_can_brown",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_RED = ITEMS.register("watering_can_red",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_ORANGE = ITEMS.register("watering_can_orange",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_YELLOW = ITEMS.register("watering_can_yellow",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_LIME = ITEMS.register("watering_can_lime",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_GREEN = ITEMS.register("watering_can_green",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_CYAN = ITEMS.register("watering_can_cyan",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_LIGHT_BLUE = ITEMS.register("watering_can_light_blue",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_BLUE = ITEMS.register("watering_can_blue",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_PURPLE = ITEMS.register("watering_can_purple",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_MAGENTA = ITEMS.register("watering_can_magenta",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> WATERING_CAN_PINK = ITEMS.register("watering_can_pink",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
