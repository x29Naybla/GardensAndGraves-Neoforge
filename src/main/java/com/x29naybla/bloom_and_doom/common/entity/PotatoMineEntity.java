package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PotatoMineEntity extends ExplosivePlant {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    protected static final RawAnimation ARMING = RawAnimation.begin().thenPlay("animation.potato_mine.arming");
    protected static final EntityDataAccessor<Boolean> ARMED = SynchedEntityData.defineId(PotatoMineEntity.class, EntityDataSerializers.BOOLEAN);
    public int armingTime = 0;
    public int maxArmingTime = 40;

    //Properties
    public PotatoMineEntity(EntityType<? extends PotatoMineEntity> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_POTATO_MINES, ModItems.SEED_PACKET_POTATO_MINE.toStack(), ModItems.POTTED_POTATO_MINE.toStack(), 1, 180, ModSounds.SPUDOW);
    }

    //Goals and AI
    public void tick() {
        if(this.isAlive()){
            if (!getArmed()){
                this.armingTime += 1;
            }

            if (this.armingTime < 0) this.armingTime = 0;

            if (getArmed() || this.armingTime >= maxArmingTime){
                this.armingTime = maxArmingTime;
                setArmed(true);
            }
        }
        super.tick();
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends PotatoMineEntity> PlayState animController(final AnimationState<E> event) {
        if (!getArmed()){
            event.setAnimation(ARMING);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    //Data
    public boolean getArmed(){
        return this.entityData.get(ARMED);
    }

    public void setArmed(boolean bool) {
        this.entityData.set(ARMED, bool);
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ARMED, false);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setArmed(compound.getBoolean("Armed"));
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Armed", getArmed());
    }
}
