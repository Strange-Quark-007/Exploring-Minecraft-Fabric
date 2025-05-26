package strangequark.exploringfabric.world.feature.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;
import strangequark.exploringfabric.world.feature.ModPlacedFeatures;
import strangequark.exploringfabric.world.feature.configured.ModOreConfiguredFeatures;

import java.util.List;

public class ModOrePlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORE_PINK_GARNET = ModPlacedFeatures.of("ore_pink_garnet");
    public static final RegistryKey<PlacedFeature> ORE_PINK_GARNET_NETHER = ModPlacedFeatures.of("ore_pink_garnet_nether");
    public static final RegistryKey<PlacedFeature> ORE_PINK_GARNET_END = ModPlacedFeatures.of("ore_pink_garnet_end");

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        var configuredFeatures = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(
                featureRegisterable, ORE_PINK_GARNET, configuredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_PINK_GARNET),
                modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-48), YOffset.fixed(256)))
        );
        ModPlacedFeatures.register(
                featureRegisterable, ORE_PINK_GARNET_NETHER, configuredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_PINK_GARNET_NETHER),
                modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(80)))
        );
        ModPlacedFeatures.register(
                featureRegisterable, ORE_PINK_GARNET_END, configuredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_PINK_GARNET_END),
                modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
        );
    }
}
