package com.korlimann.korlisfoodcraft.gen;

import java.util.Random;

import com.korlimann.korlisfoodcraft.blocks.BlockHerbgarden;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHerbs extends WorldGenerator {

	private final BlockBush block;
	
	public WorldGenHerbs(BlockBush herbgarden) {
		this.block = herbgarden;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		BlockPos pos1 = pos;
		int index = 0;
		boolean canPlace = false;
		for(int i=pos.getY(); i>=60; i--) {
			IBlockState state1 = worldIn.getBlockState(pos.down(index));
			IBlockState state2 = worldIn.getBlockState(pos.down(index-1));
			index++;
			if(state1.getMaterial() == Material.GRASS && state2.getMaterial() == Material.AIR) canPlace = true;
			if(canPlace) pos1 = new BlockPos(pos.getX(), i, pos.getZ());
		}			
		if(block.canPlaceBlockAt(worldIn, pos1)) {
			worldIn.setBlockState(pos1, block.getDefaultState(), 2);
			return true;
		}
		else return false;
	}

}
