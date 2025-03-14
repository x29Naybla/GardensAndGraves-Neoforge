package com.x29naybla.gardensandgraves.entity;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.projectile.PeaProjectile;
import com.x29naybla.gardensandgraves.entity.projectile.SnowPeaProjectile;
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

@EventBusSubscriber(modid = GardensAndGraves.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, GardensAndGraves.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<SunflowerEntity>> SUNFLOWER = register("sunflower", SunflowerEntity::new, 0.7f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<MarigoldEntity>> MARIGOLD = register("marigold", MarigoldEntity::new, 0.7f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<PeashooterEntity>> PEASHOOTER = register("peashooter", PeashooterEntity::new, 0.5f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<SnowPeashooterEntity>> SNOW_PEASHOOTER = register("snow_peashooter", SnowPeashooterEntity::new, 0.5f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<RepeaterEntity>> REPEATER = register("repeater", RepeaterEntity::new, 0.5f, 0.9f);
    public static final DeferredHolder<EntityType<?>, EntityType<WallNutEntity>> WALL_NUT = register("wall_nut", WallNutEntity::new, 0.8f, 1.3f);

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        AttributeSupplier.Builder sunflowerAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99);

        AttributeSupplier.Builder marigoldAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99);

        AttributeSupplier.Builder peashooterAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.FOLLOW_RANGE,  8.5);

        AttributeSupplier.Builder snowPeashooterAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.FOLLOW_RANGE,  8.5);

        AttributeSupplier.Builder repeaterAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99)
                .add(Attributes.ATTACK_SPEED, 30)
                .add(Attributes.ATTACK_DAMAGE, 2)
                .add(Attributes.FOLLOW_RANGE,  8.5);

        AttributeSupplier.Builder wallNutAttributes = PathfinderMob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED,-99)
                .add(Attributes.MAX_HEALTH, 80)
                .add(Attributes.KNOCKBACK_RESISTANCE, 99);

        event.put(ModEntities.SUNFLOWER.get(), sunflowerAttributes.build());
        event.put(ModEntities.MARIGOLD.get(), marigoldAttributes.build());
        event.put(ModEntities.PEASHOOTER.get(), peashooterAttributes.build());
        event.put(ModEntities.SNOW_PEASHOOTER.get(), snowPeashooterAttributes.build());
        event.put(ModEntities.REPEATER.get(), repeaterAttributes.build());
        event.put(ModEntities.WALL_NUT.get(), wallNutAttributes.build());
    }

    public static final Supplier<EntityType<PeaProjectile>> PEA_PROJECTILE = ENTITY_TYPES.register("pea", () -> (
            EntityType.Builder.<PeaProjectile>of(PeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(16)
                    .build("pea")));

    public static final Supplier<EntityType<SnowPeaProjectile>> SNOW_PEA_PROJECTILE = ENTITY_TYPES.register("projectile_snow_pea", () -> (
            EntityType.Builder.<SnowPeaProjectile>of(SnowPeaProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(16)
                    .build("projectile_snow_pea")));

    private static <T extends Mob> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.EntityFactory<T> entity, float width, float height) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(entity, MobCategory.CREATURE).sized(width, height).build(name));
    }
}
