package com.x29naybla.bloom_and_doom.client.gui;

import net.minecraft.client.gui.GuiGraphics;

import java.awt.*;

public class PlantLabelsPage extends AlmanacPage {
    private static final Rectangle PLANT_LABEL = new Rectangle(160, 1, 84, 14);
    private static final Rectangle SUNFLOWER_ICON = new Rectangle(160, 16, 12, 12);

    public PlantLabelsPage(String ModID, String background) {
        super(ModID, background);
    }

    @Override
    public void render(GuiGraphics guiGraphics) {
        if(!background.getPath().equals("null")) {
            guiGraphics.blit(background, ((guiGraphics.guiWidth() - 140) / 2) - 63, 10, 0, 0, 133, 165);
        }

        guiGraphics.blit(this.background, ((guiGraphics.guiWidth() - 140) / 2) - 46, 35 + 10, PLANT_LABEL.x, PLANT_LABEL.y, PLANT_LABEL.width, PLANT_LABEL.height);
        guiGraphics.blit(this.background, ((guiGraphics.guiWidth() - 140) / 2) - 45, 35 + 10 + 1, SUNFLOWER_ICON.x, SUNFLOWER_ICON.y, SUNFLOWER_ICON.width, SUNFLOWER_ICON.height);
    }
}
