package com.x29naybla.gardensandgraves.sound;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, GardensAndGraves.MOD_ID);

    public static final Supplier<SoundEvent> WABBY_WABBO = registerSoundEvent("wabby_wabbo");
    public static final ResourceKey<JukeboxSong> WABBY_WABBO_KEY = createSong("wabby_wabbo");

    private static ResourceKey<JukeboxSong> createSong(String name){
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name){
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
