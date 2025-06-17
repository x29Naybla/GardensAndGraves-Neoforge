package com.x29naybla.bloom_and_doom.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class AlmanacPage {
    protected ResourceLocation background;

    public AlmanacPage(String ModID, String background){
        this.background = ResourceLocation.fromNamespaceAndPath(ModID, background);
    }

    public void render(GuiGraphics guiGraphics){
        if(!background.getPath().equals("null")) {
            guiGraphics.blit(background, ((guiGraphics.guiWidth() - 140) / 2) - 63, 10, 0, 0, 133, 165);
        }
    }
}
