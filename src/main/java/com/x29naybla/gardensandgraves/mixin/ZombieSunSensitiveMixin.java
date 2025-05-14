package com.x29naybla.gardensandgraves.mixin;

import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Zombie.class)
public class ZombieSunSensitiveMixin {
    @Inject(
            method = "isSunSensitive",
            at = @At("HEAD"),
            cancellable = true
    )

    protected void notSunSensitive(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
