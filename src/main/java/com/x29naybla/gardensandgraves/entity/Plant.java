package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import com.x29naybla.gardensandgraves.data.ModDataComponents;
import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.item.custom.SeedPacketItem;
import com.x29naybla.gardensandgraves.particle.ModParticles;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

public class Plant extends TamableAnimal implements GeoEntity {
    protected int ticksForSleepyParticles;
    public int packetTime;
    public boolean fromPlanter;
    public boolean onPlanter;
    public ItemStack seedPacket;
    @Nullable
    public ItemStack pottedItem;
    public boolean mushroom;
    public boolean isSleeping;
    public boolean gotCoffee;
    private boolean fromDay;
    private boolean fromNight;

    //Properties
    public Plant(EntityType<? extends Plant> entityType, Level level, ItemStack seedPacket, @Nullable ItemStack pottedItem) {
        super(entityType, level);
        this.packetTime = 12000;
        this.fromPlanter = false;
        this.onPlanter = level.getBlockEntity(this.getOnPos()) instanceof PlanterBlockEntity;
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
        this.mushroom = false;
        this.isSleeping = false;
        this.gotCoffee = false;
        this.ticksForSleepyParticles = 40;

        this.fromDay = this.level().isDay();
        this.fromNight = this.level().isNight();
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return this.seedPacket;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
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
    protected void doPush(Entity entity) {
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    //Goals and AI
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem().getDefaultInstance().is(ItemTags.SHOVELS)){

            expire(SoundEvents.SHOVEL_FLATTEN);

            if(!player.isCreative()) {
                player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, getSlotForHand(InteractionHand.MAIN_HAND));
            }

            return InteractionResult.SUCCESS;
        } else if((player.getItemInHand(hand).getItem() == this.seedPacket.getItem()) && this.getHealth() < this.getMaxHealth() && !player.getCooldowns().isOnCooldown(this.seedPacket.getItem())){
            this.setHealth(this.getMaxHealth());
            playSound(ModSounds.SEED_PACKET_HEAL.get());
            player.getCooldowns().addCooldown(this.seedPacket.getItem(), ((SeedPacketItem) this.seedPacket.getItem()).cooldown);
            if (!player.isCreative()) {
                player.getItemInHand(hand).shrink(1);
            }
            return InteractionResult.SUCCESS;
        } else if(player.getItemInHand(InteractionHand.MAIN_HAND).is(ModTags.Items.FLOWER_POTS) && this.fromPlanter && this.pottedItem != null) {
            saveDefaultDataToItemTag(this, this.pottedItem);

            if (!player.isCreative()) player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
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
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if(fromPlanter && onPlanter){
            if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.packetTime <= 0) {
                this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.spawnAtLocation(this.seedPacket);
                this.gameEvent(GameEvent.ENTITY_PLACE);
                this.packetTime = 12000;
            }
        } else if (!fromPlanter) {
            if (fromDay && this.level().isNight()) {
                expire(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
            }

            if (fromNight && this.level().isDay()) {
                expire(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
            }
        }

        if (!this.level().isClientSide) {
            if (this.mushroom) {
                if (this.level().isNight()
                        || this.gotCoffee
                        || this.level().getBlockState(this.getOnPos()).is(BlockTags.MUSHROOM_GROW_BLOCK)
                        || (this.level().getBlockEntity(this.getOnPos()) instanceof PlanterBlockEntity planterBlock && planterBlock.content.getStackInSlot(0).is(ModTags.Items.SUSTAINS_MUSHROOMS))) {
                    this.isSleeping = false;
                } else {
                    this.isSleeping = true;
                }
            } else {
                this.isSleeping = false;
            }

            if (this.isSleeping) {
                --this.ticksForSleepyParticles;
                if (this.ticksForSleepyParticles <= 0) {
                    ((ServerLevel) level()).sendParticles(ModParticles.SLEEPING_PARTICLES.get(), this.getX(), this.getY() + this.getEyeHeight() + 0.3,
                            this.getZ(), 1, 0, 0, 0, 0.0004);
                    this.ticksForSleepyParticles = 40;
                }
                this.setNoAi(true);
            } else {
                this.setNoAi(false);
            }
         }
    }

    public void ageUp(int amount, boolean forced){
        playSound(ModSounds.PLANT_GROW.get());
    }

    public void expire(SoundEvent sound){
        this.spawnAtLocation(this.seedPacket);
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

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("FromPlanter")) {
            this.fromPlanter = compound.getBoolean("FromPlanter");
        }
        if (compound.contains("IsSleeping")) {
            this.isSleeping = compound.getBoolean("IsSleeping");
        }
        if (compound.contains("PacketTime")) {
            this.packetTime = compound.getInt("PacketTime");
        }

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromPlanter", this.fromPlanter);
        compound.putBoolean("IsSleeping", this.isSleeping);
        compound.putInt("PacketTime", this.packetTime);
    }

    private static void saveDefaultDataToItemTag(Plant plant, ItemStack itemStack) {
        if (plant.hasCustomName()) itemStack.set(DataComponents.CUSTOM_NAME, plant.getCustomName());
        if (plant instanceof MarigoldEntity) itemStack.set(DataComponents.BASE_COLOR, MarigoldEntity.dyedColor);
        if (plant.isBaby()) itemStack.set(ModDataComponents.AGE, plant.getAge());
        itemStack.set(ModDataComponents.HEALTH, plant.getHealth());
    }
}
