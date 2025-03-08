package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PlanterBlock extends Block implements EntityBlock {
    public static final MapCodec<PlanterBlock> CODEC = simpleCodec(PlanterBlock::new);

    public MapCodec<PlanterBlock> codec() {
        return CODEC;
    }

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

    public PlanterBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack p_316569_, BlockState p_316562_, Level p_316177_, BlockPos p_316898_, Player p_316632_, InteractionHand p_316424_, BlockHitResult p_316345_
    ) {
        if (p_316177_.getBlockEntity(p_316898_) instanceof PlanterBlockEntity planterblockentity) {
            if (p_316177_.isClientSide) {
                return ItemInteractionResult.CONSUME;
            } else {
                ItemStack itemstack1 = planterblockentity.getTheItem();
                if (!p_316569_.isEmpty()
                        && (
                        itemstack1.isEmpty()
                                || ItemStack.isSameItemSameComponents(itemstack1, p_316569_) && itemstack1.getCount() < itemstack1.getMaxStackSize()
                )) {
                    p_316632_.awardStat(Stats.ITEM_USED.get(p_316569_.getItem()));
                    ItemStack itemstack = p_316569_.consumeAndReturn(1, p_316632_);
                    float f;
                    if (planterblockentity.isEmpty()) {
                        planterblockentity.setTheItem(itemstack);
                        f = (float)itemstack.getCount() / (float)itemstack.getMaxStackSize();
                    } else {
                        itemstack1.grow(1);
                        f = (float)itemstack1.getCount() / (float)itemstack1.getMaxStackSize();
                    }

                    p_316177_.playSound(null, p_316898_, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F * f);

                    planterblockentity.setChanged();
                    p_316177_.gameEvent(p_316632_, GameEvent.BLOCK_CHANGE, p_316898_);
                    return ItemInteractionResult.SUCCESS;
                } else {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
            }
        } else {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState p_316866_, Level p_316544_, BlockPos p_316541_, Player p_316732_, BlockHitResult p_316860_) {
        if (p_316544_.getBlockEntity(p_316541_) instanceof PlanterBlockEntity planterblockentity) {
            p_316544_.playSound(null, p_316541_, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            p_316544_.gameEvent(p_316732_, GameEvent.BLOCK_CHANGE, p_316541_);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected boolean isPathfindable(BlockState p_276295_, PathComputationType p_276303_) {
        return false;
    }

    @Override
    protected void onRemove(BlockState p_305821_, Level p_306245_, BlockPos p_305894_, BlockState p_306294_, boolean p_306159_) {
        Containers.dropContentsOnDestroy(p_305821_, p_306294_, p_306245_, p_305894_);
        super.onRemove(p_305821_, p_306245_, p_305894_, p_306294_, p_306159_);
    }

    @Override
    public BlockState playerWillDestroy(Level p_273590_, BlockPos p_273343_, BlockState p_272869_, Player p_273002_) {
        BlockState blockstate = p_272869_;

        return super.playerWillDestroy(p_273590_, p_273343_, blockstate, p_273002_);
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
