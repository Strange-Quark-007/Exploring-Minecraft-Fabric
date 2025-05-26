package strangequark.exploringfabric.world.feature.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import strangequark.exploringfabric.world.feature.ModPlacedFeatures;
import strangequark.exploringfabric.world.feature.configured.ModVegetationConfiguredFeatures;

public class ModVegetationPlacedFeatures {
    public static final RegistryKey<PlacedFeature> HONEY_BERRY_BUSH = ModPlacedFeatures.of("honey_berry_bush");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        var configuredFeatures = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        PlacedFeatures.register(
                featureRegisterable,
                HONEY_BERRY_BUSH,
                configuredFeatures.getOrThrow(ModVegetationConfiguredFeatures.HONEY_BERRY_BUSH),
                RarityFilterPlacementModifier.of(32),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
    }
}
