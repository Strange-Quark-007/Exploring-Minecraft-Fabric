package strangequark.exploringfabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.armor.ModArmorMaterials;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.entity.ModEntities;
import strangequark.exploringfabric.food.ModConsumableComponents;
import strangequark.exploringfabric.food.ModFoodComponents;
import strangequark.exploringfabric.item.custom.ChiselItem;
import strangequark.exploringfabric.item.custom.HammerItem;
import strangequark.exploringfabric.item.custom.MagnetItem;
import strangequark.exploringfabric.item.custom.TomahawkItem;
import strangequark.exploringfabric.trim.ModTrimMaterials;
import strangequark.exploringfabric.util.ModTags;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;
import static strangequark.exploringfabric.util.ModRegistryKeys.Items.createResourceKey;

public class ModItems {
    public static final Item RAW_PINK_GARNET = createItem("raw_pink_garnet", Item::new);
    public static final Item PINK_GARNET = createItem("pink_garnet", settings -> new Item(settings.trimMaterial(ModTrimMaterials.PINK_GARNET)));

    public static final Item CHISEL = createItem("chisel", settings -> new ChiselItem(settings.durability(32)));
    public static final Item CAULIFLOWER = createItem("cauliflower", settings -> new BlockItem(ModBlocks.CAULIFLOWERS, settings.food(ModFoodComponents.CAULIFLOWER, ModConsumableComponents.CAULIFLOWER)));
    public static final Item STARLIGHT_ASHES = createItem("starlight_ashes", Item::new);

    public static final Item PINK_GARNET_SWORD = createItem("pink_garnet_sword", settings -> new Item(settings.sword(ModToolMaterials.PINK_GARNET, 3.0F, -2.4F)));
    public static final Item PINK_GARNET_PICKAXE = createItem("pink_garnet_pickaxe", settings -> new Item(settings.pickaxe(ModToolMaterials.PINK_GARNET, 1.0F, -2.8F)));
    public static final Item PINK_GARNET_AXE = createItem("pink_garnet_axe", settings -> new AxeItem(ModToolMaterials.PINK_GARNET, 5.0F, -3.0F, settings));
    public static final Item PINK_GARNET_SHOVEL = createItem("pink_garnet_shovel", settings -> new ShovelItem(ModToolMaterials.PINK_GARNET, 1.5F, -3.0F, settings));
    public static final Item PINK_GARNET_HOE = createItem("pink_garnet_hoe", settings -> new HoeItem(ModToolMaterials.PINK_GARNET, -3.0F, 0.0F, settings));

    public static final Item PINK_GARNET_HAMMER = createItem("pink_garnet_hammer", settings -> new HammerItem(settings.tool(ModToolMaterials.PINK_GARNET, ModTags.Blocks.HAMMER_MINEABLE, 7.0F, -3.3F, 0.0f)));
    public static final Item PINK_GARNET_MAGNET = createItem("pink_garnet_magnet", settings -> new MagnetItem(settings.durability(256)));

    public static final Item PINK_GARNET_HELMET = createItem("pink_garnet_helmet", settings -> new Item(settings.humanoidArmor(ModArmorMaterials.PINK_GARNET, ArmorType.HELMET)));
    public static final Item PINK_GARNET_CHESTPLATE = createItem("pink_garnet_chestplate", settings -> new Item(settings.humanoidArmor(ModArmorMaterials.PINK_GARNET, ArmorType.CHESTPLATE)));
    public static final Item PINK_GARNET_LEGGINGS = createItem("pink_garnet_leggings", settings -> new Item(settings.humanoidArmor(ModArmorMaterials.PINK_GARNET, ArmorType.LEGGINGS)));
    public static final Item PINK_GARNET_BOOTS = createItem("pink_garnet_boots", settings -> new Item(settings.humanoidArmor(ModArmorMaterials.PINK_GARNET, ArmorType.BOOTS)));

    public static final Item PINK_GARNET_HORSE_ARMOR = createItem("pink_garnet_horse_armor", settings -> new Item(settings.horseArmor(ModArmorMaterials.PINK_GARNET)));

    public static final Item QUARK_ARMOR_TRIM_SMITHING_TEMPLATE = createItem("quark_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate);

    public static final Item QUARK_BOW = createItem("quark_bow", settings -> new BowItem(settings.durability(250)));

    public static final Item HONEY_BERRIES = createItem("honey_berries", settings -> new BlockItem(ModBlocks.HONEY_BERRY_BUSH, settings.food(ModFoodComponents.HONEY_BERRIES)));
    
    public static final Item MANTIS_SPAWN_EGG = createItem("mantis_spawn_egg", settings -> new SpawnEggItem(settings.spawnEgg(ModEntities.MANTIS)));

    public static final Item TOMAHAWK = createItem("tomahawk", TomahawkItem::new);

    public static <T extends Item> T createItem(String name, ItemFactory<T> itemCreator) {
        Item.Properties settings = new Item.Properties().setId(createResourceKey(name));
        return registerItem(name, itemCreator.create(settings));
    }

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(BuiltInRegistries.ITEM, createIdentifier(name), item);
    }

    public static void registerModItems() {
        ExploringFabric.LOGGER.info("Registering Mod Items for " + ExploringFabric.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(PINK_GARNET);
            entries.accept(RAW_PINK_GARNET);
        });
    }
}
