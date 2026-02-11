package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import com.x29naybla.bloom_and_doom.common.registry.BnDBlocks;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
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

public class BnDAdvancementGenerator implements AdvancementProvider.AdvancementGenerator{
    @Override
    public void generate(HolderLookup.@NotNull Provider provider, @NotNull Consumer<AdvancementHolder> consumer, @NotNull ExistingFileHelper existingFileHelper) {
        AdvancementHolder bloomAndDoom = Advancement.Builder.advancement()
                .display(BnDItems.SUN.get(),
                        Component.translatable(BloomAndDoom.MOD_ID + "." + "advancement.root"),
                        Component.translatable(BloomAndDoom.MOD_ID + "." + "advancement.root.desc"),
                        ResourceLocation.parse("minecraft:textures/block/moss_block.png"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion("sun", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(consumer, getNameId("main/root"));

        AdvancementHolder planters = getAdvancement(bloomAndDoom, BnDBlocks.PLANTER, "planters", AdvancementType.TASK, true, true, false)
                .addCriterion("planter", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.PLANTER.getId()))
                .addCriterion("planter_white", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.WHITE_PLANTER.getId()))
                .addCriterion("planter_light_gray", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.LIGHT_GRAY_PLANTER.getId()))
                .addCriterion("planter_gray", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.GRAY_PLANTER.getId()))
                .addCriterion("planter_black", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.BLACK_PLANTER.getId()))
                .addCriterion("planter_brown", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.BROWN_PLANTER.getId()))
                .addCriterion("planter_red", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.RED_PLANTER.getId()))
                .addCriterion("planter_orange", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.ORANGE_PLANTER.getId()))
                .addCriterion("planter_yellow", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.YELLOW_PLANTER.getId()))
                .addCriterion("planter_lime", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.LIME_PLANTER.getId()))
                .addCriterion("planter_green", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.GREEN_PLANTER.getId()))
                .addCriterion("planter_cyan", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.CYAN_PLANTER.getId()))
                .addCriterion("planter_light_blue", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.LIGHT_BLUE_PLANTER.getId()))
                .addCriterion("planter_blue", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.BLUE_PLANTER.getId()))
                .addCriterion("planter_purple", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.PURPLE_PLANTER.getId()))
                .addCriterion("planter_pink", RecipeCraftedTrigger.TriggerInstance.craftedItem(BnDBlocks.PINK_PLANTER.getId()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/planters"));

        AdvancementHolder first_sun = getAdvancement(planters, BnDItems.SUN, "first_sun", AdvancementType.TASK, true, true, false)
                .addCriterion("sun", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SUN))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/first_sun"));

        AdvancementHolder potted = getAdvancement(planters, BnDItems.POTTED_SUNFLOWER, "potted", AdvancementType.TASK, true, true, false)
                .addCriterion("potted", PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(ItemPredicate.Builder.item().of(Items.FLOWER_POT), Optional.of(EntityPredicate.wrap(EntityPredicate.Builder.entity().of(BnDTags.Entities.POTTABLE_PLANTS)))))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/potted"));

        AdvancementHolder peace_love_plants = getAdvancement(potted, BnDItems.POTTED_POTATO_MINE, "peace_love_plants", AdvancementType.TASK, true, true, false)
                .addCriterion("gift", PickedUpItemTrigger.TriggerInstance.thrownItemPickedUpByEntity(
                        EntityPredicate.wrap(EntityPredicate.Builder.entity().of(EntityType.PLAYER)),
                        Optional.of(ItemPredicate.Builder.item().of(BnDItems.POTTED_POTATO_MINE).build()),
                        Optional.of(EntityPredicate.wrap(EntityPredicate.Builder.entity().of(EntityType.PLAYER)))))
                .save(consumer, getNameId("main/peace_love_plants"));

        AdvancementHolder first_pack = getAdvancement(bloomAndDoom, BnDItems.SUNFLOWER_SEED_PACKET, "first_pack", AdvancementType.TASK, true, true, false)
                .addCriterion("sunflower", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SUNFLOWER_SEED_PACKET))
                .addCriterion("marigold", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.MARIGOLD_SEED_PACKET))
                .addCriterion("peashooter", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.PEASHOOTER_SEED_PACKET))
                .addCriterion("snow_pea", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SNOW_PEA_SEED_PACKET))
                .addCriterion("repeater", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.REPEATER_SEED_PACKET))
                .addCriterion("wall_nut", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.WALL_NUT_SEED_PACKET))
                .addCriterion("potato_mine", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.POTATO_MINE_SEED_PACKET))
                .addCriterion("jalapeno", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.JALAPENO_SEED_PACKET))
                .addCriterion("chomper", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.CHOMPER_SEED_PACKET))
                .addCriterion("bonk_choy", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.BONK_CHOY_SEED_PACKET))
                .addCriterion("sun_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SUN_SHROOM_SEED_PACKET))
                .addCriterion("puff_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.PUFF_SHROOM_SEED_PACKET))
                .addCriterion("fume_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.FUME_SHROOM_SEED_PACKET))
                .addCriterion("hypno_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.HYPNO_SHROOM_SEED_PACKET))
                .addCriterion("doom_shroom", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.DOOM_SHROOM_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/first_pack"));

        AdvancementHolder sunflower = getAdvancement(first_pack, BnDItems.SUNFLOWER_SEED_PACKET, "sunflower", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SUNFLOWER_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/sunflower"));

        AdvancementHolder marigold = getAdvancement(first_pack, BnDItems.MARIGOLD_SEED_PACKET, "marigold", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.MARIGOLD_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/marigold"));

        AdvancementHolder peashooter = getAdvancement(first_pack, BnDItems.PEASHOOTER_SEED_PACKET, "peashooter", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.PEASHOOTER_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/peashooter"));

        AdvancementHolder snow_pea = getAdvancement(first_pack, BnDItems.SNOW_PEA_SEED_PACKET, "snow_pea", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SNOW_PEA_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/snow_pea"));

        AdvancementHolder repeater = getAdvancement(first_pack, BnDItems.REPEATER_SEED_PACKET, "repeater", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.REPEATER_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/repeater"));

        AdvancementHolder wall_nut = getAdvancement(first_pack, BnDItems.WALL_NUT_SEED_PACKET, "wall_nut", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.WALL_NUT_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/wall_nut"));

        AdvancementHolder potato_mine = getAdvancement(first_pack, BnDItems.POTATO_MINE_SEED_PACKET, "potato_mine", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.POTATO_MINE_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/potato_mine"));

        AdvancementHolder jalapeno = getAdvancement(first_pack, BnDItems.JALAPENO_SEED_PACKET, "jalapeno", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.JALAPENO_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/jalapeno"));

        AdvancementHolder chomper = getAdvancement(first_pack, BnDItems.CHOMPER_SEED_PACKET, "chomper", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.CHOMPER_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/chomper"));

        AdvancementHolder bonk_choy = getAdvancement(first_pack, BnDItems.BONK_CHOY_SEED_PACKET, "bonk_choy", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.BONK_CHOY_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/bonk_choy"));

        AdvancementHolder sun_shroom = getAdvancement(first_pack, BnDItems.SUN_SHROOM_SEED_PACKET, "sun_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.SUN_SHROOM_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/sun_shroom"));

        AdvancementHolder puff_shroom = getAdvancement(first_pack, BnDItems.PUFF_SHROOM_SEED_PACKET, "puff_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.PUFF_SHROOM_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/puff_shroom"));

        AdvancementHolder fume_shroom = getAdvancement(first_pack, BnDItems.FUME_SHROOM_SEED_PACKET, "fume_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.FUME_SHROOM_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/fume_shroom"));

        AdvancementHolder hypno_shroom = getAdvancement(first_pack, BnDItems.HYPNO_SHROOM_SEED_PACKET, "hypno_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.HYPNO_SHROOM_SEED_PACKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getNameId("main/hypno_shroom"));

        AdvancementHolder doom_shroom = getAdvancement(first_pack, BnDItems.DOOM_SHROOM_SEED_PACKET, "doom_shroom", AdvancementType.TASK, true, true, false)
                .addCriterion("seed_packet", InventoryChangeTrigger.TriggerInstance.hasItems(BnDItems.DOOM_SHROOM_SEED_PACKET))
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
