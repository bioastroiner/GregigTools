package com.bioast.gttools.datagen.providers.server.loottables;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootTables {

    DeferredRegister<Block> Blocks; //set to your own registery

        @Override
        protected void addTables() {
            //registerDropSelfLootTable(ModBlocks.SILVER_BLOCK.get());
            //registerDropSelfLootTable(ModBlocks.SILVER_ORE.get());
        }

        @Override // for validation so it only chekcs our mod
        protected Iterable<Block> getKnownBlocks() {
            return Blocks.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }