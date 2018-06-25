package com.korlimann.korlisfoodcraft.blocks;

import com.korlimann.korlisfoodcraft.Main;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCompostHeap extends Block implements IHasModel {

	public static final PropertyInteger FILL = PropertyInteger.create("fill", 0, 7);
	
	public BlockCompostHeap(String name, boolean creativeTab) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		if(creativeTab)
		setCreativeTab(Main.korlissushicraft);
	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		ItemStack hhi = playerIn.getHeldItemMainhand();
		IBlockState state = worldIn.getBlockState(pos);
		
		if(((Integer)state.getValue(FILL)).intValue()==7) {
			if(hhi.getItem() != null) {
				if(hhi.getItem() == ModItems.BANANA_PEEL) {
					worldIn.setBlockState(pos, state.withProperty(FILL, Integer.valueOf(((Integer)state.getValue(FILL)).intValue() + 1)), 2);
				}
			}
		} else {
				playerIn.addItemStackToInventory(new ItemStack(ModItems.FERTILIZER));
				worldIn.setBlockState(pos, state.withProperty(FILL, Integer.valueOf(0)), 2);
		}
	}
	
	 public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(FILL, Integer.valueOf((meta & 15)));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        i = i | ((Integer)state.getValue(FILL)).intValue();
	        return i;
	    }

	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {FILL});
	    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	
}
