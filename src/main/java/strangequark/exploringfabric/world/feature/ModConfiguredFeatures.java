package strangequark.exploringfabric.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import strangequark.exploringfabric.world.feature.configured.ModOreConfiguredFeatures;
import strangequark.exploringfabric.world.feature.configured.ModTreeConfiguredFeatures;
import strangequark.exploringfabric.world.feature.configured.ModVegetationConfiguredFeatures;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModConfiguredFeatures {
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ModOreConfiguredFeatures.bootstrap(featureRegisterable);
        ModTreeConfiguredFeatures.bootstrap(featureRegisterable);
        ModVegetationConfiguredFeatures.bootstrap(featureRegisterable);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, createIdentifier(name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config
    ) {
        registerable.register(key, new ConfiguredFeature<>(feature, config));
    }
}
