package com.x29naybla.gardensandgraves.block.entity;

import com.x29naybla.gardensandgraves.data.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.ticks.ContainerSingleItem;

public class PlanterBlockEntity extends BlockEntity implements ContainerSingleItem.BlockContainerSingleItem {
    private ItemStack item;

    public PlanterBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PLANTER.get(), pos, blockState);
        this.item = ItemStack.EMPTY;
    }

    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    @Override
    public ItemStack getTheItem() {
        return this.item;
    }

    public ItemStack splitTheItem(int amount) {
        ItemStack itemstack = this.item;
        this.setTheItem(ItemStack.EMPTY);
        return itemstack;
    }

    @Override
    public void setTheItem(ItemStack itemStack) {
        this.item = item;
    }

    public boolean canPlaceItem(int slot, ItemStack stack) {
        return stack.is(ModTags.Items.PLANTER_SUBSTRATES) && this.getItem(slot).isEmpty();
    }

    public boolean canTakeItem(Container target, int slot, ItemStack stack) {
        return target.hasAnyMatching(ItemStack::isEmpty);
    }
}
