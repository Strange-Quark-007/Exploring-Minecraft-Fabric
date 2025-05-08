package strangequark.exploringfabric.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

@FunctionalInterface
public interface BlockFactory<T extends Block> {
    T create(AbstractBlock.Settings settings);
}
