package com.bioast.gttools.core.setup;

import com.bioast.gttools.common.item.LumberAxe;
import com.bioast.gttools.common.item.Saw;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> L_AXE = Registration.ITEMS.register("gt_axe",
            () -> new LumberAxe(ItemTier.IRON,6,-3,new Item.Properties().addToolType(ToolType.AXE, 2)));
    public static final RegistryObject<Item> L_SAW = Registration.ITEMS.register("gt_saw",
            () -> new Saw(ItemTier.IRON,6,-3,new Item.Properties().addToolType(ToolType.AXE, 2)));

    static void register_axes(){
        String head_mat = "";
        String rod_mat = "";
        Registration.ITEMS.register("gt_axe" + "_" + rod_mat + "_" + head_mat,
                () -> new Item(new Item.Properties().addToolType(ToolType.AXE, 2)));
    }

    static void register() {

    }
}
