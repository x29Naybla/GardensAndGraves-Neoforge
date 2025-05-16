package com.x29naybla.gardensandgraves.item.custom;

import com.x29naybla.gardensandgraves.data.ModDataComponents;
import com.x29naybla.gardensandgraves.entity.MarigoldEntity;
import com.x29naybla.gardensandgraves.entity.Plant;
import com.x29naybla.gardensandgraves.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PottedPlantItem extends SeedPacketItem{
    public PottedPlantItem(EntityType<? extends Mob> defaultType, Properties properties) {
        super(defaultType, 0, 0, properties);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        ItemStack stack = context.getItemInHand();

        Direction direction = context.getClickedFace();
        if (direction == Direction.DOWN) {
            return InteractionResult.FAIL;
        }else if (onSubstrate(level, blockpos) || onPlanter(level, blockpos)){
            ItemStack itemStack = context.getItemInHand();
            Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
            AABB aabb = this.getType(itemStack).getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
            if(level.noCollision(null, aabb) && level.getEntities(null, aabb).isEmpty()){
                if(level instanceof ServerLevel){
                    ServerLevel serverlevel = (ServerLevel)level;
                    Entity entity = this.getType(itemStack).create(serverlevel, EntityType.createDefaultStackConfig(serverlevel, itemStack, context.getPlayer()), blockpos, MobSpawnType.SPAWN_EGG, false, false);
                    if (entity == null) {
                        return InteractionResult.FAIL;
                    }
                    float f = (float)Mth.floor((Mth.wrapDegrees(context.getRotation()) + 22.5F) / 45.0F) * 45.0F;
                    entity.moveTo(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                    entity.setYRot(f);
                    entity.setXRot(0);
                    if(entity instanceof Plant plant){
                        if (stack.has(DataComponents.CUSTOM_NAME)) plant.setCustomName(stack.getHoverName());
                        if (stack.has(DataComponents.BASE_COLOR)) ((MarigoldEntity) plant).setColor(stack.get(DataComponents.BASE_COLOR));
                        if (stack.has(ModDataComponents.AGE)) plant.setAge(stack.get(ModDataComponents.AGE));
                        if (stack.has(ModDataComponents.HEALTH)) plant.setHealth(stack.get(ModDataComponents.HEALTH));
                        plant.fromPlanter = true;
                    }
                    if (!context.getPlayer().isCreative()) context.getPlayer().setItemInHand(InteractionHand.MAIN_HAND, Items.FLOWER_POT.getDefaultInstance());
                    serverlevel.addFreshEntityWithPassengers(entity);
                    level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ModSounds.PLANT.get(), SoundSource.BLOCKS, 0.75F, 0.8F);
                    entity.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else return InteractionResult.FAIL;
        } else return InteractionResult.FAIL;
    }
}
