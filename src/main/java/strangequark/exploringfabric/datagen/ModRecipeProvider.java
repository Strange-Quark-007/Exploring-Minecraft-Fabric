package strangequark.exploringfabric.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import strangequark.exploringfabric.block.ModBlocks;
import strangequark.exploringfabric.item.ModItems;
import strangequark.exploringfabric.trim.ModTrimPatterns;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static strangequark.exploringfabric.util.ModIdentifier.createIdentifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                offerSmelting(List.of(ModItems.RAW_PINK_GARNET), RecipeCategory.MISC, ModItems.PINK_GARNET, .25f, 200, "pink_garnet");
                offerBlasting(List.of(ModItems.RAW_PINK_GARNET), RecipeCategory.MISC, ModItems.PINK_GARNET, .25f, 100, "pink_garnet");
                offerSmelting(List.of(ModBlocks.RAW_PINK_GARNET_BLOCK), RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK, 2.5f, 600, "pink_garnet_block");
                offerBlasting(List.of(ModBlocks.RAW_PINK_GARNET_BLOCK), RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK, 2.5f, 300, "pink_garnet_block");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINK_GARNET_BLOCK);

                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_BLOCK);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)), ModBlocks.PINK_GARNET_BLOCK);
                offerWithCriterion(createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)), ModItems.PINK_GARNET);
                offerWithCriterion(createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)), ModBlocks.PINK_GARNET_BLOCK);
                offerWithCriterion(createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItem(ModItems.PINK_GARNET)), ModItems.PINK_GARNET);
                offerWithCriterion(createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItem(ModItems.PINK_GARNET)), ModItems.PINK_GARNET);
                offerWithCriterion(createButtonRecipe(ModBlocks.PINK_GARNET_BUTTON, Ingredient.ofItem(ModItems.PINK_GARNET)), ModBlocks.PINK_GARNET_BLOCK);
                offerWithCriterion(createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.PINK_GARNET_BLOCK)), ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                                .pattern("DPD")
                                .pattern("PDP")
                                .pattern("DPD")
                                .input('D', Blocks.DIAMOND_BLOCK)
                                .input('P', ModBlocks.PINK_GARNET_BLOCK),
                        ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_SWORD)
                                .pattern(" P ")
                                .pattern(" P ")
                                .pattern(" S ")
                                .input('P', ModItems.PINK_GARNET)
                                .input('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_PICKAXE)
                                .pattern("PPP")
                                .pattern(" S ")
                                .pattern(" S ")
                                .input('P', ModItems.PINK_GARNET)
                                .input('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_AXE)
                                .pattern("PP ")
                                .pattern("PS ")
                                .pattern(" S ")
                                .input('P', ModItems.PINK_GARNET)
                                .input('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_SHOVEL)
                                .pattern(" P ")
                                .pattern(" S ")
                                .pattern(" S ")
                                .input('P', ModItems.PINK_GARNET)
                                .input('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_HOE)
                                .pattern("PP ")
                                .pattern(" S ")
                                .pattern(" S ")
                                .input('P', ModItems.PINK_GARNET)
                                .input('S', Items.STICK),
                        ModItems.PINK_GARNET);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.PINK_GARNET_HAMMER)
                                .pattern("PPP")
                                .pattern(" S ")
                                .pattern(" S ")
                                .input('P', ModBlocks.PINK_GARNET_BLOCK)
                                .input('S', Items.STICK),
                        ModBlocks.PINK_GARNET_BLOCK);

                offerSmithingTrimRecipe(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE, ModTrimPatterns.QUARK,
                        RegistryKey.of(RegistryKeys.RECIPE, createIdentifier("quark_armor_trim_smithing_template_smithing_trim")));

                offerSmithingTemplateCopyingRecipe(ModItems.QUARK_ARMOR_TRIM_SMITHING_TEMPLATE, ModBlocks.PINK_GARNET_BLOCK);

                offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.QUARK_BOW)
                                .pattern("ST ")
                                .pattern("SPT")
                                .pattern("ST ")
                                .input('P', ModItems.PINK_GARNET)
                                .input('S', Items.STRING)
                                .input('T', Items.STICK),
                        ModItems.PINK_GARNET);

            }

            private void offerWithCriterion(CraftingRecipeJsonBuilder recipe, ItemConvertible unlockItem) {
                recipe.criterion(hasItem(unlockItem), conditionsFromItem(unlockItem)).offerTo(recipeExporter);
            }
        };
    }


    @Override
    public String getName() {
        return "RecipeGenerator";
    }
}
