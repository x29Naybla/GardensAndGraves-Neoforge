package com.x29naybla.bloom_and_doom.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AlmanacItem extends Item {
    public AlmanacItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxStackSize(@NotNull ItemStack stack) {
        return 1;
    }
}
