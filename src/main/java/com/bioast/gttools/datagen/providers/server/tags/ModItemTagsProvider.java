package com.bioast.gttools.datagen.providers.server.tags;

import com.bioast.gttools.core.Ref;
import com.bioast.gttools.core.setup.ModItems;
import com.bioast.gttools.core.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider,
                               ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, Ref.ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        ModTags.Items.TOOL_TAGS.forEach((name,tag)->{
            ModItems.Tools.forEach((id,map)->map.values().forEach(i->{
                if(name.equals(ModItems.TOOL_MAP.get(id)))
                tag(tag).add(i.get());
            }));
        });

        /*
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
        */
        //copy(Tags.Blocks.ORES, Tags.Items.ORES);
    }
}