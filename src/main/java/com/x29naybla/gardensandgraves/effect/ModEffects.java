package com.x29naybla.gardensandgraves.effect;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, GardensAndGraves.MOD_ID);

    public static final Holder<MobEffect> ZOMBIFICATION = MOB_EFFECTS.register("zombification",
            () -> new Zombification(MobEffectCategory.NEUTRAL, 0x8d4cdb));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
