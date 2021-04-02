package com.bioast.gttools.core.setup;

import com.bioast.gttools.common.item.Hammer;
import com.bioast.gttools.common.item.LumberAxe;
import com.bioast.gttools.common.item.ModItemTier;
import com.bioast.gttools.common.item.Saw;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModItems {

    public static final Map<IItemTier,RegistryObject<Item>> Axes = new HashMap<>();

    public static final RegistryObject<Item> L_AXE = Registration.ITEMS.register("gt_axe",
            () -> new LumberAxe(ModItemTier.get("iron"),6,-3,new Item.Properties().addToolType(ToolType.AXE, 2),"iron"));
    public static final RegistryObject<Item> L_SAW = Registration.ITEMS.register("gt_saw",
            () -> new Saw(ModItemTier.get("iron"),6,-3,new Item.Properties().addToolType(ToolType.AXE, 2)));
    public static final RegistryObject<Item> L_HAMMER = Registration.ITEMS.register("gt_hammer",
            () -> new Hammer(ModItemTier.get("iron"),6,-3,new Item.Properties().addToolType(ToolType.SHOVEL, 2)));

    static {
        //Axes.put(ModItemTier.get("iron"),)
    }

    static void register_axes(){
        String head_mat = "";
        String rod_mat = "";
        Registration.ITEMS.register("gt_axe" + "_" + rod_mat + "_" + head_mat,
                () -> new Item(new Item.Properties().addToolType(ToolType.AXE, 2)));
    }

    static void register() {

    }
}
