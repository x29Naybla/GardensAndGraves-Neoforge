package com.x29naybla.gardensandgraves.jade;

import com.x29naybla.gardensandgraves.entity.Plant;
import com.x29naybla.gardensandgraves.entity.SunflowerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum SunflowerSunTimerProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    SUNFLOWER_SUN;

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        CompoundTag compound = entityAccessor.getServerData();
        Plant plant = (Plant) entityAccessor.getEntity();

        if (entityAccessor.getServerData().contains("SunTimer") && !plant.isBaby()) {
            iTooltip.add(Component.translatable("gardensandgraves.sun_timer", entityAccessor.getServerData().getInt("SunTimer")));
            iTooltip.append(IThemeHelper.get().seconds(compound.getInt("SunTimer"), 20));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        SunflowerEntity sunflower = (SunflowerEntity) entityAccessor.getEntity();
        compoundTag.putInt("SunTimer", sunflower.sunTime);
    }

    @Override
    public ResourceLocation getUid() {
        return JadeIntegration.SUNFLOWER_SUN_TIMER;
    }

}
