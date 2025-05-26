package strangequark.exploringfabric.world.feature.configured;

import net.minecraft.block.Block;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.world.feature.ModConfiguredFeatures;

public class ModTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_DRIFTWOOD = ModConfiguredFeatures.of("trees_driftwood");

    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.of(leaves),
                new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeFeatureConfig.Builder driftwood() {
        return builder(ModBlocks.DRIFTWOOD_LOG, ModBlocks.DRIFTWOOD_LEAVES, 5, 2, 0, 2).ignoreVines();
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ModConfiguredFeatures.register(featureRegisterable, TREES_DRIFTWOOD, Feature.TREE, driftwood().build());
    }
}
