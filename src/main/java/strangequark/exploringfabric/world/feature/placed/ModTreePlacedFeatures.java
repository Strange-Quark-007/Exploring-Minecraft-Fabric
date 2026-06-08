package strangequark.exploringfabric.world.feature.placed;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.UnknownNullability;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.world.feature.ModPlacedFeatures;
import strangequark.exploringfabric.world.feature.configured.ModTreeConfiguredFeatures;

public class ModTreePlacedFeatures {
    public static final ResourceKey<PlacedFeature> TREES_DRIFTWOOD = ModPlacedFeatures.of("trees_driftwood");

    public static void bootstrap(@UnknownNullability BootstrapContext<PlacedFeature> featureRegisterable) {
        var configuredFeatures = featureRegisterable.lookup(Registries.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(featureRegisterable, TREES_DRIFTWOOD,
                configuredFeatures.getOrThrow(ModTreeConfiguredFeatures.TREES_DRIFTWOOD),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1), ModBlocks.DRIFTWOOD_SAPLING)
        );
    }
}
