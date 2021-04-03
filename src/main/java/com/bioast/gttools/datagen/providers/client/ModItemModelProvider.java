package com.bioast.gttools.datagen.providers.client;

import com.bioast.gttools.core.Ref;
import com.bioast.gttools.core.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Ref.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //withExistingParent("silver_block", modLoc("block/silver_block"));
        //withExistingParent("silver_ore", modLoc("block/silver_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

//        builder(itemGenerated, "gt_axe");
//        builder(itemHandheld, "gt_saw");
//        builder(itemHandheld, "gt_hammer","gt_hammer");

        ModItems.Axes.forEach((t,i)->{
            builder(itemHandheld,i.get().toString(),"gt_axe");
        });
        ModItems.Hammers.forEach((t,i)->{
            builder(itemHandheld,i.get().toString(),"gt_hammer");
        });
        ModItems.Saws.forEach((t,i)->{
            builder(itemHandheld,i.get().toString(),"gt_saw");
        });
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name, String toolName) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + "stick")
                .texture("layer1","item/" + toolName);
    }
}