package com.bioast.gttools.datagen.providers.server.loottables;

import com.bioast.gttools.core.setup.Registration;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.stream.Collectors;

public class ModEntityLootTables extends EntityLootTables {

    DeferredRegister<EntityType<?>> Entities = Registration.ENTITIES;

    @Override
    protected void addTables() {

    }

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return Entities.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}