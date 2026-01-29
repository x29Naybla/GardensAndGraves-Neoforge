package com.x29naybla.bloom_and_doom.client;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.RepositorySource;
import net.neoforged.neoforgespi.locating.IModFile;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

public class HiResPackSource implements RepositorySource {
    private final IModFile modFile;
    private final PackType type;
    private final Component packName;
    private final String packId;

    public HiResPackSource(IModFile modFile, PackType type, String packId, Component packName) {
        this.modFile = modFile;
        this.type = type;
        this.packId = packId;
        this.packName = packName;
    }



    @Override
    public void loadPacks(Consumer<Pack> consumer) {
        Path packPath = modFile.findResource(type == PackType.CLIENT_RESOURCES ? "resourcepacks" : "datapacks").resolve(packId);

        PackLocationInfo locationInfo = new PackLocationInfo(packId, packName, PackSource.BUILT_IN, Optional.empty());
        PackSelectionConfig selectionConfig = new PackSelectionConfig(false, Pack.Position.TOP, false);
        Pack.ResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(packPath);
        Pack pack = Pack.readMetaAndCreate(locationInfo, resourcesSupplier, type, selectionConfig);
        if (pack != null) {
            consumer.accept(pack);
        }
    }
}
