package strangequark.exploringfabric.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import strangequark.exploringfabric.world.feature.placed.ModTreePlacedFeatures;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS, Biomes.MEADOW), GenerationStep.Decoration.VEGETAL_DECORATION, ModTreePlacedFeatures.TREES_DRIFTWOOD);
    }
}
