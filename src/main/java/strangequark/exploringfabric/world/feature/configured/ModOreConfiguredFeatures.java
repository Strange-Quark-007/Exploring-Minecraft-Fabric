package strangequark.exploringfabric.world.feature.configured;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.world.feature.ModConfiguredFeatures;

import java.util.List;

public class ModOreConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET = ModConfiguredFeatures.of("ore_pink_garnet");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_NETHER = ModConfiguredFeatures.of("ore_pink_garnet_nether");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_END = ModConfiguredFeatures.of("ore_pink_garnet_end");

    public static void bootstrap(BootstrapContext<net.minecraft.world.level.levelgen.feature.ConfiguredFeature<?, ?>> featureRegisterable) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldPinkGarnetOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.PINK_GARNET_DEEPSLATE_ORE.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> netherPinkGarnetOres = List.of(OreConfiguration.target(netherReplaceables, ModBlocks.PINK_GARNET_NETHER_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endPinkGarnetOres = List.of(OreConfiguration.target(endReplaceables, ModBlocks.PINK_GARNET_END_ORE.defaultBlockState()));

        ModConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET, Feature.ORE, new OreConfiguration(overworldPinkGarnetOres, 12));
        ModConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_NETHER, Feature.ORE, new OreConfiguration(netherPinkGarnetOres, 12));
        ModConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_END, Feature.ORE, new OreConfiguration(endPinkGarnetOres, 12));
    }
}
