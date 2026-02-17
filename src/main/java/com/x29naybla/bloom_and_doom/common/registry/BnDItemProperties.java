package com.x29naybla.bloom_and_doom.common.registry;

import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;

public class BnDItemProperties {
    private static final ClampedItemPropertyFunction TRAFFIC_CONE_EQUIPPED = (stack, level, entity, i) -> {
        if (entity == null) {
            return 0.0F;
        } else {
            return entity.getItemBySlot(EquipmentSlot.HEAD) == stack ? 1.0F : 0.0F;
        }
    };

    public static void addCustomItemProperties() {
        ItemProperties.register(BnDBlocks.WHITE_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.LIGHT_GRAY_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.GRAY_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.BLACK_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.BROWN_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.RED_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.ORANGE_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.YELLOW_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.LIME_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.GREEN_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.CYAN_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.LIGHT_BLUE_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.BLUE_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.PURPLE_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.MAGENTA_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
        ItemProperties.register(BnDBlocks.PINK_TRAFFIC_CONE.asItem(), ResourceLocation.fromNamespaceAndPath(BloomAndDoom.MOD_ID, "equipped"), TRAFFIC_CONE_EQUIPPED);
    }
}
