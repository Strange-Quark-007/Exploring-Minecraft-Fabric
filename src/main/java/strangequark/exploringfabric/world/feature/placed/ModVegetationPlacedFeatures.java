package strangequark.exploringfabric.world.feature.placed;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import org.jetbrains.annotations.UnknownNullability;
import strangequark.exploringfabric.world.feature.ModPlacedFeatures;
import strangequark.exploringfabric.world.feature.configured.ModVegetationConfiguredFeatures;

public class ModVegetationPlacedFeatures {
    public static final ResourceKey<PlacedFeature> HONEY_BERRY_BUSH = ModPlacedFeatures.of("honey_berry_bush");

    public static void bootstrap(@UnknownNullability BootstrapContext<PlacedFeature> featureRegisterable) {
        var configuredFeatures = featureRegisterable.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(
                featureRegisterable,
                HONEY_BERRY_BUSH,
                configuredFeatures.getOrThrow(ModVegetationConfiguredFeatures.HONEY_BERRY_BUSH),
                RarityFilter.onAverageOnceEvery(32),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        );
    }
}
