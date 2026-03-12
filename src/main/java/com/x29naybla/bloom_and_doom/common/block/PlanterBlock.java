package com.x29naybla.bloom_and_doom.common.block;

import com.mojang.serialization.MapCodec;
import com.x29naybla.bloom_and_doom.common.block.entity.PlanterBlockEntity;
import com.x29naybla.bloom_and_doom.common.tag.CommonTags;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
import com.x29naybla.bloom_and_doom.common.entity.Plant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;

import java.util.stream.Stream;

public class PlanterBlock extends BaseEntityBlock {
    public static final BooleanProperty FILLED = BooleanProperty.create("filled");
    public static final MapCodec<PlanterBlock> CODEC = simpleCodec(PlanterBlock::new);
    public @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE_EMPTY  = Shapes.join(Stream.of(
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
    public static final VoxelShape SHAPE_FULL = Shapes.join(Block.box(1, 0, 1, 15, 12, 15), Block.box(0, 12, 0, 16, 16, 16), BooleanOp.OR);

    public PlanterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FILLED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FILLED);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state){
        return new PlanterBlockEntity(pos, state);
    }

    @Override
    protected void onRemove(BlockState state, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if (level.getBlockEntity(pos) instanceof PlanterBlockEntity planter) {
                planter.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack itemStack, @NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if(level.getBlockEntity(pos) instanceof PlanterBlockEntity planter) {
            ItemStack substrate = planter.content.getStackInSlot(0);
            if(itemStack.is(BnDTags.Items.PLANTER_SUBSTRATES)) {
                if(substrate.isEmpty()) {
                    if(!level.isClientSide()) level.setBlockAndUpdate(pos, state.setValue(FILLED, true));

                    planter.content.insertItem(0, itemStack.copy(), false);

                    BlockItem content = (BlockItem) itemStack.getItem();
                    level.playSound(null, pos, content.getBlock().getSoundType(content.getBlock().defaultBlockState(), level, pos, null).getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);

                    if(!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                } else
                    level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            } else if (itemStack.isEmpty() && (level.getEntitiesOfClass(Plant.class, AABB.ofSize(pos.getCenter().add(0, 1, 0), 1, 1, 1))).isEmpty()){
                if(!substrate.isEmpty() && player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.AIR)){
                    ItemStack stackOnPlanter = planter.content.extractItem(0,1,false);

                    BlockItem content = (BlockItem) stackOnPlanter.getItem();
                    level.playSound(null, pos, content.getBlock().getSoundType(content.getBlock().defaultBlockState(), level, pos, null).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);

                    player.setItemInHand(InteractionHand.MAIN_HAND, stackOnPlanter);
                    planter.clearContents();

                    if(!level.isClientSide()) level.setBlockAndUpdate(pos, state.setValue(FILLED, false));
                } else
                    level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            } else if(!(itemStack.isEmpty() && substrate.isEmpty())) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }

            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType type) {
        return false;
    }

    @Override
    protected boolean isRandomlyTicking(@NotNull BlockState state) {
        return true;
    }

    @Override
    public @NotNull TriState canSustainPlant(@NotNull BlockState state, BlockGetter level, @NotNull BlockPos pos, @NotNull Direction facing, @NotNull BlockState plant) {
        if(level.getBlockEntity(pos) instanceof PlanterBlockEntity planter) {
            ItemStack substrate = planter.content.getStackInSlot(0);

            if (!state.getValue(FILLED) && (plant.is(Blocks.TWISTING_VINES) || plant.is(Blocks.TWISTING_VINES_PLANT)))
                return TriState.FALSE;
            if (!substrate.isEmpty() && !substrate.is(BnDTags.Items.SUSTAINS_MUSHROOMS)) {
                if (plant.is(CommonTags.Blocks.MUSHROOMS)){
                    return TriState.DEFAULT;
                }
            }
            if (substrate.is(ItemTags.DIRT) && plant.is(BnDTags.Blocks.DIRT_SUSTAINS)){
                 return TriState.TRUE;
            } else if (substrate.is(BnDTags.Items.SUSTAINS_MUSHROOMS) && plant.is(BnDTags.Blocks.MYCELIUM_SUSTAINS)){
                return TriState.TRUE;
            } else if ((substrate.is(Items.SAND) || substrate.is(Items.RED_SAND)) && plant.is(BnDTags.Blocks.SAND_SUSTAINS)) {
                return TriState.TRUE;
            } else if (substrate.is(Items.SOUL_SAND) && plant.is(BnDTags.Blocks.SOUL_SAND_SUSTAINS)){
                return TriState.TRUE;
            } else if ((substrate.is(Items.CRIMSON_NYLIUM) || substrate.is(Items.WARPED_NYLIUM)) && plant.is(BnDTags.Blocks.NYLIUM_SUSTAINS)){
                return TriState.TRUE;
            } else if (substrate.is(Items.END_STONE) && plant.is(BnDTags.Blocks.END_STONE_SUSTAINS)){
                return TriState.TRUE;
            }
        }

        return TriState.DEFAULT;
    }

    @Override
    protected void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if(level.getBlockEntity(pos) instanceof PlanterBlockEntity planter){
            ItemStack substrate = planter.content.getStackInSlot(0);

            if(ModList.get().isLoaded(FarmersDelight.MODID)) {
                if(substrate.is(ModItems.RICH_SOIL.get())) {
                    if (!level.isClientSide) {
                        BlockState aboveState = level.getBlockState(pos.above());
                        Block aboveBlock = aboveState.getBlock();

                        // Do nothing if the plant is unaffected by rich soil
                        if (aboveState.is(ModTags.UNAFFECTED_BY_RICH_SOIL)) {
                            return;
                        }

                        // Convert mushrooms to colonies if it's dark enough
                        if (aboveBlock == Blocks.BROWN_MUSHROOM) {
                            level.setBlockAndUpdate(pos.above(), ModBlocks.BROWN_MUSHROOM_COLONY.get().defaultBlockState());
                            return;
                        }
                        if (aboveBlock == Blocks.RED_MUSHROOM) {
                            level.setBlockAndUpdate(pos.above(), ModBlocks.RED_MUSHROOM_COLONY.get().defaultBlockState());
                            return;
                        }

                        if (Configuration.RICH_SOIL_BOOST_CHANCE.get() == 0.0) {
                            return;
                        }

                        // If all else fails, and it's a plant, give it a growth boost now and then!
                        if (aboveBlock instanceof BonemealableBlock growable && MathUtils.RAND.nextFloat() <= Configuration.RICH_SOIL_BOOST_CHANCE.get()) {
                            if (growable.isValidBonemealTarget(level, pos.above(), aboveState) && CommonHooks.canCropGrow(level, pos.above(), aboveState, true)) {
                                growable.performBonemeal(level, level.random, pos.above(), aboveState);
                                //level.levelEvent(1505, pos.above(), 0);
                                CommonHooks.fireCropGrowPost(level, pos.above(), aboveState);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Boolean filled = state.getValue(FILLED);

        if (filled) return SHAPE_FULL;
        else return SHAPE_EMPTY;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
}
