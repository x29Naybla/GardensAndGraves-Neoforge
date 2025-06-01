package com.x29naybla.bloom_and_doom.jade;

import com.x29naybla.bloom_and_doom.entity.SolarPlant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum SunTimerProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    SUN;

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        CompoundTag compound = entityAccessor.getServerData();
        SolarPlant solarPlant = (SolarPlant) entityAccessor.getEntity();

        if (entityAccessor.getServerData().contains("SunTimer") && !solarPlant.isBaby()) {
            iTooltip.add(Component.translatable("bloom_and_doom.sun_timer", entityAccessor.getServerData().getInt("SunTimer")));
            iTooltip.append(IThemeHelper.get().seconds(compound.getInt("SunTimer"), 20));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        SolarPlant solarPlant = (SolarPlant) entityAccessor.getEntity();
        compoundTag.putInt("SunTimer", solarPlant.sunTime);
    }

    @Override
    public ResourceLocation getUid() {
        return JadeIntegration.SUN_TIMER;
    }

}
