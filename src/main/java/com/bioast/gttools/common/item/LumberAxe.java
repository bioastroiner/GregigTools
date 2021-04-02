package com.bioast.gttools.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LumberAxe extends AxeItem {
    public LumberAxe(IItemTier p_i48530_1_, float p_i48530_2_, float p_i48530_3_, Properties p_i48530_4_) {
        super(p_i48530_1_, p_i48530_2_, p_i48530_3_, p_i48530_4_);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        return ActionResultType.PASS;
    }

    @Override
    public boolean mineBlock(ItemStack stack, World world, BlockState state, BlockPos blockPos, LivingEntity entity) {
        if (!world.isClientSide && state.getDestroySpeed(world, blockPos) != 0.0F) {
            for (int i = 1; i < 20; i++) {
                BlockPos pos2break = blockPos.above(i);
                BlockState state2break = world.getBlockState(pos2break);
                if(state2break.isToolEffective(ToolType.AXE)){
                    world.destroyBlock(pos2break,true,entity);
                }
            }
            stack.hurtAndBreak(1, entity, p -> {
                p.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }
}
