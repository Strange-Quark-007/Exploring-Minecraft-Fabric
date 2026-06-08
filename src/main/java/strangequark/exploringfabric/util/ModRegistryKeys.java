package strangequark.exploringfabric.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModRegistryKeys {
    public static class Items {
        public static ResourceKey<Item> createResourceKey(String name) {
            return ResourceKey.create(Registries.ITEM, createIdentifier(name));
        }
    }

    public static class Blocks {
        public static ResourceKey<Block> createResourceKey(String name) {
            return ResourceKey.create(Registries.BLOCK, createIdentifier(name));
        }
    }
}