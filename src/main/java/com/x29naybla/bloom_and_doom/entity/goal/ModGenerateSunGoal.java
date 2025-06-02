package com.x29naybla.bloom_and_doom.entity.goal;

import com.x29naybla.bloom_and_doom.entity.SolarPlant;
import com.x29naybla.bloom_and_doom.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.gameevent.GameEvent;

public class ModGenerateSunGoal extends Goal {
    private final SolarPlant plant;
    private final SoundEvent sound;
    private final Boolean dayPlant;

    public ModGenerateSunGoal(SolarPlant plant, SoundEvent sound, Boolean dayPlant) {
        this.plant = plant;
        this.sound = sound;
        this.dayPlant = dayPlant;
    }

    @Override
    public boolean canUse(){
        return this.plant.isAlive() && ((this.dayPlant && this.plant.level().isDay()) || (!this.dayPlant && this.plant.level().isNight()));
    }

    public void start(){
        super.start();
    }

    @Override
    public boolean canContinueToUse() {
        return this.plant.isAlive() && ((this.dayPlant && this.plant.level().isDay()) || (!this.dayPlant && this.plant.level().isNight()));
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick(){
        if (!this.dayPlant || (this.dayPlant && !this.plant.level().isRainingAt(this.plant.getOnPos().above()))) {
            if (!this.plant.isBaby()) {
                --this.plant.sunTime;
                if (this.plant.sunTime == 5985) {
                    this.plant.setGenerated(false);
                }
                if (this.plant.sunTime <= 5) {
                    this.plant.setGenerated(true);
                }
                if (!this.plant.level().isClientSide && this.plant.sunTime <= 0) {
                    this.plant.playSound(this.sound, 1.0F, (this.plant.getRandom().nextFloat() - this.plant.getRandom().nextFloat()) * 0.2F + 1.0F);
                    this.plant.spawnAtLocation(ModItems.SUN);
                    this.plant.gameEvent(GameEvent.ENTITY_PLACE);
                    this.plant.sunTime = 6000;

                }
            }
        }
    }
}
