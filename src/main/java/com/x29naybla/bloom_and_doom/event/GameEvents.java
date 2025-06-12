package com.x29naybla.bloom_and_doom.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.block.ModBlocks;
import com.x29naybla.bloom_and_doom.data.ModDataAttachments;
import com.x29naybla.bloom_and_doom.data.ModTags;
import com.x29naybla.bloom_and_doom.entity.*;
import com.x29naybla.bloom_and_doom.item.ModItems;
import com.x29naybla.bloom_and_doom.potion.ModPotions;
import com.x29naybla.bloom_and_doom.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

import static com.x29naybla.bloom_and_doom.item.ZombieBanner.getZombieLeaderBannerInstance;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class GameEvents {

    @SubscribeEvent
    public static void addAdditionalGoals(EntityJoinLevelEvent event){
        if (event.getEntity() instanceof  Monster monster){
            if (monster.getType().is(ModTags.Entities.PLANT_ENEMIES)){
                monster.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(monster, (WallNutEntity.class), true));
                monster.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(monster, (PotatoMineEntity.class), true));
                monster.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(monster, Plant.class, true));
            }
        }
        if (event.getEntity() instanceof AbstractGolem golem) {
            golem.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(golem, LivingEntity.class, true,
                    (target) -> target instanceof LivingEntity livingEntity && livingEntity.getData(ModDataAttachments.ZOMBIE)));
        }
        if (!event.getLevel().isClientSide && event.getLevel().random.nextIntBetweenInclusive(0, 49) <= 0.75) {
            if (event.getEntity() instanceof Zombie zombie) {
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

        if(attacker instanceof Monster && newTarget instanceof Player player) {
            if(player.getData(ModDataAttachments.ZOMBIE)) {
                event.setCanceled(true);
                if(attacker.getLastHurtByMob() != null) {
                    event.setCanceled(!attacker.getLastHurtByMob().is(player));
                }
            }
        }

    }

    @SubscribeEvent
    public static void addGardenerTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.GARDENER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Novice
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.FLOWER_POT, 1), 16, 1, 0.05f
            ));

            trades.get(1).add(new BiomeSpecificTrade(
                    new ItemCost(Items.EMERALD, 4), 1,2, 2,
                    Map.of(VillagerType.PLAINS, ModItems.SEED_PACKET_SUNFLOWER.get(),
                            VillagerType.SAVANNA, ModItems.SEED_PACKET_SUNFLOWER.get(),
                            VillagerType.DESERT, ModItems.SEED_PACKET_SUNFLOWER.get(),
                            VillagerType.JUNGLE, ModItems.SEED_PACKET_SUNFLOWER.get(),
                            VillagerType.TAIGA, ModItems.SEED_PACKET_SUN_SHROOM.get(),
                            VillagerType.SNOW, ModItems.SEED_PACKET_SUN_SHROOM.get(),
                            VillagerType.SWAMP, ModItems.SEED_PACKET_SUN_SHROOM.get()))
            );

            trades.get(1).add(new BiomeSpecificTrade(
                    new ItemCost(Items.EMERALD, 4), 1,2, 2,
                    Map.of(VillagerType.PLAINS, ModItems.SEED_PACKET_PEASHOOTER.get(),
                            VillagerType.SAVANNA, ModItems.SEED_PACKET_PEASHOOTER.get(),
                            VillagerType.DESERT, ModItems.SEED_PACKET_PEASHOOTER.get(),
                            VillagerType.JUNGLE, ModItems.SEED_PACKET_REPEATER.get(),
                            VillagerType.TAIGA, ModItems.SEED_PACKET_PUFF_SHROOM.get(),
                            VillagerType.SWAMP, ModItems.SEED_PACKET_PUFF_SHROOM.get(),
                            VillagerType.SNOW, ModItems.SEED_PACKET_SNOW_PEA.get()))
            );

            //Apprentice
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.PLANTER, 1), 8, 5, 0.05f
            ));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.BONE_MEAL, 5), 16, 5, 0.05f
            ));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(ModItems.SEED_PACKET_WALL_NUT.get(), 1), 2, 5, 0.05f
            ));

            //Journeyman
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(Items.SHEARS, 1), 16, 10, 0.05f
            ));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 7),
                    new ItemStack(ModItems.GREEN_WATERING_CAN.get(), 1), 12, 10, 0.05f
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
                    Map.of(VillagerType.PLAINS, ModItems.PEA.get(),
                            VillagerType.SAVANNA, ModItems.PEA.get(),
                            VillagerType.DESERT, ModItems.PEA.get(),
                            VillagerType.JUNGLE, ModItems.PEA.get(),
                            VillagerType.TAIGA, ModItems.SPORE.get(),
                            VillagerType.SWAMP, ModItems.SPORE.get(),
                            VillagerType.SNOW, ModItems.FROZEN_PEA.get()))
            );

            //Master
            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(ModItems.SEED_PACKET_DOOM_SHROOM.get(), 1), 6, 30, 0.05f
            ));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 8),
                    new ItemStack(ModItems.SEED_PACKET_MARIGOLD.get(), 1), 6, 30, 0.05f
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
    public static void zombiePlayerEndermanFriend(EnderManAngerEvent event){
        if(event.getPlayer().getData(ModDataAttachments.ZOMBIE)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void zombiePlayerSleep(CanPlayerSleepEvent event){
        if(event.getEntity().getData(ModDataAttachments.ZOMBIE) && event.getProblem() == Player.BedSleepingProblem.NOT_SAFE) {
            event.setProblem(null);
        }
    }

    @SubscribeEvent
    public static void zombiePlayerCureSelf(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        boolean fromCuring = false;
        if(player.getData(ModDataAttachments.ZOMBIE)) {
            if(player.hasEffect(MobEffects.WEAKNESS) && ((player.getUseItem().is(Items.GOLDEN_APPLE) || player.getUseItem().is(Items.ENCHANTED_GOLDEN_APPLE)) && player.getUseItemRemainingTicks() <= 1)) {
                player.removeEffect(MobEffects.WEAKNESS);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.PLAYERS);
                player.addEffect(new MobEffectInstance(
                        MobEffects.DAMAGE_BOOST,
                        6000,
                        0,
                        false,
                        true,
                        true
                ));
                fromCuring = true;
            }
            if(player.hasEffect(MobEffects.DAMAGE_BOOST) && player.getEffect(MobEffects.DAMAGE_BOOST).getDuration() <= 1 && fromCuring){
                player.removeData(ModDataAttachments.ZOMBIE);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ZOMBIE_VILLAGER_CONVERTED, SoundSource.PLAYERS);
                player.addEffect(new MobEffectInstance(
                        MobEffects.CONFUSION,
                        200,
                        0,
                        false,
                        true,
                        true
                ));
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.BRAIN.get(), ModPotions.ZOMBIFICATION);
    }
}
