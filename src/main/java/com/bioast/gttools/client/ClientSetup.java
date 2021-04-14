package com.bioast.gttools.client;

import com.bioast.gttools.common.item.Hammer;
import com.bioast.gttools.common.item.LumberAxe;
import com.bioast.gttools.common.item.ModItemTier;
import com.bioast.gttools.common.item.Saw;
import com.bioast.gttools.core.setup.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public ClientSetup(FMLClientSetupEvent event){

    }
    public static void registerItemColor(ColorHandlerEvent.Item event) {
        ModItems.Axes.forEach((tier,item)->{
            event.getItemColors().register(LumberAxe::getItemColor, item.get());
        });
        ModItems.Hammers.forEach((tier,item)->{
            event.getItemColors().register(Hammer::getItemColor, item.get());
        });
        ModItems.Saws.forEach((tier,item)->{
            event.getItemColors().register(Saw::getItemColor, item.get());
        });
        ModItems.CraftingMats.forEach((i,m)->m.forEach((tier,item)->{
            event.getItemColors().register((s,l)->colorWrapper(s,l,0,((ModItemTier)tier).getColor()));
        }));
    }

    private static int colorWrapper(ItemStack stack,int layer, int layerToColor,int color){
//        if (layer == layerToColor) {
//            return color;
//        }
//        return 0xFFFFFF;
        return color;
    }
}
