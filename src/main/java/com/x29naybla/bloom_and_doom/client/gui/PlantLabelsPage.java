package com.x29naybla.bloom_and_doom.client.gui;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class PlantLabelsPage extends AlmanacPage {
    private static final Rectangle PLANT_LABEL = new Rectangle(144, 1, 84, 14);
    private static final ResourceLocation SUNFLOWER_ICON = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/gui/almanac/plant_icons/sunflower.png");

    public PlantLabelsPage(String ModID, String background) {
        super(ModID, background);
    }

    @Override
    public void render(GuiGraphics guiGraphics) {
        if(!background.getPath().equals("null")) {
            guiGraphics.blit(background, ((guiGraphics.guiWidth() - 140) / 2) - 63, 10, 0, 0, 133, 165);
        }

        guiGraphics.blit(this.background, ((guiGraphics.guiWidth() - 140) / 2) - 46, 35 + 10, PLANT_LABEL.x, PLANT_LABEL.y, PLANT_LABEL.width, PLANT_LABEL.height);
        guiGraphics.blit(SUNFLOWER_ICON, ((guiGraphics.guiWidth() - 140) / 2) - 45, 35 + 10 + 1, 0, 0, 12, 12);
    }
}
