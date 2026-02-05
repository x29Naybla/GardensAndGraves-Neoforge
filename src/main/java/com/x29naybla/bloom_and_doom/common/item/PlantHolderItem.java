package com.x29naybla.bloom_and_doom.common.item;

import com.mojang.serialization.MapCodec;
import com.x29naybla.bloom_and_doom.common.block.entity.PlanterBlockEntity;
import com.x29naybla.bloom_and_doom.common.entity.Plant;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.BlockGetter;

public class PlantHolderItem  extends Item {
    protected static final MapCodec<EntityType<?>> ENTITY_TYPE_FIELD_CODEC;
    protected EntityType<?> defaultType;

    public PlantHolderItem(EntityType<? extends Plant> defaultType, Properties properties) {
        super(properties);
        this.defaultType = defaultType;
    }

    public PlantHolderItem(Properties properties) {
        super(properties);
    }

    public static boolean onSubstrate(BlockGetter level, BlockPos pos) {
        return isSubstrate(level, pos.below());
    }

    public static boolean isSubstrate(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos).is(BnDTags.Blocks.SUPPORTS_PLANTS);
    }

    public boolean onPlanter(BlockGetter level, BlockPos pos) {
        return isPlanter(level, pos.below());
    }

    public boolean isPlanter(BlockGetter reader, BlockPos pos) {
        return reader.getBlockEntity(pos) instanceof PlanterBlockEntity;
    }

    public EntityType<?> getType(ItemStack stack) {
        CustomData customdata = stack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
        return !customdata.isEmpty() ? customdata.read(ENTITY_TYPE_FIELD_CODEC).result().orElse(this.getDefaultType()) : this.getDefaultType();
    }

    protected EntityType<?> getDefaultType() {
        return this.defaultType;
    }

    static {
        ENTITY_TYPE_FIELD_CODEC = BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("id");
    }
}
