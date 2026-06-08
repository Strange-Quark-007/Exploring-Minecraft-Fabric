package strangequark.exploringfabric.world.feature;


import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import strangequark.exploringfabric.world.feature.configured.ModOreConfiguredFeatures;
import strangequark.exploringfabric.world.feature.configured.ModTreeConfiguredFeatures;
import strangequark.exploringfabric.world.feature.configured.ModVegetationConfiguredFeatures;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModConfiguredFeatures {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ModOreConfiguredFeatures.bootstrap(context);
        ModTreeConfiguredFeatures.bootstrap(context);
        ModVegetationConfiguredFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> of(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, createIdentifier(name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config
    ) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
