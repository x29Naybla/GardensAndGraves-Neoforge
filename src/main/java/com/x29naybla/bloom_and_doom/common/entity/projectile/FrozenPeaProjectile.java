package com.x29naybla.bloom_and_doom.common.entity.projectile;

import com.x29naybla.bloom_and_doom.common.registry.*;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import com.x29naybla.bloom_and_doom.common.registry.BnDItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class FrozenPeaProjectile extends PlantProjectile {
    public FrozenPeaProjectile(EntityType<? extends FrozenPeaProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public FrozenPeaProjectile(Level level, LivingEntity shooter) {
        super(BnDEntities.FROZEN_PEA_PROJECTILE.get(), shooter, level);
    }

    public FrozenPeaProjectile(Level level, double x, double y, double z) {
        super(BnDEntities.FROZEN_PEA_PROJECTILE.get(), x, y, z, level);
    }

    protected @NotNull Item getDefaultItem() {
        return BnDItems.FROZEN_PEA.get();
    }

    protected @NotNull ResourceKey<DamageType> setDamageType() {
        return BnDDamageTypes.FROZEN_PEA_DAMAGE;
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        if (!(entity.getType().is(BnDTags.Entities.PLANT_ALLAYS) || entity instanceof Player player && !player.getData(BnDDataAttachments.ZOMBIE))){
            entity.hurt(this.damageSources().source(BnDDamageTypes.FROZEN_PEA_DAMAGE, this, this.getOwner()), 2);
            entity.extinguishFire();
            entity.setTicksFrozen(280);
            entity.isFullyFrozen();
            this.level().broadcastEntityEvent(this, (byte)3);
            playSound(BnDSounds.SPLAT.get(),0.25F, 1 / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            shouldBreak = true;
        }
    }
}
