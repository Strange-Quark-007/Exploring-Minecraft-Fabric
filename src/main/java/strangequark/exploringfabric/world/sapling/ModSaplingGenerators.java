package strangequark.exploringfabric.world.sapling;

import net.minecraft.world.level.block.grower.TreeGrower;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.world.feature.configured.ModTreeConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final TreeGrower DRIFTWOOD = new TreeGrower(
            ExploringFabric.MOD_ID + ":driftwood", Optional.empty(), Optional.of(ModTreeConfiguredFeatures.TREES_DRIFTWOOD), Optional.empty()
    );
}
