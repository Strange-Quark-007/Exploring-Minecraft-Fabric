package strangequark.exploringfabric.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import strangequark.exploringfabric.entity.ModEntities;

public class ModEntitySpawns {
    public static void addSpawns() {
        var mantis = ModEntities.MANTIS;
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.CHERRY_GROVE, BiomeKeys.GROVE, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SNOWY_TAIGA, BiomeKeys.SNOWY_PLAINS),
                SpawnGroup.CREATURE, mantis, 30, 1, 3);

        SpawnRestriction.register(mantis, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
