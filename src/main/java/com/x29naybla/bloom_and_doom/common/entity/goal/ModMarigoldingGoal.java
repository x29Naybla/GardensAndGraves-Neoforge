package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.entity.MarigoldEntity;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModMarigoldingGoal extends Goal {
    private final MarigoldEntity plant;

    public ModMarigoldingGoal(MarigoldEntity plant) {
        this.plant = plant;
    }

    @Override
    public boolean canUse(){
        return this.plant.isAlive() && !this.plant.isBaby();
    }

    public void start(){
        super.start();
    }

    @Override
    public boolean canContinueToUse() {
        return this.plant.isAlive();
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick(){
        --this.plant.rewardTime;
        if (this.plant.rewardTime == 5985) {
            this.plant.setGenerated(false);
        }
        if(this.plant.rewardTime <= 5) {
            this.plant.setGenerated(true);
        }
        if (!this.plant.level().isClientSide && this.plant.rewardTime == 0) {
            this.plant.playSound(ModSounds.MONEYFALLS.get(), 1.0F, (this.plant.getRandom().nextFloat() - this.plant.getRandom().nextFloat()) * 0.2F + 1.0F);
            if(this.plant.getRandom().nextInt(1, 4) <= 1){
                this.plant.spawnAtLocation(Items.GOLD_NUGGET);
                if(this.plant.getRandom().nextInt(1, 4) <= 2){
                    this.plant.spawnAtLocation(Items.GOLD_NUGGET);
                    if(this.plant.getRandom().nextInt(1, 4) <= 1){
                        this.plant.spawnAtLocation(Items.GOLD_NUGGET);
                    }
                }
            }else{
                this.plant.spawnAtLocation(Items.IRON_NUGGET);
                if(this.plant.getRandom().nextInt(1, 4) <= 2){
                    this.plant.spawnAtLocation(Items.IRON_NUGGET);
                    if(this.plant.getRandom().nextInt(1, 4) <= 1){
                        this.plant.spawnAtLocation(Items.IRON_NUGGET);
                    }
                }
            }
            this.plant.gameEvent(GameEvent.ENTITY_PLACE);
            this.plant.rewardTime = 6000;
        }
    }
}
