package com.x29naybla.gardensandgraves.entity.projectile;

import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class FrozenPeaProjectile extends ThrowableItemProjectile {
    public Boolean shouldBreak = false;

    public FrozenPeaProjectile(EntityType<? extends FrozenPeaProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public FrozenPeaProjectile(Level level, LivingEntity shooter) {
        super(ModEntities.FROZEN_PEA_PROJECTILE.get(), shooter, level);
    }

    public FrozenPeaProjectile(Level level, double x, double y, double z) {
        super(ModEntities.FROZEN_PEA_PROJECTILE.get(), x, y, z, level);
    }

    protected Item getDefaultItem() {
        return ModItems.FROZEN_PEA.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItem();
        return (ParticleOptions)(!itemstack.isEmpty() && !itemstack.is(this.getDefaultItem()) ? new ItemParticleOption(ParticleTypes.ITEM, itemstack) : new ItemParticleOption(ParticleTypes.ITEM, ModItems.FROZEN_PEA.toStack()));
    }

    public void handleEntityEvent(byte id) {
        if (id == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F, 0.0F);
            }
        }

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (!(entity.getType().is(ModTags.Entities.PLANTS))){
            entity.hurt(this.damageSources().thrown(this, this.getOwner()), 2);
            entity.extinguishFire();
            entity.setTicksFrozen(140);
            entity.isFullyFrozen();
            this.level().broadcastEntityEvent(this, (byte)3);
            shouldBreak = true;
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide && shouldBreak == true) {
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result){
        this.level().broadcastEntityEvent(this, (byte)3);
    }
}
