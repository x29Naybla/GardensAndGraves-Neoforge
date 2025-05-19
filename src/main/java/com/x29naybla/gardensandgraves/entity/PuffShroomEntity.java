package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.entity.projectile.SporeProjectile;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PuffShroomEntity extends ShootingPlant {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.peashooter.idle");
    protected static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("animation.peashooter.shoot");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);
    public boolean isShooting = false;

    //Properties
    public PuffShroomEntity(EntityType<? extends PuffShroomEntity> entityType, Level level) {
        super(entityType, level, ModItems.SEED_PACKET_PUFF_SHROOM.toStack(), ModItems.POTTED_PUFF_SHROOM.toStack());
        this.mushroom = true;
    }

    //Goals and AI
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        SporeProjectile spore = new SporeProjectile(this.level(), this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - spore.getY();
        double d3 = target.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        spore.shoot(d1, d2 + d4, d3, 1.6F, 3.0F);
        this.playSound(ModSounds.THROW.get(), 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(spore);
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends PuffShroomEntity> PlayState animController(final AnimationState<E> event) {
        if(isShooting){
            event.setAnimation(SHOOT);
        }else
            event.setAnimation(IDLE);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}
