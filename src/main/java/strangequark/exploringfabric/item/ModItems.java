package strangequark.exploringfabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.NotNull;
import strangequark.exploringfabric.ExploringFabric;

import static strangequark.exploringfabric.utils.ModIdentifier.createIdentifier;
import static strangequark.exploringfabric.utils.ModRegistryKeys.Items.createRegistryKey;

public class ModItems {
    public static final Item RAW_PINK_GARNET = createItem("raw_pink_garnet", Item::new);
    public static final Item PINK_GARNET = createItem("pink_garnet", Item::new);

    public static <T extends Item> T createItem(String name, @NotNull ItemFactory<T> itemCreator) {
        Item.Settings settings = new Item.Settings().registryKey(createRegistryKey(name));
        return registerItem(name, itemCreator.create(settings));
    }

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, createIdentifier(name), item);
    }

    public static void registerModItems() {
        ExploringFabric.LOGGER.info("Registering Mod Items for " + ExploringFabric.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
