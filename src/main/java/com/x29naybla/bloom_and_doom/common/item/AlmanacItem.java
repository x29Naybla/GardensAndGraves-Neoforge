package com.x29naybla.bloom_and_doom.common.item;

import com.x29naybla.bloom_and_doom.client.BloomAndDoomClient;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AlmanacItem extends Item {
    public AlmanacItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxStackSize(@NotNull ItemStack stack) {
        return 1;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if (level.isClientSide()) {
            BloomAndDoomClient.openAtlas();
        }
        return super.use(level, player, usedHand);
    }
}
