package com.x29naybla.bloom_and_doom.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class AlmanacScreen extends Screen {
    private AlmanacPage lPage;
    private AlmanacPage rPage;
    public static final ResourceLocation ALMANAC_BACKGROUND_RIGHT = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/gui/almanac/almanac_background_right.png");
    public static final ResourceLocation ALMANAC_BACKGROUND_LEFT = ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "textures/gui/almanac/almanac_background_left.png");

    public AlmanacScreen(Component title) {
        super(title);
    }

    Map<String, AlmanacPage> left_pages = new HashMap<>();
    {
        left_pages.put("starting_page", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        left_pages.put("plant_labels", new PlantLabelsPage(BloomAndDoom.MOD_ID, "textures/gui/almanac/almanac_plants.png"));
    }

    Map<String, AlmanacPage> right_pages = new HashMap<>();
    {
        right_pages.put("starting_page", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("plant_labels", new PlantLabelsPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("sunflower", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("marigold", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("peashooter", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("snow_pea", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("repeater", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("wall_nut", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("potato_mine", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("chomper", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("sun_shroom", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("puff_shroom", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
        right_pages.put("doom_shroom", new AlmanacPage(BloomAndDoom.MOD_ID, "null"));
    }

    @Override
    protected void init() {
        this.createMenuControls();
        this.lPage = left_pages.get("starting_page");
        this.rPage = right_pages.get("starting_page");
    }

    protected void createMenuControls() {
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, p_315823_ -> this.onClose()).bounds(this.width / 2 - 50, 196, 100, 20).build());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    public void setPages(AlmanacPage leftPage, AlmanacPage rightPage) {
        this.lPage = leftPage;
        this.rPage = rightPage;
        this.clearWidgets();
        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, p_315823_ -> this.onClose()).bounds(this.width / 2 - 50, 196, 100, 20).build());
    }

    @Override
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Button plantsButton = Button.builder(Component.translatable(BloomAndDoom.MOD_ID + ".gui.almanac.button.plants"), p_315823_ -> this.setPages(left_pages.get("plant_labels"), right_pages.get("plant_labels"))).bounds(this.width / 2 - 100, 78, 70, 20).build();
        Button zombiesButton = Button.builder(Component.translatable(BloomAndDoom.MOD_ID + ".gui.almanac.button.zombies"), p_315823_ -> this.onClose()).bounds(this.width / 2 + 30, 78, 70, 20).build();

        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.minecraft == null)
            return;

        this.renderTransparentBackground(guiGraphics);
        guiGraphics.blit(ALMANAC_BACKGROUND_RIGHT, ((this.width - 140) / 2) + 70, 2, 0, 0, 140, 192);
        guiGraphics.blit(ALMANAC_BACKGROUND_LEFT, ((this.width - 140) / 2) - 70, 2, 0, 0, 140, 192);

        lPage.render(guiGraphics);
        rPage.render(guiGraphics);

        if (lPage == left_pages.get("starting_page")) {
            this.addRenderableWidget(plantsButton);
            this.addRenderableWidget(zombiesButton);
        }

        if (lPage == left_pages.get("plant_labels")) {
            left_pages.get("plant_labels").render(guiGraphics);
        }
    }
}
