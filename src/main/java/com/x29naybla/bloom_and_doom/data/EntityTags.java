package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import com.x29naybla.bloom_and_doom.common.registry.BnDEntities;
import com.x29naybla.bloom_and_doom.common.tag.BnDTags;
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
        tag(BnDTags.Entities.FLOWERS)
                .add(BnDEntities.SUNFLOWER.get())
                .add(BnDEntities.MARIGOLD.get());

        tag(BnDTags.Entities.PEASHOOTERS)
                .add(BnDEntities.PEASHOOTER.get())
                .add(BnDEntities.SNOW_PEA.get())
                .add(BnDEntities.REPEATER.get());

        tag(BnDTags.Entities.MUSHROOMS)
                .add(BnDEntities.SUN_SHROOM.get())
                .add(BnDEntities.PUFF_SHROOM.get())
                .add(BnDEntities.DOOM_SHROOM.get());

        tag(BnDTags.Entities.PLANTS)
                .add(BnDEntities.SPROUT.get())
                .addTag(BnDTags.Entities.FLOWERS)
                .addTag(BnDTags.Entities.PEASHOOTERS)
                .add(BnDEntities.WALL_NUT.get())
                .add(BnDEntities.POTATO_MINE.get())
                .add(BnDEntities.CHOMPER.get())
                .add(BnDEntities.BONK_CHOY.get())
                .addTag(BnDTags.Entities.MUSHROOMS);

        tag(BnDTags.Entities.POTTABLE_PLANTS)
                .add(BnDEntities.SPROUT.get())
                .add(BnDEntities.SUNFLOWER.get())
                .add(BnDEntities.MARIGOLD.get())
                .add(BnDEntities.PEASHOOTER.get())
                .add(BnDEntities.SNOW_PEA.get())
                .add(BnDEntities.REPEATER.get())
                .add(BnDEntities.POTATO_MINE.get())
                .add(BnDEntities.SUN_SHROOM.get())
                .add(BnDEntities.PUFF_SHROOM.get());

        tag(BnDTags.Entities.PLANT_ENEMIES)
                .addTag(EntityTypeTags.UNDEAD)
                .addTag(EntityTypeTags.ARTHROPOD)
                .remove(EntityType.BEE);

        tag(BnDTags.Entities.PLANT_ALLAYS)
                .addTag(BnDTags.Entities.PLANTS)
                .add(EntityType.BEE)
                .add(EntityType.VILLAGER)
                .add(EntityType.WANDERING_TRADER)
                .add(EntityType.IRON_GOLEM)
                .add(EntityType.SNOW_GOLEM);

        //Minecraft Tags
        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)
                .add(BnDEntities.SNOW_PEA.get());

        tag(EntityTypeTags.ZOMBIES)
                .add(BnDEntities.ZOMBIE_WOLF.get());
    }
}
