package com.bioast.gttools.client;

import com.bioast.gttools.common.item.LumberAxe;
import com.bioast.gttools.core.setup.ModItems;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public ClientSetup(FMLClientSetupEvent event){

    }
    public static void registerItemColor(ColorHandlerEvent.Item event) {
        event.getItemColors().register(LumberAxe::getItemColor, ModItems.L_AXE.get());
    }
}
