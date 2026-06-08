package strangequark.exploringfabric.world.feature.configured;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.block.custom.HoneyBerryBushBlock;
import strangequark.exploringfabric.world.feature.ModConfiguredFeatures;

import java.util.List;

public class ModVegetationConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HONEY_BERRY_BUSH = ModConfiguredFeatures.of("honey_berry_bush");

    public static void bootstrap(BootstrapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> featureRegisterable) {
        ModConfiguredFeatures.register(featureRegisterable, HONEY_BERRY_BUSH, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HONEY_BERRY_BUSH.defaultBlockState().setValue(HoneyBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );
    }
}
