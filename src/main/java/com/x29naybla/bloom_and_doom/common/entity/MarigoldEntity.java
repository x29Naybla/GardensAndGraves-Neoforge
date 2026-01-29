package com.x29naybla.bloom_and_doom.common.entity;

import com.google.common.collect.Maps;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.entity.goal.MarigoldGenerateGoal;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MarigoldEntity extends Plant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.flower.idle");
    protected static final RawAnimation GENERATE = RawAnimation.begin().thenPlayAndHold("animation.flower.generate");
    protected static final EntityDataAccessor<Boolean> GENERATED = SynchedEntityData.defineId(MarigoldEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Byte> DATA_PETALS_ID = SynchedEntityData.defineId(MarigoldEntity.class, EntityDataSerializers.BYTE);
    private static final Map<DyeColor, Integer> COLOR_BY_DYE = Maps.<DyeColor, Integer>newEnumMap(Arrays.stream(DyeColor.values()).collect(Collectors.toMap((p_29868_) -> p_29868_, MarigoldEntity::createMarigoldColor)));
    public int rewardTime;
    public static DyeColor dyedColor;

    //Properties
    public MarigoldEntity(EntityType<? extends MarigoldEntity> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_MARIGOLDS, ModItems.MARIGOLD_SEED_PACKET.toStack(), ModItems.POTTED_MARIGOLD.toStack());
        this.rewardTime = 6000;
    }

    private static int createMarigoldColor(DyeColor dyeColor) {
        if (dyeColor == DyeColor.WHITE) {
            return -1644826;
        } else {
            int i = dyeColor.getTextureDiffuseColor();
            float f = 0.75F;
            return FastColor.ARGB32.color(
                    255,
                    Mth.floor((float) FastColor.ARGB32.red(i) * f),
                    Mth.floor((float) FastColor.ARGB32.green(i) * f),
                    Mth.floor((float) FastColor.ARGB32.blue(i) * f));
        }
    }

    public static int getColor(DyeColor dyeColor) {
        return COLOR_BY_DYE.get(dyeColor);
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new MarigoldGenerateGoal(this));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
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

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends MarigoldEntity> PlayState animController(final AnimationState<E> event) {
        if (this.isGenerated()) {
            event.setAnimation(GENERATE);

            return PlayState.CONTINUE;
        }
        event.setAnimation(IDLE);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    //Data
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GENERATED, false);
        builder.define(DATA_PETALS_ID, (byte)0);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("RewardGenerateTime")) {
            this.rewardTime = compound.getInt("RewardGenerateTime");
        }
        getEntityData().set(GENERATED, compound.getBoolean("Generated"));
        this.setColor(DyeColor.byId(compound.getByte("Color")));
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("RewardGenerateTime", this.rewardTime);
        compound.putBoolean("Generated", getEntityData().get(GENERATED));
        compound.putByte("Color", (byte)this.getColor().getId());
    }

    public boolean isGenerated(){
        return getEntityData().get(GENERATED);
    }

    public void setGenerated(boolean bool) {
        getEntityData().set(GENERATED, bool);
    }

    public DyeColor getColor() {
        return DyeColor.byId(this.entityData.get(DATA_PETALS_ID) & 15);
    }

    public void setColor(DyeColor dyeColor) {
        byte b0 = this.entityData.get(DATA_PETALS_ID);
        this.entityData.set(DATA_PETALS_ID, (byte)(b0 & 240 | dyeColor.getId() & 15));
        dyedColor = dyeColor;
    }
}
