package strangequark.exploringfabric.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModRegistryKeys {
    public static class Items {
        public static RegistryKey<Item> createRegistryKey(String name) {
            return RegistryKey.of(RegistryKeys.ITEM, createIdentifier(name));
        }
    }

    public static class Blocks {
        public static RegistryKey<Block> createRegistryKey(String name) {
            return RegistryKey.of(RegistryKeys.BLOCK, createIdentifier(name));
        }
    }
}
