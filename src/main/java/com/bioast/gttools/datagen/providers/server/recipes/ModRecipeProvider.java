package com.bioast.gttools.datagen.providers.server.recipes;

import com.bioast.gttools.common.item.ModItemTier;
import com.bioast.gttools.core.Ref;
import com.bioast.gttools.core.setup.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(Ref.ID, path);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ModItems.TOOL_MAP.forEach((i, s) -> {
            ModItemTier.ourTiers.forEach((tierName, tier) -> {
                if (ModItems.Tools.get(i) != null) {
                    ShapelessRecipeBuilder.shapeless(ModItems.Tools.get(i).get(tier).get(), 1)
                            .requires(Tags.Items.RODS_WOODEN)
                            .requires(ModItems.getCraftingMaterialsOf(i, tier).get())
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                }
            });
        });
        ModItems.CraftingMats.forEach((i, map) -> map.forEach((tier, item) -> {
            String type = ModItems.TOOL_MAP.get(i).toLowerCase();
            switch (type) { //FIXME temp
                case "axe":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .pattern("xx ")
                            .pattern(" x ")
                            .pattern(" x ")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;
                case "hammer":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .pattern("xx ")
                            .pattern("x  ")
                            .pattern("xx ")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;
                case "saw":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .pattern("x  ")
                            .pattern("x  ")
                            .pattern("x  ")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;
                case "pickaxe":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .pattern(" x ")
                            .pattern("x x")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;
                case "drill":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .define('p', Items.DIAMOND)
                            .pattern("xpx")
                            .pattern(" x ")
                            .pattern("xxx")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;
                case "chainsaw":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .define('p', Items.DIAMOND)
                            .define('r', Items.REDSTONE)
                            .pattern("xxx")
                            .pattern("xpx")
                            .pattern("xrx")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;
                case "spade":
                    ShapedRecipeBuilder.shaped(item.get())
                            .define('x', tier.getRepairIngredient())
                            .define('p', Items.CHAIN)
                            .pattern(" x ")
                            .pattern("xpx")
                            .unlockedBy("has_Item", has(Items.OAK_WOOD))
                            .save(consumer);
                    break;

            }
        }));

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