package com.bioast.modid.datagen.providers.server.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

import static com.bioast.modid.core.ModName.MOD_ID;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		/*
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.SILVER_INGOT.get(), 9)
                .addIngredient(ModBlocks.SILVER_BLOCK.get())
                .addCriterion("has_item", hasItem(ModItems.SILVER_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SILVER_BLOCK.get())
                .key('#', ModItems.SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.SILVER_INGOT.get()))
                .build(consumer);

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT
        .get(), 0.7f, 200)
                .addCriterion("has_item", hasItem(ModBlocks.SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_smelting"));
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT
        .get(), 0.7f, 100)
                .addCriterion("has_item", hasItem(ModBlocks.SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_blasting"));
		*/
    }
}