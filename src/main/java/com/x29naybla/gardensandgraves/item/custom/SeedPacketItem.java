package com.x29naybla.gardensandgraves.item.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.MarigoldEntity;
import com.x29naybla.gardensandgraves.entity.Plant;
import com.x29naybla.gardensandgraves.entity.SunShroomEntity;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
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
    public final int cooldown;

    public SeedPacketItem(EntityType<? extends Mob> defaultType, int sunAmount, int cooldown, Item.Properties properties) {
        super(properties);
        this.defaultType = defaultType;
        this.sunAmount = sunAmount;
        this.cooldown = cooldown*20;
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(this.getDisplayName().withStyle(ChatFormatting.GRAY));
    }

    public MutableComponent getDisplayName() {
        return Component.translatable("gardensandgraves.description.seed_packets_sun_cost").append(String.valueOf(this.sunAmount));
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
            }else if (onSubstrate(level, blockpos) || onPlanter(level, blockpos)){
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
                                plant.fromPlanter = true;
                                plant.onPlanter = true;
                                if (plant instanceof MarigoldEntity) ((MarigoldEntity) plant).setColor(DyeColor.byId(level.getRandom().nextIntBetweenInclusive(0, 15)));
                            }else
                                plant.fromPlanter = false;
                            if(entity instanceof SunShroomEntity) plant.setBaby(true);
                        }
                        itemStack.shrink(1);
                        context.getPlayer().getCooldowns().addCooldown(this, cooldown);
                        serverlevel.addFreshEntityWithPassengers(entity);
                        level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.PLANT.get(), SoundSource.BLOCKS, 0.75F, 0.8F);
                        entity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                    }
                    if(!((context.getPlayer().isCreative() || onPlanter(level, blockpos)))){
                        if(this.sunAmount == 0){

                        } else
                        context.getPlayer().getInventory().removeItem(context.getPlayer().getInventory().findSlotMatchingItem(ModItems.SUN.toStack()), sunAmount);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else return InteractionResult.FAIL;
            } else return InteractionResult.FAIL;
        } else return InteractionResult.FAIL;
    }

    public static boolean onSubstrate(BlockGetter level, BlockPos pos) {
        return isSubstrate(level, pos.below());
    }

    public static boolean isSubstrate(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos).is(ModTags.Blocks.SUPPORTS_PLANTS);
    }

    public boolean onPlanter(BlockGetter level, BlockPos pos) {
        return isPlanter(level, pos.below());
    }

    public boolean isPlanter(BlockGetter reader, BlockPos pos) {
        if (reader.getBlockEntity(pos) instanceof PlanterBlockEntity planter){
            if (this.getType(this.getDefaultInstance()).is(ModTags.Entities.PLANTABLE_ON_DIRT) && planter.content.getStackInSlot(0).is(Items.DIRT)) {
                return true;
            } else if (this.getType(this.getDefaultInstance()).is(ModTags.Entities.PLANTABLE_ON_MYCELIUM) && planter.content.getStackInSlot(0).is(Items.MYCELIUM)) {
                return true;
            } else if (this.getType(this.getDefaultInstance()).is(ModTags.Entities.PLANTABLE_ON_SANDS) && planter.content.getStackInSlot(0).is(Items.SAND) || planter.content.getStackInSlot(0).is(Items.RED_SAND)) {
                return true;
            } else if (this.getType(this.getDefaultInstance()).is(ModTags.Entities.PLANTABLE_ON_SOUL_SAND) && planter.content.getStackInSlot(0).is(Items.SOUL_SAND)) {
                return true;
            } else if (this.getType(this.getDefaultInstance()).is(ModTags.Entities.PLANTABLE_ON_NYLIUM) && planter.content.getStackInSlot(0).is(Items.CRIMSON_NYLIUM) || planter.content.getStackInSlot(0).is(Items.WARPED_NYLIUM)) {
                return true;
            } else if (this.getType(this.getDefaultInstance()).is(ModTags.Entities.PLANTABLE_ON_END_STONE) && planter.content.getStackInSlot(0).is(Items.END_STONE)) {
                return true;
            } else
                return false;
        } else
            return false;
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
