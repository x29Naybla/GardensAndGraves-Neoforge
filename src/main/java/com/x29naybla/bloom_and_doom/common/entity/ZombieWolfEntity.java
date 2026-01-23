package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    protected void registerGoals() {
        this.goalSelector.addGoal(4, new ZombieAttackTurtleEggGoal(this, 1.0, 3));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        return false;
    }

    @Override
    public @Nullable Wolf getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    class ZombieAttackTurtleEggGoal extends RemoveBlockGoal {
        ZombieAttackTurtleEggGoal(PathfinderMob mob, double speedModifier, int verticalSearchRange) {
            super(Blocks.TURTLE_EGG, mob, speedModifier, verticalSearchRange);
        }

        @Override
        public void playDestroyProgressSound(LevelAccessor level, BlockPos pos) {
            level.playSound(null, pos, SoundEvents.ZOMBIE_DESTROY_EGG, SoundSource.HOSTILE, 0.5F, 0.9F + ZombieWolfEntity.this.random.nextFloat() * 0.2F);
        }

        @Override
        public void playBreakSound(Level level, BlockPos pos) {
            level.playSound(null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + level.random.nextFloat() * 0.2F);
        }

        @Override
        public double acceptedDistance() {
            return 1.14;
        }
    }
}
