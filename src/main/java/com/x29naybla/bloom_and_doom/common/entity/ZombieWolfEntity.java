package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ZombieWolfEntity extends Wolf {
    public ZombieWolfEntity(EntityType<? extends Wolf> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @NotNull ResourceLocation getTexture() {
        if (this.isTame()) {
            return ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/zombie_wolf/wolf_zombie_tame.png");
        } else {
            return this.isAngry() ? ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/zombie_wolf/wolf_zombie_angry.png") : ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/entity/zombie_wolf/wolf_zombie.png");
        }
    }
}
