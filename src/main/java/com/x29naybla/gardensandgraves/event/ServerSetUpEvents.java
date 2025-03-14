package com.x29naybla.gardensandgraves.event;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.Plant;
import com.x29naybla.gardensandgraves.entity.WallNutEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ServerSetUpEvents {

    @SubscribeEvent
    public static void addAdditionalGoals(EntityJoinLevelEvent event){
        if(event.getEntity() instanceof Monster monster && !(event.getEntity() instanceof Creeper || event.getEntity() instanceof EnderMan)){
            monster.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(monster, WallNutEntity.class, true));
            monster.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(monster, Plant.class, true));
        }
    }
}
