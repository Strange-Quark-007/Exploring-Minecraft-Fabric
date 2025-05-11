package strangequark.exploringfabric;

import net.fabricmc.api.ClientModInitializer;
import strangequark.exploringfabric.tooltip.ModTooltips;

public class ExploringFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModTooltips.registerModTooltips();
    }
}
