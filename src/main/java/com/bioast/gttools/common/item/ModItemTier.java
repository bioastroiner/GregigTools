package com.bioast.gttools.common.item;

import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItemTier implements IItemTier {
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;
    private final int color;

    public static final Map<String,ModItemTier> ourTiers = new HashMap<>();

    public static IItemTier get(String tierName){
        return ourTiers.get(tierName);
    }

    public static ModItemTier getRaw(String tierName){
        return ourTiers.get(tierName);
    }

    public static int getCol(String tierName){
        return getRaw(tierName).color;
    }

    public static void registerItemTier(){
        ourTiers.put("wood",out(1,200,2,2,1, ItemTags.PLANKS, MaterialColor.WOOD.col));
        ourTiers.put("stone",out(2,400,3,3,2, Tags.Items.COBBLESTONE, MaterialColor.STONE.col));
        ourTiers.put("flint",out(2,400,3,3,2,Items.FLINT, MaterialColor.COLOR_BLACK.col));
        ourTiers.put("iron",out(2, 250, 6.0F, 2.0F, 14,Items.IRON_INGOT, MaterialColor.METAL.col));
        ourTiers.put("gold",out(3,200,5,5,4,Items.GOLD_INGOT, MaterialColor.GOLD.col));
        ourTiers.put("diamond",out(3,1800,8,5,3,Items.DIAMOND, MaterialColor.DIAMOND.col));
        ourTiers.put("emerald",out(3,2000,8,5,3,Items.EMERALD, MaterialColor.EMERALD.col));
        ourTiers.put("quartz",out(3,1500,6,5,3,Items.QUARTZ, MaterialColor.QUARTZ.col));
        ourTiers.put("netherite",out(3,2300,8,5,3,Items.NETHERITE_INGOT, MaterialColor.PODZOL.col));
        ourTiers.put("netherrack",out(3,300,9,5,3,Items.NETHERRACK, MaterialColor.NETHER.col));
    }

    static {
        registerItemTier();
    }

    private ModItemTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient,int color) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.color = color;
    }

    private static ModItemTier out(int level, int uses, float speed, float damage, int enchantmentValue, Item repairIngredient, int color){
        return new ModItemTier(level, uses, speed, damage, enchantmentValue, ()->Ingredient.of(repairIngredient),color);
    }

    private static ModItemTier out(int level, int uses, float speed, float damage, int enchantmentValue, ITag<Item> repairIngredient, int color){
        return new ModItemTier(level, uses, speed, damage, enchantmentValue, ()->Ingredient.of(repairIngredient),color);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
