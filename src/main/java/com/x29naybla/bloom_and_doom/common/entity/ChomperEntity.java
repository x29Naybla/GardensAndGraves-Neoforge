package com.x29naybla.bloom_and_doom.common.entity;

import com.x29naybla.bloom_and_doom.common.entity.goal.PlantChompGoal;
import com.x29naybla.bloom_and_doom.common.registry.ModDataAttachments;
import com.x29naybla.bloom_and_doom.common.registry.ModItems;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ChomperEntity extends Plant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.chomper.idle");
    protected static final RawAnimation CHOMP = RawAnimation.begin().thenPlay("animation.chomper.chomp").thenPlayXTimes("animation.chomper.chew", 22);
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    protected static final EntityDataAccessor<Boolean> CHEWING = SynchedEntityData.defineId(ChomperEntity.class, EntityDataSerializers.BOOLEAN);
    public int chewingTime = 0;
    public int maxChewingTime = 350;

    //Properties
    public ChomperEntity(EntityType<? extends Plant> entityType, Level level) {
        super(entityType, level, ModTags.Items.SUSTAINS_CHOMPERS, ModItems.CHOMPER_SEED_PACKET.toStack(), null);
    }

    //Goals and AI
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new PlantChompGoal(this));
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false,
                (target) -> target instanceof LivingEntity livingEntity && (livingEntity.getType().is(ModTags.Entities.PLANT_ENEMIES) || livingEntity.getData(ModDataAttachments.ZOMBIE))));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        if(this.isAlive()) {
            if(getChewing()) {
               chewingTime += 1;
            }
            if(chewingTime < 0) chewingTime = 0;

            if(chewingTime >= maxChewingTime) {
                setChewing(false);
                chewingTime = 0;
            }
        }
        super.tick();
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends ChomperEntity> PlayState animController(final AnimationState<E> event) {
        if(this.getChewing()){
            event.setAnimation(CHOMP);
            return PlayState.CONTINUE;

        }else
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
        builder.define(CHEWING, false);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        getEntityData().set(CHEWING, compound.getBoolean("Chewing"));
        if (compound.contains("ChewingTime")) {
            this.chewingTime = compound.getInt("ChewingTime");
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Chewing", getEntityData().get(CHEWING));
        compound.putInt("ChewingTime", this.chewingTime);
    }

    public boolean getChewing(){
        return getEntityData().get(CHEWING);
    }

    public void setChewing(boolean bool) {
        getEntityData().set(CHEWING, bool);
    }

    public void performChompAttack(LivingEntity target) {
        target.remove(RemovalReason.KILLED);
    }
}
