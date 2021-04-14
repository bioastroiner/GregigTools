package com.bioast.gttools.datagen.providers.client;

import com.bioast.gttools.core.Ref;
import com.bioast.gttools.core.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.Level;

import java.util.concurrent.atomic.AtomicInteger;

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

//        ModItems.Axes.forEach((t, i) -> {
//
//        });
//        ModItems.Hammers.forEach((t, i) -> {
//
//        });
//        ModItems.Saws.forEach((t, i) -> {
//
//        });
        AtomicInteger unOperatedNumbers = new AtomicInteger();
        ModItems.TOOL_MAP.forEach((I,n)->{
            ModItems.Tools.forEach((i, map) -> map.forEach((tier, item) -> {
                String typeName = item.get().toString().split("\\.")[1].split("_")[0];
                String matName = item.get().toString().split("\\.")[1].split("_")[1];
                String catgName = item.get().toString().split("\\.")[0]; // in this context it should always be "tools"

                switch (typeName){
                    case "axe":
                        builderTool(itemHandheld, item.get().toString(), "axe", "stick");
                        break;
                    case "saw":
                        builderTool(itemHandheld, item.get().toString(), "saw", "handle_saw");
                        break;
                    case "hammer":
                        builderTool(itemHandheld, item.get().toString(), "hammer", "stick");
                        break;
                    default:
                        unOperatedNumbers.getAndIncrement();
                        break;
                }
                Ref.out().log(Level.DEBUG,typeName + " with material of: " + matName + "has passed!");
                if(!catgName.equals("tools"))
                    Ref.out().log(Level.DEBUG,catgName + " isn't right!");
                else
                    Ref.out().log(Level.DEBUG,catgName + "'s model have finished!");
            }));
        });
        Ref.out().log(Level.DEBUG,"they were successful probably...");
        Ref.out().log(Level.DEBUG,"number of ToolTypes that didn't got Model because i was stupid. if 0 yay >_< : "+unOperatedNumbers.get());

        ModItems.CraftingMats.forEach((i, m) -> {
            m.forEach((tier, item) -> {
                builder(itemGenerated, item.get().toString(), ModItems.TOOL_MAP.get(i).toLowerCase());
            });
        });
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name, String textName) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + textName);
    }

    private ItemModelBuilder builderTool(ModelFile itemGenerated, String name, String toolName, String rodName) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + rodName)
                .texture("layer1", "item/" + toolName);
    }
}