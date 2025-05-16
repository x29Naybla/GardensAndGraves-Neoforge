package com.x29naybla.gardensandgraves.effect;

import com.x29naybla.gardensandgraves.data.ModDataAttachments;
import com.x29naybla.gardensandgraves.data.ModTags;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.WolfVariants;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.EventHooks;

public class Zombification extends MobEffect {
    public Zombification(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if(!entity.level().isClientSide && (entity.getHealth() <= 0 || entity.getEffect(ModEffects.ZOMBIFICATION).getDuration() == 1)) {
            ServerLevel level = (ServerLevel) entity.level();
            if((entity instanceof Piglin || entity instanceof PiglinBrute)) {
                AbstractPiglin piglin = (AbstractPiglin) entity;
                ZombifiedPiglin zombifiedpiglin = piglin.convertTo(EntityType.ZOMBIFIED_PIGLIN, true);
                if (zombifiedpiglin != null) {
                    zombifiedpiglin.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                    EventHooks.onLivingConvert(piglin, zombifiedpiglin);
                }
                if(entity instanceof Piglin) entity.makeSound(SoundEvents.PIGLIN_CONVERTED_TO_ZOMBIFIED);
                else entity.makeSound(SoundEvents.PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED);
                return true;

            } else if(entity instanceof Hoglin hoglin) {
                hoglin.makeSound(SoundEvents.HOGLIN_CONVERTED_TO_ZOMBIFIED);
                Zoglin zoglin = hoglin.convertTo(EntityType.ZOGLIN, true);
                if (zoglin != null) {
                    zoglin.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                    EventHooks.onLivingConvert(hoglin, zoglin);
                }
                return true;

            } else if(entity instanceof Villager villager) {
                ZombieVillager zombievillager = villager.convertTo(EntityType.ZOMBIE_VILLAGER, false);
                if (zombievillager != null) {
                    zombievillager.finalizeSpawn(level, level.getCurrentDifficultyAt(zombievillager.blockPosition()), MobSpawnType.CONVERSION, new Zombie.ZombieGroupData(false, true));
                    zombievillager.setVillagerData(villager.getVillagerData());
                    zombievillager.setGossips(villager.getGossips().store(NbtOps.INSTANCE));
                    zombievillager.setTradeOffers(villager.getOffers().copy());
                    zombievillager.setVillagerXp(villager.getVillagerXp());
                    EventHooks.onLivingConvert(entity, zombievillager);
                    entity.makeSound(SoundEvents.ZOMBIE_INFECT);
                }
                return true;

            } else if(entity instanceof Horse horse) {
                horse.makeSound(SoundEvents.HORSE_BREATHE);
                ZombieHorse zHorse = horse.convertTo(EntityType.ZOMBIE_HORSE, true);
                if(zHorse != null) {
                    zHorse.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                    EventHooks.onLivingConvert(horse, zHorse);
                }
                return true;

            } else if(entity instanceof Player player) {
                player.setData(ModDataAttachments.ZOMBIE, true);
                if (!entity.level().isClientSide) player.level().playSound(player, player.getOnPos(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS,1.0F, 1.0F);
                return true;

            }
        } else if (entity.level().isClientSide && (entity.getHealth() <= 0 || entity.getEffect(ModEffects.ZOMBIFICATION).getDuration() == 1) && entity instanceof Player player) {
            player.setData(ModDataAttachments.ZOMBIE, true);
            if (!entity.level().isClientSide) player.level().playSound(player, player.getOnPos(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS,1.0F, 1.0F);
            return true;
        }

        return super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
