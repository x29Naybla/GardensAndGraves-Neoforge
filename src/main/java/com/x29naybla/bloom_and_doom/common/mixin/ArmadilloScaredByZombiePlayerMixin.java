package com.x29naybla.bloom_and_doom.common.mixin;

import com.x29naybla.bloom_and_doom.common.registry.BnDDataAttachments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Armadillo.class)
public class ArmadilloScaredByZombiePlayerMixin {
    @Inject(
            method = "isScaredBy",
            at = @At("HEAD"),
            cancellable = true
    )

    protected void scaredByZombiePlayer(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player player && player.getData(BnDDataAttachments.ZOMBIE)) {
            cir.setReturnValue(true);
        }
    }
}
