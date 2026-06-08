package strangequark.exploringfabric.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.client.renderer.item.properties.conditional.IsUsingItem;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import strangequark.exploringfabric.armor.ModEquipmentAssetKeys;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.block.custom.CauliflowersBlock;
import strangequark.exploringfabric.block.custom.HoneyBerryBushBlock;
import strangequark.exploringfabric.block.custom.PinkGarnetLampBlock;
import strangequark.exploringfabric.component.ModDataComponentTypes;
import strangequark.exploringfabric.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        BlockModelGenerators.BlockFamilyProvider pinkGarnetPool = blockStateModelGenerator.family(ModBlocks.PINK_GARNET_BLOCK);

        blockStateModelGenerator.createTrivialCube(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PINK_GARNET_NETHER_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PINK_GARNET_END_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.createDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        pinkGarnetPool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetPool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetPool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetPool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetPool.wall(ModBlocks.PINK_GARNET_WALL);
        pinkGarnetPool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetPool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        MultiVariant offVariant = BlockModelGenerators.plainVariant(
                TexturedModel.CUBE.create(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelOutput)
        );
        MultiVariant onVariant = BlockModelGenerators.plainVariant(
                blockStateModelGenerator.createSuffixedVariant(ModBlocks.PINK_GARNET_LAMP, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube)
        );

        blockStateModelGenerator.blockStateOutput.accept(
                MultiVariantGenerator
                        .dispatch(ModBlocks.PINK_GARNET_LAMP)
                        .with(BlockModelGenerators.createBooleanModelDispatch(PinkGarnetLampBlock.CLICKED, onVariant, offVariant))
        );

        blockStateModelGenerator.createCropBlock(ModBlocks.CAULIFLOWERS, CauliflowersBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.createCrossBlock(ModBlocks.HONEY_BERRY_BUSH, BlockModelGenerators.PlantType.NOT_TINTED, HoneyBerryBushBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.woodProvider(ModBlocks.DRIFTWOOD_LOG)
                .log(ModBlocks.DRIFTWOOD_LOG)
                .wood(ModBlocks.DRIFTWOOD_WOOD);

        blockStateModelGenerator.woodProvider(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .log(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        BlockModelGenerators.BlockFamilyProvider driftwoodPool = blockStateModelGenerator.family(ModBlocks.DRIFTWOOD_PLANKS);

        driftwoodPool.slab(ModBlocks.DRIFTWOOD_SLAB);
        driftwoodPool.stairs(ModBlocks.DRIFTWOOD_STAIRS);
        driftwoodPool.fence(ModBlocks.DRIFTWOOD_FENCE);
        driftwoodPool.fenceGate(ModBlocks.DRIFTWOOD_FENCE_GATE);
        driftwoodPool.button(ModBlocks.DRIFTWOOD_BUTTON);
        driftwoodPool.pressurePlate(ModBlocks.DRIFTWOOD_PRESSURE_PLATE);

        blockStateModelGenerator.createTrivialBlock(ModBlocks.DRIFTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.createCrossBlock(ModBlocks.DRIFTWOOD_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createHorizontallyRotatedBlock(ModBlocks.CHAIR, TexturedModel.ORIENTABLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_PINK_GARNET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STARLIGHT_ASHES, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_MAGNET, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateTrimmableItem(ModItems.PINK_GARNET_HELMET, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerator.generateTrimmableItem(ModItems.PINK_GARNET_CHESTPLATE, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerator.generateTrimmableItem(ModItems.PINK_GARNET_LEGGINGS, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerator.generateTrimmableItem(ModItems.PINK_GARNET_BOOTS, ModEquipmentAssetKeys.PINK_GARNET, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerator.generateFlatItem(ModItems.PINK_GARNET_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModBlocks.DRIFTWOOD_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);

        Item chisel = ModItems.CHISEL;
        Identifier usedChiselId = ModelLocationUtils.getModelLocation(chisel, "_used");

        ItemModel.Unbaked unusedChisel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(chisel, TextureMapping.layer0(chisel), itemModelGenerator.modelOutput));
        ItemModel.Unbaked usedChisel = ItemModelUtils.plainModel(ModelTemplates.FLAT_ITEM.create(usedChiselId, TextureMapping.layer0(usedChiselId), itemModelGenerator.modelOutput));

        itemModelGenerator.itemModelOutput.accept(
                chisel,
                ItemModelUtils.conditional(
                        new HasComponent(ModDataComponentTypes.COORDINATES, true),
                        usedChisel,
                        unusedChisel
                )
        );

        Item bow = ModItems.QUARK_BOW;
        net.minecraft.resources.Identifier bow0 = ModelLocationUtils.getModelLocation(bow, "_pulling_0");
        net.minecraft.resources.Identifier bow1 = ModelLocationUtils.getModelLocation(bow, "_pulling_1");
        net.minecraft.resources.Identifier bow2 = ModelLocationUtils.getModelLocation(bow, "_pulling_2");

        ItemModel.Unbaked unbakedBow = ItemModelUtils.plainModel(ModelTemplates.BOW.create(bow, TextureMapping.layer0(bow), itemModelGenerator.modelOutput));
        ItemModel.Unbaked unbakedBow2 = ItemModelUtils.plainModel(ModelTemplates.BOW.create(bow0, TextureMapping.layer0(bow0), itemModelGenerator.modelOutput));
        ItemModel.Unbaked unbakedBow3 = ItemModelUtils.plainModel(ModelTemplates.BOW.create(bow1, TextureMapping.layer0(bow1), itemModelGenerator.modelOutput));
        ItemModel.Unbaked unbakedBow4 = ItemModelUtils.plainModel(ModelTemplates.BOW.create(bow2, TextureMapping.layer0(bow2), itemModelGenerator.modelOutput));

        itemModelGenerator.itemModelOutput.accept(
                bow,
                ItemModelUtils.conditional(
                        new IsUsingItem(),
                        ItemModelUtils.rangeSelect(
                                new UseDuration(false),
                                0.05F, unbakedBow2,
                                ItemModelUtils.override(unbakedBow3, 0.65F),
                                ItemModelUtils.override(unbakedBow4, 0.9F)
                        ),
                        unbakedBow
                )
        );

        itemModelGenerator.generateFlatItem(ModItems.MANTIS_SPAWN_EGG, new ModelTemplate(Optional.of(Identifier.withDefaultNamespace("item/brown_egg")), Optional.empty()));
    }
}