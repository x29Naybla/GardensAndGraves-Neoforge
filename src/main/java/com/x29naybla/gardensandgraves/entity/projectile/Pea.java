package com.x29naybla.gardensandgraves.entity.projectile;

import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Pea extends ThrowableItemProjectile {
    public Boolean shouldBreak = false;

    public Pea(EntityType<? extends Pea> entityType, Level level) {
        super(entityType, level);
    }

    public Pea(Level level, LivingEntity shooter) {
        super(ModEntities.PEA.get(), shooter, level);
    }

    public Pea(Level level, double x, double y, double z) {
        super(ModEntities.PEA.get(), x, y, z, level);
    }

    protected Item getDefaultItem() {
        return ModItems.PEA.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItem();
        return (ParticleOptions)(!itemstack.isEmpty() && !itemstack.is(this.getDefaultItem()) ? new ItemParticleOption(ParticleTypes.ITEM, itemstack) : ParticleTypes.ITEM_SNOWBALL);
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
            shouldBreak = true;
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide && shouldBreak == true) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
        shouldBreak = true;
    }
}
