package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.entity.PlanterBlockEntity;
import com.x29naybla.gardensandgraves.data.ModTags;
import com.x29naybla.gardensandgraves.entity.Plant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;

import javax.annotation.Nullable;

public class PlanterBlock extends BaseEntityBlock {
    public static final MapCodec<PlanterBlock> CODEC = simpleCodec(PlanterBlock::new);

    public MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Shapes.join(Block.box(1, 0, 1, 15, 12, 15), Block.box(0, 12, 0, 16, 16, 16), BooleanOp.OR);

    public PlanterBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new PlanterBlockEntity(pos, state);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if (level.getBlockEntity(pos) instanceof PlanterBlockEntity planter) {
                planter.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(level.getBlockEntity(pos) instanceof PlanterBlockEntity planter) {
            if(itemStack.is(ModTags.Items.PLANTER_SUBSTRATES)) {
                if(planter.content.getStackInSlot(0).isEmpty()) {
                    planter.content.insertItem(0, itemStack.copy(), false);
                    if(itemStack.is(Items.DIRT)) {
                        level.playSound(null, pos, SoundType.GRAVEL.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(itemStack.is(Items.MYCELIUM)) {
                        level.playSound(null, pos, SoundType.GRASS.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(itemStack.is(Items.SAND) || itemStack.is(Items.RED_SAND)) {
                        level.playSound(null, pos, SoundType.SAND.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(itemStack.is(Items.SOUL_SAND)) {
                        level.playSound(null, pos, SoundType.SOUL_SAND.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(itemStack.is(Items.CRIMSON_NYLIUM) || itemStack.is(Items.WARPED_NYLIUM)) {
                        level.playSound(null, pos, SoundType.NYLIUM.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(itemStack.is(Items.END_STONE)) {
                        level.playSound(null, pos, SoundType.STONE.getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    }

                    if(!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                } else
                    level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            } else if (itemStack.isEmpty() && (level.getEntitiesOfClass(Plant.class, AABB.ofSize(pos.getCenter().add(0, 1, 0), 1, 1, 1))).isEmpty()){
                if(!planter.content.getStackInSlot(0).isEmpty() && player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.AIR)){
                    ItemStack stackOnPlanter = planter.content.extractItem(0,1,false);

                    if(stackOnPlanter.is(Items.DIRT)) {
                        level.playSound(null, pos, SoundType.GRAVEL.getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(stackOnPlanter.is(Items.MYCELIUM)) {
                        level.playSound(null, pos, SoundType.GRASS.getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(stackOnPlanter.is(Items.SAND) || itemStack.is(Items.RED_SAND)) {
                        level.playSound(null, pos, SoundType.SAND.getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(stackOnPlanter.is(Items.SOUL_SAND)) {
                        level.playSound(null, pos, SoundType.SOUL_SAND.getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(stackOnPlanter.is(Items.CRIMSON_NYLIUM) || itemStack.is(Items.WARPED_NYLIUM)) {
                        level.playSound(null, pos, SoundType.NYLIUM.getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    } else if(stackOnPlanter.is(Items.END_STONE)) {
                        level.playSound(null, pos, SoundType.STONE.getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    }

                    player.setItemInHand(InteractionHand.MAIN_HAND, stackOnPlanter);
                    level.playSound(null, pos, SoundEvents.DECORATED_POT_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
                    planter.clearContents();
                } else
                    level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            } else if(!(itemStack.isEmpty() && planter.content.getStackInSlot(0).isEmpty())) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }

            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    @Override
    public TriState canSustainPlant(BlockState state, BlockGetter level, BlockPos soilPosition, Direction facing, BlockState plant) {
        if(level.getBlockEntity(soilPosition) instanceof PlanterBlockEntity planter) {
            ItemStack substrate = planter.content.getStackInSlot(0);

            if (substrate.is(Items.DIRT) && (plant.is(ModTags.Blocks.DIRT_SUSTAINS))){
                if (plant.is(ModTags.Blocks.MUSHROOMS)){
                    if (level.getLightEmission(soilPosition.above()) > 13)
                        return TriState.FALSE;
                } else return TriState.TRUE;
            } else if (substrate.is(Items.MYCELIUM) && plant.is(ModTags.Blocks.MYCELIUM_SUSTAINS)){
                return TriState.TRUE;
            } else if ((substrate.is(Items.SAND) || substrate.is(Items.RED_SAND)) && plant.is(ModTags.Blocks.SAND_SUSTAINS)) {
                return TriState.TRUE;
            } else if (substrate.is(Items.SOUL_SAND) && plant.is(ModTags.Blocks.SOUL_SAND_SUSTAINS)){
                return TriState.TRUE;
            } else if ((substrate.is(Items.CRIMSON_NYLIUM) || substrate.is(Items.WARPED_NYLIUM)) && plant.is(ModTags.Blocks.NYLIUM_SUSTAINS)){
                return TriState.TRUE;
            } else if (substrate.is(Items.END_STONE) && plant.is(ModTags.Blocks.END_STONE_SUSTAINS)){
                return TriState.TRUE;
            }
        }

        return super.canSustainPlant(state, level, soilPosition, facing, plant);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
