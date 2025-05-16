package com.x29naybla.gardensandgraves.entity.goal;

import com.x29naybla.gardensandgraves.entity.MarigoldEntity;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModMarigoldingGoal extends Goal {
    private final MarigoldEntity plant;
    private final Boolean dayPlant;
    private final Boolean canBaby;

    public ModMarigoldingGoal(MarigoldEntity plant, Boolean dayPlant, Boolean canBaby) {
        this.plant = plant;
        this.dayPlant = dayPlant;
        this.canBaby = canBaby;
    }

    @Override
    public boolean canUse(){
        if(this.plant.isAlive() && ((this.dayPlant && this.plant.level().isDay()) || (!this.dayPlant && this.plant.level().isNight()))) return true;
        else return false;
    }

    public void start(){
        super.start();
    }

    @Override
    public boolean canContinueToUse() {
        if(this.plant.isAlive() && ((this.dayPlant && this.plant.level().isDay()) || (!this.dayPlant && this.plant.level().isNight()))) return true;
        else return false;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick(){
        if (!this.dayPlant || (this.dayPlant && !this.plant.level().isRainingAt(this.plant.getOnPos()))) {
            if (!this.plant.isBaby() || (this.canBaby && this.plant.isBaby()) || (!this.canBaby && !this.plant.isBaby())) {
                if (--this.plant.rewardTime <= 40) {
                    this.plant.setGenerated(true);
                    if (!this.plant.level().isClientSide && --this.plant.rewardTime <= 0) {
                        this.plant.playSound(ModSounds.THROW.get(), 1.0F, (this.plant.getRandom().nextFloat() - this.plant.getRandom().nextFloat()) * 0.2F + 1.0F);
                        this.plant.spawnAtLocation(ModItems.SUN);
                        this.plant.gameEvent(GameEvent.ENTITY_PLACE);
                        if (this.plant.isBaby()) this.plant.rewardTime = 12000;
                        else this.plant.rewardTime = 6000;
                        this.plant.setGenerated(false);
                    }
                }
            }
        }
    }
}
