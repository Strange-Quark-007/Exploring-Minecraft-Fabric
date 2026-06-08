package strangequark.exploringfabric.trim;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> PINK_GARNET = of("pink_garnet");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, PINK_GARNET, Style.EMPTY.withColor(TextColor.parseColor("#b03fe0").getOrThrow()), ModTrimAssets.PINK_GARNET);
    }
    
    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Style style, MaterialAssetGroup assets) {
        Component text = Component.translatable(Util.makeDescriptionId("trim_material", key.identifier())).withStyle(style);
        context.register(key, new TrimMaterial(assets, text));
    }

    private static ResourceKey<TrimMaterial> of(String id) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, createIdentifier(id));
    }
}