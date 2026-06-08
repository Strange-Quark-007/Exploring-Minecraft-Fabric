package strangequark.exploringfabric.world.feature.placed;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.UnknownNullability;
import strangequark.exploringfabric.world.feature.ModPlacedFeatures;
import strangequark.exploringfabric.world.feature.configured.ModOreConfiguredFeatures;

import java.util.List;

public class ModOrePlacedFeatures {
    public static final ResourceKey<PlacedFeature> ORE_PINK_GARNET = ModPlacedFeatures.of("ore_pink_garnet");
    public static final ResourceKey<PlacedFeature> ORE_PINK_GARNET_NETHER = ModPlacedFeatures.of("ore_pink_garnet_nether");
    public static final ResourceKey<PlacedFeature> ORE_PINK_GARNET_END = ModPlacedFeatures.of("ore_pink_garnet_end");

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacement.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilter.onAverageOnceEvery(chance), heightModifier);
    }

    public static void bootstrap(@UnknownNullability BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(
                context, ORE_PINK_GARNET, configuredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_PINK_GARNET),
                modifiersWithCount(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(256)))
        );
        ModPlacedFeatures.register(
                context, ORE_PINK_GARNET_NETHER, configuredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_PINK_GARNET_NETHER),
                modifiersWithCount(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(80)))
        );
        ModPlacedFeatures.register(
                context, ORE_PINK_GARNET_END, configuredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_PINK_GARNET_END),
                modifiersWithCount(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)))
        );
    }
}
