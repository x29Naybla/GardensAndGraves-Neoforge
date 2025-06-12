package com.x29naybla.bloom_and_doom.block.custom;

import com.mojang.serialization.MapCodec;
import com.x29naybla.bloom_and_doom.block.entity.PlanterBlockEntity;
import com.x29naybla.bloom_and_doom.data.ModTags;
import com.x29naybla.bloom_and_doom.entity.Plant;
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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
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
import vectorwing.farmersdelight.common.utility.MathUtils;

public class PlanterBlock extends BaseEntityBlock {
    public static final MapCodec<PlanterBlock> CODEC = simpleCodec(PlanterBlock::new);
    public @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Shapes.join(Block.box(1, 0, 1, 15, 12, 15), Block.box(0, 12, 0, 16, 16, 16), BooleanOp.OR);

    public PlanterBlock(Properties properties) {
        super(properties);
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
            if(itemStack.is(ModTags.Items.PLANTER_SUBSTRATES)) {
                if(planter.content.getStackInSlot(0).isEmpty()) {
                    planter.content.insertItem(0, itemStack.copy(), false);

                    BlockItem content = (BlockItem) itemStack.getItem();
                    level.playSound(null, pos, content.getBlock().getSoundType(content.getBlock().defaultBlockState(), level, pos, null).getPlaceSound(), SoundSource.BLOCKS, 1.0F, 1.0F);

                    if(!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                } else
                    level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            } else if (itemStack.isEmpty() && (level.getEntitiesOfClass(Plant.class, AABB.ofSize(pos.getCenter().add(0, 1, 0), 1, 1, 1))).isEmpty()){
                if(!planter.content.getStackInSlot(0).isEmpty() && player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.AIR)){
                    ItemStack stackOnPlanter = planter.content.extractItem(0,1,false);

                    BlockItem content = (BlockItem) stackOnPlanter.getItem();
                    level.playSound(null, pos, content.getBlock().getSoundType(content.getBlock().defaultBlockState(), level, pos, null).getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);

                    player.setItemInHand(InteractionHand.MAIN_HAND, stackOnPlanter);
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
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType type) {
        return false;
    }

    @Override
    public @NotNull TriState canSustainPlant(@NotNull BlockState state, BlockGetter level, @NotNull BlockPos pos, @NotNull Direction facing, @NotNull BlockState plant) {
        if(level.getBlockEntity(pos) instanceof PlanterBlockEntity planter) {
            ItemStack substrate = planter.content.getStackInSlot(0);
            LevelReader reader = (LevelReader) level;

            if (substrate.is(ItemTags.DIRT) && !substrate.is(ModTags.Items.SUSTAINS_MUSHROOMS) && plant.is(ModTags.Blocks.DIRT_SUSTAINS)){
                if (plant.is(ModTags.Blocks.MUSHROOMS)){
                    if (reader.getRawBrightness(pos, 0) > 13) {
                        return TriState.FALSE;
                    } else return TriState.TRUE;
                } else return TriState.TRUE;
            } else if (substrate.is(ModTags.Items.SUSTAINS_MUSHROOMS) && plant.is(ModTags.Blocks.MYCELIUM_SUSTAINS)){
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

        return super.canSustainPlant(state, level, pos, facing, plant);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(level.getBlockEntity(pos) instanceof PlanterBlockEntity planter){
            ItemStack substrate = planter.content.getStackInSlot(0);

            if(ModList.get().isLoaded(FarmersDelight.MODID)) {
                if(substrate.is(ModItems.RICH_SOIL.get())) {
                    if (!level.isClientSide) {
                        BlockState aboveState = level.getBlockState(pos.above());
                        Block aboveBlock = aboveState.getBlock();

                        // Do nothing if the plant is unaffected by rich soil
                        if (aboveState.is(vectorwing.farmersdelight.common.tag.ModTags.UNAFFECTED_BY_RICH_SOIL)) {
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
        return SHAPE;
    }

    @Override
    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }
}
