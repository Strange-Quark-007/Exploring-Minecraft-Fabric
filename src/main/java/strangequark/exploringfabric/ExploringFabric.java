package strangequark.exploringfabric;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.item.ModItemGroups;
import strangequark.exploringfabric.item.ModItems;

public class ExploringFabric implements ModInitializer {
    public static final String MOD_ID = "exploringfabric";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
    }
}