package com.x29naybla.bloom_and_doom.client.gui;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AlmanacScreen extends Screen {
    public static final ResourceLocation ALMANAC_BACKGROUND = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/gui/almanac/almanac_background.png");
    protected static final int IMAGE_WIDTH = 336;
    protected static final int IMAGE_HEIGHT = 192;

    protected AlmanacScreen(Component title) {
        super(title);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderTransparentBackground(guiGraphics);
        guiGraphics.blit(ALMANAC_BACKGROUND, (this.width - IMAGE_WIDTH) / 2, 2, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    }

    protected void closeScreen() {
        this.minecraft.setScreen(null);
    }
}
