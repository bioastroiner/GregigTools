package com.bioast.gttools.common.item;

import com.bioast.gttools.common.item.interfaces.IGTTool;
import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;

import java.util.Set;

public class GTTool extends ToolItem implements IGTTool {

    public String tierName;
    private int tool_type;

    public GTTool(float attackDamage, float attackSpeed, IItemTier tier, Set<Block> blockSet,
                  Properties properties, String tierName) {
        super(attackDamage, attackSpeed, tier, blockSet, properties);
        this.tierName = tierName;
    }
}
