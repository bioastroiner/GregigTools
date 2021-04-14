package com.bioast.gttools.core.setup;

import com.bioast.gttools.core.Ref;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ModTags {
    public static final class Blocks {
        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(Ref.id(), path).toString());
        }
    }

    public static final class Items {

        public static final Map<String,ITag.INamedTag<Item>> TOOL_TAGS = new HashMap();

        static {
            ModItems.TOOL_MAP.values().forEach(s -> {
                TOOL_TAGS.put(s,mod("tools/"+s.toLowerCase()));
            });
        }

        public static final ITag.INamedTag<Item> AXE_TOOL = forge("tools/axe");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(Ref.id(), path).toString());
        }
    }
}
