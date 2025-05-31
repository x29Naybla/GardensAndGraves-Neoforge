package com.x29naybla.gardensandgraves.item.custom;

import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.common.Tags;

public class WateringCanItem extends Item {
    public WateringCanItem(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();

        if (isCrop(level, blockpos.below()) && isFarmland(level, blockpos.below(2))){
            BlockState blockState = level.getBlockState(blockpos.below(2));
            level.setBlockAndUpdate(blockpos.below(2), blockState.setValue(BlockStateProperties.MOISTURE, 7));
            level.addParticle(ParticleTypes.SPLASH, blockpos.getX(), blockpos.getY()+0.5, blockpos.getZ(), 0, 0, 0);
            level.playSound(null, blockpos, ModSounds.WATERING_CAN_USE.get(), SoundSource.BLOCKS, 0.75F, 1.8F);

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (isFarmland(level, blockpos.below())){
            BlockState blockState = level.getBlockState(blockpos.below());
            level.setBlockAndUpdate(blockpos.below(), blockState.setValue(BlockStateProperties.MOISTURE, 7));
            level.addParticle(ParticleTypes.SPLASH, blockpos.getX(), blockpos.getY()+0.5, blockpos.getZ(), 0, 0, 0);
            level.playSound(null, blockpos, ModSounds.WATERING_CAN_USE.get(), SoundSource.BLOCKS, 0.75F, 1.8F);

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (isMudable(level, context)){
            level.setBlockAndUpdate(context.getClickedPos(), Blocks.MUD.defaultBlockState());
            level.addParticle(ParticleTypes.SPLASH, blockpos.getX(), blockpos.getY()+0.5, blockpos.getZ(), 0, 0, 0);
            level.playSound(null, blockpos, ModSounds.WATERING_CAN_USE.get(), SoundSource.BLOCKS, 0.75F, 1.8F);

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else return InteractionResult.FAIL;
    }

    public static boolean isFarmland(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos).is(Tags.Blocks.VILLAGER_FARMLANDS);
    }

    public static boolean isCrop(BlockGetter reader, BlockPos pos) {
        return reader.getBlockState(pos).is(BlockTags.MAINTAINS_FARMLAND);
    }

    public static boolean isMudable(BlockGetter reader, UseOnContext context) {
        return reader.getBlockState(context.getClickedPos()).is(BlockTags.CONVERTABLE_TO_MUD);
    }
}
