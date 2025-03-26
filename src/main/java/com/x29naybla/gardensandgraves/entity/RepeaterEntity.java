package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.entity.projectile.PeaProjectile;
import com.x29naybla.gardensandgraves.item.ModItems;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class RepeaterEntity extends Peashooting {
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.peashooter.idle");
    protected static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("animation.peashooter.shoot");
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public RepeaterEntity(EntityType<? extends RepeaterEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        return ModItems.SEED_PACKET_REPEATER.toStack();
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherparent) {;
        return ModEntities.REPEATER.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::animController));
    }

    protected <E extends RepeaterEntity> PlayState animController(final AnimationState<E> event) {
        if(this.isShooting()){
            event.setAnimation(SHOOT);
            return PlayState.CONTINUE;

        }else
            event.setAnimation(IDLE);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        PeaProjectile pea = new PeaProjectile(this.level(), this);
        double d0 = target.getEyeY() - (double)1.1F;
        double d1 = target.getX() - this.getX();
        double d2 = d0 - pea.getY();
        double d3 = target.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        pea.shoot(d1, d2 + d4, d3, 1.6F, 3.0F);
        this.playSound(ModSounds.THROW.get(), 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(pea);
    }
}
