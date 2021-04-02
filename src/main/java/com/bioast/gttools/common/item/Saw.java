package com.bioast.gttools.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Saw extends AxeItem {
    public Saw(IItemTier p_i48530_1_, float p_i48530_2_, float p_i48530_3_, Properties p_i48530_4_) {
        super(p_i48530_1_, p_i48530_2_, p_i48530_3_, p_i48530_4_);
    }

    @Override
    public boolean mineBlock(ItemStack stack, World world, BlockState state, BlockPos pos,
                             LivingEntity entity) {
        BlockState block = state.getToolModifiedState(world, pos, (PlayerEntity) entity, stack, ToolType.AXE);
        if (getAxeStrippingState(state) != null && block != null && !world.isClientSide) {
            world.setBlock(pos, block, 11);
            stack.hurtAndBreak(1, entity, (p) -> {
                p.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }
        if (!world.isClientSide && state.getDestroySpeed(world, pos) != 0.0F) {
            if (state.is(Blocks.ICE)) {
                spawnItem(world,pos,Items.ICE);
            }
            if (state.is(Blocks.BLUE_ICE)) {
                spawnItem(world,pos,Items.BLUE_ICE);
            }
            if (state.is(Blocks.PACKED_ICE)) {
                spawnItem(world,pos,Items.PACKED_ICE);
            }
            if(world.getBlockState(pos).is(Blocks.WATER))
                world.setBlock(pos,Blocks.AIR.defaultBlockState(),11 );
            stack.hurtAndBreak(1, entity, (p) -> {
                p.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    private static void spawnItem(World world, BlockPos pos, Item item) {
        world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                new ItemStack(item)));
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        if (state.is(Blocks.ICE) || state.is(Blocks.BLUE_ICE)
                || state.is(Blocks.PACKED_ICE))
            return true;
        return super.isCorrectToolForDrops(state);
    }

    @Override
    public float getDestroySpeed(ItemStack p_150893_1_, BlockState state) {
        if (state.is(BlockTags.LEAVES))
            return super.getDestroySpeed(p_150893_1_, state) + 5f;
        if (super.getDestroySpeed(p_150893_1_, state) != 0)
            return super.getDestroySpeed(p_150893_1_, state) + 3f;
        return super.getDestroySpeed(p_150893_1_, state);
    }
}
