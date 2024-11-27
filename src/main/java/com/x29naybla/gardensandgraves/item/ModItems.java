package com.x29naybla.gardensandgraves.item;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GardensAndGraves.MOD_ID);



    public static final DeferredItem<Item> SEED_PACKET_SUNFLOWER = ITEMS.register("seed_packet_sunflower",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_MARIGOLD = ITEMS.register("seed_packet_marigold",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_PEASHOOTER = ITEMS.register("seed_packet_peashooter",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_REPEATER = ITEMS.register("seed_packet_repeater",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_SNOW_PEA = ITEMS.register("seed_packet_snow_pea",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_POTATO_MINE = ITEMS.register("seed_packet_potato_mine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_JALAPENO = ITEMS.register("seed_packet_jalapeno",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_CHOMPER = ITEMS.register("seed_packet_chomper",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_BONK_CHOY = ITEMS.register("seed_packet_bonk_choy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SEED_PACKET_SUN_SHROOM = ITEMS.register("seed_packet_sun_shroom",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_PUFF_SHROOM = ITEMS.register("seed_packet_puff_shroom",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_FUME_SHROOM = ITEMS.register("seed_packet_fume_shroom",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEED_PACKET_DOOM_SHROOM = ITEMS.register("seed_packet_doom_shroom",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BRAINZ_BANNER_PATTERN = ITEMS.register("brainz_banner_pattern",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_WABBY_WABBO = ITEMS.register("music_disc_wabby_wabbo",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(ModSounds.WABBY_WABBO_KEY).stacksTo(1)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
