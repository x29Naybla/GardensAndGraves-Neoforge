package com.x29naybla.bloom_and_doom.common.event;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.EnderManAngerEvent;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class BnDZombiePlayerEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onTargetSelected(LivingChangeTargetEvent event){
        LivingEntity attacker = event.getEntity();
        LivingEntity newTarget = event.getNewAboutToBeSetTarget();

        if(attacker instanceof Monster && newTarget instanceof Player player) {
            if(player.getData(BnDDataAttachments.ZOMBIE)) {
                event.setCanceled(true);
                if(attacker.getLastHurtByMob() != null) {
                    event.setCanceled(!attacker.getLastHurtByMob().is(player));
                }
            }
        }
    }

    @SubscribeEvent
    public static void zombiePlayerEndermanFriend(EnderManAngerEvent event){
        if(event.getPlayer().getData(BnDDataAttachments.ZOMBIE)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void zombiePlayerSleep(CanPlayerSleepEvent event){
        if(event.getEntity().getData(BnDDataAttachments.ZOMBIE) && event.getProblem() == Player.BedSleepingProblem.NOT_SAFE) {
            event.setProblem(null);
        }
    }

    @SubscribeEvent
    public static void zombieEntitySuffersSmite(LivingDamageEvent.Pre event){
        if(!event.getEntity().getType().is(EntityTypeTags.UNDEAD) && event.getEntity().getData(BnDDataAttachments.ZOMBIE)){

            if(event.getContainer().getSource().getWeaponItem() != null && event.getContainer().getSource().getWeaponItem().is(ItemTags.WEAPON_ENCHANTABLE)){
                var smite = event.getEntity().level().getServer().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SMITE);
                int smiteLevel = event.getContainer().getSource().getWeaponItem().getTagEnchantments().getLevel(smite);

                event.setNewDamage((float) (event.getOriginalDamage() + (smiteLevel * 2.5)));
            }
        }
    }

    static boolean fromCuring = false;

    @SubscribeEvent
    public static void zombiePlayerCureSelf(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        if(player.getData(BnDDataAttachments.ZOMBIE)) {
            if(player.hasEffect(MobEffects.WEAKNESS) && (player.getUseItem().is(BnDTags.Items.ZOMBIE_ANTIDOTE) && player.getUseItemRemainingTicks() <= 1)) {
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

            if(fromCuring && (player.getUseItem().is(Tags.Items.DRINKS_MILK) && player.getUseItemRemainingTicks() <= 1)) {
                fromCuring = false;
            }

            if(player.hasEffect(MobEffects.DAMAGE_BOOST) && player.getEffect(MobEffects.DAMAGE_BOOST).getDuration() <= 1 && fromCuring){
                player.removeData(BnDDataAttachments.ZOMBIE);
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
}
