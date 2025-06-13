package com.x29naybla.bloom_and_doom.common.registry;

import com.mojang.serialization.Codec;
import com.x29naybla.bloom_and_doom.BloomAndDoom;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, BloomAndDoom.MOD_ID);

    public static final Supplier<AttachmentType<Boolean>> ZOMBIE = ATTACHMENT_TYPES.register("zombie",
            () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).copyOnDeath().build());

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
