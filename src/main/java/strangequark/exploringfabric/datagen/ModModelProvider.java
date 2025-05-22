package strangequark.exploringfabric.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.client.render.item.property.numeric.UseDurationProperty;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Item;
import strangequark.exploringfabric.armor.ModEquipmentAssetKeys;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.block.custom.CauliflowersBlock;
import strangequark.exploringfabric.block.custom.HoneyBerryBushBlock;
import strangequark.exploringfabric.block.custom.PinkGarnetLampBlock;
import strangequark.exploringfabric.component.ModDataComponentTypes;
import strangequark.exploringfabric.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_END_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);
        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        WeightedVariant offVariant = BlockStateModelGenerator.createWeightedVariant(
                TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector)
        );
        WeightedVariant onVariant = BlockStateModelGenerator.createWeightedVariant(
                blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all)
        );

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator
                        .of(ModBlocks.PINK_GARNET_LAMP)
                        .with(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, onVariant, offVariant))
        );

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWERS, CauliflowersBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.HONEY_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED, HoneyBerryBushBlock.AGE, 0, 1, 2, 3);


        blockStateModelGenerator.createLogTexturePool(ModBlocks.DRIFTWOOD_LOG)
                .log(ModBlocks.DRIFTWOOD_LOG)
                .wood(ModBlocks.DRIFTWOOD_WOOD);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .log(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.DRIFTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DRIFTWOOD_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        /*
         * itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED); // Regular Item registration without predicate
         * itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED); // Registered via block state model generator
         */
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_HELMET, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_CHESTPLATE, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_LEGGINGS, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.PINK_GARNET_BOOTS, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModBlocks.DRIFTWOOD_SAPLING.asItem(), Models.GENERATED);

        Item chisel = ModItems.CHISEL;
        ItemModel.Unbaked unusedChisel = ItemModels.basic(itemModelGenerator.upload(chisel, Models.GENERATED));
        ItemModel.Unbaked usedChisel = ItemModels.basic(itemModelGenerator.registerSubModel(chisel, "_used", Models.GENERATED));

        itemModelGenerator.registerCondition(
                chisel,
                new HasComponentProperty(ModDataComponentTypes.COORDINATES, true),
                usedChisel,
                unusedChisel
        );

        Item bow = ModItems.QUARK_BOW;
        ItemModel.Unbaked unbakedBow = ItemModels.basic(itemModelGenerator.upload(bow, Models.BOW));
        ItemModel.Unbaked unbakedBow2 = ItemModels.basic(itemModelGenerator.registerSubModel(bow, "_pulling_0", Models.BOW));
        ItemModel.Unbaked unbakedBow3 = ItemModels.basic(itemModelGenerator.registerSubModel(bow, "_pulling_1", Models.BOW));
        ItemModel.Unbaked unbakedBow4 = ItemModels.basic(itemModelGenerator.registerSubModel(bow, "_pulling_2", Models.BOW));

        itemModelGenerator.registerCondition(
                bow,
                ItemModels.usingItemProperty(),
                ItemModels.rangeDispatch(new UseDurationProperty(false), 0.05F, unbakedBow2, ItemModels.rangeDispatchEntry(unbakedBow3, 0.65F), ItemModels.rangeDispatchEntry(unbakedBow4, 0.9F)),
                unbakedBow
        );
    }
}
