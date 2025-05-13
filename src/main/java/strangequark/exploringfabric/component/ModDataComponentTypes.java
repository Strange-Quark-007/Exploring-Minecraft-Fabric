package strangequark.exploringfabric.component;

import net.minecraft.block.Block;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.BlockPos;
import strangequark.exploringfabric.ExploringFabric;

import java.util.function.UnaryOperator;

import static strangequark.exploringfabric.utils.ModIdentifier.createIdentifier;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));
    public static final ComponentType<Block> BLOCK = register("block", builder -> builder.codec(Registries.BLOCK.getCodec()));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, createIdentifier(name), builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        ExploringFabric.LOGGER.info("Registering Data Component Types for " + ExploringFabric.MOD_ID);
    }
}