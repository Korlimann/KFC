package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBaseFruit extends Block implements IGrowable, IHasModel {

	public BlockBaseFruit(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		
	}

}
