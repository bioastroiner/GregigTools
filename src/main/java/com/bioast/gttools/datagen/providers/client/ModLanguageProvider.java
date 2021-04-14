package com.bioast.gttools.datagen.providers.client;

import com.bioast.gttools.core.Ref;
import com.bioast.gttools.core.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.logging.log4j.Level;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen) {
        super(gen, Ref.id(), "en_us"); // TODO: provide a table with key values for international translation
    }

    @Override
    protected void addTranslations() {
        ModItems.Tools.forEach((i, map) -> map.forEach((tier, item) -> {
            String typeName = item.get().toString().split("\\.")[1].split("_")[0];
            String matName = item.get().toString().split("\\.")[1].split("_")[1];
            String catgName = item.get().toString().split("\\.")[0]; // in this context it should always be "tools"
            Ref.out().log(Level.DEBUG, item.get() + " is getting translated as: [" + matName + " " + typeName + "]");
            add(item.get(), matName + " " + typeName);
            Ref.out().log(Level.DEBUG, item.get() + " is translated over");
        }));
        ModItems.CraftingMats.forEach((i, m) -> m.forEach((tier, item) -> {
            String typeName = item.get().toString().split("\\.")[1].split("_")[0];
            String matName = item.get().toString().split("\\.")[1].split("_")[1];
            String catgName = item.get().toString().split("\\.")[0]; // in this context it should always be
            // "componenets"
            add(item.get(), matName + " " + typeName + " " + catgName);
            Ref.out().log(Level.DEBUG, item.get() + " is getting translated as: [" + matName + " " + typeName + "]");
        }));
        Ref.out().log(Level.DEBUG, "translationed!");
    }


}
