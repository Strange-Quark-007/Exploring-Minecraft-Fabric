package strangequark.exploringfabric.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.block.custom.*;
import strangequark.exploringfabric.sound.ModSounds;
import strangequark.exploringfabric.util.ModRegistryKeys;
import strangequark.exploringfabric.world.sapling.ModSaplingGenerators;

import static strangequark.exploringfabric.item.ModItems.createItem;
import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = createBlock("pink_garnet_block", settings ->
            new Block(settings.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block RAW_PINK_GARNET_BLOCK = createBlock("raw_pink_garnet_block", settings ->
            new Block(settings.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final Block PINK_GARNET_ORE = createBlock("pink_garnet_ore", settings ->
            new DropExperienceBlock(UniformInt.of(2, 5),
                    settings.strength(3f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = createBlock("pink_garnet_deepslate_ore", settings ->
            new DropExperienceBlock(UniformInt.of(3, 6),
                    settings.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final Block PINK_GARNET_NETHER_ORE = createBlock("pink_garnet_nether_ore", settings ->
            new DropExperienceBlock(UniformInt.of(3, 6),
                    settings.strength(3f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_END_ORE = createBlock("pink_garnet_end_ore", settings ->
            new DropExperienceBlock(UniformInt.of(4, 8),
                    settings.strength(4f).requiresCorrectToolForDrops()));

    public static final Block MAGIC_BLOCK = createBlock("magic_block", settings ->
            new MagicBlock(settings.strength(4f).requiresCorrectToolForDrops().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block PINK_GARNET_SLAB = createBlock("pink_garnet_slab", settings ->
            new SlabBlock(settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_STAIRS = createBlock("pink_garnet_stairs", settings ->
            new StairBlock(ModBlocks.PINK_GARNET_BLOCK.defaultBlockState(), settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_FENCE = createBlock("pink_garnet_fence", settings ->
            new FenceBlock(settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_FENCE_GATE = createBlock("pink_garnet_fence_gate", settings ->
            new FenceGateBlock(WoodType.OAK, settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_WALL = createBlock("pink_garnet_wall", settings ->
            new WallBlock(settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_DOOR = createBlock("pink_garnet_door", settings ->
            new DoorBlock(BlockSetType.IRON, settings.strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final Block PINK_GARNET_TRAPDOOR = createBlock("pink_garnet_trapdoor", settings ->
            new TrapDoorBlock(BlockSetType.IRON, settings.strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final Block PINK_GARNET_BUTTON = createBlock("pink_garnet_button", settings ->
            new ButtonBlock(BlockSetType.IRON, 2, settings.strength(2f).requiresCorrectToolForDrops().noCollision()));

    public static final Block PINK_GARNET_PRESSURE_PLATE = createBlock("pink_garnet_pressure_plate", settings ->
            new PressurePlateBlock(BlockSetType.IRON, settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block PINK_GARNET_LAMP = createBlock("pink_garnet_lamp", settings ->
            new PinkGarnetLampBlock(settings.strength(2f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(PinkGarnetLampBlock.CLICKED) ? 15 : 0)));

    public static final Block CAULIFLOWERS = createBlock("cauliflowers", settings ->
                    new CauliflowersBlock(settings
                            .mapColor(MapColor.COLOR_GREEN)
                            .noCollision()
                            .randomTicks()
                            .instabreak()
                            .sound(SoundType.CROP)
                            .pushReaction(PushReaction.DESTROY)),
            false
    );

    public static final Block HONEY_BERRY_BUSH = createBlock("honey_berry_bush", settings ->
            new HoneyBerryBushBlock(settings
                    .mapColor(MapColor.COLOR_GREEN)
                    .randomTicks()
                    .noCollision()
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .pushReaction(PushReaction.DESTROY))
    );

    public static final Block DRIFTWOOD_LOG = createBlock("driftwood_log", Blocks.OAK_LOG, RotatedPillarBlock::new);
    public static final Block DRIFTWOOD_WOOD = createBlock("driftwood_wood", Blocks.OAK_WOOD, RotatedPillarBlock::new);
    public static final Block STRIPPED_DRIFTWOOD_LOG = createBlock("stripped_driftwood_log", Blocks.OAK_WOOD, RotatedPillarBlock::new);
    public static final Block STRIPPED_DRIFTWOOD_WOOD = createBlock("stripped_driftwood_wood", Blocks.OAK_WOOD, RotatedPillarBlock::new);

    public static final Block DRIFTWOOD_PLANKS = createBlock("driftwood_planks", Blocks.OAK_PLANKS, Block::new);
    public static final Block DRIFTWOOD_SLAB = createBlock("driftwood_slab", Blocks.OAK_SLAB, SlabBlock::new);

    public static final Block DRIFTWOOD_STAIRS = createBlock("driftwood_stairs", settings ->
            new StairBlock(ModBlocks.DRIFTWOOD_PLANKS.defaultBlockState(), settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block DRIFTWOOD_FENCE = createBlock("driftwood_fence", settings ->
            new FenceBlock(settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block DRIFTWOOD_FENCE_GATE = createBlock("driftwood_fence_gate", settings ->
            new FenceGateBlock(WoodType.OAK, settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block DRIFTWOOD_BUTTON = createBlock("driftwood_button", settings ->
            new ButtonBlock(BlockSetType.OAK, 10, settings.strength(2f).requiresCorrectToolForDrops().noCollision()));

    public static final Block DRIFTWOOD_PRESSURE_PLATE = createBlock("driftwood_pressure_plate", settings ->
            new PressurePlateBlock(BlockSetType.OAK, settings.strength(2f).requiresCorrectToolForDrops()));

    public static final Block DRIFTWOOD_LEAVES = createBlock("driftwood_leaves", Blocks.OAK_LEAVES, settings -> new TintedParticleLeavesBlock(0.01f, settings));
    public static final Block DRIFTWOOD_SAPLING = createBlock("driftwood_sapling", Blocks.OAK_SAPLING, settings -> new SaplingBlock(ModSaplingGenerators.DRIFTWOOD, settings));

    public static final Block CHAIR = createBlock("chair", settings -> new ChairBlock(settings.noOcclusion()));

    private static <T extends Block> T createBlock(String name, BlockFactory<T> blockCreator) {
        Block.Properties properties = Block.Properties.of().setId(ModRegistryKeys.Blocks.createResourceKey(name));
        return registerBlock(name, blockCreator.create(properties), true);
    }

    private static <T extends Block> T createBlock(String name, Block block, BlockFactory<T> blockCreator) {
        Block.Properties properties = Block.Properties.ofFullCopy(block).setId(ModRegistryKeys.Blocks.createResourceKey(name));
        return registerBlock(name, blockCreator.create(properties), true);
    }

    private static <T extends Block> T createBlock(String name, BlockFactory<T> blockCreator, boolean registerItem) {
        Block.Properties properties = Block.Properties.of().setId(ModRegistryKeys.Blocks.createResourceKey(name));
        return registerBlock(name, blockCreator.create(properties), registerItem);
    }

    private static <T extends Block> T registerBlock(String name, T block, boolean registerItem) {
        if (registerItem) {
            // "settings" is changed to "properties" to reflect Item.Properties
            createItem(name, properties -> new BlockItem(block, properties));
        }
        return Registry.register(BuiltInRegistries.BLOCK, createIdentifier(name), block);
    }

    public static void registerModBlocks() {
        ExploringFabric.LOGGER.info("Registering Mod Blocks for " + ExploringFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((entries -> {
            entries.accept(PINK_GARNET_BLOCK);
            entries.accept(RAW_PINK_GARNET_BLOCK);
            entries.accept(PINK_GARNET_SLAB);
            entries.accept(PINK_GARNET_STAIRS);
            entries.accept(PINK_GARNET_FENCE);
            entries.accept(PINK_GARNET_FENCE_GATE);
            entries.accept(PINK_GARNET_WALL);
            entries.accept(PINK_GARNET_DOOR);
            entries.accept(PINK_GARNET_TRAPDOOR);
            entries.accept(PINK_GARNET_BUTTON);
            entries.accept(PINK_GARNET_PRESSURE_PLATE);
        }));
    }
}
