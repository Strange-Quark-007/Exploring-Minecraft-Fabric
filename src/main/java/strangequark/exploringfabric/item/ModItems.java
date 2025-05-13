package strangequark.exploringfabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.NotNull;
import strangequark.exploringfabric.ExploringFabric;
import strangequark.exploringfabric.food.ModConsumableComponents;
import strangequark.exploringfabric.food.ModFoodComponents;
import strangequark.exploringfabric.item.custom.ChiselItem;

import static strangequark.exploringfabric.utils.ModIdentifier.createIdentifier;
import static strangequark.exploringfabric.utils.ModRegistryKeys.Items.createRegistryKey;

public class ModItems {
    public static final Item RAW_PINK_GARNET = createItem("raw_pink_garnet", Item::new);
    public static final Item PINK_GARNET = createItem("pink_garnet", Item::new);
    public static final Item CHISEL = createItem("chisel", settings -> new ChiselItem(settings.maxDamage(32)));
    public static final Item CAULIFLOWER = createItem("cauliflower", settings ->
            new Item(settings.food(ModFoodComponents.CAULIFLOWER, ModConsumableComponents.CAULIFLOWER)));
    public static final Item STARLIGHT_ASHES = createItem("starlight_ashes", Item::new);

    public static final Item PINK_GARNET_SWORD = createItem("pink_garnet_sword", settings -> new Item(settings.sword(ModToolMaterials.PINK_GARNET, 3.0F, -2.4F)));
    public static final Item PINK_GARNET_PICKAXE = createItem("pink_garnet_pickaxe", settings -> new Item(settings.pickaxe(ModToolMaterials.PINK_GARNET, 1.0F, -2.8F)));
    public static final Item PINK_GARNET_AXE = createItem("pink_garnet_axe", settings -> new AxeItem(ModToolMaterials.PINK_GARNET, 5.0F, -3.0F, settings));
    public static final Item PINK_GARNET_SHOVEL = createItem("pink_garnet_shovel", settings -> new ShovelItem(ModToolMaterials.PINK_GARNET, 1.5F, -3.0F, settings));
    public static final Item PINK_GARNET_HOE = createItem("pink_garnet_hoe", settings -> new HoeItem(ModToolMaterials.PINK_GARNET, -3.0F, 0.0F, settings));

    public static <T extends Item> T createItem(String name, @NotNull ItemFactory<T> itemCreator) {
        Item.Settings settings = new Item.Settings().registryKey(createRegistryKey(name));
        return registerItem(name, itemCreator.create(settings));
    }

    private static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, createIdentifier(name), item);
    }

    public static void registerModItems() {
        ExploringFabric.LOGGER.info("Registering Mod Items for " + ExploringFabric.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });


    }
}
