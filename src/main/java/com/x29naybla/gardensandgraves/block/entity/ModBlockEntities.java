package com.x29naybla.gardensandgraves.block.entity;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, GardensAndGraves.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlanterBlockEntity>> PLANTER = BLOCK_ENTITIES
            .register("planter", () -> BlockEntityType.Builder.of(PlanterBlockEntity::new,
                    ModBlocks.PLANTER.get(),
                    ModBlocks.PLANTER_WHITE.get(),
                    ModBlocks.PLANTER_LIGHT_GRAY.get(),
                    ModBlocks.PLANTER_GRAY.get(),
                    ModBlocks.PLANTER_BLACK.get(),
                    ModBlocks.PLANTER_BROWN.get(),
                    ModBlocks.PLANTER_RED.get(),
                    ModBlocks.PLANTER_ORANGE.get(),
                    ModBlocks.PLANTER_YELLOW.get(),
                    ModBlocks.PLANTER_LIME.get(),
                    ModBlocks.PLANTER_GREEN.get(),
                    ModBlocks.PLANTER_CYAN.get(),
                    ModBlocks.PLANTER_LIGHT_BLUE.get(),
                    ModBlocks.PLANTER_BLUE.get(),
                    ModBlocks.PLANTER_PURPLE.get(),
                    ModBlocks.PLANTER_MAGENTA.get(),
                    ModBlocks.PLANTER_PINK.get()

            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
