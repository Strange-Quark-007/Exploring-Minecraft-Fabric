package strangequark.exploringfabric.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import strangequark.exploringfabric.world.feature.placed.ModOrePlacedFeatures;
import strangequark.exploringfabric.world.feature.placed.ModTreePlacedFeatures;
import strangequark.exploringfabric.world.feature.placed.ModVegetationPlacedFeatures;

import java.util.List;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModPlacedFeatures {
    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        ModOrePlacedFeatures.bootstrap(featureRegisterable);
        ModTreePlacedFeatures.bootstrap(featureRegisterable);
        ModVegetationPlacedFeatures.bootstrap(featureRegisterable);
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }

    public static RegistryKey<PlacedFeature> of(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, createIdentifier(name));
    }
}
