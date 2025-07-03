package strangequark.exploringfabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.PINK_GARNET_NETHER_ORE)
                .add(ModBlocks.PINK_GARNET_END_ORE)
                .add(ModBlocks.MAGIC_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);

        valueLookupBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG)
                .add(ModBlocks.DRIFTWOOD_WOOD)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        valueLookupBuilder(ModTags.Blocks.HAMMER_MINEABLE)
                .addOptionalTag(BlockTags.AXE_MINEABLE)
                .addOptionalTag(BlockTags.PICKAXE_MINEABLE)
                .addOptionalTag(BlockTags.SHOVEL_MINEABLE)
                .addOptionalTag(BlockTags.HOE_MINEABLE)
                .addOptionalTag(BlockTags.LEAVES);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(ModBlocks.DRIFTWOOD_LEAVES);

        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.DRIFTWOOD_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.DRIFTWOOD_FENCE_GATE);

        valueLookupBuilder(ModTags.Blocks.TOMAHAWK_BREAKABLE)
                .addOptionalTag(BlockTags.AXE_MINEABLE)
                .addTag(BlockTags.LEAVES);
    }
}
