package com.x29naybla.bloom_and_doom.common.entity.projectile;

import com.x29naybla.bloom_and_doom.common.registry.ModDataAttachments;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import com.x29naybla.bloom_and_doom.common.registry.ModSounds;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public abstract class PlantProjectile extends ThrowableItemProjectile {
    public Boolean shouldBreak = false;

    public PlantProjectile(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public PlantProjectile(EntityType<? extends ThrowableItemProjectile> entityType, double x, double y, double z, Level level) {
        super(entityType, x, y, z, level);
    }

    public PlantProjectile(EntityType<? extends ThrowableItemProjectile> entityType, LivingEntity shooter, Level level) {
        super(entityType, shooter, level);
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItem();
        return (!itemstack.isEmpty() && !itemstack.is(this.getDefaultItem()) ? new ItemParticleOption(ParticleTypes.ITEM, itemstack) : new ItemParticleOption(ParticleTypes.ITEM, getDefaultItem().getDefaultInstance()));
    }

    public void handleEntityEvent(byte id) {
        if (id == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F, 0.0F);
            }
        }

    }

    protected abstract ResourceKey<DamageType> setDamageType();

    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (!(entity.getType().is(ModTags.Entities.PLANT_ALLAYS) || entity instanceof Player player && !player.getData(ModDataAttachments.ZOMBIE))){
            entity.hurt(this.damageSources().source(setDamageType(), this, this.getOwner()), 4);
            this.level().broadcastEntityEvent(this, (byte)3);
            shouldBreak = true;
        }
    }

    protected void onHit(@NotNull HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide && shouldBreak == true) {
            playSound(ModSounds.SPLAT.get(), 0.25F, 1 / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result){
        this.level().broadcastEntityEvent(this, (byte)3);
    }
}
