package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, GardensAndGraves.MOD_ID);
    }

    @Override
    protected void start() {
        //Plains villages
        add("sunflower_in_plains_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(25f).build()},
                ModItems.SEED_PACKET_SUNFLOWER.get()));

        add("peashooter_in_plains_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_PEASHOOTER.get()));

        add("wall_nut_in_plains_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_WALL_NUT.get()));

        add("repeater_in_plains_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(6.5f).build()},
                ModItems.SEED_PACKET_REPEATER.get()));

        //Taiga villages
        add("sun_shroom_in_taiga_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(25f).build()},
                ModItems.SEED_PACKET_SUN_SHROOM.get()));

        add("peashooter_in_taiga_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_PEASHOOTER.get()));

        add("wall_nut_in_taiga_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_WALL_NUT.get()));

        add("puff_shroom_in_taiga_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_PUFF_SHROOM.get()));

        add("fume_shroom_in_taiga_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_FUME_SHROOM.get()));

        add("hypno_shroom_in_taiga_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_HYPNO_SHROOM.get()));

        //Snowy villages
        add("snow_peashooter_in_snowy_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_snowy_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_SNOW_PEA.get()));

        add("wall_nut_in_snowy_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_snowy_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_WALL_NUT.get()));

        //Desert villages
        add("jalapeno_in_desert_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_JALAPENO.get()));

        add("peashooter_in_desert_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_PEASHOOTER.get()));

        add("wall_nut_in_desert_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_WALL_NUT.get()));

        add("bonk_choy_in_desert_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_BONK_CHOY.get()));

        add("potato_mine_in_desert_village", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_POTATO_MINE.get()));

        //Desert temples
        add("bonk_choy_in_desert_pyramid", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_BONK_CHOY.get()));

        //Jungle temples
        add("potato_mine_in_jungle_temple", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_POTATO_MINE.get()));

        add("chomper_in_jungle_temple", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_CHOMPER.get()));

        //Ancient city
        add("doom_shroom_in_ancient_city", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_DOOM_SHROOM.get()));

        add("snow_peashooter_in_ancient_city_ice_box", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/ancient_city_ice_box")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_SNOW_PEA.get()));

        //Abandoned mineshaft
        add("marigold_in_abandoned_mineshaft", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_MARIGOLD.get()));

        //Shipwrecks
        add("marigold_in_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/shipwreck_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(12.5f).build()},
                ModItems.SEED_PACKET_MARIGOLD.get()));
    }
}
