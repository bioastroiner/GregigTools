package com.bioast.gttools.core.setup;

import com.bioast.gttools.common.item.Hammer;
import com.bioast.gttools.common.item.LumberAxe;
import com.bioast.gttools.common.item.ModItemTier;
import com.bioast.gttools.common.item.Saw;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    public static final Map<IItemTier, RegistryObject<Item>> Axes = new HashMap<>();
    public static final Map<IItemTier, RegistryObject<Item>> Hammers = new HashMap<>();
    public static final Map<IItemTier, RegistryObject<Item>> Saws = new HashMap<>();
    //TODO: move above to below
    public static final Map<Integer,Map<IItemTier, RegistryObject<Item>>> Tools = new HashMap<>();

    /**
     * {@link ModItemTier#ourTiers} to refrence our local tiers instance
     * by using {@code CraftingMats.get({@link ModItems#TOOL_TYPES_PRIMITIVES }).get({@link ModItemTier#ourTiers})}
     * you can access the rigistered object of crafting materials witch gets registered down the line
     * see {@link ModItems#getCraftingMaterialsOf(int, IItemTier)}
     */
    public static final Map<Integer,Map<IItemTier, RegistryObject<Item>>> CraftingMats = new HashMap<>();

    public static final String[] TOOL_TYPES_PRIMITIVES = {
            "Axe",
            "Chainsaw",
            "Drill",
            "Spade",
            "Pickaxe",
            "Sword",
            "Saw",
            "Hammer",
    };

    /**
     * see {@link ModItems#TOOL_TYPES_PRIMITIVES} for base values
     */
    public static final Map<Integer,String> TOOL_MAP = new HashMap<>();

    static {
        for (int i = 0; i < TOOL_TYPES_PRIMITIVES.length; i++) {
            TOOL_MAP.put(i, TOOL_TYPES_PRIMITIVES[i]);
        }
    }
    static {
        //FIXME for now
        TOOL_MAP.forEach((i,tool)->{
            switch(tool){
                case "Axe":
                    Tools.put(i,Axes);
                    break;
                case "Saw":
                    Tools.put(i,Saws);
                    break;
                case "Hammer":
                    Tools.put(i,Hammers);
                    break;
            }

        });
    }

    /**
     * {@code @link Item#toolClasses}
     */
    public static final Map<String, Map<ToolType,Integer>> TOOL_TYPES_CLASSES = new HashMap<>();

////    public static final RegistryObject<Item> L_AXE = Registration.ITEMS.register("gt_axe",
////            () -> new LumberAxe(ModItemTier.get("iron"), 6, -3, new Item.Properties().addToolType(ToolType.AXE, 2),
////                    "iron"));
//    public static final RegistryObject<Item> L_SAW = Registration.ITEMS.register("gt_saw",
//            () -> new Saw(ModItemTier.get("iron"), 6, -3, new Item.Properties().addToolType(ToolType.AXE, 2)));
//    public static final RegistryObject<Item> L_HAMMER = Registration.ITEMS.register("gt_hammer",
//            () -> new Hammer(ModItemTier.get("iron"), 6, -3, new Item.Properties().addToolType(ToolType.SHOVEL, 2)));

    static {
        registerTools();
        registerToolsComponents();

        //Axes.put(ModItemTier.get("iron"),)
    }

    private static void registerToolsComponents() {
        for (int i = 0; i < TOOL_TYPES_PRIMITIVES.length; i++) {
            final Map<IItemTier, RegistryObject<Item>> Mats = new HashMap<>();
            final int I = i;
            final String T = TOOL_TYPES_PRIMITIVES[i];

            ModItemTier.ourTiers.forEach((tierName, tier) -> {
                String name = "components."+T.toLowerCase()+"_"+tierName;
                Mats.put(tier, Registration.ITEMS.register(name,()->
                        new Item(new Item.Properties()
                                .tab(ItemGroup.TAB_MATERIALS))
                ));
            });
            CraftingMats.put(I,Mats);
        }
    }

    private static void registerTools() {

//        for (int i = 0; i < ModItems.TOOL_TYPES.length; i++) {
//            final Map<IItemTier, RegistryObject<Item>> Tool = new HashMap<>();
//            final int I = i;
//            ModItemTier.ourTiers.forEach((tierName, tier)->{
//                String name = "tool."+TOOL_TYPES[I].toLowerCase()+"_"+tierName;
//                Supplier<? extends Item> supplier = getItemSupplier(tierName, tier);
//                Tool.put(tier,Registration.ITEMS.register(name, supplier));
//            });
//            Tools.put(I, Tool);
//        }

        ModItemTier.ourTiers.forEach((tierName, tier) ->{
            String name;
            int toolID;

            name = "tools.axe"+"_"+tierName;
            toolID = 0;
            Axes.put(ModItemTier.get(tierName), Registration.ITEMS.register(name,
                    () -> new LumberAxe(tier, 6, -3, new Item.Properties()
                            .addToolType(ToolType.AXE, tier.getLevel()).tab(ItemGroup.TAB_TOOLS), tierName)));
            name = "tools.hammer"+"_"+tierName;
            Hammers.put(ModItemTier.get(tierName), Registration.ITEMS.register(name,
                    () -> new Hammer(tier, 6, -3, new Item.Properties()
                            .addToolType(ToolType.PICKAXE, tier.getLevel()).tab(ItemGroup.TAB_TOOLS), tierName)));
            name = "tools.saw"+"_"+tierName;
            Saws.put(ModItemTier.get(tierName), Registration.ITEMS.register(name,
                    () -> new Saw(tier, 6, -3, new Item.Properties()
                            .addToolType(ToolType.AXE, tier.getLevel()).tab(ItemGroup.TAB_TOOLS), tierName)));

        });
    }

//    private static Supplier<Item> getItemSupplier(String tierName, ModItemTier tier, float attDmg, float attSpd,ToolType typeOfTool) {
//        return ()->{return new LumberAxe(tier, attDmg, attSpd, new Item.Properties()
//                .addToolType(typeOfTool, tier.getLevel()).tab(ItemGroup.TAB_TOOLS), tierName);};
//    }

    public static RegistryObject<Item> getCraftingMaterialsOf(int i,IItemTier tier){
        if(i>= TOOL_TYPES_PRIMITIVES.length||i<0) return null;
        String type = TOOL_TYPES_PRIMITIVES[i];
        return CraftingMats.get(i).get(tier);
    }

    public static List<RegistryObject<Item>> getAllCraftingMaterials(){
        List<RegistryObject<Item>> list = new ArrayList<>();
        for (int i = 0; i < TOOL_TYPES_PRIMITIVES.length; i++) {
            final int I = i;
            ModItemTier.ourTiers.forEach((name,tier)->{
                list.add(getCraftingMaterialsOf(I,tier));
            });
        }
        return list;
    }

//    static void register_axes() {
//        String head_mat = "";
//        String rod_mat = "";
//        Registration.ITEMS.register("gt_axe" + "_" + rod_mat + "_" + head_mat,
//                () -> new Item(new Item.Properties().addToolType(ToolType.AXE, 2)));
//    }

    static void register() {

    }
}
