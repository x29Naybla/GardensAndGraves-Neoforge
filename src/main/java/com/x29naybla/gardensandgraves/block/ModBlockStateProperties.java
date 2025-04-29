package com.x29naybla.gardensandgraves.block;

import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ModBlockStateProperties {
    public static final EnumProperty<Substrate> SUBSTRATE;

    static{
        SUBSTRATE = EnumProperty.create("content", Substrate.class);
    }
}
