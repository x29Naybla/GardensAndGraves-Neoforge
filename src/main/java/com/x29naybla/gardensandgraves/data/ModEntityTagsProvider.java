package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.entity.ModEntities;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
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

        tag(ModTags.Entities.PLANTS)
                .addTag(ModTags.Entities.FLOWERS)
                .addTag(ModTags.Entities.PEASHOOTERS)
                .add(ModEntities.WALL_NUT.get());

        //Minecraft Tags
        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)
                .add(ModEntities.SNOW_PEA.get());
    }
}
