package com.x29naybla.bloom_and_doom.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class AlmanacScreen extends Screen {
    public static final ResourceLocation ALMANAC_BACKGROUND_RIGHT = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/gui/almanac/almanac_background_right.png");
    public static final ResourceLocation ALMANAC_BACKGROUND_LEFT = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/gui/almanac/almanac_background_left.png");

    public AlmanacScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.minecraft == null)
            return;

        this.renderTransparentBackground(guiGraphics);
        guiGraphics.blit(ALMANAC_BACKGROUND_RIGHT, ((this.width - 140) / 2) + 70, 2, 0, 0, 140, 192);
        guiGraphics.blit(ALMANAC_BACKGROUND_LEFT, ((this.width - 140) / 2) - 70, 2, 0, 0, 140, 192);
    }

    protected void closeScreen() {
        this.minecraft.setScreen(null);
    }
}
