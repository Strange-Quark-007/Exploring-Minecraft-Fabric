package strangequark.exploringfabric.world.feature.configured;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.world.feature.ModConfiguredFeatures;

public class ModTreeConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_DRIFTWOOD = ModConfiguredFeatures.of("trees_driftwood");

    private static TreeConfiguration.TreeConfigurationBuilder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder driftwood() {
        return builder(ModBlocks.DRIFTWOOD_LOG, ModBlocks.DRIFTWOOD_LEAVES, 5, 2, 0, 2).ignoreVines();
    }

    public static void bootstrap(BootstrapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> featureRegisterable) {
        ModConfiguredFeatures.register(featureRegisterable, TREES_DRIFTWOOD, Feature.TREE, driftwood().build());
    }
}
