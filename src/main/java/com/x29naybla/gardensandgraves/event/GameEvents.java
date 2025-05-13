package com.x29naybla.gardensandgraves.event;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.data.ModDataAttachments;
import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.*;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.potion.ModPotions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class GameEvents {

    @SubscribeEvent
    public static void addAdditionalGoals(EntityJoinLevelEvent event){
        if (event.getEntity() instanceof  Mob mob){
            if (mob.getType().is(ModTags.Entities.PLANT_ENEMIES)){
                mob.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(mob, (WallNutEntity.class), true));
                mob.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(mob, (PotatoMineEntity.class), true));
                mob.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(mob, Plant.class, true));
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

        if(attacker instanceof Mob && newTarget instanceof Player player) {
            if(player.getData(ModDataAttachments.ZOMBIE)) {
                event.setCanceled(true);
                if(attacker.getLastHurtByMob() != null) {
                    event.setCanceled(!attacker.getLastHurtByMob().is(player));
                }
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
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.BRAIN.get(), ModPotions.ZOMBIFICATION);
    }
}
