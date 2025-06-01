package com.x29naybla.bloom_and_doom.item.custom;

import com.x29naybla.bloom_and_doom.data.ModDataComponents;
import com.x29naybla.bloom_and_doom.entity.MarigoldEntity;
import com.x29naybla.bloom_and_doom.entity.Plant;
import com.x29naybla.bloom_and_doom.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PottedPlantItem extends SeedPacketItem{
    public PottedPlantItem(EntityType<? extends Mob> defaultType, Properties properties) {
        super(defaultType, 0, 0, properties);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        ItemStack stack = context.getItemInHand();

        Direction direction = context.getClickedFace();
        if (player != null && player.isCrouching()) {
            if (level instanceof ServerLevel) {
                ServerLevel serverlevel = (ServerLevel)level;
                ItemStack flowerPot = stack.get(DataComponents.BUNDLE_CONTENTS).getItemUnsafe(0);
                BlockItem flowerPotBlock = (BlockItem) flowerPot.getItem();
                level.setBlock(blockpos, flowerPotBlock.getBlock().defaultBlockState(), 3);
                placePlant(stack, serverlevel, context, blockpos, true);
                if (player != null && !player.isCreative()) player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (direction == Direction.DOWN) {
            return InteractionResult.FAIL;
        }else if (onSubstrate(level, blockpos) || onPlanter(level, blockpos)){
            Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
            AABB aabb = this.getType(stack).getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
            if(level.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()){
                if(level instanceof ServerLevel){
                    ServerLevel serverlevel = (ServerLevel)level;
                    placePlant(stack, serverlevel, context, blockpos, false);
                    if (player != null && !player.isCreative()) {
                        ItemStack flowerPot = stack.get(DataComponents.BUNDLE_CONTENTS).getItemUnsafe(0);
                        player.setItemInHand(InteractionHand.MAIN_HAND, flowerPot);
                    }
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else return InteractionResult.FAIL;
        } else return InteractionResult.FAIL;
    }

    private void placePlant(ItemStack stack, ServerLevel serverlevel, UseOnContext context, BlockPos blockpos, Boolean onFlowerPot) {
        Entity entity = this.getType(stack).create(serverlevel, EntityType.createDefaultStackConfig(serverlevel, stack, context.getPlayer()), blockpos, MobSpawnType.BUCKET, false, false);
        if (entity == null) {
            return;
        }
        float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation()) + 22.5F) / 45.0F) * 45.0F;
        if (onFlowerPot) {
            entity.moveTo(entity.getX(), entity.getY()+0.375, entity.getZ(), 0, 0);
            serverlevel.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1F, 0.8F);
        } else {
            entity.moveTo(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
            serverlevel.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.POTTED_PLANT_PLANT.get(), SoundSource.BLOCKS, 0.75F, 0.8F);
        }
        entity.setYRot(f);
        entity.setXRot(0);
        if(entity instanceof Plant plant){
            if (stack.has(DataComponents.CUSTOM_NAME)) plant.setCustomName(stack.getHoverName());
            if (stack.has(DataComponents.BASE_COLOR)) ((MarigoldEntity) plant).setColor(stack.get(DataComponents.BASE_COLOR));
            if (stack.has(ModDataComponents.AGE)) plant.setAge(stack.get(ModDataComponents.AGE));
            if (stack.has(ModDataComponents.HEALTH)) plant.setHealth(stack.get(ModDataComponents.HEALTH));
            plant.fromPlanter = true;
        }
        serverlevel.addFreshEntityWithPassengers(entity);
        entity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
    }
}
