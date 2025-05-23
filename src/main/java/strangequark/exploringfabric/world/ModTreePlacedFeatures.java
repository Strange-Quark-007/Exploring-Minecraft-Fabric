package strangequark.exploringfabric.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import strangequark.exploringfabric.block.ModBlocks;

public class ModTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> TREES_DRIFTWOOD = ModPlacedFeatures.of("trees_driftwood");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        var configuredFeatures = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(featureRegisterable, TREES_DRIFTWOOD,
                configuredFeatures.getOrThrow(ModTreeConfiguredFeatures.TREES_DRIFTWOOD),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), ModBlocks.DRIFTWOOD_SAPLING)
        );
    }
}
