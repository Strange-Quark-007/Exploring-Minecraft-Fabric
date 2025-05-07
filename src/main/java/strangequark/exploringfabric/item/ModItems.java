package strangequark.exploringfabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import strangequark.exploringfabric.ExploringFabric;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(ExploringFabric.MOD_ID, "pink_garnet")))));
    
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                            Identifier.of(ExploringFabric.MOD_ID, "raw_pink_garnet")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExploringFabric.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExploringFabric.LOGGER.info("Registering Mod Items for " + ExploringFabric.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
