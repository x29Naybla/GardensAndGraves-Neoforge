package com.x29naybla.bloom_and_doom.data.advancement;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.ModBlocks;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Consumer;

public class BNDAdvancementGenerator implements AdvancementProvider.AdvancementGenerator{
    @Override
    public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<AdvancementHolder> consumer, @NotNull ExistingFileHelper existingFileHelper) {
        AdvancementHolder bloomAndDoom = Advancement.Builder.advancement()
                .display(ModItems.SUN.get(),
                        Component.translatable(BloomAndDoom.MOD_ID + "." + "advancement.root"),
                        Component.translatable(BloomAndDoom.MOD_ID + "." + "advancement.root.desc"),
                        ResourceLocation.parse("minecraft:textures/block/moss_block.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("sun", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(consumer, getNameId("main/root"));

        AdvancementHolder planters = getAdvancement(bloomAndDoom, ModBlocks.PLANTER, "planters", AdvancementType.TASK, true, true, false)
                .addCriterion("planter", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PLANTER.getId()))
                .addCriterion("planter_white", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.WHITE_PLANTER.getId()))
                .addCriterion("planter_light_gray", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.LIGHT_GRAY_PLANTER.getId()))
                .addCriterion("planter_gray", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.GRAY_PLANTER.getId()))
                .addCriterion("planter_black", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.BLACK_PLANTER.getId()))
                .addCriterion("planter_brown", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.BROWN_PLANTER.getId()))
                .addCriterion("planter_red", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.RED_PLANTER.getId()))
                .addCriterion("planter_orange", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.ORANGE_PLANTER.getId()))
                .addCriterion("planter_yellow", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.YELLOW_PLANTER.getId()))
                .addCriterion("planter_lime", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.LIME_PLANTER.getId()))
                .addCriterion("planter_green", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.GREEN_PLANTER.getId()))
                .addCriterion("planter_cyan", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.CYAN_PLANTER.getId()))
                .addCriterion("planter_light_blue", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.LIGHT_BLUE_PLANTER.getId()))
                .addCriterion("planter_blue", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.BLUE_PLANTER.getId()))
                .addCriterion("planter_purple", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PURPLE_PLANTER.getId()))
                .addCriterion("planter_pink", RecipeCraftedTrigger.TriggerInstance.craftedItem(ModBlocks.PINK_PLANTER.getId()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/planters"));

        AdvancementHolder first_sun = getAdvancement(planters, ModItems.SUN, "first_sun", AdvancementType.TASK, true, true, false)
                .addCriterion("sun", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SUN))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/first_sun"));

        AdvancementHolder potted = getAdvancement(planters, ModItems.POTTED_SUNFLOWER, "potted", AdvancementType.TASK, true, true, false)
                .addCriterion("potted", PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(ItemPredicate.Builder.item().of(Items.FLOWER_POT), Optional.of(EntityPredicate.wrap(EntityPredicate.Builder.entity().of(ModTags.Entities.POTTABLE_PLANTS)))))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/potted"));

        AdvancementHolder peace_love_plants = getAdvancement(potted, ModItems.POTTED_POTATO_MINE, "peace_love_plants", AdvancementType.TASK, true, true, false)
                .addCriterion("gift", PickedUpItemTrigger.TriggerInstance.thrownItemPickedUpByEntity(
                        EntityPredicate.wrap(EntityPredicate.Builder.entity().of(EntityType.PLAYER)),
                        Optional.of(ItemPredicate.Builder.item().of(ModItems.POTTED_POTATO_MINE).build()),
                        Optional.of(EntityPredicate.wrap(EntityPredicate.Builder.entity().of(EntityType.PLAYER)))))
                .save(consumer, getNameId("main/peace_love_plants"));

        AdvancementHolder first_pack = getAdvancement(bloomAndDoom, ModItems.SEED_PACKET_SUNFLOWER, "first_pack", AdvancementType.TASK, true, true, false)
                .addCriterion("sunflower", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUNFLOWER))
                .addCriterion("marigold", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_MARIGOLD))
                .addCriterion("peashooter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PEASHOOTER))
                .addCriterion("snow_pea", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SNOW_PEA))
                .addCriterion("repeater", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_REPEATER))
                .addCriterion("wall_nut", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_WALL_NUT))
                .addCriterion("potato_mine", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_POTATO_MINE))
                .addCriterion("jalapeno", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_JALAPENO))
                .addCriterion("chomper", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_CHOMPER))
                .addCriterion("bonk_choy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_BONK_CHOY))
                .addCriterion("sun_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUN_SHROOM))
                .addCriterion("puff_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PUFF_SHROOM))
                .addCriterion("fume_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_FUME_SHROOM))
                .addCriterion("hypno_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_HYPNO_SHROOM))
                .addCriterion("doom_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_DOOM_SHROOM))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/first_pack"));

        AdvancementHolder sunflower = getAdvancement(first_pack, ModItems.SEED_PACKET_SUNFLOWER, "sunflower", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUNFLOWER))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/sunflower"));

        AdvancementHolder marigold = getAdvancement(first_pack, ModItems.SEED_PACKET_MARIGOLD, "marigold", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_MARIGOLD))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/marigold"));

        AdvancementHolder peashooter = getAdvancement(first_pack, ModItems.SEED_PACKET_PEASHOOTER, "peashooter", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PEASHOOTER))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/peashooter"));

        AdvancementHolder snow_pea = getAdvancement(first_pack, ModItems.SEED_PACKET_SNOW_PEA, "snow_pea", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SNOW_PEA))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/snow_pea"));

        AdvancementHolder repeater = getAdvancement(first_pack, ModItems.SEED_PACKET_REPEATER, "repeater", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_REPEATER))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/repeater"));

        AdvancementHolder wall_nut = getAdvancement(first_pack, ModItems.SEED_PACKET_WALL_NUT, "wall_nut", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_WALL_NUT))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/wall_nut"));

        AdvancementHolder potato_mine = getAdvancement(first_pack, ModItems.SEED_PACKET_POTATO_MINE, "potato_mine", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_POTATO_MINE))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/potato_mine"));

        AdvancementHolder jalapeno = getAdvancement(first_pack, ModItems.SEED_PACKET_JALAPENO, "jalapeno", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_JALAPENO))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/jalapeno"));

        AdvancementHolder chomper = getAdvancement(first_pack, ModItems.SEED_PACKET_CHOMPER, "chomper", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_CHOMPER))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/chomper"));

        AdvancementHolder bonk_choy = getAdvancement(first_pack, ModItems.SEED_PACKET_BONK_CHOY, "bonk_choy", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_BONK_CHOY))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/bonk_choy"));

        AdvancementHolder sun_shroom = getAdvancement(first_pack, ModItems.SEED_PACKET_SUN_SHROOM, "sun_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_SUN_SHROOM))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/sun_shroom"));

        AdvancementHolder puff_shroom = getAdvancement(first_pack, ModItems.SEED_PACKET_PUFF_SHROOM, "puff_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_PUFF_SHROOM))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/puff_shroom"));

        AdvancementHolder fume_shroom = getAdvancement(first_pack, ModItems.SEED_PACKET_FUME_SHROOM, "fume_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_FUME_SHROOM))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/fume_shroom"));

        AdvancementHolder hypno_shroom = getAdvancement(first_pack, ModItems.SEED_PACKET_HYPNO_SHROOM, "hypno_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_HYPNO_SHROOM))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/hypno_shroom"));

        AdvancementHolder doom_shroom = getAdvancement(first_pack, ModItems.SEED_PACKET_DOOM_SHROOM, "doom_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEED_PACKET_DOOM_SHROOM))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/doom_shroom"));
    }

    protected static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike display, String name, AdvancementType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(parent).display(display,
                Component.translatable(BloomAndDoom.MOD_ID + "." + "advancement." + name),
                Component.translatable(BloomAndDoom.MOD_ID + "." + "advancement." + name + ".desc"),
                null, frame, showToast, announceToChat, hidden);
    }

    private String getNameId(String id) {
        return BloomAndDoom.MOD_ID + ":" + id;
    }
}
