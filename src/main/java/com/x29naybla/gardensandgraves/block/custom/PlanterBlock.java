package com.x29naybla.gardensandgraves.block.custom;

import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PlanterBlock extends Block implements EntityBlock {
    public static final VoxelShape SHAPE = Shapes.join(Stream.of(
            Block.box(1, 0, 1, 15, 1, 15),
            Block.box(2, 1, 1, 14, 12, 2),
            Block.box(2, 1, 14, 14, 12, 15),
            Block.box(1, 1, 1, 2, 12, 15),
            Block.box(14, 1, 1, 15, 12, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(), Stream.of(
            Block.box(2, 12, 0, 14, 16, 2),
            Block.box(2, 12, 14, 14, 16, 16),
            Block.box(0, 12, 0, 2, 16, 16),
            Block.box(14, 12, 0, 16, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(), BooleanOp.OR);

    public PlanterBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PlanterBlockEntity(pos, state);
    }
}
