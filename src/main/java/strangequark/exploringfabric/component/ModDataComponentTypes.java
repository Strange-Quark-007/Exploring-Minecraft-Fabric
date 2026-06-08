package strangequark.exploringfabric.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import strangequark.exploringfabric.ExploringFabric;

import java.util.function.UnaryOperator;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModDataComponentTypes {
    public static final DataComponentType<BlockPos> COORDINATES = register("coordinates", builder -> builder.persistent(BlockPos.CODEC));
    public static final DataComponentType<Block> BLOCK = register("block", builder -> builder.persistent(BuiltInRegistries.BLOCK.byNameCodec()));

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                createIdentifier(name),
                builderUnaryOperator.apply(DataComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        ExploringFabric.LOGGER.info("Registering Data Component Types for " + ExploringFabric.MOD_ID);
    }
}