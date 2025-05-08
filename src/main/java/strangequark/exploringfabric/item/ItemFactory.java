package strangequark.exploringfabric.item;

import net.minecraft.item.Item;

@FunctionalInterface
public interface ItemFactory<T extends Item> {
    T create(Item.Settings settings);
}
