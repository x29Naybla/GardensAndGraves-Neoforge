package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GardensAndGraves.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Gardens and Graves Tags
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
                .addTag(ModTags.Entities.MUSHROOMS);

        tag(ModTags.Entities.PLANT_ENEMIES)
                .addTag(EntityTypeTags.UNDEAD)
                .addTag(EntityTypeTags.ARTHROPOD)
                .remove(EntityType.BEE);

        tag(ModTags.Entities.PLANTABLE_ON_DIRT)
                .addTag(ModTags.Entities.PLANTS);

        tag(ModTags.Entities.PLANTABLE_ON_MYCELIUM)
                .addTag(ModTags.Entities.PLANTABLE_ON_DIRT);

        tag(ModTags.Entities.PLANTABLE_ON_SANDS);

        tag(ModTags.Entities.PLANTABLE_ON_SOUL_SAND);

        tag(ModTags.Entities.PLANTABLE_ON_NYLIUM)
                .addTag(ModTags.Entities.MUSHROOMS);

        tag(ModTags.Entities.PLANTABLE_ON_END_STONE);

        //Minecraft Tags
        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)
                .add(ModEntities.SNOW_PEA.get());
    }
}
