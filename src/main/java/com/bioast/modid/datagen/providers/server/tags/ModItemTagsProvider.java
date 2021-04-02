package com.bioast.modid.datagen.providers.server.tags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.bioast.modid.core.ModName.MOD_ID;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,
                               ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        /*
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
        */
    }
}