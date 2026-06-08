package strangequark.exploringfabric.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import strangequark.exploringfabric.world.feature.placed.ModVegetationPlacedFeatures;

public class ModVegetationGeneration {
    public static void generateVegetation() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS, Biomes.FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacedFeatures.HONEY_BERRY_BUSH);
    }
}
