package strangequark.exploringfabric.trim;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimPattern;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> QUARK = of("quark");

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, QUARK);
    }

    public static void register(BootstrapContext<TrimPattern> registry, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.identifier(), Component.translatable(Util.makeDescriptionId("trim_pattern", key.identifier())), false);
        registry.register(key, trimPattern);
    }

    private static ResourceKey<TrimPattern> of(String id) {
        return ResourceKey.create(Registries.TRIM_PATTERN, createIdentifier(id));
    }
}