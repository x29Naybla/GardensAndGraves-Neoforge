package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.entity.ModBlockEntities;
import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PlanterBlock extends Block implements EntityBlock {
    public static final MapCodec<PlanterBlock> CODEC = simpleCodec(PlanterBlock::new);
    public static final BooleanProperty HAS_SUBSTRATE;

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
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(HAS_SUBSTRATE, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if ((Boolean)state.getValue(HAS_SUBSTRATE)) {
            BlockEntity var7 = level.getBlockEntity(pos);
            if (var7 instanceof PlanterBlockEntity) {
                PlanterBlockEntity planterblockentity = (PlanterBlockEntity)var7;
                planterblockentity.popOutTheItem();
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }

    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if ((Boolean)state.getValue(HAS_SUBSTRATE)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            ItemStack itemstack = player.getItemInHand(hand);
            ItemInteractionResult iteminteractionresult = JukeboxPlayable.tryInsertIntoJukebox(level, pos, itemstack, player);
            return !iteminteractionresult.consumesAction() ? ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION : iteminteractionresult;
        }
    }

    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity var7 = level.getBlockEntity(pos);
            if (var7 instanceof PlanterBlockEntity) {
                PlanterBlockEntity planterblockentity = (PlanterBlockEntity)var7;
                planterblockentity.popOutTheItem();
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }

    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PlanterBlockEntity(pos, state);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HAS_SUBSTRATE});
    }

    static {
        HAS_SUBSTRATE = BlockStateProperties.HAS_RECORD;
    }
}
