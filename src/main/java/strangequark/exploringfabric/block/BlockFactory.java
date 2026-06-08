package strangequark.exploringfabric.block;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

@FunctionalInterface
public interface BlockFactory<T extends Block> {
    T create(BlockBehaviour.Properties properties);
}
