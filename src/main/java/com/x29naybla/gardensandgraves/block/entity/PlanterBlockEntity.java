package com.x29naybla.gardensandgraves.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.ticks.ContainerSingleItem;

import javax.annotation.Nullable;
import java.util.List;

public class PlanterBlockEntity extends BlockEntity implements RandomizableContainer, ContainerSingleItem.BlockContainerSingleItem{
    public static final String TAG_ITEM = "item";
    private ItemStack item = ItemStack.EMPTY;
    @Nullable
    protected ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;

    public PlanterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PLANTER.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.trySaveLootTable(tag) && !this.item.isEmpty()) {
            tag.put("item", this.item.save(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (!this.tryLoadLootTable(tag)) {
            if (tag.contains("item", 10)) {
                this.item = ItemStack.parse(registries, tag.getCompound("item")).orElse(ItemStack.EMPTY);
            } else {
                this.item = ItemStack.EMPTY;
            }
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveCustomOnly(registries);
    }

    public void setFromItem(ItemStack item) {
        this.applyComponentsFromItemStack(item);
    }

    @Nullable
    @Override
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceKey<LootTable> lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.item)));
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        this.item = componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyOne();
    }

    @Override
    public void removeComponentsFromTag(CompoundTag tag) {
        super.removeComponentsFromTag(tag);
        tag.remove("item");
    }

    @Override
    public ItemStack getTheItem() {
        this.unpackLootTable(null);
        return this.item;
    }

    @Override
    public ItemStack splitTheItem(int amount) {
        this.unpackLootTable(null);
        ItemStack itemstack = this.item.split(amount);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }

        return itemstack;
    }

    @Override
    public void setTheItem(ItemStack item) {
        this.unpackLootTable(null);
        this.item = item;
    }

    @Override
    public BlockEntity getContainerBlockEntity() {
        return this;
    }
}
