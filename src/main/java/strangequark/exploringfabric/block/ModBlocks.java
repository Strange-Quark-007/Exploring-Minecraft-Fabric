package strangequark.exploringfabric.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.NotNull;
import strangequark.exploringfabric.ExploringFabric;

import static strangequark.exploringfabric.item.ModItems.createItem;
import static strangequark.exploringfabric.utils.ModIdentifier.createIdentifier;
import static strangequark.exploringfabric.utils.ModRegistryKeys.Blocks;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = createBlock("pink_garnet_block", settings ->
            new Block(settings.strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = createBlock("raw_pink_garnet_block", settings ->
            new Block(settings.strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_ORE = createBlock("pink_garnet_ore", settings ->
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    settings.strength(4f).requiresTool()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = createBlock("pink_garnet_deepslate_ore", settings ->
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    settings.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    private static <T extends Block> T createBlock(String name, @NotNull BlockFactory<T> blockCreator) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().registryKey(Blocks.createRegistryKey(name));
        return registerBlock(name, blockCreator.create(settings));
    }

    private static <T extends Block> T registerBlock(String name, T block) {
        createItem(name, settings -> new BlockItem(block, settings));
        return Registry.register(Registries.BLOCK, createIdentifier(name), block);
    }

    public static void registerModBlocks() {
        ExploringFabric.LOGGER.info("Registering Mod Blocks for " + ExploringFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries -> {
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
        }));
    }
}
