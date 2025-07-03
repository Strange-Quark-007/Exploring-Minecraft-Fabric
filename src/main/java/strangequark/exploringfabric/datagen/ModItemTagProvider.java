package strangequark.exploringfabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.RAW_PINK_GARNET)
                .add(Items.APPLE)
                .add(Items.COAL);

        valueLookupBuilder(ModTags.Items.PINK_GARNET_REPAIR).add(ModItems.PINK_GARNET);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.PINK_GARNET_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.PINK_GARNET_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.PINK_GARNET_SHOVEL);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.PINK_GARNET_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.PINK_GARNET_HOE);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.PINK_GARNET_HAMMER);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        valueLookupBuilder(ModTags.Items.PINK_GARNET_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .addTag(ModTags.Items.PINK_GARNET_ARMOR);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.PINK_GARNET_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.PINK_GARNET_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.PINK_GARNET_BOOTS);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .addTag(ModTags.Items.PINK_GARNET_ARMOR)
                .add(ModItems.PINK_GARNET_MAGNET)
                .add(ModItems.QUARK_BOW);

        valueLookupBuilder(ModTags.Items.NETHERITE_ARMOR)
                .add(Items.NETHERITE_HELMET)
                .add(Items.NETHERITE_CHESTPLATE)
                .add(Items.NETHERITE_LEGGINGS)
                .add(Items.NETHERITE_BOOTS);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.PINK_GARNET);

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.QUARK_BOW);

        valueLookupBuilder(ModTags.Items.LIGHTNING_STRIKER_ENCHANTABLE)
                .add(Items.BOW)
                .add(Items.DIAMOND_SWORD)
                .add(Items.NETHERITE_SWORD)
                .add(Items.DIAMOND_AXE)
                .add(Items.NETHERITE_AXE)
                .add(ModItems.PINK_GARNET_SWORD)
                .add(ModItems.PINK_GARNET_AXE)
                .add(ModItems.QUARK_BOW);

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.DRIFTWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DRIFTWOOD_PLANKS.asItem());
    }
}
