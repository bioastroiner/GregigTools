package com.bioast.gttools.core;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.Logger;

public final class Ref {
    public static String id() {
        return Main.MOD_ID;
    }

    public static final String ID = id();

    public static String ver() {
        return "0.0";
    }

    public static Logger out(){
        return Main.LOGGER;
    }

    public static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> reg(T of) {
        return null;
    }
}
