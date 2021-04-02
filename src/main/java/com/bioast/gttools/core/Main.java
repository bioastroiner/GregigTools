package com.bioast.gttools.core;

import com.bioast.gttools.client.ClientSetup;
import com.bioast.gttools.core.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.bioast.gttools.core.Main.MOD_ID;

@Mod(MOD_ID)
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger();
	
	static final String MOD_ID = "gttools";

    public Main() {
        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        new ClientSetup(event);
    }
}
