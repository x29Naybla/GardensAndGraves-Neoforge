package com.x29naybla.gardensandgraves.block;

import net.minecraft.util.StringRepresentable;

public enum Substrate implements StringRepresentable {
    EMPTY("empty"),
    DIRT("dirt"),
    MYCELIUM("mycelium"),
    SAND("sand"),
    RED_SAND("red_sand"),
    SOUL_SAND("soul_sand");

    private final String name;

    private Substrate(String name){
        this.name = name;
    }

    public String toString() {
        return this.getSerializedName();
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}