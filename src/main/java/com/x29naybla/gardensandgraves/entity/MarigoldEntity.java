package com.x29naybla.gardensandgraves.entity;

import com.google.common.collect.Maps;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MarigoldEntity extends Plant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.flower.idle");
    protected static final RawAnimation GENERATE = RawAnimation.begin().thenLoop("animation.flower.generate");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Byte> DATA_PETALS_ID;
    private static final Map<DyeColor, Integer> COLOR_BY_DYE;
    public int rewardTime;

    private static int createMarigoldColor(DyeColor dyeColor) {
        if (dyeColor == DyeColor.WHITE) {
            return -1644826;
        } else {
            int i = dyeColor.getTextureDiffuseColor();
            float f = 0.75F;
            return FastColor.ARGB32.color(255, Mth.floor((float) FastColor.ARGB32.red(i) * 0.75F), Mth.floor((float) FastColor.ARGB32.green(i) * 0.75F), Mth.floor((float) FastColor.ARGB32.blue(i) * 0.75F));
        }
    }

    public static int getColor(DyeColor dyeColor) {
        return COLOR_BY_DYE.get(dyeColor);
    }

    public MarigoldEntity(EntityType<? extends MarigoldEntity> entityType, Level level) {
        super(entityType, level, ModItems.SEED_PACKET_MARIGOLD.toStack(), ModItems.POTTED_MARIGOLD.toStack());
        this.rewardTime = 6000;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherparent) {;
        return ModEntities.MARIGOLD.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends MarigoldEntity> PlayState animController(final AnimationState<E> event) {
        if (this.rewardTime <= 20) {
            event.setAnimation(GENERATE);
        } else {
            event.setAnimation(IDLE);
        }

        return PlayState.CONTINUE;
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_PETALS_ID, (byte)0);
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.rewardTime <= 0) {
            this.playSound(ModSounds.MONEYFALLS.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            if(this.random.nextInt(1, 4) <= 1){
                this.spawnAtLocation(Items.GOLD_NUGGET);
                if(this.random.nextInt(1, 4) <= 2){
                    this.spawnAtLocation(Items.GOLD_NUGGET);
                    if(this.random.nextInt(1, 4) <= 1){
                        this.spawnAtLocation(Items.GOLD_NUGGET);
                    }
                }
            }else{
                this.spawnAtLocation(Items.IRON_NUGGET);
                if(this.random.nextInt(1, 4) <= 2){
                    this.spawnAtLocation(Items.IRON_NUGGET);
                    if(this.random.nextInt(1, 4) <= 1){
                        this.spawnAtLocation(Items.IRON_NUGGET);
                    }
                }
            }
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.rewardTime = 6000;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getItem() instanceof DyeItem) {
            DyeColor dyeColor = ((DyeItem)itemStack.getItem()).getDyeColor();
            if (dyeColor != this.getColor()) {
                this.setColor(dyeColor);
                this.playSound(SoundEvents.DYE_USE, 1.0f, 1.0f);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        }

        return super.mobInteract(player, hand);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("RewardGenerateTime")) {
            this.rewardTime = compound.getInt("RewardGenerateTime");
        }
        this.setColor(DyeColor.byId(compound.getByte("Color")));
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("RewardGenerateTime", this.rewardTime);
        compound.putByte("Color", (byte)this.getColor().getId());
    }

    public DyeColor getColor() {
        return DyeColor.byId((Byte)this.entityData.get(DATA_PETALS_ID) & 15);
    }

    public void setColor(DyeColor dyeColor) {
        byte b0 = (Byte)this.entityData.get(DATA_PETALS_ID);
        this.entityData.set(DATA_PETALS_ID, (byte)(b0 & 240 | dyeColor.getId() & 15));
    }

    static {
        DATA_PETALS_ID = SynchedEntityData.defineId(MarigoldEntity.class, EntityDataSerializers.BYTE);
        COLOR_BY_DYE = Maps.newEnumMap((Map) Arrays.stream(DyeColor.values()).collect(Collectors.toMap((p_29868_) -> p_29868_, MarigoldEntity::createMarigoldColor)));
    }
}
