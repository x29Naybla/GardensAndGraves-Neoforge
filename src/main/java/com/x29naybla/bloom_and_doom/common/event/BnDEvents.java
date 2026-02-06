package com.x29naybla.bloom_and_doom.common.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.item.ZombieBanner;
import com.x29naybla.bloom_and_doom.common.registry.*;
import com.x29naybla.bloom_and_doom.common.tag.CommonTags;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import com.x29naybla.bloom_and_doom.common.entity.*;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

import static com.x29naybla.bloom_and_doom.common.item.ZombieBanner.getZombieLeaderBannerInstance;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class BnDEvents {

    @SubscribeEvent
    public static void addAdditionalGoals(EntityJoinLevelEvent event){
        if (event.getEntity() instanceof  Monster monster){
            if (monster.getType().is(BnDTags.Entities.PLANT_ENEMIES)){
                monster.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(monster, (WallNutEntity.class), true));
                monster.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(monster, (PotatoMineEntity.class), true));
                monster.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(monster, Plant.class, true));
            }
        }
        if (event.getEntity() instanceof AbstractGolem golem) {
            golem.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(golem, LivingEntity.class, true,
                    (target) -> target instanceof LivingEntity livingEntity && livingEntity.getData(BnDDataAttachments.ZOMBIE)));
        }
    }

    @SubscribeEvent
    public static void entitySpawnEvent(FinalizeSpawnEvent event){
        if (!event.getLevel().isClientSide() && event.getEntity() instanceof Zombie zombie) {
            if (event.getLevel().getRandom().nextIntBetweenInclusive(0, 49) <= 0.75) {
                zombie.setItemSlot(EquipmentSlot.HEAD, getZombieLeaderBannerInstance(zombie.registryAccess().lookupOrThrow(Registries.BANNER_PATTERN)));
                zombie.setGuaranteedDrop(EquipmentSlot.HEAD);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onTargetSelected(LivingChangeTargetEvent event){
        LivingEntity attacker = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        if (event.getEntity().level().isClientSide || newTarget == null) return;

        if(attacker instanceof Creeper || attacker instanceof EnderMan){
            if (newTarget instanceof Plant){
                event.setCanceled(true);
            }
        }

        if(attacker instanceof Plant && newTarget instanceof TamableAnimal tamableAnimal && tamableAnimal.isTame()){
            event.setCanceled(true);
            if(attacker.getLastHurtByMob() != null) {
                event.setCanceled(!attacker.getLastHurtByMob().is(tamableAnimal));
            }
        }

    }

    @SubscribeEvent
    public static void addGardenerTrades(VillagerTradesEvent event) {
        if (event.getType() == BnDVillagers.GARDENER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Novice
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.FLOWER_POT, 1), 16, 1, 0.05f
            ));

            trades.get(1).add(new BiomeSpecificTrade(
                    new ItemCost(Items.EMERALD, 4), 1,2, 2,
                    Map.of(VillagerType.PLAINS, BnDItems.SUNFLOWER_SEED_PACKET.get(),
                            VillagerType.SAVANNA, BnDItems.SUNFLOWER_SEED_PACKET.get(),
                            VillagerType.DESERT, BnDItems.SUNFLOWER_SEED_PACKET.get(),
                            VillagerType.JUNGLE, BnDItems.SUNFLOWER_SEED_PACKET.get(),
                            VillagerType.TAIGA, BnDItems.SUN_SHROOM_SEED_PACKET.get(),
                            VillagerType.SNOW, BnDItems.SUN_SHROOM_SEED_PACKET.get(),
                            VillagerType.SWAMP, BnDItems.SUN_SHROOM_SEED_PACKET.get()))
            );

            trades.get(1).add(new BiomeSpecificTrade(
                    new ItemCost(Items.EMERALD, 4), 1,2, 2,
                    Map.of(VillagerType.PLAINS, BnDItems.PEASHOOTER_SEED_PACKET.get(),
                            VillagerType.SAVANNA, BnDItems.PEASHOOTER_SEED_PACKET.get(),
                            VillagerType.DESERT, BnDItems.PEASHOOTER_SEED_PACKET.get(),
                            VillagerType.JUNGLE, BnDItems.REPEATER_SEED_PACKET.get(),
                            VillagerType.TAIGA, BnDItems.PUFF_SHROOM_SEED_PACKET.get(),
                            VillagerType.SWAMP, BnDItems.PUFF_SHROOM_SEED_PACKET.get(),
                            VillagerType.SNOW, BnDItems.SNOW_PEA_SEED_PACKET.get()))
            );

            //Apprentice
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(BnDBlocks.PLANTER, 1), 8, 5, 0.05f
            ));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.BONE_MEAL, 5), 16, 5, 0.05f
            ));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(BnDItems.WALL_NUT_SEED_PACKET.get(), 1), 2, 5, 0.05f
            ));

            //Journeyman
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(Items.SHEARS, 1), 16, 10, 0.05f
            ));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 7),
                    new ItemStack(BnDItems.GREEN_WATERING_CAN.get(), 1), 12, 10, 0.05f
            ));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.GRASS_BLOCK, 1), 12, 10, 0.05f
            ));

            //Expert
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 8),
                    new ItemStack(Items.MYCELIUM, 1), 8, 15, 0.05f
            ));

            trades.get(4).add(new BiomeSpecificTrade(
                    new ItemCost(Items.EMERALD, 3), 1,8, 15,
                    Map.of(VillagerType.PLAINS, BnDItems.PEA.get(),
                            VillagerType.SAVANNA, BnDItems.PEA.get(),
                            VillagerType.DESERT, BnDItems.PEA.get(),
                            VillagerType.JUNGLE, BnDItems.PEA.get(),
                            VillagerType.TAIGA, BnDItems.SPORE.get(),
                            VillagerType.SWAMP, BnDItems.SPORE.get(),
                            VillagerType.SNOW, BnDItems.FROZEN_PEA.get()))
            );

            //Master
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(BnDItems.DOOM_SHROOM_SEED_PACKET.get(), 1), 6, 30, 0.05f
            ));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 8),
                    new ItemStack(BnDItems.MARIGOLD_SEED_PACKET.get(), 1), 6, 30, 0.05f
            ));
        }
    }

    static class BiomeSpecificTrade implements VillagerTrades.ItemListing {
        private final Map<VillagerType, Item> trades;
        private final ItemCost itemCost;
        private final int toSell;
        private final int maxUses;
        private final int villagerXp;

        public BiomeSpecificTrade(ItemCost itemCost, int toSell, int maxUses, int villagerXp, Map<VillagerType, Item> trades) {
            this.trades = trades;
            this.itemCost = itemCost;
            this.toSell = toSell;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
        }

        @Nullable
        public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
            if (trader instanceof VillagerDataHolder villagerdataholder) {
                Item item = this.trades.get(villagerdataholder.getVillagerData().getType());
                if (item == null) {
                    return null;
                } else {
                    ItemStack itemStack = new ItemStack(item, this.toSell);
                    return new MerchantOffer(itemCost, itemStack, this.maxUses, this.villagerXp, 0.05F);
                }
            } else {
                return null;
            }
        }
    }

    @SubscribeEvent
    public static void flowerPotOccupied(PlayerInteractEvent.RightClickBlock event){
        Block block = event.getLevel().getBlockState(event.getPos()).getBlock();
        if (block.defaultBlockState().is(CommonTags.Blocks.FLOWER_POTS)) {
            List<Plant> plants = event.getLevel().getEntitiesOfClass(Plant.class, AABB.unitCubeFromLowerCorner(Vec3.atLowerCornerOf(event.getPos())));
            if (!plants.isEmpty()) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.insertAfter(Blocks.SMITHING_TABLE.asItem().getDefaultInstance(), BnDBlocks.POTTING_TABLE.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Raid.getLeaderBannerInstance(event.getParameters().holders().lookupOrThrow(Registries.BANNER_PATTERN)), ZombieBanner.getZombieLeaderBannerInstance(event.getParameters().holders().lookupOrThrow(Registries.BANNER_PATTERN)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(BnDBlocks.WHITE_PLASTIC_BLOCK);
            event.accept(BnDBlocks.WHITE_PLASTIC_STAIRS);
            event.accept(BnDBlocks.LIGHT_GRAY_PLASTIC_BLOCK);
            event.accept(BnDBlocks.LIGHT_GRAY_PLASTIC_STAIRS);
            event.accept(BnDBlocks.GRAY_PLASTIC_BLOCK);
            event.accept(BnDBlocks.GRAY_PLASTIC_STAIRS);
            event.accept(BnDBlocks.BLACK_PLASTIC_BLOCK);
            event.accept(BnDBlocks.BLACK_PLASTIC_STAIRS);
            event.accept(BnDBlocks.BROWN_PLASTIC_BLOCK);
            event.accept(BnDBlocks.BROWN_PLASTIC_STAIRS);
            event.accept(BnDBlocks.RED_PLASTIC_BLOCK);
            event.accept(BnDBlocks.RED_PLASTIC_STAIRS);
            event.accept(BnDBlocks.ORANGE_PLASTIC_BLOCK);
            event.accept(BnDBlocks.ORANGE_PLASTIC_STAIRS);
            event.accept(BnDBlocks.YELLOW_PLASTIC_BLOCK);
            event.accept(BnDBlocks.YELLOW_PLASTIC_STAIRS);
            event.accept(BnDBlocks.LIME_PLASTIC_BLOCK);
            event.accept(BnDBlocks.LIME_PLASTIC_STAIRS);
            event.accept(BnDBlocks.GREEN_PLASTIC_BLOCK);
            event.accept(BnDBlocks.GREEN_PLASTIC_STAIRS);
            event.accept(BnDBlocks.CYAN_PLASTIC_BLOCK);
            event.accept(BnDBlocks.CYAN_PLASTIC_STAIRS);
            event.accept(BnDBlocks.LIGHT_BLUE_PLASTIC_BLOCK);
            event.accept(BnDBlocks.LIGHT_BLUE_PLASTIC_STAIRS);
            event.accept(BnDBlocks.BLUE_PLASTIC_BLOCK);
            event.accept(BnDBlocks.BLUE_PLASTIC_STAIRS);
            event.accept(BnDBlocks.PURPLE_PLASTIC_BLOCK);
            event.accept(BnDBlocks.PURPLE_PLASTIC_STAIRS);
            event.accept(BnDBlocks.MAGENTA_PLASTIC_BLOCK);
            event.accept(BnDBlocks.MAGENTA_PLASTIC_STAIRS);
            event.accept(BnDBlocks.PINK_PLASTIC_BLOCK);
            event.accept(BnDBlocks.PINK_PLASTIC_STAIRS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.MUSIC_DISC_PIGSTEP.getDefaultInstance(), BnDItems.MUSIC_DISC_WABBY_WABBO.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.accept(BnDItems.WHITE_WATERING_CAN);
            event.accept(BnDItems.LIGHT_GRAY_WATERING_CAN);
            event.accept(BnDItems.GRAY_WATERING_CAN);
            event.accept(BnDItems.BLACK_WATERING_CAN);
            event.accept(BnDItems.BROWN_WATERING_CAN);
            event.accept(BnDItems.RED_WATERING_CAN);
            event.accept(BnDItems.ORANGE_WATERING_CAN);
            event.accept(BnDItems.YELLOW_WATERING_CAN);
            event.accept(BnDItems.LIME_WATERING_CAN);
            event.accept(BnDItems.GREEN_WATERING_CAN);
            event.accept(BnDItems.CYAN_WATERING_CAN);
            event.accept(BnDItems.LIGHT_BLUE_WATERING_CAN);
            event.accept(BnDItems.BLUE_WATERING_CAN);
            event.accept(BnDItems.PURPLE_WATERING_CAN);
            event.accept(BnDItems.MAGENTA_WATERING_CAN);
            event.accept(BnDItems.PINK_WATERING_CAN);
        }
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS){
            event.accept(BnDItems.ZOMBIE_WOLF_SPAWN_EGG);
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, BnDItems.BRAIN.get(), BnDPotions.ZOMBIFICATION);
    }
}
