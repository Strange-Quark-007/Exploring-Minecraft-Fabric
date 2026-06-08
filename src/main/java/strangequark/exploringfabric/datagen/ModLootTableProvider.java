package strangequark.exploringfabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.block.custom.CauliflowersBlock;
import strangequark.exploringfabric.block.custom.HoneyBerryBushBlock;
import strangequark.exploringfabric.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        var enchantmentImpl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        add(ModBlocks.PINK_GARNET_ORE, createOreDrop(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModItems.RAW_PINK_GARNET, 2.0F, 5.0F));
        add(ModBlocks.PINK_GARNET_NETHER_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_NETHER_ORE, ModItems.RAW_PINK_GARNET, 3.0F, 7.0F));
        add(ModBlocks.PINK_GARNET_END_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_END_ORE, ModItems.RAW_PINK_GARNET, 4.0F, 9.0F));

        dropSelf(ModBlocks.MAGIC_BLOCK);

        dropSelf(ModBlocks.PINK_GARNET_BLOCK);
        dropSelf(ModBlocks.RAW_PINK_GARNET_BLOCK);
        add(ModBlocks.PINK_GARNET_SLAB, createSlabItemTable(ModBlocks.PINK_GARNET_SLAB));
        dropSelf(ModBlocks.PINK_GARNET_STAIRS);
        dropSelf(ModBlocks.PINK_GARNET_FENCE);
        dropSelf(ModBlocks.PINK_GARNET_FENCE_GATE);
        dropSelf(ModBlocks.PINK_GARNET_WALL);
        add(ModBlocks.PINK_GARNET_DOOR, createDoorTable(ModBlocks.PINK_GARNET_DOOR));
        dropSelf(ModBlocks.PINK_GARNET_TRAPDOOR);
        dropSelf(ModBlocks.PINK_GARNET_BUTTON);
        dropSelf(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        dropSelf(ModBlocks.PINK_GARNET_LAMP);

        dropSelf(ModBlocks.DRIFTWOOD_LOG);
        dropSelf(ModBlocks.DRIFTWOOD_WOOD);
        dropSelf(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        dropSelf(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
        dropSelf(ModBlocks.DRIFTWOOD_PLANKS);
        add(ModBlocks.DRIFTWOOD_SLAB, createSlabItemTable(ModBlocks.DRIFTWOOD_SLAB));
        dropSelf(ModBlocks.DRIFTWOOD_FENCE);
        dropSelf(ModBlocks.DRIFTWOOD_FENCE_GATE);
        dropSelf(ModBlocks.DRIFTWOOD_BUTTON);
        dropSelf(ModBlocks.DRIFTWOOD_PRESSURE_PLATE);
        dropSelf(ModBlocks.DRIFTWOOD_SAPLING);

        add(ModBlocks.DRIFTWOOD_LEAVES, createLeavesDrops(ModBlocks.DRIFTWOOD_LEAVES, ModBlocks.DRIFTWOOD_SAPLING, 0.0625f));

        LootItemBlockStatePropertyCondition.Builder cauliflowerCondition =
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CAULIFLOWERS)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CauliflowersBlock.AGE, CauliflowersBlock.MAX_AGE));

        this.add(ModBlocks.CAULIFLOWERS, this.createCropDrops(ModBlocks.CAULIFLOWERS, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER, cauliflowerCondition));

        this.add(ModBlocks.HONEY_BERRY_BUSH, block -> this.applyExplosionDecay(
                block, LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HONEY_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HoneyBerryBushBlock.AGE, 3)))
                                .add(LootItem.lootTableItem(ModItems.HONEY_BERRIES))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantmentImpl.getOrThrow(Enchantments.FORTUNE)))
                        )
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HONEY_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HoneyBerryBushBlock.AGE, 2)))
                                .add(LootItem.lootTableItem(ModItems.HONEY_BERRIES))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(enchantmentImpl.getOrThrow(Enchantments.FORTUNE)))
                        )
        ));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        var impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(drop, this.applyExplosionDecay(drop, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                .apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
        ));
    }
}