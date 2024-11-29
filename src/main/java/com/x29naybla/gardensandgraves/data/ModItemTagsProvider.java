package com.x29naybla.gardensandgraves.data;

import com.x29naybla.gardensandgraves.GardensAndGraves;
import com.x29naybla.gardensandgraves.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, GardensAndGraves.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //Gardens and Graves Tags
        tag(ModTags.Items.SEED_PACKET_PEASHOOTERS)
                .add(ModItems.SEED_PACKET_PEASHOOTER.get())
                .add(ModItems.SEED_PACKET_REPEATER.get())
                .add(ModItems.SEED_PACKET_SNOW_PEA.get());

        tag(ModTags.Items.SEED_PACKET_MUSHROOMS)
                .add(ModItems.SEED_PACKET_SUN_SHROOM.get())
                .add(ModItems.SEED_PACKET_PUFF_SHROOM.get())
                .add(ModItems.SEED_PACKET_FUME_SHROOM.get())
                .add(ModItems.SEED_PACKET_DOOM_SHROOM.get());

    }
}
