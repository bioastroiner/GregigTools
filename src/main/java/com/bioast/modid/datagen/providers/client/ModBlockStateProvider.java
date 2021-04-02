package com.bioast.modid.datagen.providers.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.bioast.modid.core.ModName.MOD_ID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //simpleBlock(ModBlocks.SILVER_BLOCK.get());
        //simpleBlock(ModBlocks.SILVER_ORE.get());
    }
}