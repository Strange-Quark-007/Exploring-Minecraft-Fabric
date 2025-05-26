package strangequark.exploringfabric.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.block.custom.CauliflowersBlock;
import strangequark.exploringfabric.block.custom.HoneyBerryBushBlock;
import strangequark.exploringfabric.block.custom.MagicBlock;
import strangequark.exploringfabric.block.custom.PinkGarnetLampBlock;
import strangequark.exploringfabric.sound.ModSounds;
import strangequark.exploringfabric.util.ModRegistryKeys;
import strangequark.exploringfabric.world.sapling.ModSaplingGenerators;

import static strangequark.exploringfabric.item.ModItems.createItem;
import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = createBlock("pink_garnet_block", settings ->
            new Block(settings.strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = createBlock("raw_pink_garnet_block", settings ->
            new Block(settings.strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_ORE = createBlock("pink_garnet_ore", settings ->
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    settings.strength(3f).requiresTool()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = createBlock("pink_garnet_deepslate_ore", settings ->
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    settings.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block PINK_GARNET_NETHER_ORE = createBlock("pink_garnet_nether_ore", settings ->
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    settings.strength(3f).requiresTool()));

    public static final Block PINK_GARNET_END_ORE = createBlock("pink_garnet_end_ore", settings ->
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    settings.strength(4f).requiresTool()));

    public static final Block MAGIC_BLOCK = createBlock("magic_block", settings ->
            new MagicBlock(settings.strength(4f).requiresTool().sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block PINK_GARNET_SLAB = createBlock("pink_garnet_slab", settings ->
            new SlabBlock(settings.strength(2f).requiresTool()));

    public static final Block PINK_GARNET_STAIRS = createBlock("pink_garnet_stairs", settings ->
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(), settings.strength(2f).requiresTool()));

    public static final Block PINK_GARNET_FENCE = createBlock("pink_garnet_fence", settings ->
            new FenceBlock(settings.strength(2f).requiresTool()));

    public static final Block PINK_GARNET_FENCE_GATE = createBlock("pink_garnet_fence_gate", settings ->
            new FenceGateBlock(WoodType.OAK, settings.strength(2f).requiresTool()));

    public static final Block PINK_GARNET_WALL = createBlock("pink_garnet_wall", settings ->
            new WallBlock(settings.strength(2f).requiresTool()));

    public static final Block PINK_GARNET_DOOR = createBlock("pink_garnet_door", settings ->
            new DoorBlock(BlockSetType.IRON, settings.strength(2f).requiresTool().nonOpaque()));

    public static final Block PINK_GARNET_TRAPDOOR = createBlock("pink_garnet_trapdoor", settings ->
            new TrapdoorBlock(BlockSetType.IRON, settings.strength(2f).requiresTool().nonOpaque()));

    public static final Block PINK_GARNET_BUTTON = createBlock("pink_garnet_button", settings ->
            new ButtonBlock(BlockSetType.IRON, 2, settings.strength(2f).requiresTool().noCollision()));

    public static final Block PINK_GARNET_PRESSURE_PLATE = createBlock("pink_garnet_pressure_plate", settings ->
            new PressurePlateBlock(BlockSetType.IRON, settings.strength(2f).requiresTool()));

    public static final Block PINK_GARNET_LAMP = createBlock("pink_garnet_lamp", settings ->
            new PinkGarnetLampBlock(settings.strength(2f).requiresTool()
                    .luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)));

    public static final Block CAULIFLOWERS = createBlock("cauliflowers", settings ->
                    new CauliflowersBlock(settings
                            .mapColor(MapColor.DARK_GREEN)
                            .noCollision()
                            .ticksRandomly()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.CROP)
                            .pistonBehavior(PistonBehavior.DESTROY)),
            false
    );

    public static final Block HONEY_BERRY_BUSH = createBlock("honey_berry_bush", settings ->
            new HoneyBerryBushBlock(settings.mapColor(MapColor.DARK_GREEN)
                    .ticksRandomly()
                    .noCollision()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block DRIFTWOOD_LOG = createBlock("driftwood_log", Blocks.OAK_LOG, PillarBlock::new);
    public static final Block DRIFTWOOD_WOOD = createBlock("driftwood_wood", Blocks.OAK_WOOD, PillarBlock::new);
    public static final Block STRIPPED_DRIFTWOOD_LOG = createBlock("stripped_driftwood_log", Blocks.OAK_WOOD, PillarBlock::new);
    public static final Block STRIPPED_DRIFTWOOD_WOOD = createBlock("stripped_driftwood_wood", Blocks.OAK_WOOD, PillarBlock::new);

    public static final Block DRIFTWOOD_PLANKS = createBlock("driftwood_planks", Blocks.OAK_PLANKS, Block::new);

    public static final Block DRIFTWOOD_LEAVES = createBlock("driftwood_leaves", Blocks.OAK_LEAVES, settings -> new TintedParticleLeavesBlock(0.01f, settings));
    public static final Block DRIFTWOOD_SAPLING = createBlock("driftwood_sapling", Blocks.OAK_SAPLING, settings -> new SaplingBlock(ModSaplingGenerators.DRIFTWOOD, settings));

    private static <T extends Block> T createBlock(String name, BlockFactory<T> blockCreator) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().registryKey(ModRegistryKeys.Blocks.createRegistryKey(name));
        return registerBlock(name, blockCreator.create(settings), true);
    }

    private static <T extends Block> T createBlock(String name, Block block, BlockFactory<T> blockCreator) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.copy(block).registryKey(ModRegistryKeys.Blocks.createRegistryKey(name));
        return registerBlock(name, blockCreator.create(settings), true);
    }

    private static <T extends Block> T createBlock(String name, BlockFactory<T> blockCreator, boolean registerItem) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().registryKey(ModRegistryKeys.Blocks.createRegistryKey(name));
        return registerBlock(name, blockCreator.create(settings), registerItem);
    }

    private static <T extends Block> T registerBlock(String name, T block, boolean registerItem) {
        if (registerItem) {
            createItem(name, settings -> new BlockItem(block, settings));
        }
        return Registry.register(Registries.BLOCK, createIdentifier(name), block);
    }

    public static void registerModBlocks() {
        ExploringFabric.LOGGER.info("Registering Mod Blocks for " + ExploringFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries -> {
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
            entries.add(PINK_GARNET_SLAB);
            entries.add(PINK_GARNET_STAIRS);
            entries.add(PINK_GARNET_FENCE);
            entries.add(PINK_GARNET_FENCE_GATE);
            entries.add(PINK_GARNET_WALL);
            entries.add(PINK_GARNET_DOOR);
            entries.add(PINK_GARNET_TRAPDOOR);
            entries.add(PINK_GARNET_BUTTON);
            entries.add(PINK_GARNET_PRESSURE_PLATE);
        }));
    }
}
