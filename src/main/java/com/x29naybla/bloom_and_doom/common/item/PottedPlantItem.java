package com.x29naybla.bloom_and_doom.common.item;

import com.google.common.collect.Maps;
import com.x29naybla.bloom_and_doom.common.registry.ModDataComponents;
import com.x29naybla.bloom_and_doom.common.entity.MarigoldEntity;
import com.x29naybla.bloom_and_doom.common.entity.Plant;
import com.x29naybla.bloom_and_doom.common.entity.PotatoMineEntity;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class PottedPlantItem extends PlantHolderItem {
    private static final Map<DyeColor, Component> MARIGOLD_COLORS = Util.make(Maps.newEnumMap(DyeColor.class), map -> {
        map.put(DyeColor.WHITE, Component.translatable("item.bloom_and_Doom.potted_marigold.white").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.LIGHT_GRAY, Component.translatable("item.bloom_and_Doom.potted_marigold.light_gray").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.GRAY, Component.translatable("item.bloom_and_Doom.potted_marigold.gray").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.BLACK, Component.translatable("item.bloom_and_Doom.potted_marigold.black").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.BROWN, Component.translatable("item.bloom_and_Doom.potted_marigold.brown").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.RED, Component.translatable("item.bloom_and_Doom.potted_marigold.red").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.ORANGE, Component.translatable("item.bloom_and_Doom.potted_marigold.orange").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.YELLOW, Component.translatable("item.bloom_and_Doom.potted_marigold.yellow").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.LIME, Component.translatable("item.bloom_and_Doom.potted_marigold.lime").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.GREEN, Component.translatable("item.bloom_and_Doom.potted_marigold.green").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.CYAN, Component.translatable("item.bloom_and_Doom.potted_marigold.cyan").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.LIGHT_BLUE, Component.translatable("item.bloom_and_Doom.potted_marigold.light_blue").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.BLUE, Component.translatable("item.bloom_and_Doom.potted_marigold.blue").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.PURPLE, Component.translatable("item.bloom_and_Doom.potted_marigold.purple").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.MAGENTA, Component.translatable("item.bloom_and_Doom.potted_marigold.magenta").withStyle(ChatFormatting.GRAY));
        map.put(DyeColor.PINK, Component.translatable("item.bloom_and_Doom.potted_marigold.pink").withStyle(ChatFormatting.GRAY));
    });

    public PottedPlantItem(EntityType<? extends Plant> defaultType, Properties properties) {
        super(defaultType, properties);
    }

    @Override
    public int getMaxStackSize(@NotNull ItemStack stack) {
        return 1;
    }

    public @NotNull String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        BundleContents bundlecontents = stack.get(DataComponents.BUNDLE_CONTENTS);

        if (stack.is(ModItems.POTTED_MARIGOLD)) {
            tooltipComponents.add(MARIGOLD_COLORS.get(stack.get(DataComponents.BASE_COLOR)));
        }

        if (bundlecontents != null) {
            ItemStack flowerPot = bundlecontents.getItemUnsafe(0).getItem().getDefaultInstance();
            String flowerPotName = flowerPot.getDisplayName().getString().substring(1, flowerPot.getDisplayName().getString().length() - 1);

            tooltipComponents.add(Component.translatable(flowerPotName).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        ItemStack stack = context.getItemInHand();

        Direction direction = context.getClickedFace();
        if (level instanceof ServerLevel serverLevel) {
            Plant plant = (Plant) this.getType(stack).create(serverLevel, EntityType.createDefaultStackConfig(serverLevel, stack, context.getPlayer()), blockpos, MobSpawnType.BUCKET, false, false);
            Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
            AABB aabb = this.getType(stack).getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
            if(serverLevel.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()){
                if(serverLevel.isEmptyBlock(blockpos)) {
                    if (direction == Direction.DOWN) {
                        return InteractionResult.FAIL;
                    } else if (player != null && player.isCrouching()) {
                        ItemStack flowerPot = stack.get(DataComponents.BUNDLE_CONTENTS).getItemUnsafe(0);
                        BlockItem flowerPotBlock = (BlockItem) flowerPot.getItem();
                        serverLevel.setBlock(blockpos, flowerPotBlock.getBlock().defaultBlockState(), 3);
                        placePlant(stack, serverLevel, context, blockpos, true);
                        if (!player.isCreative()) player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
                        return InteractionResult.SUCCESS;
                    } else if (plant.onRightSubstrate(serverLevel, blockpos)){
                        placePlant(stack, serverLevel, context, blockpos, false);
                        if (player != null && !player.isCreative()) {
                            ItemStack flowerPot = stack.get(DataComponents.BUNDLE_CONTENTS).getItemUnsafe(0);
                            player.setItemInHand(InteractionHand.MAIN_HAND, flowerPot);
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }

    private void placePlant(ItemStack stack, ServerLevel serverlevel, UseOnContext context, BlockPos blockpos, Boolean onFlowerPot) {
        Entity entity = this.getType(stack).create(serverlevel, EntityType.createDefaultStackConfig(serverlevel, stack, context.getPlayer()), blockpos, MobSpawnType.BUCKET, false, false);
        if (entity != null) {
            if (entity instanceof Plant plant) {
                float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation()) + 22.5F) / 45.0F) * 45.0F;
                if (onFlowerPot) {
                    plant.moveTo(entity.getX(), entity.getY()+0.375, entity.getZ(), 0, 0);
                    serverlevel.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1F, 0.8F);
                } else {
                    plant.moveTo(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                    serverlevel.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.POTTED_PLANT_PLANT.get(), SoundSource.BLOCKS, 0.75F, 0.8F);
                }
                plant.setYRot(f);
                plant.setXRot(0);
                if (stack.has(DataComponents.CUSTOM_NAME)) plant.setCustomName(stack.getHoverName());
                if (stack.has(DataComponents.BASE_COLOR)) ((MarigoldEntity) plant).setColor(stack.get(DataComponents.BASE_COLOR));
                if (stack.has(ModDataComponents.AGE)) plant.setAge(stack.get(ModDataComponents.AGE));
                if (stack.has(ModDataComponents.HEALTH)) plant.setHealth(stack.get(ModDataComponents.HEALTH));
                if (plant instanceof PotatoMineEntity potatoMine) potatoMine.setArmed(true);
                plant.fromPlanter = true;

                serverlevel.addFreshEntityWithPassengers(entity);
                plant.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
            }
        }
    }
}
