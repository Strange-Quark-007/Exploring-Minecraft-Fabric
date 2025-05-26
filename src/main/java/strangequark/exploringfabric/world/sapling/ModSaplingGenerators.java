package strangequark.exploringfabric.world.sapling;

import net.minecraft.block.SaplingGenerator;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.world.feature.configured.ModTreeConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DRIFTWOOD = new SaplingGenerator(
            ExploringFabric.MOD_ID + ":driftwood", Optional.empty(), Optional.of(ModTreeConfiguredFeatures.TREES_DRIFTWOOD), Optional.empty()
    );
}
