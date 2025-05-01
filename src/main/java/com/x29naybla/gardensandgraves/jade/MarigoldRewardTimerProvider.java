package com.x29naybla.gardensandgraves.jade;

import com.x29naybla.gardensandgraves.entity.MarigoldEntity;
import com.x29naybla.gardensandgraves.entity.Plant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;

public enum MarigoldRewardTimerProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    MARIGOLD_REWARD;

    @Override
    public void appendTooltip(ITooltip iTooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        CompoundTag compound = entityAccessor.getServerData();
        Plant plant = (Plant) entityAccessor.getEntity();

        if (entityAccessor.getServerData().contains("RewardTimer") && !plant.isBaby()) {
            iTooltip.add(Component.translatable("gardensandgraves.reward_timer", entityAccessor.getServerData().getInt("RewardTimer")));
            iTooltip.append(IThemeHelper.get().seconds(compound.getInt("RewardTimer"), 20));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        MarigoldEntity marigold = (MarigoldEntity) entityAccessor.getEntity();
        compoundTag.putInt("RewardTimer", marigold.rewardTime);
    }

    @Override
    public ResourceLocation getUid() {
        return JadeIntegration.REWARD_TIMER;
    }

}
