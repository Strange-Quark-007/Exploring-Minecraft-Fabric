package strangequark.exploringfabric.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModVegetationGeneration.generateVegetation();
        ModEntitySpawns.addSpawns();
    }
}
