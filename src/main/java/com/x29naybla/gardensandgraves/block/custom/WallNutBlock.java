package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallNutBlock extends Block {
    public static final MapCodec<WallNutBlock> CODEC = simpleCodec(WallNutBlock::new);

    public MapCodec<WallNutBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 20, 15);

    public WallNutBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
