package com.x29naybla.gardensandgraves.item.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.component.ModDataComponents;
import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.Plant;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SeedPacketItem extends Item {
    private static final MapCodec<EntityType<?>> ENTITY_TYPE_FIELD_CODEC;
    private final EntityType<?> defaultType;
    private final int sunAmount;

    public SeedPacketItem(EntityType<? extends Mob> defaultType, int sunAmount, Item.Properties properties) {
        super(properties);
        this.defaultType = defaultType;
        this.sunAmount = sunAmount;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }


    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        ItemStack stack = context.getItemInHand();

        if ((context.getPlayer().getInventory().countItem(ModItems.SUN.get()) >= sunAmount) || context.getPlayer().isCreative() ||onPlanter(level, blockpos)){
            Direction direction = context.getClickedFace();
            if (direction == Direction.DOWN) {
                return InteractionResult.FAIL;
            }else if (onSubstrate(level, blockpos)){
                ItemStack itemStack = context.getItemInHand();
                Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
                AABB aabb = this.getType(itemStack).getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
                if(level.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()){
                    if(level instanceof ServerLevel){
                        ServerLevel serverlevel = (ServerLevel)level;
                        Entity entity = this.getType(itemStack).create(serverlevel, EntityType.createDefaultStackConfig(serverlevel, itemStack, context.getPlayer()), blockpos, MobSpawnType.SPAWN_EGG, false, false);
                        if (entity == null) {
                            return InteractionResult.FAIL;
                        }
                        float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation()) + 22.5F) / 45.0F) * 45.0F;
                        entity.moveTo(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                        entity.setYRot(f);
                        entity.setXRot(0);
                        if(entity instanceof Plant plant){
                            if (stack.has(DataComponents.CUSTOM_NAME)) plant.setCustomName(stack.getHoverName());
                            if(onPlanter(level, blockpos)){
                                plant.setBaby(true);
                                plant.fromPlanter(true);
                            }else
                                plant.fromPlanter(false);
                        }
                        serverlevel.addFreshEntityWithPassengers(entity);
                        level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
                        entity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                    }
                    itemStack.shrink(1);
                    if(!((context.getPlayer().isCreative() || onPlanter(level, blockpos)))){
                        context.getPlayer().getInventory().removeItem(context.getPlayer().getInventory().findSlotMatchingItem(ModItems.SUN.toStack()), sunAmount);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else return InteractionResult.FAIL;
            } else return InteractionResult.FAIL;
        } else return InteractionResult.FAIL;
    }

    /*
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        ItemStack stack = context.getItemInHand();

        if ((context.getPlayer().getInventory().countItem(ModItems.SUN.get()) >= sunAmount) || context.getPlayer().isCreative() || onPlanter(level, blockpos)){
            Direction direction = context.getClickedFace();
            if (direction == Direction.DOWN) {
                return InteractionResult.FAIL;
            } else if (onSubstrate(level, blockpos)) {
                ItemStack itemstack = context.getItemInHand();
                Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
                AABB aabb = this.getType(itemstack).getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
                if (level.noCollision((Entity)null, aabb) && level.getEntities((Entity)null, aabb).isEmpty()) {
                    if (level instanceof ServerLevel) {
                        ServerLevel serverlevel = (ServerLevel)level;
                        Entity entity = this.getType(itemstack).create(serverlevel, EntityType.createDefaultStackConfig(serverlevel, itemstack, context.getPlayer()), blockpos, MobSpawnType.SPAWN_EGG, true, true);
                        if (entity == null) {
                            return InteractionResult.FAIL;
                        }
                        float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                        entity.moveTo(entity.getX(), entity.getY(), entity.getZ(), f, 0.0F);
                        if(entity instanceof Plant plant){
                            if (stack.has(DataComponents.CUSTOM_NAME)) plant.setCustomName(stack.getHoverName());
                            plant.load((CompoundTag) stack.getTags());
                            if(onPlanter(level, blockpos)){
                                plant.setBaby(true);
                                plant.fromPlanter(true);
                            }else
                                plant.fromPlanter(false);
                        }
                        serverlevel.addFreshEntityWithPassengers(entity);
                        level.playSound((Player)null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
                        entity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                    }
                    itemstack.shrink(1);
                    if(!((context.getPlayer().isCreative() || onPlanter(level, blockpos)))){
                        context.getPlayer().getInventory().removeItem(context.getPlayer().getInventory().findSlotMatchingItem(ModItems.SUN.toStack()), sunAmount);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    return InteractionResult.FAIL;
                }
            }else {
                return InteractionResult.FAIL;
            }
        }else {
            return InteractionResult.FAIL;
        }
    }
    */

    public static boolean onSubstrate(BlockGetter level, BlockPos pos) {
        return isSubstrate(level, pos.below());
    }

    public static boolean isSubstrate(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos).is(ModTags.Blocks.SUPPORTS_PLANTS);
    }

    public static boolean onPlanter(BlockGetter level, BlockPos pos) {
        return isPlanter(level, pos.below());
    }

    public static boolean isPlanter(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos).is(ModTags.Blocks.PLANTERS);
    }

    public EntityType<?> getType(ItemStack stack) {
        CustomData customdata = (CustomData)stack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
        return !customdata.isEmpty() ? (EntityType)customdata.read(ENTITY_TYPE_FIELD_CODEC).result().orElse(this.getDefaultType()) : this.getDefaultType();
    }

    protected EntityType<?> getDefaultType() {
        return this.defaultType;
    }

    static {
        ENTITY_TYPE_FIELD_CODEC = BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("id");
    }
}
