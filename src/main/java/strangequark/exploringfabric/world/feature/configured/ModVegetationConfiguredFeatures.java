package strangequark.exploringfabric.world.feature.configured;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.block.custom.HoneyBerryBushBlock;
import strangequark.exploringfabric.world.feature.ModConfiguredFeatures;

import java.util.List;

public class ModVegetationConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> HONEY_BERRY_BUSH = ModConfiguredFeatures.of("honey_berry_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ModConfiguredFeatures.register(featureRegisterable, HONEY_BERRY_BUSH, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HONEY_BERRY_BUSH.getDefaultState().with(HoneyBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );
    }
}
