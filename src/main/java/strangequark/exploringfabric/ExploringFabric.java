package strangequark.exploringfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.component.ModDataComponentTypes;
import strangequark.exploringfabric.effect.ArmourEffectHandler;
import strangequark.exploringfabric.item.ModItemGroups;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.sound.ModSounds;
import strangequark.exploringfabric.util.HammerUsageEvent;

public class ExploringFabric implements ModInitializer {
    public static final String MOD_ID = "exploringfabric";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModDataComponentTypes.registerDataComponentTypes();
        ModSounds.registerSounds();

        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.2f);
        FuelRegistryEvents.BUILD.register((builder, context) -> builder.add(ModItems.STARLIGHT_ASHES, 4 * 10 * 20));

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

        ServerTickEvents.END_SERVER_TICK.register(new ArmourEffectHandler());
    }
}