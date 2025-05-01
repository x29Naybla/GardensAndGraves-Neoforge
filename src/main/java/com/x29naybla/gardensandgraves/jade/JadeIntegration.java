package com.x29naybla.gardensandgraves.jade;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.MarigoldEntity;
import com.x29naybla.gardensandgraves.entity.Plant;
import com.x29naybla.gardensandgraves.entity.SunShroomEntity;
import com.x29naybla.gardensandgraves.entity.SunflowerEntity;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;

@WailaPlugin
public class JadeIntegration implements IWailaPlugin {

    public static final ResourceLocation SUNFLOWER_SUN_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "sunflower_sun_timer");
    public static final ResourceLocation SUNSHROOM_SUN_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "sunshroom_sun_timer");

    public static final ResourceLocation REWARD_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "reward_timer");

    public static final ResourceLocation SEED_PACKETS_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "seed_packets_timer");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(SunflowerSunTimerProvider.SUNFLOWER_SUN, SunflowerEntity.class);
        registration.registerEntityDataProvider(SunShroomSunTimerProvider.SUNSHROOM_SUN, SunShroomEntity.class);
        registration.registerEntityDataProvider(MarigoldRewardTimerProvider.MARIGOLD_REWARD, MarigoldEntity.class);
        registration.registerEntityDataProvider(SeedPacketsTimerProvider.SEED_PACKETS, Plant.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(SunflowerSunTimerProvider.SUNFLOWER_SUN, SunflowerEntity.class);
        registration.registerEntityComponent(SunShroomSunTimerProvider.SUNSHROOM_SUN, SunShroomEntity.class);
        registration.registerEntityComponent(MarigoldRewardTimerProvider.MARIGOLD_REWARD, MarigoldEntity.class);
        registration.registerEntityComponent(SeedPacketsTimerProvider.SEED_PACKETS, Plant.class);
    }
}
