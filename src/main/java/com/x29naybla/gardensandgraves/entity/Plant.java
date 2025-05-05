package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import com.x29naybla.gardensandgraves.item.custom.SeedPacketItem;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

public class Plant extends TamableAnimal implements GeoEntity {
    public int packetTime;
    public boolean fromPlanter;
    public boolean onPlanter;
    public ItemStack seedPacket;
    @Nullable
    public ItemStack pottedItem;

    public Plant(EntityType<? extends TamableAnimal> entityType, Level level, ItemStack seedPacket, @Nullable ItemStack pottedItem) {
        super(entityType, level);
        this.packetTime = 12000;
        this.fromPlanter = false;
        this.onPlanter = level.getBlockEntity(this.getOnPos()) instanceof PlanterBlockEntity;
        this.seedPacket = seedPacket;
        this.pottedItem = pottedItem;
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return this.seedPacket;
    }

    public boolean fromPlanter(boolean planter){
        return fromPlanter = planter;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        SeedPacketItem item = (SeedPacketItem) this.seedPacket.getItem();

        if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem().getDefaultInstance().is(ItemTags.SHOVELS)){
            packUp(player, this.seedPacket);
            playSound(SoundEvents.SHOVEL_FLATTEN);
            this.discard();
            level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY()+0.5, this.getZ(), 0, 0, 0);
            level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY()+0.5, this.getZ(), 0, 0, 0);
        }
        if((player.getItemInHand(hand).getItem() == this.getPickResult().getItem()) && this.getHealth() < this.getMaxHealth() && !player.getCooldowns().isOnCooldown(item)){
            this.setHealth(this.getMaxHealth());
            playSound(ModSounds.PLANT.get());
            player.getCooldowns().addCooldown(this.getPickResult().getItem(), item.cooldown);
            if (!player.isCreative()) {
                player.getItemInHand(hand).shrink(1);
            }
        }
        if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem().getDefaultInstance().is(Items.FLOWER_POT) && this.fromPlanter && this.pottedItem != null) {
            packUp(player, this.pottedItem);
            this.discard();
            level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY()+0.5, this.getZ(), 0, 0, 0);
            level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY()+0.5, this.getZ(), 0, 0, 0);
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
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

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
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
        }
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("FromPlanter")) {
            this.fromPlanter = compound.getBoolean("FromPlanter");
        }
        if (compound.contains("PacketTime")) {
            this.packetTime = compound.getInt("PacketTime");
        }

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromPlanter", this.fromPlanter);
        compound.putInt("PacketTime", this.packetTime);
    }

    public void packUp(Player player, ItemStack stack){
        ItemStack output = stack;
        saveDefaultDataToItemTag(this, output);

        if(player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.FLOWER_POT)){

            if(player.getItemInHand(InteractionHand.MAIN_HAND).getCount() == 1) {
                player.setItemInHand(InteractionHand.MAIN_HAND, output);
            } else if(player.getInventory().hasAnyMatching(ItemStack::isEmpty)) {
                player.addItem(output);
                player.getItemInHand(InteractionHand.MAIN_HAND).shrink(1);
            } else
                spawnAtLocation(output);
        } else {

            if(player.getInventory().hasAnyMatching(ItemStack::isEmpty)) {
                player.addItem(output);
            } else
                spawnAtLocation(output);

            if(!player.isCreative()) {
                player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, getSlotForHand(InteractionHand.MAIN_HAND));
            }
        }
    }

    private static void saveDefaultDataToItemTag(Plant plant, ItemStack itemStack) {
        if (plant.hasCustomName()) itemStack.set(DataComponents.CUSTOM_NAME, plant.getCustomName());
    }
}
