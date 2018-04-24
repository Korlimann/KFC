package com.korlimann.korlisfoodcraft.gen;

import java.util.Random;

import com.korlimann.korlisfoodcraft.init.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class KFCWorldGen implements IWorldGenerator
{
	/*
	 * This class is used for implementing, for example, new ores into the world generation.
	 * That means, that when you create a new world, salt ore will be spread all over the world.
	 * */
	
	private WorldGenerator salt_ore;
	private WorldGenerator seaweed_block;
	private WorldGenerator fruit_tree_avocado;
	
	public KFCWorldGen() 
	{
		salt_ore = new WorldGenMinable(ModBlocks.SALT_ORE.getDefaultState(), 15);
		seaweed_block = new WorldGenSeaweed(ModBlocks.SEAWEED_BLOCK);
		//fruit_tree_avocado = new WorldGenFruitTree(true, 6, ModBlocks.AVOCADO_BLOCK);
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case 0:
			
			runGenerator(salt_ore, world, random, chunkX, chunkZ, 10, 0, 120);
			runGenerator(seaweed_block, world, random, chunkX, chunkZ, 50, 0, 256);
			//runGenerator(fruit_tree_avocado, world, random, chunkX, chunkZ, 100, 0, 256);
			
			break;
			
		case 1:
			
			break;
			
		case -1:
		
			break;
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}

}
