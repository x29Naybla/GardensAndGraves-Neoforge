package com.x29naybla.gardensandgraves.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.gardensandgraves.block.ModBlockStateProperties;
import com.x29naybla.gardensandgraves.block.Substrate;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.TriState;

import java.util.stream.Stream;

public class PlanterBlock extends Block {
    public static final MapCodec<PlanterBlock> CODEC = simpleCodec(PlanterBlock::new);
    public static final EnumProperty<Substrate> CONTENT;

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

    public static final VoxelShape TEMPORARY_SHAPE = Shapes.join(Block.box(1, 0, 1, 15, 12, 15), Block.box(0, 12, 0, 16, 16, 16), BooleanOp.OR);

    public PlanterBlock(BlockBehaviour.Properties properties) {
        super(properties);

        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(CONTENT, Substrate.EMPTY));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{CONTENT});
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        itemStack = player.getItemInHand(hand);

        if(level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("empty")){
            if(itemStack.is(Items.DIRT)){
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.DIRT)), 2);
                level.playSound(null, pos, SoundEvents.GRAVEL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            } else if (itemStack.is(Items.MYCELIUM)){
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.MYCELIUM)), 2);
                level.playSound(null, pos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            } else if (itemStack.is(Items.SAND)){
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.SAND)), 2);
                level.playSound(null, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            } else if (itemStack.is(Items.RED_SAND)){
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.RED_SAND)), 2);
                level.playSound(null, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            } else if (itemStack.is(Items.SOUL_SAND)){
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.SOUL_SAND)), 2);
                level.playSound(null, pos, SoundEvents.SOUL_SAND_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
        } else if (itemStack.isEmpty() && (level.getEntitiesOfClass(Plant.class, AABB.ofSize(pos.getCenter().add(0, 1, 0), 1, 1, 1))).isEmpty()) {
            if (level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("empty")) {
                level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                return ItemInteractionResult.SUCCESS;
            } else if (level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("dirt")) {
                level.playSound(null, pos, SoundEvents.GRAVEL_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                player.setItemInHand(InteractionHand.MAIN_HAND, Items.DIRT.getDefaultInstance());
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.EMPTY)), 2);
                return ItemInteractionResult.SUCCESS;
            } else if (level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("mycelium")) {
                level.playSound(null, pos, SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                player.setItemInHand(InteractionHand.MAIN_HAND, Items.MYCELIUM.getDefaultInstance());
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.EMPTY)), 2);
                return ItemInteractionResult.SUCCESS;
            } else if (level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("sand")) {
                level.playSound(null, pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                player.setItemInHand(InteractionHand.MAIN_HAND, Items.SAND.getDefaultInstance());
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.EMPTY)), 2);
                return ItemInteractionResult.SUCCESS;
            } else if (level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("red_sand")) {
                level.playSound(null, pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                player.setItemInHand(InteractionHand.MAIN_HAND, Items.RED_SAND.getDefaultInstance());
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.EMPTY)), 2);
                return ItemInteractionResult.SUCCESS;
            } else if (level.getBlockState(pos).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("soul_sand")) {
                level.playSound(null, pos, SoundEvents.SOUL_SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                player.setItemInHand(InteractionHand.MAIN_HAND, Items.SOUL_SAND.getDefaultInstance());
                level.setBlock(pos, (state.setValue(CONTENT, Substrate.EMPTY)), 2);
                return ItemInteractionResult.SUCCESS;
            } else {
                return ItemInteractionResult.FAIL;
            }
        } return ItemInteractionResult.FAIL;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType p_276303_) {
        return false;
    }

    @Override
    public TriState canSustainPlant(BlockState state, BlockGetter level, BlockPos soilPosition, Direction facing, BlockState plant) {
        if(plant.is(ModTags.Blocks.DIRT_SUSTAINS) || (plant.is(ModTags.Blocks.MUSHROOMS) && (level.getLightEmission(soilPosition.above()) < 14)) && level.getBlockState(soilPosition).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("dirt")){
            return TriState.TRUE;
        } else if(plant.is(ModTags.Blocks.MYCELIUM_SUSTAINS) && level.getBlockState(soilPosition).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("mycelium")){
            return TriState.TRUE;
        } else if(plant.is(ModTags.Blocks.SANDS_SUSTAINS) && (level.getBlockState(soilPosition).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("sand") || level.getBlockState(soilPosition).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("red_sand"))){
            return TriState.TRUE;
        } else if(plant.is(ModTags.Blocks.SOUL_SAND_SUSTAINS) && level.getBlockState(soilPosition).getValue(ModBlockStateProperties.SUBSTRATE).toString().equals("soul_sand")){
            return TriState.TRUE;
        }

        return super.canSustainPlant(state, level, soilPosition, facing, plant);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return TEMPORARY_SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    static {
        CONTENT = ModBlockStateProperties.SUBSTRATE;
    }
}
