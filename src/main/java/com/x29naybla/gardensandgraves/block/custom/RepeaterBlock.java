package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.entity.PeashooterBlockEntity;
import com.x29naybla.gardensandgraves.block.entity.RepeaterBlockEntity;
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

public class RepeaterBlock extends Block implements EntityBlock {
    public static final MapCodec<RepeaterBlock> CODEC = simpleCodec(RepeaterBlock::new);

    public MapCodec<RepeaterBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Shapes.join(
            Block.box(7, 0, 7, 9, 11, 9),
            Block.box(4.5, 7, 0.5, 11.5, 15, 11.5),
            BooleanOp.OR);

    public RepeaterBlock(Properties properties) {
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

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RepeaterBlockEntity(pos, state);
    }
}
