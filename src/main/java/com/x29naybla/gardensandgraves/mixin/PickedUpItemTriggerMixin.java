package com.x29naybla.gardensandgraves.mixin;

import net.minecraft.advancements.critereon.PickedUpItemTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(PickedUpItemTrigger.class)
public class PickedUpItemTriggerMixin {
    @Inject(
            method = "trigger(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/Entity;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void throwToNewPlayer(ServerPlayer firstOwner, ItemStack stack, @Nullable Entity newOwner, CallbackInfo ci) {
        assert newOwner != null;
        if (newOwner.getUUID() == firstOwner.getUUID()) {
            ci.cancel();
        }
    }
}