package com.x29naybla.bloom_and_doom;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class ClientConfigs {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue NEW_BABY_MODELS = BUILDER
            .comment("Makes baby plants have the style of the new babies from the 26.1 drop")
            .define("new_baby_models", false);

    public static final ModConfigSpec.BooleanValue PEAS_3D = BUILDER
            .comment("Makes peas render in 3D (Amendments compat)")
            .define("pea_3d", true);

    public static final ModConfigSpec.BooleanValue FROZEN_PEAS_3D = BUILDER
            .comment("Makes frozen peas render in 3D (Amendments compat)")
            .define("frozen_pea_3d", true);

    public static final ModConfigSpec.BooleanValue SPORES_3D = BUILDER
            .comment("Makes spores render in 3D (Amendments compat)")
            .define("spore_3d", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}
