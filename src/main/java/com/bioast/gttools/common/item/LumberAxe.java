package com.bioast.gttools.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LumberAxe extends AxeItem {
    public String tierName;

    public LumberAxe(IItemTier tier, float attackDamage, float attackSpeed, Properties properties, String tierName) {
        super(tier, attackDamage, attackSpeed, properties);
        this.tierName = tierName;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        return ActionResultType.PASS;
    }

    @Override
    public boolean mineBlock(ItemStack stack, World world, BlockState state, BlockPos blockPos, LivingEntity entity) {
        if (!world.isClientSide && state.getDestroySpeed(world, blockPos) != 0.0F) {
            for (int i = 1; i < 50; i++) {
                BlockPos pos2break = blockPos.above(i);
                if (pos2break.getY() > world.getMaxBuildHeight())
                    break;
                BlockState state2break = world.getBlockState(pos2break);
                if (state2break.is(Blocks.AIR))
                    break;
                if (state2break.isToolEffective(ToolType.AXE) && state2break.is(BlockTags.LOGS)) {
                    world.destroyBlock(pos2break, true, entity);
                    stack.hurtAndBreak(1, entity, p -> {
                        p.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                    });
                }
            }
        }

        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getMaterial() == Material.LEAVES)
            return this.speed + 5;
        return super.getDestroySpeed(stack, state);
    }

    public static int getItemColor(ItemStack stack, int layer) {
        if (layer == 1) {
            return ModItemTier.getCol(((LumberAxe)stack.getItem()).tierName);
        }
        return 0xFFFFFF;
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if(allowdedIn(group)){

        }
    }
}
