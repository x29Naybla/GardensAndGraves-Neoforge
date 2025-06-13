package com.x29naybla.bloom_and_doom.integration.jade;

import com.x29naybla.bloom_and_doom.common.entity.Plant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum SeedPacketsTimerProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    SEED_PACKETS;

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        CompoundTag compound = entityAccessor.getServerData();
        Plant plant = (Plant) entityAccessor.getEntity();

        if (compound.contains("SeedPacketsTimer") && compound.getBoolean("isFromPlanter") && compound.getBoolean("onPlanter") && !(plant.isBaby())) {
            iTooltip.add(Component.translatable("bloom_and_doom.seed_packets_timer", entityAccessor.getServerData().getInt("SeedPacketsTimer")));
            iTooltip.append(IThemeHelper.get().seconds(compound.getInt("SeedPacketsTimer"), 20));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        Plant plant = (Plant) entityAccessor.getEntity();
        compoundTag.putInt("SeedPacketsTimer", plant.packetTime);
        compoundTag.putBoolean("isFromPlanter", plant.fromPlanter);
        compoundTag.putBoolean("onPlanter", plant.onPlanter);
    }

    @Override
    public ResourceLocation getUid() {
        return JadeIntegration.SEED_PACKETS_TIMER;
    }

}
