package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.entity.SunflowerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SunflowerBlock extends Block implements EntityBlock {
    public static final MapCodec<SunflowerBlock> CODEC = simpleCodec(SunflowerBlock::new);

    public MapCodec<SunflowerBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Shapes.join(
            Block.box(7, 0, 7, 9, 11, 9),
            Block.box(1.5, 5, 6.5, 14.5, 15, 9),
            BooleanOp.OR);


    public SunflowerBlock(BlockBehaviour.Properties properties) {
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
        return new SunflowerBlockEntity(pos, state);
    }
}
