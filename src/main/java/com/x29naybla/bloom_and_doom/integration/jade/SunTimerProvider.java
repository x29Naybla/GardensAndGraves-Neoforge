package com.x29naybla.bloom_and_doom.integration.jade;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.SolarPlant;
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

        if (entityAccessor.getServerData().contains("SunTimer") && (entityAccessor.getServerData().getBoolean("CanBaby") || !entityAccessor.getServerData().getBoolean("IsBaby"))) {
            iTooltip.add(Component.translatable(BloomAndDoom.MOD_ID+".sun_timer", entityAccessor.getServerData().getInt("SunTimer")));
            iTooltip.append(IThemeHelper.get().seconds(compound.getInt("SunTimer"), 20));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        SolarPlant solarPlant = (SolarPlant) entityAccessor.getEntity();
        compoundTag.putInt("SunTimer", solarPlant.sunTime);
        compoundTag.putBoolean("IsBaby", solarPlant.isBaby());
        compoundTag.putBoolean("CanBaby", solarPlant.canBaby);
    }

    @Override
    public ResourceLocation getUid() {
        return JadeIntegration.SUN_TIMER;
    }

}
