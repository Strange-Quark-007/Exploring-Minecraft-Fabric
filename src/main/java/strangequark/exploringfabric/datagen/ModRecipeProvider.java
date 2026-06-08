package strangequark.exploringfabric.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.trim.ModTrimPatterns;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        return new RecipeProvider(wrapperLookup, recipeExporter) {

            @Override
            public void buildRecipes() {
                var itemLookup = registries.lookupOrThrow(Registries.ITEM);

                oreSmelting(List.of(ModItems.RAW_PINK_GARNET), RecipeCategory.MISC, ModItems.PINK_GARNET, .25f, 200, "pink_garnet");
                oreBlasting(List.of(ModItems.RAW_PINK_GARNET), RecipeCategory.MISC, ModItems.PINK_GARNET, .25f, 100, "pink_garnet");
                oreSmelting(List.of(ModBlocks.RAW_PINK_GARNET_BLOCK), RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK, 2.5f, 600, "pink_garnet_block");
                oreBlasting(List.of(ModBlocks.RAW_PINK_GARNET_BLOCK), RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK, 2.5f, 300, "pink_garnet_block");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINK_GARNET_BLOCK);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, Ingredient.of(ModBlocks.PINK_GARNET_BLOCK));
                wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, Ingredient.of(ModBlocks.PINK_GARNET_BLOCK));

                offerWithCriterion(stairBuilder(ModBlocks.PINK_GARNET_STAIRS, Ingredient.of(ModBlocks.PINK_GARNET_BLOCK)), ModBlocks.PINK_GARNET_BLOCK);
                offerWithCriterion(fenceBuilder(ModBlocks.PINK_GARNET_FENCE, Ingredient.of(ModBlocks.PINK_GARNET_BLOCK)), ModItems.PINK_GARNET);
                offerWithCriterion(fenceGateBuilder(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.of(ModBlocks.PINK_GARNET_BLOCK)), ModBlocks.PINK_GARNET_BLOCK);
                offerWithCriterion(doorBuilder(ModBlocks.PINK_GARNET_DOOR, Ingredient.of(ModItems.PINK_GARNET)), ModItems.PINK_GARNET);
                offerWithCriterion(trapdoorBuilder(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.of(ModItems.PINK_GARNET)), ModItems.PINK_GARNET);
                offerWithCriterion(buttonBuilder(ModBlocks.PINK_GARNET_BUTTON, Ingredient.of(ModItems.PINK_GARNET)), ModBlocks.PINK_GARNET_BLOCK);
                offerWithCriterion(pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.of(ModBlocks.PINK_GARNET_BLOCK)), ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                                .pattern("DPD")
                                .pattern("PDP")
                                .pattern("DPD")
                                .define('D', Blocks.DIAMOND_BLOCK)
                                .define('P', ModBlocks.PINK_GARNET_BLOCK),
                        ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_SWORD)
                                .pattern(" P ")
                                .pattern(" P ")
                                .pattern(" S ")
                                .define('P', ModItems.PINK_GARNET)
                                .define('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_PICKAXE)
                                .pattern("PPP")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('P', ModItems.PINK_GARNET)
                                .define('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_AXE)
                                .pattern("PP ")
                                .pattern("PS ")
                                .pattern(" S ")
                                .define('P', ModItems.PINK_GARNET)
                                .define('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_SHOVEL)
                                .pattern(" P ")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('P', ModItems.PINK_GARNET)
                                .define('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_HOE)
                                .pattern("PP ")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('P', ModItems.PINK_GARNET)
                                .define('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_HAMMER)
                                .pattern("PPP")
                                .pattern(" S ")
                                .pattern(" S ")
                                .define('P', ModBlocks.PINK_GARNET_BLOCK)
                                .define('S', Items.STICK),
                        ModBlocks.PINK_GARNET_BLOCK);


                trimSmithing(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE, ModTrimPatterns.QUARK,
                        ResourceKey.create(Registries.RECIPE, createIdentifier("quark_armor_trim_smithing_template_smithing_trim")));


                copySmithingTemplate(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.QUARK_BOW)
                                .pattern("ST ")
                                .pattern("SPT")
                                .pattern("ST ")
                                .define('P', ModItems.PINK_GARNET)
                                .define('S', Items.STRING)
                                .define('T', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(stairBuilder(ModBlocks.DRIFTWOOD_STAIRS, Ingredient.of(ModBlocks.DRIFTWOOD_PLANKS)), ModBlocks.DRIFTWOOD_PLANKS);
                offerWithCriterion(fenceBuilder(ModBlocks.DRIFTWOOD_FENCE, Ingredient.of(ModBlocks.DRIFTWOOD_PLANKS)), ModBlocks.DRIFTWOOD_PLANKS);
                offerWithCriterion(fenceGateBuilder(ModBlocks.DRIFTWOOD_FENCE_GATE, Ingredient.of(ModBlocks.DRIFTWOOD_PLANKS)), ModBlocks.DRIFTWOOD_PLANKS);
                offerWithCriterion(buttonBuilder(ModBlocks.DRIFTWOOD_BUTTON, Ingredient.of(ModBlocks.DRIFTWOOD_PLANKS)), ModBlocks.DRIFTWOOD_PLANKS);
                offerWithCriterion(pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.DRIFTWOOD_PRESSURE_PLATE, Ingredient.of(ModBlocks.DRIFTWOOD_PLANKS)), ModBlocks.DRIFTWOOD_PLANKS);

                offerWithCriterion(ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.MISC, ModItems.TOMAHAWK, 8)
                                .pattern(" CI")
                                .pattern("CSI")
                                .pattern(" S ")
                                .define('I', Items.IRON_INGOT)
                                .define('C', Items.COBBLESTONE)
                                .define('S', Items.STICK),
                        Items.IRON_INGOT);
            }

            private void offerWithCriterion(RecipeBuilder recipe, ItemLike unlockItem) {
                recipe.unlockedBy(getHasName(unlockItem), has(unlockItem)).save(recipeExporter);
            }
        };
    }


    @Override
    public String getName() {
        return "RecipeGenerator";
    }
}
