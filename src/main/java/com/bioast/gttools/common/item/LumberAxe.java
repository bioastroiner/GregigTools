package com.bioast.gttools.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LumberAxe extends AxeItem {
    public LumberAxe(IItemTier tier, float speed, float p_i48530_3_, Properties properties) {
        super(tier, speed, p_i48530_3_, properties);
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
                if (state2break.is(Blocks.AIR) || !state2break.is(BlockTags.LOGS) ||
                        !state2break.is(BlockTags.LEAVES))
                    break;
                if (state2break.isToolEffective(ToolType.AXE)) {
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
}
