package strangequark.exploringfabric.world.feature;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import strangequark.exploringfabric.world.feature.placed.ModOrePlacedFeatures;
import strangequark.exploringfabric.world.feature.placed.ModTreePlacedFeatures;
import strangequark.exploringfabric.world.feature.placed.ModVegetationPlacedFeatures;

import java.util.List;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModPlacedFeatures {
    public static void bootstrap(BootstrapContext<PlacedFeature> featureRegisterable) {
        ModOrePlacedFeatures.bootstrap(featureRegisterable);
        ModTreePlacedFeatures.bootstrap(featureRegisterable);
        ModVegetationPlacedFeatures.bootstrap(featureRegisterable);
    }

    public static void register(
            BootstrapContext<PlacedFeature> featureRegisterable,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            BootstrapContext<PlacedFeature> featureRegisterable,
            ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }

    public static ResourceKey<PlacedFeature> of(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, createIdentifier(name));
    }
}
