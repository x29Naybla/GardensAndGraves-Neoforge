package com.x29naybla.gardensandgraves.item;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.item.custom.SeedPacketItem;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.x29naybla.gardensandgraves.data.ModTags.BannerPatterns.BRAINZ;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GardensAndGraves.MOD_ID);

    public static final DeferredItem<Item> SEED_PACKET_SUNFLOWER = ITEMS.register("seed_packet_sunflower",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_MARIGOLD = ITEMS.register("seed_packet_marigold",
            () -> new SeedPacketItem(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_PEASHOOTER = ITEMS.register("seed_packet_peashooter",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_REPEATER = ITEMS.register("seed_packet_repeater",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_SNOW_PEA = ITEMS.register("seed_packet_snow_pea",
            () -> new SeedPacketItem(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_WALL_NUT = ITEMS.register("seed_packet_wall_nut",
            () -> new SeedPacketItem(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_POTATO_MINE = ITEMS.register("seed_packet_potato_mine",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_JALAPENO = ITEMS.register("seed_packet_jalapeno",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_CHOMPER = ITEMS.register("seed_packet_chomper",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_BONK_CHOY = ITEMS.register("seed_packet_bonk_choy",
            () -> new SeedPacketItem(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_SUN_SHROOM = ITEMS.register("seed_packet_sun_shroom",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_PUFF_SHROOM = ITEMS.register("seed_packet_puff_shroom",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_FUME_SHROOM = ITEMS.register("seed_packet_fume_shroom",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_HYPNO_SHROOM = ITEMS.register("seed_packet_hypno_shroom",
            () -> new SeedPacketItem(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_DOOM_SHROOM = ITEMS.register("seed_packet_doom_shroom",
            () -> new SeedPacketItem(new Item.Properties()));

    public static final DeferredItem<Item> BRAINZ_BANNER_PATTERN = ITEMS.register("brainz_banner_pattern",
            () -> new BannerPatternItem(BRAINZ, new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_WABBY_WABBO = ITEMS.register("music_disc_wabby_wabbo",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.WABBY_WABBO_KEY).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
