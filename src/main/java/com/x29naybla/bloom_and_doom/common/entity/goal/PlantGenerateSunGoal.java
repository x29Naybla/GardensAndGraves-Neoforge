package com.x29naybla.bloom_and_doom.common.entity.goal;

import com.x29naybla.bloom_and_doom.common.entity.SolarPlant;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.gameevent.GameEvent;

import static com.x29naybla.bloom_and_doom.common.entity.Plant.DATA_IS_SLEEPING;

public class PlantGenerateSunGoal extends Goal {
    private final SolarPlant plant;
    private final SoundEvent sound;

    public PlantGenerateSunGoal(SolarPlant plant, SoundEvent sound) {
        this.plant = plant;
        this.sound = sound;
    }

    @Override
    public boolean canUse(){
        return this.plant.isAlive() && ((!this.plant.isMushroom && this.plant.level().isDay()) || (this.plant.isMushroom && !this.plant.getEntityData().get(DATA_IS_SLEEPING)));
    }

    public void start(){
        super.start();
    }

    @Override
    public boolean canContinueToUse() {
        return this.plant.isAlive() && ((!this.plant.isMushroom && this.plant.level().isDay()) || (this.plant.isMushroom && !this.plant.getEntityData().get(DATA_IS_SLEEPING)));
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick(){
        if (this.plant.isMushroom || !this.plant.level().isRainingAt(this.plant.getOnPos().above())) {
            if (this.plant.canBaby || !this.plant.isBaby()) {
                --this.plant.sunTime;
                if (this.plant.sunTime == plant.maxSunTime-15) {
                    this.plant.setGenerated(false);
                }
                if (this.plant.sunTime <= 5) {
                    this.plant.setGenerated(true);
                }
                if (!this.plant.level().isClientSide && this.plant.sunTime <= 0) {
                    this.plant.playSound(this.sound, 1.0F, (this.plant.getRandom().nextFloat() - this.plant.getRandom().nextFloat()) * 0.2F + 1.0F);
                    this.plant.spawnAtLocation(BnDItems.SUN);
                    this.plant.gameEvent(GameEvent.ENTITY_PLACE);
                    if (this.plant.isBaby()) {
                        this.plant.sunTime = plant.maxSunTime*2;
                    } else this.plant.sunTime = plant.maxSunTime;
                }
            }
        }
    }
}
