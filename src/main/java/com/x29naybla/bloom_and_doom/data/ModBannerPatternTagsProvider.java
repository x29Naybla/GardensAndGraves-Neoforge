package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBannerPatternTagsProvider extends BannerPatternTagsProvider {
    public ModBannerPatternTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BloomAndDoom.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider){
        tag(ModTags.BannerPatterns.BRAINZ)
                .add();
    }
}
