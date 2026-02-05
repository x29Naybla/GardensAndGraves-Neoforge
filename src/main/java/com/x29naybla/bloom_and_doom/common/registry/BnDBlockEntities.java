package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.block.entity.PlanterBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BnDBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BloomAndDoom.MOD_ID);

    public static final Supplier<BlockEntityType<PlanterBlockEntity>> PLANTER_BE =
            BLOCK_ENTITIES.register("planter_be", () -> BlockEntityType.Builder.of(
                    PlanterBlockEntity::new,
                    BnDBlocks.PLANTER.get(),
                    BnDBlocks.WHITE_PLANTER.get(),
                    BnDBlocks.LIGHT_GRAY_PLANTER.get(),
                    BnDBlocks.GRAY_PLANTER.get(),
                    BnDBlocks.BLACK_PLANTER.get(),
                    BnDBlocks.BROWN_PLANTER.get(),
                    BnDBlocks.RED_PLANTER.get(),
                    BnDBlocks.ORANGE_PLANTER.get(),
                    BnDBlocks.YELLOW_PLANTER.get(),
                    BnDBlocks.LIME_PLANTER.get(),
                    BnDBlocks.GREEN_PLANTER.get(),
                    BnDBlocks.CYAN_PLANTER.get(),
                    BnDBlocks.LIGHT_BLUE_PLANTER.get(),
                    BnDBlocks.BLUE_PLANTER.get(),
                    BnDBlocks.PURPLE_PLANTER.get(),
                    BnDBlocks.MAGENTA_PLANTER.get(),
                    BnDBlocks.PINK_PLANTER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
