package com.korlimann.korlisfoodcraft.gen;

import java.util.Random;

import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.util.RngHelper;

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
	private WorldGenerator herbgarden;
	
	public KFCWorldGen() 
	{
		salt_ore = new WorldGenMinable(ModBlocks.SALT_ORE.getDefaultState(), 15);
		seaweed_block = new WorldGenSeaweed(ModBlocks.SEAWEED_BLOCK,10);
		herbgarden = new WorldGenHerbs(ModBlocks.HERBGARDEN);
		fruit_tree_avocado = new WorldGenFruitTree(true, 5, ModBlocks.AVOCADO_BLOCK);
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case 0:
			//chunkChance is the percentage how likely it is to spawn a patch in a Chunk
			//any ChunkChance higher then including 100 is always true
			//PatchPercentage is the percentage the generator gets for blocks in a Chunk
			//PatchRuns is the number of times the PercentageRNG runs to get the Blocks per Chunk
			
			
			runGeneratorOre(salt_ore, world, random, chunkX, chunkZ, 95,5, 85, 0, 120);
			runGeneratorSeaweed(seaweed_block, world, random, chunkX, chunkZ, 95, 2, 75, 0, 256);
			//Min Height does not affect this Generator
			runGeneratorHerbs(herbgarden, world, random, chunkX, chunkZ, 99, 4, 65, 60, 120);
			runGeneratorSeaweed(fruit_tree_avocado, world, random, chunkX, chunkZ, 54, 4,95,60, 256);
			
			break;
			
		case 1:
			
			break;
			
		case -1:
		
			break;
		}
	}
	
	private void runGeneratorOre(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int patchPercentage,int patchRuns,int chunkChance, int minHeight, int maxHeight)
	{
		if(RngHelper.getPercentageRNG(rand, chunkChance)>=1)
		{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		int bpc = RngHelper.getRepeatedPercentageRNG(rand, patchPercentage, patchRuns);
		for(int i = 0; i < bpc; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
		}
	}
	
	private void runGeneratorSeaweed(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int patchPercentage,int patchRuns,int chunkChance, int minHeight, int maxHeight)
	{
		
		if(RngHelper.getPercentageRNG(rand, chunkChance)>=1)
		{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		
		int bpc = RngHelper.getRepeatedPercentageRNG(rand, patchPercentage, patchRuns);
		for(int i = 0; i < bpc; i++)
		{
			int x = 2+ chunkX * 16 + rand.nextInt(8);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = 2+ chunkZ * 16 + rand.nextInt(8);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		
		}}
	}
	private void runGeneratorHerbs(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int patchPercentage,int patchRuns,int chunkChance, int minHeight, int maxHeight)
	{
		if(RngHelper.getPercentageRNG(rand, chunkChance)>=1)
		{
		if(minHeight > maxHeight || minHeight < 60) throw new IllegalArgumentException("Herbs generated out of bounds");
		
		int bpc = RngHelper.getRepeatedPercentageRNG(rand, patchPercentage, patchRuns);
		
		for(int i = 0; i < bpc; i++)
		{
			int x = 2 + chunkX * 16 + rand.nextInt(8);
			int y = maxHeight;
			int z = 2 + chunkZ * 16 + rand.nextInt(8);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
		}
	}
	
	
}
