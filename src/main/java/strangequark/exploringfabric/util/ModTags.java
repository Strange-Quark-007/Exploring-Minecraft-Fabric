package strangequark.exploringfabric.util;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL = createTag("needs_pink_garnet_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool");
        public static final TagKey<Block> HAMMER_MINEABLE = createTag("hammer_mineable");
        public static final TagKey<Block> TOMAHAWK_BREAKABLE = createTag("tomahawk_breakable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, createIdentifier(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> PINK_GARNET_REPAIR = createTag("pink_garnet_repair");

        public static final TagKey<Item> PINK_GARNET_ARMOR = createTag("pink_garnet_armor");
        public static final TagKey<Item> NETHERITE_ARMOR = createTag("netherite_armor");

        public static final TagKey<Item> LIGHTNING_STRIKER_ENCHANTABLE = createTag("lightning_striker_enchantable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, createIdentifier(name));
        }
    }
}
