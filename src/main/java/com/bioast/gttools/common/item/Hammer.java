package com.bioast.gttools.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Hammer extends PickaxeItem {
    public String tierName;

    public Hammer(IItemTier tier, int p_i48478_2_, float p_i48478_3_, Properties properties,String tierName) {
        super(tier, p_i48478_2_, p_i48478_3_, properties);
        this.tierName = tierName;
    }

    private static void spawnItem(World world, BlockPos pos, Item item) {
        world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                new ItemStack(item)));
    }

    @Override
    public boolean mineBlock(ItemStack stack, World world, BlockState state, BlockPos pos,
                             LivingEntity entity) {
        if (!world.isClientSide && state.getDestroySpeed(world, pos) != 0.0F) {
//            if(state.is(Tags.Blocks.COBBLESTONE)){
//                world.removeBlock(pos,false);
//                spawnItem(world,pos, Items.GRAVEL);
//            }
//            if(state.is(Tags.Blocks.GRAVEL) || state.is(Tags.Blocks.SANDSTONE)){
//                world.removeBlock(pos,false);
//                spawnItem(world,pos, Items.SAND);
//            }
            stack.hurtAndBreak(1, entity, (p) -> {
                p.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.METAL && material != Material.HEAVY_METAL
                && material != Material.STONE && material != Material.SAND && material != Material.GRASS
                && material != Material.DIRT
                ? super.getDestroySpeed(stack, state) : this.speed;
    }

    public static int getItemColor(ItemStack stack, int layer) {
        if (layer == 1) {
            return ModItemTier.getCol(((Hammer)stack.getItem()).tierName);
        }
        return 0xFFFFFF;
    }
}
