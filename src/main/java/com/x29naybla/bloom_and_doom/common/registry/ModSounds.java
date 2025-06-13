package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BloomAndDoom.MOD_ID);

    public static final Supplier<SoundEvent> WABBY_WABBO = registerSoundEvent("wabby_wabbo");
    public static final ResourceKey<JukeboxSong> WABBY_WABBO_KEY = createSong("wabby_wabbo");

    public static final Supplier<SoundEvent> SPLAT = registerSoundEvent("splat");
    public static final Supplier<SoundEvent> SEED_PACKET_HEAL = registerSoundEvent("seed_packet_heal");
    public static final Supplier<SoundEvent> SEED_PACKER_PLANT = registerSoundEvent("seed_packet_plant");
    public static final Supplier<SoundEvent> POTTED_PLANT_PLANT = registerSoundEvent("potted_plant_plant");
    public static final Supplier<SoundEvent> GARDENER_WORK = registerSoundEvent("gardener_work");
    public static final Supplier<SoundEvent> SUNFLOWER_SUN = registerSoundEvent("sunflower_sun");
    public static final Supplier<SoundEvent> SUN_SHROOM_SUN = registerSoundEvent("sun_shroom_sun");
    public static final Supplier<SoundEvent> MONEYFALLS = registerSoundEvent("moneyfalls");
    public static final Supplier<SoundEvent> PEASHOOTER_SHOT = registerSoundEvent("pea_shot");
    public static final Supplier<SoundEvent> SNOW_PEA_SHOT = registerSoundEvent("snow_pea_shot");
    public static final Supplier<SoundEvent> REPEATER_SHOT = registerSoundEvent("repeater_shot");
    public static final Supplier<SoundEvent> PUFF = registerSoundEvent("puff");

    public static final DeferredHolder<SoundEvent, SoundEvent> SPUDOW = registerSoundEvent("spudow");
    public static final DeferredHolder<SoundEvent, SoundEvent> DOOM = registerSoundEvent("doom");

    public static final DeferredHolder<SoundEvent, SoundEvent> PLANT_GROW = registerSoundEvent("plant_grow");
    public static final DeferredHolder<SoundEvent, SoundEvent> WATERING_CAN_USE = registerSoundEvent("watering_can_use");

    private static ResourceKey<JukeboxSong> createSong(String name){
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, name));
    }

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name){
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
