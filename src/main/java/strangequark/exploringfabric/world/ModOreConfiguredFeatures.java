package strangequark.exploringfabric.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import strangequark.exploringfabric.block.ModBlocks;

import java.util.List;

public class ModOreConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET = ModConfiguredFeatures.of("ore_pink_garnet");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_NETHER = ModConfiguredFeatures.of("ore_pink_garnet_nether");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_END = ModConfiguredFeatures.of("ore_pink_garnet_end");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new BlockMatchRuleTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldPinkGarnetOres = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.PINK_GARNET_DEEPSLATE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> netherPinkGarnetOres = List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.PINK_GARNET_NETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endPinkGarnetOres = List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.PINK_GARNET_END_ORE.getDefaultState()));

        ModConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET, Feature.ORE, new OreFeatureConfig(overworldPinkGarnetOres, 12));
        ModConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_NETHER, Feature.ORE, new OreFeatureConfig(netherPinkGarnetOres, 12));
        ModConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_END, Feature.ORE, new OreFeatureConfig(endPinkGarnetOres, 12));
    }
}
