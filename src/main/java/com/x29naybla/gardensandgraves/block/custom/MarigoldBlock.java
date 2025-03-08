package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MarigoldBlock extends Block {
    public static final MapCodec<MarigoldBlock> CODEC = simpleCodec(MarigoldBlock::new);

    public MapCodec<MarigoldBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Shapes.join(
            Block.box(7, 0, 7, 9, 11, 9),
            Block.box(2.5, 5.5, 6.5, 13.5, 15.5, 9),
            BooleanOp.OR);

    public MarigoldBlock(Properties properties) {
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
