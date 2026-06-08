package strangequark.exploringfabric.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import strangequark.exploringfabric.entity.ModEntities;

public class ModEntitySpawns {
    public static void addSpawns() {
        var mantis = ModEntities.MANTIS;
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.MEADOW, Biomes.BIRCH_FOREST, Biomes.CHERRY_GROVE, Biomes.GROVE, Biomes.MANGROVE_SWAMP, Biomes.SUNFLOWER_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_PLAINS),
                MobCategory.CREATURE, mantis, 30, 1, 3);

        SpawnPlacements.register(mantis, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }
}
