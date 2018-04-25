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
		BlockPos pos1 = getGroundPosFromAbove(worldIn, pos).up();	
		if(block.canPlaceBlockAt(worldIn, pos1)) {
			worldIn.setBlockState(pos1, block.getDefaultState(), 2);
			return true;
		}
		else return false;
	}
	
	private BlockPos getGroundPosFromAbove(World worldIn, BlockPos pos)
	{
		
		for(int i=255; i>=60; i--) {
			BlockPos pos1 = new BlockPos(pos.getX(),i ,pos.getZ());
			IBlockState state1 = worldIn.getBlockState(pos1);
			if(!(state1.getMaterial() == Material.AIR))
			{
				return pos1;
			}
			
		}	
		return pos;
	}

}
