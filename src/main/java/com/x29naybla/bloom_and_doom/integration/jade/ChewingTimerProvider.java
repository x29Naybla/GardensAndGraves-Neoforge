package com.x29naybla.bloom_and_doom.integration.jade;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.ChomperEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum ChewingTimerProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    CHEWING;

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        CompoundTag compound = entityAccessor.getServerData();

        if (entityAccessor.getServerData().contains("Chewing") && !entityAccessor.getServerData().getBoolean("IsBaby")) {
            iTooltip.add(Component.translatable(BloomAndDoom.MOD_ID+".chew_timer", entityAccessor.getServerData().getInt("Chewing")));
            iTooltip.append(IThemeHelper.get().seconds(compound.getInt("Chewing"), 20));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        ChomperEntity chomper = (ChomperEntity) entityAccessor.getEntity();
        compoundTag.putInt("Chewing", chomper.getChewing());
        compoundTag.putBoolean("IsBaby", chomper.isBaby());
    }

    @Override
    public ResourceLocation getUid() {
        return JadeIntegration.CHEWING_TIMER;
    }

}
