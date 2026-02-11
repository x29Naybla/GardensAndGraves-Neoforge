package com.x29naybla.bloom_and_doom.data;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BloomAndDoom.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BNDBlockLoot::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(event.includeServer(), new BnDRecipeProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new BlockTags(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        generator.addProvider(event.includeServer(), new ItemTags(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new EntityTags(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeClient(), new AdvancementProvider(packOutput, lookupProvider, existingFileHelper, List.of(new BnDAdvancementGenerator())));

        generator.addProvider(event.includeClient(), new BnDItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BnDBlockStateProvider(packOutput, existingFileHelper));
    }
}
