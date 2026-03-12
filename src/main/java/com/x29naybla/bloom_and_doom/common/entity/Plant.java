package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.CommonConfigs;
import com.x29naybla.bloom_and_doom.common.block.entity.PlanterBlockEntity;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import com.x29naybla.bloom_and_doom.common.registry.BnDDataComponents;
import com.x29naybla.bloom_and_doom.common.tag.CommonTags;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import com.x29naybla.bloom_and_doom.common.item.SeedPacketItem;
import com.x29naybla.bloom_and_doom.common.registry.BnDParticles;
import com.x29naybla.bloom_and_doom.common.registry.BnDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

import java.util.List;

public class Plant extends TamableAnimal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> DATA_IS_SLEEPING = SynchedEntityData.defineId(Plant.class, EntityDataSerializers.BOOLEAN);
    protected int ticksForSleepyParticles;
    public TagKey<Item> substrate;
    public int packetTime;
    public boolean fromPlanter;
    public boolean onPlanter;
    @Nullable
    public ItemStack seedPacket;
    @Nullable
    public ItemStack pottedItem;
    public boolean isMushroom;
    public boolean gotCoffee;
    private final boolean fromDay;
    private final boolean fromNight;

    //Properties
    public Plant(EntityType<? extends Plant> entityType, Level level, TagKey<Item> substrate, @Nullable ItemStack seedPacket, @Nullable ItemStack pottedItem) {
        super(entityType, level);
        this.packetTime = 12000;
        this.fromPlanter = false;
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
        this.isMushroom = false;
        this.gotCoffee = false;
        this.ticksForSleepyParticles = 40;

        this.fromDay = this.level().isDay();
        this.fromNight = this.level().isNight();

        this.substrate = substrate;
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return this.seedPacket;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return null;
    }

    public boolean canBeLeashed() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(@NotNull Entity entity) {
    }

    @Override
    public boolean isFood(@NotNull ItemStack itemStack) {
        return false;
    }

    //Goals and AI
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
        ItemStack playerHand = player.getItemInHand(InteractionHand.MAIN_HAND);

        if(playerHand.getItem().getDefaultInstance().is(ItemTags.SHOVELS)){

            expire(SoundEvents.SHOVEL_FLATTEN);

            if(!player.isCreative()) {
                player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, getSlotForHand(InteractionHand.MAIN_HAND));
            }

            return InteractionResult.SUCCESS;
        } else if (seedPacket != null && (playerHand.getItem() == this.seedPacket.getItem()) && this.getHealth() < this.getMaxHealth() && !player.getCooldowns().isOnCooldown(this.seedPacket.getItem()) && (player.getInventory().countItem(BnDItems.SUN.get()) >= ((SeedPacketItem) this.seedPacket.getItem()).getSunAmount() || player.isCreative())) {
            SeedPacketItem seedPacket = (SeedPacketItem) this.seedPacket.getItem();
            this.setHealth(this.getMaxHealth());
            playSound(BnDSounds.SEED_PACKET_HEAL.get());
            player.getCooldowns().addCooldown(seedPacket, seedPacket.cooldown);
            if (!player.isCreative()) {
                player.getItemInHand(hand).shrink(1);
                player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(BnDItems.SUN.toStack()), seedPacket.getSunAmount());
            }
            return InteractionResult.SUCCESS;
        } else if(playerHand.is(CommonTags.Items.FLOWER_POTS) && this.fromPlanter && this.pottedItem != null) {
            saveDefaultDataToItemTag(this, this.pottedItem);
            this.pottedItem.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(playerHand.copyWithCount(1))));

            if (!player.isCreative()) playerHand.shrink(1);
            if (!player.getInventory().add(this.pottedItem)) {
                ItemEntity itemEntity = new ItemEntity(level(), this.getX(), this.getY() + 0.5, this.getZ(), this.pottedItem);
                itemEntity.setPickUpDelay(0);
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().multiply(0, 0.5, 0));
                this.level().addFreshEntity(itemEntity);
            }
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            player.getInventory().add(this.pottedItem);

            playSound(SoundEvents.ROOTED_DIRT_PLACE);
            this.discard();
            if (!level().isClientSide && level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.POOF, this.getX(), this.getY() + 0.5,
                        this.getZ(), 2, 0, 0, 0, 0);
            }
            return InteractionResult.SUCCESS;
        } else if(playerHand.isEmpty() && this.fromPlanter && this.level().getBlockState(this.getOnPos()).is(CommonTags.Blocks.FLOWER_POTS)) {
            saveDefaultDataToItemTag(this, this.pottedItem);
            this.pottedItem.set(DataComponents.BUNDLE_CONTENTS, new BundleContents(List.of(this.level().getBlockState(this.getOnPos()).getBlock().asItem().getDefaultInstance())));

            if (!player.getInventory().add(this.pottedItem)) {
                ItemEntity itemEntity = new ItemEntity(level(), this.getX(), this.getY() + 0.5, this.getZ(), this.pottedItem);
                itemEntity.setPickUpDelay(0);
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().multiply(0, 0.5, 0));
                this.level().addFreshEntity(itemEntity);
            }
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            player.getInventory().add(this.pottedItem);

            playSound(SoundEvents.ROOTED_DIRT_PLACE);
            this.discard();
            if (!level().isClientSide && level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.POOF, this.getX(), this.getY() + 0.5,
                        this.getZ(), 2, 0, 0, 0, 0);
            }
            this.level().removeBlock(this.getOnPos(), false);
            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {
            this.onPlanter = (this.level().getBlockEntity(this.blockPosition().below()) instanceof PlanterBlockEntity planter && planter.content.getStackInSlot(0).is(this.substrate));

            if(this.fromPlanter && onPlanter) {
                if (this.isAlive() && !this.isBaby() && --this.packetTime <= 0) {
                    this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                    this.spawnAtLocation(this.seedPacket);
                    this.gameEvent(GameEvent.ENTITY_PLACE);
                    this.packetTime = 12000;
                }
            }

            if (this.isAlive() && this.isBaby()) {
                int i = this.getAge();
                if (!onPlanter) this.setAge(--i);
            }

            if (!fromPlanter) {
                if (CommonConfigs.PLANTS_LIFESPAN.get()) {
                    if (fromDay && this.level().isNight()) {
                        expire(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
                    }

                    if (fromNight && this.level().isDay()) {
                        expire(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
                    }
                }
            }

            if(this.level().getBlockState(this.getOnPos()).is(Blocks.AIR) ||
                    this.level().getBlockState(this.getOnPos()).is(Blocks.CAVE_AIR) ||
                    this.level().getBlockState(this.getOnPos()).is(Blocks.VOID_AIR)) {
                this.expire(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
            }

            if (this.isMushroom) {
                setSleeping(!this.level().isNight()
                        && !this.gotCoffee
                        && !this.level().getBlockState(this.getOnPos()).is(BlockTags.MUSHROOM_GROW_BLOCK)
                        && (!(this.level().getBlockEntity(this.getOnPos()) instanceof PlanterBlockEntity planterBlock) || !planterBlock.content.getStackInSlot(0).is(BnDTags.Items.SUSTAINS_MUSHROOMS)));
            }

            if (this instanceof SunflowerEntity) {
                setSleeping((this.level().isNight() || this.level().isRaining())
                        && !this.gotCoffee);
            }

            if (getSleeping()) {
                --this.ticksForSleepyParticles;
                if (this.ticksForSleepyParticles <= 0) {
                    ((ServerLevel) level()).sendParticles(BnDParticles.SLEEPING_PARTICLES.get(), this.getX(), this.getY() + this.getEyeHeight() + 0.3,
                            this.getZ(), 1, 0, 0, 0, 0.0004);
                    this.ticksForSleepyParticles = 40;
                }
                this.setNoAi(true);
            } else {
                this.setNoAi(false);
            }
        }
    }

    public boolean onRightSubstrate(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos.below()).is(BnDTags.Blocks.SUPPORTS_PLANTS) ||
                (reader.getBlockEntity(pos.below()) instanceof PlanterBlockEntity planter && planter.content.getStackInSlot(0).is(this.substrate));
    }

    public void ageUp(int amount, boolean forced){
        playSound(BnDSounds.PLANT_GROW.get());
    }

    public void expire(SoundEvent sound){
        if (this.seedPacket != null) this.spawnAtLocation(this.seedPacket);
        playSound(sound);
        this.discard();
        if (!level().isClientSide && level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.POOF, this.getX(), this.getY() + 0.5,
                    this.getZ(), 2, 0, 0, 0, 0);
        }
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }

    //Data
    @Override
    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }

    public boolean getSleeping() {
        return this.entityData.get(DATA_IS_SLEEPING);
    }

    public void setSleeping(boolean isSleeping) {
        this.entityData.set(DATA_IS_SLEEPING, isSleeping);
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_IS_SLEEPING, false);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("FromPlanter")) {
            this.fromPlanter = compound.getBoolean("FromPlanter");
        }
        if (compound.contains("IsSleeping")) {
            setSleeping(compound.getBoolean("IsSleeping"));
        }
        if (compound.contains("PacketTime")) {
            this.packetTime = compound.getInt("PacketTime");
        }

    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromPlanter", this.fromPlanter);
        compound.putBoolean("IsSleeping", getSleeping());
        compound.putInt("PacketTime", this.packetTime);
    }

    private static void saveDefaultDataToItemTag(Plant plant, ItemStack itemStack) {
        if (plant.hasCustomName()) itemStack.set(DataComponents.CUSTOM_NAME, plant.getCustomName());
        if (plant instanceof MarigoldEntity marigold) itemStack.set(DataComponents.BASE_COLOR, marigold.getColor());
        if (plant.isBaby()) itemStack.set(BnDDataComponents.AGE, plant.getAge());
        itemStack.set(BnDDataComponents.HEALTH, plant.getHealth());
    }
}
