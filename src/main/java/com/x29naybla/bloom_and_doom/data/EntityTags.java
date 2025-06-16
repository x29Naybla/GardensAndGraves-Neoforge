package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.ModEntities;
import com.x29naybla.bloom_and_doom.common.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EntityTags extends EntityTypeTagsProvider {
    public EntityTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BloomAndDoom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        //Bloom and Doom Tags
        tag(ModTags.Entities.FLOWERS)
                .add(ModEntities.SUNFLOWER.get())
                .add(ModEntities.MARIGOLD.get());

        tag(ModTags.Entities.PEASHOOTERS)
                .add(ModEntities.PEASHOOTER.get())
                .add(ModEntities.SNOW_PEA.get())
                .add(ModEntities.REPEATER.get());

        tag(ModTags.Entities.MUSHROOMS)
                .add(ModEntities.SUN_SHROOM.get())
                .add(ModEntities.PUFF_SHROOM.get())
                .add(ModEntities.DOOM_SHROOM.get());

        tag(ModTags.Entities.PLANTS)
                .addTag(ModTags.Entities.FLOWERS)
                .addTag(ModTags.Entities.PEASHOOTERS)
                .add(ModEntities.WALL_NUT.get())
                .add(ModEntities.POTATO_MINE.get())
                //.add(ModEntities.CHOMPER.get())
                .addTag(ModTags.Entities.MUSHROOMS);

        tag(ModTags.Entities.POTTABLE_PLANTS)
                .add(ModEntities.SUNFLOWER.get())
                .add(ModEntities.MARIGOLD.get())
                .add(ModEntities.PEASHOOTER.get())
                .add(ModEntities.SNOW_PEA.get())
                .add(ModEntities.REPEATER.get())
                .add(ModEntities.POTATO_MINE.get())
                .add(ModEntities.SUN_SHROOM.get())
                .add(ModEntities.PUFF_SHROOM.get());

        tag(ModTags.Entities.PLANT_ENEMIES)
                .addTag(EntityTypeTags.UNDEAD)
                .addTag(EntityTypeTags.ARTHROPOD)
                .remove(EntityType.BEE);

        tag(ModTags.Entities.PLANT_ALLAYS)
                .addTag(ModTags.Entities.PLANTS)
                .add(EntityType.BEE)
                .add(EntityType.VILLAGER)
                .add(EntityType.WANDERING_TRADER)
                .add(EntityType.IRON_GOLEM)
                .add(EntityType.SNOW_GOLEM);

        //Minecraft Tags
        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)
                .add(ModEntities.SNOW_PEA.get());
    }
}
