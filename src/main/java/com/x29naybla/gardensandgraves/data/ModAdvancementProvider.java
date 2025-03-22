package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.block.ModBlocks;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeCraftedTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class ModAdvancementProvider implements AdvancementProvider.AdvancementGenerator{
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
        AdvancementHolder gardensAndGraves = Advancement.Builder.advancement()
                .display(ModItems.SUN.get(),
                        Component.translatable(GardensAndGraves.MOD_ID + "." + "advancement.root"),
                        Component.translatable(GardensAndGraves.MOD_ID + "." + "advancement.root.desc"),
                        ResourceLocation.parse("minecraft:textures/block/moss_block.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("sun", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(consumer, getNameId("main/root"));

        AdvancementHolder planters = getAdvancement(gardensAndGraves, ModBlocks.PLANTER, "planters", AdvancementType.TASK, true, true, false)
                .addCriterion("planter", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER.getId()))
                .addCriterion("planter_white", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_WHITE.getId()))
                .addCriterion("planter_light_gray", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_LIGHT_GRAY.getId()))
                .addCriterion("planter_gray", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_GRAY.getId()))
                .addCriterion("planter_black", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_BLACK.getId()))
                .addCriterion("planter_brown", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_BROWN.getId()))
                .addCriterion("planter_red", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_RED.getId()))
                .addCriterion("planter_orange", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_ORANGE.getId()))
                .addCriterion("planter_yellow", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_YELLOW.getId()))
                .addCriterion("planter_lime", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_LIME.getId()))
                .addCriterion("planter_green", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_GREEN.getId()))
                .addCriterion("planter_cyan", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_CYAN.getId()))
                .addCriterion("planter_light_blue", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_LIGHT_BLUE.getId()))
                .addCriterion("planter_blue", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_BLUE.getId()))
                .addCriterion("planter_purple", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_PURPLE.getId()))
                .addCriterion("planter_pink", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER_PINK.getId()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/planters"));

        AdvancementHolder sunflower = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_SUNFLOWER.get(), "sunflower", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUNFLOWER.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/sunflower"));

        AdvancementHolder marigold = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_MARIGOLD.get(), "marigold", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_MARIGOLD.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/marigold"));

        AdvancementHolder peafectCollection = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_PEASHOOTER.get(), "pea_collection", AdvancementType.TASK, true, true, false)
                .addCriterion("peashooter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PEASHOOTER.get()))
                .addCriterion("snow_peashooter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SNOW_PEA.get()))
                .addCriterion("repeater", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_REPEATER.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, getNameId("main/pea_collection"));

        AdvancementHolder peashooter = getAdvancement(peafectCollection, ModItems.SEED_PACKET_PEASHOOTER.get(), "peashooter", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PEASHOOTER.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/peashooter"));

        AdvancementHolder snow_pea = getAdvancement(peafectCollection, ModItems.SEED_PACKET_SNOW_PEA.get(), "snow_pea", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SNOW_PEA.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/snow_pea"));

        AdvancementHolder repeater = getAdvancement(peafectCollection, ModItems.SEED_PACKET_REPEATER.get(), "repeater", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_REPEATER.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/repeater"));

        AdvancementHolder wall_nut = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_WALL_NUT.get(), "wall_nut", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_WALL_NUT.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/wall_nut"));

        AdvancementHolder potato_mine = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_POTATO_MINE.get(), "potato_mine", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_POTATO_MINE.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/potato_mine"));

        AdvancementHolder jalapeno = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_JALAPENO.get(), "jalapeno", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_JALAPENO.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/jalapeno"));

        AdvancementHolder chomper = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_CHOMPER.get(), "chomper", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_CHOMPER.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/chomper"));

        AdvancementHolder bonk_choy = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_BONK_CHOY.get(), "bonk_choy", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_BONK_CHOY.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/bonk_choy"));

        AdvancementHolder mushroomCollection = getAdvancement(gardensAndGraves, ModItems.SEED_PACKET_SUN_SHROOM.get(), "mushroom_collection", AdvancementType.TASK, true, true, false)
                .addCriterion("sun_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUN_SHROOM.get()))
                .addCriterion("puff_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PUFF_SHROOM.get()))
                .addCriterion("fume_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_FUME_SHROOM.get()))
                .addCriterion("hypno_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_HYPNO_SHROOM.get()))
                .addCriterion("doom_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_DOOM_SHROOM.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, getNameId("main/mushroom_collection"));

        AdvancementHolder sun_shroom = getAdvancement(mushroomCollection, ModItems.SEED_PACKET_SUN_SHROOM.get(), "sun_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUN_SHROOM.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/sun_shroom"));

        AdvancementHolder puff_shroom = getAdvancement(mushroomCollection, ModItems.SEED_PACKET_PUFF_SHROOM.get(), "puff_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PUFF_SHROOM.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/puff_shroom"));

        AdvancementHolder fume_shroom = getAdvancement(mushroomCollection, ModItems.SEED_PACKET_FUME_SHROOM.get(), "fume_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_FUME_SHROOM.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/fume_shroom"));

        AdvancementHolder hypno_shroom = getAdvancement(mushroomCollection, ModItems.SEED_PACKET_HYPNO_SHROOM.get(), "hypno_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_HYPNO_SHROOM.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/hypno_shroom"));

        AdvancementHolder doom_shroom = getAdvancement(mushroomCollection, ModItems.SEED_PACKET_DOOM_SHROOM.get(), "doom_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_DOOM_SHROOM.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/doom_shroom"));
    }

    protected static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike display, String name, AdvancementType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(parent).display(display,
                Component.translatable(GardensAndGraves.MOD_ID + "." + "advancement." + name),
                Component.translatable(GardensAndGraves.MOD_ID + "." + "advancement." + name + ".desc"),
                null, frame, showToast, announceToChat, hidden);
    }

    private String getNameId(String id) {
        return GardensAndGraves.MOD_ID + ":" + id;
    }
}
