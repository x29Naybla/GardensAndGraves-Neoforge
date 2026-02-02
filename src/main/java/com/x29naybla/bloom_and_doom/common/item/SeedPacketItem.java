package com.x29naybla.bloom_and_doom.common.item;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.MarigoldEntity;
import com.x29naybla.bloom_and_doom.common.entity.Plant;
import com.x29naybla.bloom_and_doom.common.entity.SunShroomEntity;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SeedPacketItem extends PlantHolderItem {
    private final int sunAmount;
    public final int cooldown;

    public SeedPacketItem(EntityType<? extends Mob> defaultType, int sunAmount, int cooldown, Properties properties) {
        super(properties);
        this.defaultType = defaultType;
        this.sunAmount = sunAmount;
        this.cooldown = cooldown*20;
    }

    public int getSunAmount() {
        return this.sunAmount;
    }

    public @NotNull String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(BloomAndDoom.MOD_ID+".description.seed_packets_sun_cost").append(String.valueOf(this.sunAmount));
    }

    public @NotNull InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        ItemStack stack = context.getItemInHand();

        if (context.getPlayer() != null) {
            if ((context.getPlayer().getInventory().countItem(ModItems.SUN.get()) >= sunAmount) || context.getPlayer().isCreative() || onPlanter(level, blockpos)){
                Direction direction = context.getClickedFace();
                if (direction == Direction.DOWN) {
                    return InteractionResult.FAIL;
                }else if (onSubstrate(level, blockpos) || onPlanter(level, blockpos)){
                    ItemStack itemStack = context.getItemInHand();
                    Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
                    AABB aabb = this.getType(itemStack).getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
                    if(level.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()){
                        if(level instanceof ServerLevel serverLevel){
                            Entity entity = this.getType(itemStack).create(serverLevel, EntityType.createDefaultStackConfig(serverLevel, itemStack, context.getPlayer()), blockpos, MobSpawnType.SPAWN_EGG, false, false);
                            if (entity == null) {
                                return InteractionResult.FAIL;
                            }
                            float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation()) + 22.5F) / 45.0F) * 45.0F;
                            entity.moveTo(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                            entity.setYRot(f);
                            entity.setXRot(0);
                            if(entity instanceof Plant plant){
                                if (plant.onRightSubstrate(level, blockpos)) {
                                    if (stack.has(DataComponents.CUSTOM_NAME)) plant.setCustomName(stack.getHoverName());
                                    if(onPlanter(level, blockpos)){
                                        if(entity instanceof SunShroomEntity) plant.setAge(-28800);
                                        else
                                            plant.setBaby(true);
                                        plant.fromPlanter = true;
                                        plant.onPlanter = true;
                                        if (plant instanceof MarigoldEntity) ((MarigoldEntity) plant).setColor(DyeColor.byId(level.getRandom().nextIntBetweenInclusive(0, 15)));
                                    }else {
                                        plant.fromPlanter = false;
                                        if(entity instanceof SunShroomEntity) plant.setAge(-4800);
                                    }
                                } else
                                    return InteractionResult.FAIL;
                            }
                            itemStack.shrink(1);
                            context.getPlayer().getCooldowns().addCooldown(this, cooldown);
                            serverLevel.addFreshEntityWithPassengers(entity);
                            level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.SEED_PACKER_PLANT.get(), SoundSource.BLOCKS, 0.75F, 0.8F);
                            entity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                        }
                        if(!((context.getPlayer().isCreative() || onPlanter(level, blockpos)))){
                            if(!(this.sunAmount == 0)) {
                                context.getPlayer().getInventory().removeItem(context.getPlayer().getInventory().findSlotMatchingItem(ModItems.SUN.toStack()), sunAmount);
                            }
                        }
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    } else return InteractionResult.FAIL;
                } else {
                    context.getPlayer().displayClientMessage(Component.translatable("item.bloom_and_doom.seed_packet.bad_substrate"), true);
                    return InteractionResult.FAIL;
                }
            } else if (!context.getPlayer().isCreative() && (context.getPlayer().getInventory().countItem(ModItems.SUN.get()) < sunAmount)) {
                context.getPlayer().displayClientMessage(Component.translatable("item.bloom_and_doom.seed_packet.not_enough_sun"), true);
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.FAIL;
    }
}
