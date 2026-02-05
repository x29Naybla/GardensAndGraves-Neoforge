package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.entity.*;
import com.x29naybla.bloom_and_doom.common.entity.projectile.FrozenPeaProjectile;
import com.x29naybla.bloom_and_doom.common.entity.projectile.PeaProjectile;
import com.x29naybla.bloom_and_doom.common.entity.projectile.SporeProjectile;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class BnDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, BloomAndDoom.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<SproutEntity>> SPROUT = register("sprout", SproutEntity::new, 0.7f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<SunflowerEntity>> SUNFLOWER = register("sunflower", SunflowerEntity::new, 0.7f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<MarigoldEntity>> MARIGOLD = register("marigold", MarigoldEntity::new, 0.7f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<PeashooterEntity>> PEASHOOTER = register("peashooter", PeashooterEntity::new, 0.5f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<SnowPeaEntity>> SNOW_PEA = register("snow_pea", SnowPeaEntity::new, 0.5f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<RepeaterEntity>> REPEATER = register("repeater", RepeaterEntity::new, 0.5f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<WallNutEntity>> WALL_NUT = register("wall_nut", WallNutEntity::new, 0.8f, 1.3f);
    public static final DeferredHolder<EntityType<?>, EntityType<PotatoMineEntity>> POTATO_MINE = register("potato_mine", PotatoMineEntity::new, 0.7f, 0.7f);
    public static final DeferredHolder<EntityType<?>, EntityType<ChomperEntity>> CHOMPER = register("chomper", ChomperEntity::new, 1f, 1.65f);
    public static final DeferredHolder<EntityType<?>, EntityType<BonkChoyEntity>> BONK_CHOY = register("bonk_choy", BonkChoyEntity::new, 1f, 1f);
    public static final DeferredHolder<EntityType<?>, EntityType<SunShroomEntity>> SUN_SHROOM = register("sun_shroom", SunShroomEntity::new, 0.7f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<PuffShroomEntity>> PUFF_SHROOM = register("puff_shroom", PuffShroomEntity::new, 0.5f, 0.5f);
    public static final DeferredHolder<EntityType<?>, EntityType<DoomShroomEntity>> DOOM_SHROOM = register("doom_shroom", DoomShroomEntity::new, 0.7f, 1f);

    public static final DeferredHolder<EntityType<?>, EntityType<ZombieWolfEntity>> ZOMBIE_WOLF = register("zombie_wolf", ZombieWolfEntity::new, 0.7f, 1f);

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        AttributeSupplier.Builder sproutAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99);

        AttributeSupplier.Builder sunflowerAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99);

        AttributeSupplier.Builder marigoldAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99);

        AttributeSupplier.Builder peashooterAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 9);

        AttributeSupplier.Builder snowPeashooterAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 9);

        AttributeSupplier.Builder repeaterAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 9);

        AttributeSupplier.Builder wallNutAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 216)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99);

        AttributeSupplier.Builder potatoMineAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 1);

        AttributeSupplier.Builder chomperAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 350)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 2);

        AttributeSupplier.Builder bonkChoyAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 2);

        AttributeSupplier.Builder puffShroomAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 4);

        AttributeSupplier.Builder doomShroomAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 1);

        event.put(BnDEntities.SPROUT.get(), sproutAttributes.build());
        event.put(BnDEntities.SUNFLOWER.get(), sunflowerAttributes.build());
        event.put(BnDEntities.MARIGOLD.get(), marigoldAttributes.build());
        event.put(BnDEntities.PEASHOOTER.get(), peashooterAttributes.build());
        event.put(BnDEntities.SNOW_PEA.get(), snowPeashooterAttributes.build());
        event.put(BnDEntities.REPEATER.get(), repeaterAttributes.build());
        event.put(BnDEntities.WALL_NUT.get(), wallNutAttributes.build());
        event.put(BnDEntities.POTATO_MINE.get(), potatoMineAttributes.build());
        event.put(BnDEntities.CHOMPER.get(), chomperAttributes.build());
        event.put(BnDEntities.BONK_CHOY.get(), bonkChoyAttributes.build());
        event.put(BnDEntities.SUN_SHROOM.get(), sunflowerAttributes.build());
        event.put(BnDEntities.PUFF_SHROOM.get(), puffShroomAttributes.build());
        event.put(BnDEntities.DOOM_SHROOM.get(), doomShroomAttributes.build());
        event.put(BnDEntities.ZOMBIE_WOLF.get(), ZombieWolfEntity.createAttributes().build());
    }

    public static final Supplier<EntityType<PeaProjectile>> PEA_PROJECTILE = ENTITY_TYPES.register("pea", () -> (
            EntityType.Builder.<PeaProjectile>of(PeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(16)
                    .build("pea")));

    public static final Supplier<EntityType<FrozenPeaProjectile>> FROZEN_PEA_PROJECTILE = ENTITY_TYPES.register("frozen_pea", () -> (
            EntityType.Builder.<FrozenPeaProjectile>of(FrozenPeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(16)
                    .build("frozen_pea")));

    public static final Supplier<EntityType<SporeProjectile>> SPORE_PROJECTILE = ENTITY_TYPES.register("spore", () -> (
            EntityType.Builder.<SporeProjectile>of(SporeProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(16)
                    .build("spore")));

    private static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.EntityFactory<T> entity, float width, float height) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
    }
}
