package com.korlimann.korlisfoodcraft.items;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBaseCoffeeBean extends Item implements IHasModel {

	
	public ItemBaseCoffeeBean(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
		
		//ModItems.ITEMS.add(this);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (block == Blocks.LOG && iblockstate.getValue(BlockOldLog.VARIANT) == BlockPlanks.EnumType.JUNGLE)
        {
            if (facing == EnumFacing.DOWN || facing == EnumFacing.UP)
            {
                return EnumActionResult.FAIL;
            }

            pos = pos.offset(facing);

            if (worldIn.isAirBlock(pos))
            {
                IBlockState iblockstate1 = ModBlocks.COFFEE_BEAN.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, 0, player, hand);
                worldIn.setBlockState(pos, iblockstate1, 10);

                if (!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.FAIL;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
