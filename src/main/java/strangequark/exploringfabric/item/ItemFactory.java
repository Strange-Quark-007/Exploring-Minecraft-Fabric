package strangequark.exploringfabric.item;

import net.minecraft.world.item.Item;

@FunctionalInterface
public interface ItemFactory<T extends Item> {
    T create(Item.Properties properties);
}
