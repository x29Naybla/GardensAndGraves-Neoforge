package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.item.ModItems;
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
    public int packetTime;
    public boolean fromPlanter = false;

    public Plant(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
        this.packetTime = 12000;
    }

    public boolean fromPlanter(boolean planter){
        return fromPlanter = planter;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(player.getItemInHand(hand).getItem().getDefaultInstance().is(ItemTags.SHOVELS)){
            packUp(player);
            player.getItemInHand(hand).hurtAndBreak(1, player, getSlotForHand(hand));
            level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY()+0.5, this.getZ(), 0, 0, 0);
            level().addParticle(ParticleTypes.CLOUD, this.getX(), this.getY()+0.5, this.getZ(), 0, 0, 0);
        }
        if((player.getItemInHand(hand).getItem() == this.getPickResult().getItem()) && this.getHealth() < this.getMaxHealth()){
            this.setHealth(this.getMaxHealth());
            playSound(ModSounds.PLANT.get());
            if (!player.isCreative()) player.getItemInHand(hand).shrink(1);
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
        if(fromPlanter){
            if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.packetTime <= 0) {
                this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.spawnAtLocation(this.getPickResult().getItem());
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

    public void packUp(Player player){
        ItemStack output = this.getPickResult();
        saveDefaultDataToItemTag(this, output);
        playSound(SoundEvents.SHOVEL_FLATTEN);

        this.discard();
        spawnAtLocation(output);
    }

    private static void saveDefaultDataToItemTag(Plant plant, ItemStack itemStack) {
        if (plant.hasCustomName()) itemStack.set(DataComponents.CUSTOM_NAME, plant.getCustomName());
    }
}
