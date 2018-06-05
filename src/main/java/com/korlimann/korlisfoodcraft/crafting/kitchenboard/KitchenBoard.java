package com.korlimann.korlisfoodcraft.crafting.kitchenboard;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.gui.GUIType;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KitchenBoard extends Block {

	public KitchenBoard() {
		super(Material.WOOD);
		setSoundType(SoundType.WOOD);
		setHardness(1.5F);
		setResistance(3.0F);
		setUnlocalizedName("kitchenboard");
		setRegistryName("kitchenboard");
		setCreativeTab(Main.korlissushicraft);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.openGui(Main.instance, GUIType.KITCHENBOARD.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

}
