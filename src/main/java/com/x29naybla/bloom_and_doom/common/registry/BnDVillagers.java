package com.x29naybla.bloom_and_doom.common.registry;

import com.google.common.collect.ImmutableSet;
import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BnDVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, BloomAndDoom.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, BloomAndDoom.MOD_ID);

    public static final Holder<PoiType> GARDENER_POI = POI_TYPES.register("gardener_poi",
            () -> new PoiType(ImmutableSet.copyOf(BnDBlocks.POTTING_TABLE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> GARDENER = VILLAGER_PROFESSIONS.register("gardener",
            () -> new VillagerProfession("gardener", holder -> holder.value() == GARDENER_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == GARDENER_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    BnDSounds.GARDENER_WORK.get()));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
