package com.x29naybla.bloom_and_doom.entity.projectile;

import com.x29naybla.bloom_and_doom.data.ModDamageTypes;
import com.x29naybla.bloom_and_doom.data.ModDataAttachments;
import com.x29naybla.bloom_and_doom.data.ModTags;
import com.x29naybla.bloom_and_doom.entity.ModEntities;
import com.x29naybla.bloom_and_doom.item.ModItems;
import com.x29naybla.bloom_and_doom.sound.ModSounds;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class SporeProjectile extends ThrowableItemProjectile {
    public Boolean shouldBreak = false;

    public SporeProjectile(EntityType<? extends SporeProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public SporeProjectile(Level level, LivingEntity shooter) {
        super(ModEntities.SPORE_PROJECTILE.get(), shooter, level);
    }

    public SporeProjectile(Level level, double x, double y, double z) {
        super(ModEntities.SPORE_PROJECTILE.get(), x, y, z, level);
    }

    protected @NotNull Item getDefaultItem() {
        return ModItems.SPORE.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItem();
        return (!itemstack.isEmpty() && !itemstack.is(this.getDefaultItem()) ? new ItemParticleOption(ParticleTypes.ITEM, itemstack) : new ItemParticleOption(ParticleTypes.ITEM, ModItems.SPORE.toStack()));
    }

    public void handleEntityEvent(byte id) {
        if (id == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F, 0.0F);
            }
        }

    }

    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (!(entity.getType().is(ModTags.Entities.PLANT_ALLAYS) || entity instanceof Player player && !player.getData(ModDataAttachments.ZOMBIE))){
            entity.hurt(this.damageSources().source(ModDamageTypes.PEA_DAMAGE, this, this.getOwner()), 2);
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
