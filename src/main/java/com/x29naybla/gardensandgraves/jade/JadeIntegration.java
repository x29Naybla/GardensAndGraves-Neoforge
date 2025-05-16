package com.x29naybla.gardensandgraves.jade;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.*;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;

@WailaPlugin
public class JadeIntegration implements IWailaPlugin {

    public static final ResourceLocation SUN_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "sun_timer");

    public static final ResourceLocation REWARD_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "reward_timer");

    public static final ResourceLocation SEED_PACKETS_TIMER = ResourceLocation.fromNamespaceAndPath(GardensAndGraves.MOD_ID, "seed_packets_timer");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(SunTimerProvider.SUN, SolarPlant.class);
        registration.registerEntityDataProvider(MarigoldRewardTimerProvider.MARIGOLD_REWARD, MarigoldEntity.class);
        registration.registerEntityDataProvider(SeedPacketsTimerProvider.SEED_PACKETS, Plant.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(SunTimerProvider.SUN, SolarPlant.class);
        registration.registerEntityComponent(MarigoldRewardTimerProvider.MARIGOLD_REWARD, MarigoldEntity.class);
        registration.registerEntityComponent(SeedPacketsTimerProvider.SEED_PACKETS, Plant.class);
    }
}
