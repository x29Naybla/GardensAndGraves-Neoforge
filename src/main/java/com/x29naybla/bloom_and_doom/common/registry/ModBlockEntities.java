package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.block.entity.PlanterBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BloomAndDoom.MOD_ID);

    public static final Supplier<BlockEntityType<PlanterBlockEntity>> PLANTER_BE =
            BLOCK_ENTITIES.register("planter_be", () -> BlockEntityType.Builder.of(
                    PlanterBlockEntity::new,
                    ModBlocks.PLANTER.get(),
                    ModBlocks.WHITE_PLANTER.get(),
                    ModBlocks.LIGHT_GRAY_PLANTER.get(),
                    ModBlocks.GRAY_PLANTER.get(),
                    ModBlocks.BLACK_PLANTER.get(),
                    ModBlocks.BROWN_PLANTER.get(),
                    ModBlocks.RED_PLANTER.get(),
                    ModBlocks.ORANGE_PLANTER.get(),
                    ModBlocks.YELLOW_PLANTER.get(),
                    ModBlocks.LIME_PLANTER.get(),
                    ModBlocks.GREEN_PLANTER.get(),
                    ModBlocks.CYAN_PLANTER.get(),
                    ModBlocks.LIGHT_BLUE_PLANTER.get(),
                    ModBlocks.BLUE_PLANTER.get(),
                    ModBlocks.PURPLE_PLANTER.get(),
                    ModBlocks.MAGENTA_PLANTER.get(),
                    ModBlocks.PINK_PLANTER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
