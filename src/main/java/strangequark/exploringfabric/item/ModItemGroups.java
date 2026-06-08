package strangequark.exploringfabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.block.ModBlocks;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModItemGroups {

    public static final CreativeModeTab PINK_GARNET_ITEMS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            createIdentifier("pink_garnet_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .title(Component.translatable("itemgroup.exploringfabric.pink_garnet_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.PINK_GARNET);
                        entries.accept(ModItems.RAW_PINK_GARNET);
                        entries.accept(ModItems.PINK_GARNET_MAGNET);
                        entries.accept(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE);
                    })
                    .build());

    public static final CreativeModeTab PINK_GARNET_BLOCKS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            createIdentifier("pink_garnet_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .title(Component.translatable("itemgroup.exploringfabric.pink_garnet_blocks"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.PINK_GARNET_ORE);
                        entries.accept(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.accept(ModBlocks.PINK_GARNET_NETHER_ORE);
                        entries.accept(ModBlocks.PINK_GARNET_END_ORE);
                        entries.accept(ModBlocks.PINK_GARNET_BLOCK);
                        entries.accept(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.accept(ModBlocks.PINK_GARNET_SLAB);
                        entries.accept(ModBlocks.PINK_GARNET_STAIRS);
                        entries.accept(ModBlocks.PINK_GARNET_FENCE);
                        entries.accept(ModBlocks.PINK_GARNET_FENCE_GATE);
                        entries.accept(ModBlocks.PINK_GARNET_WALL);
                        entries.accept(ModBlocks.PINK_GARNET_DOOR);
                        entries.accept(ModBlocks.PINK_GARNET_TRAPDOOR);
                        entries.accept(ModBlocks.PINK_GARNET_BUTTON);
                        entries.accept(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
                        entries.accept(ModBlocks.PINK_GARNET_LAMP);
                    })
                    .build());

    public static final CreativeModeTab PINK_GARNET_EQUIPMENT_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            createIdentifier("pink_garnet_equipment"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.PINK_GARNET_SWORD))
                    .title(Component.translatable("itemgroup.exploringfabric.pink_garnet_equipment"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.PINK_GARNET_HAMMER);
                        entries.accept(ModItems.PINK_GARNET_SWORD);
                        entries.accept(ModItems.PINK_GARNET_PICKAXE);
                        entries.accept(ModItems.PINK_GARNET_AXE);
                        entries.accept(ModItems.PINK_GARNET_SHOVEL);
                        entries.accept(ModItems.PINK_GARNET_HOE);
                        entries.accept(ModItems.QUARK_BOW);
                        entries.accept(ModItems.PINK_GARNET_HELMET);
                        entries.accept(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.accept(ModItems.PINK_GARNET_LEGGINGS);
                        entries.accept(ModItems.PINK_GARNET_BOOTS);
                        entries.accept(ModItems.PINK_GARNET_HORSE_ARMOR);
                    })
                    .build());

    public static final CreativeModeTab DRIFTWOOD_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            createIdentifier("drftwood_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.DRIFTWOOD_LOG))
                    .title(Component.translatable("itemgroup.exploringfabric.driftwood_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.DRIFTWOOD_LOG);
                        entries.accept(ModBlocks.DRIFTWOOD_WOOD);
                        entries.accept(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        entries.accept(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
                        entries.accept(ModBlocks.DRIFTWOOD_PLANKS);
                        entries.accept(ModBlocks.DRIFTWOOD_SLAB);
                        entries.accept(ModBlocks.DRIFTWOOD_STAIRS);
                        entries.accept(ModBlocks.DRIFTWOOD_FENCE);
                        entries.accept(ModBlocks.DRIFTWOOD_FENCE_GATE);
                        entries.accept(ModBlocks.DRIFTWOOD_BUTTON);
                        entries.accept(ModBlocks.DRIFTWOOD_PRESSURE_PLATE);
                        entries.accept(ModBlocks.DRIFTWOOD_LEAVES);
                        entries.accept(ModBlocks.DRIFTWOOD_SAPLING);
                    })
                    .build());

    public static final CreativeModeTab MISC_MOD_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            createIdentifier("misc_mod_stuff"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CHISEL))
                    .title(Component.translatable("itemgroup.exploringfabric.misc_mod_stuff"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.MAGIC_BLOCK);
                        entries.accept(ModBlocks.CHAIR);
                        entries.accept(ModItems.CHISEL);
                        entries.accept(ModItems.CAULIFLOWER);
                        entries.accept(ModItems.STARLIGHT_ASHES);
                        entries.accept(ModItems.HONEY_BERRIES);
                        entries.accept(ModItems.MANTIS_SPAWN_EGG);
                        entries.accept(ModItems.TOMAHAWK);
                    })
                    .build());

    public static void registerItemGroups() {
        ExploringFabric.LOGGER.info("Registering Item Groups for " + ExploringFabric.MOD_ID);
    }
}
