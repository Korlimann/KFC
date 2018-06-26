package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockFilledCompostHeap extends Block implements IHasModel {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
	
	public BlockFilledCompostHeap(String name, boolean creativeTab) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		if(creativeTab)
		setCreativeTab(Main.korlissushicraft);
	}

	/*@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		ItemStack hhi = playerIn.getHeldItemMainhand();
		IBlockState state = worldIn.getBlockState(pos);
		
		if(((Integer)state.getValue(AGE)).intValue()==7) {
			if(hhi.getItem() != null) {
				if(hhi.getItem() == ModItems.BANANA_PEEL) {
					worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(((Integer)state.getValue(AGE)).intValue() + 1)), 2);
				}
			}
		} else {
				playerIn.addItemStackToInventory(new ItemStack(ModItems.FERTILIZER));
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 2);
		}
	}*/
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {			
		if(!worldIn.isRemote) {
			if(((Integer)state.getValue(AGE)).intValue()==3) {
					worldIn.setBlockState(pos, ModBlocks.COMPOST_HEAP.getDefaultState(), 2);			
					playerIn.addItemStackToInventory(new ItemStack(ModItems.FERTILIZER));
					return true;
			} 
			return false;
		}
		return false;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(!worldIn.isRemote) {
			if(((Integer)state.getValue(AGE)).intValue()<3) {	
				int i = ((Integer)state.getValue(AGE)).intValue();

	            if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0))
	            {
	                worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
	                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
	            }
			}
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(ModBlocks.COMPOST_HEAP);
	}
	
	/*public boolean AGEHeap(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		
	}*/
	
	 public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(AGE, Integer.valueOf((meta & 15)));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        i = i | ((Integer)state.getValue(AGE)).intValue();
	        return i;
	    }

	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {AGE});
	    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	
}
