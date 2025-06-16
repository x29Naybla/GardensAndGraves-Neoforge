package com.x29naybla.bloom_and_doom.common.item;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.client.gui.AlmanacScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import static com.mojang.realmsclient.util.task.LongRunningTask.setScreen;

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
        setScreen(new AlmanacScreen(Component.translatable(BloomAndDoom.MOD_ID + ".gui.almanac")));
        return super.use(level, player, usedHand);
    }
}
