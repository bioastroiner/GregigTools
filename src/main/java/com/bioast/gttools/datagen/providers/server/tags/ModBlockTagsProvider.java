package com.bioast.gttools.datagen.providers.server.tags;

import com.bioast.gttools.core.Ref;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Ref.ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        return;
        //getOrCreateRawBuilder(Tags.Blocks.CHESTS).addTag(Blocks.ACACIA_BUTTON,);
        /*
        getOrCreateBuilder(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SILVER);
        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModBlocks.SILVER_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER);
        */
        //getOrCreateRawBuilder()
    }
}