package strangequark.exploringfabric.utils;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static strangequark.exploringfabric.utils.ModIdentifier.createIdentifier;

public class ModRegistryKeys {
    public static class Items {
        public static RegistryKey<Item> createRegistryKey(String name) {
            return RegistryKey.of(RegistryKeys.ITEM, createIdentifier(name));
        }
    }
}
