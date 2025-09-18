package com.x29naybla.bloom_and_doom;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class CommonConfigs {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue PLANTS_LIFESPAN = BUILDER
            .comment("Makes plants pop out on sunsets and sunrises")
            .define("plants_lifespan", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}
