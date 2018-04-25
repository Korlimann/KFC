package com.korlimann.korlisfoodcraft.gen;

import java.util.Random;

import com.korlimann.korlisfoodcraft.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenBush;
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
		seaweed_block = new WorldGenSeaweed(ModBlocks.SEAWEED_BLOCK);
		herbgarden = new WorldGenHerbs(ModBlocks.HERBGARDEN);
		//fruit_tree_avocado = new WorldGenFruitTree(true, 6, ModBlocks.AVOCADO_BLOCK);
	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case 0:
			
			runGeneratorOre(salt_ore, world, random, chunkX, chunkZ, 10, 0, 120);
			runGeneratorOre(seaweed_block, world, random, chunkX, chunkZ, 50, 0, 256);
			runGeneratorHerbs(herbgarden, world, random, chunkX, chunkZ, 500, 60, 75);
			//runGenerator(fruit_tree_avocado, world, random, chunkX, chunkZ, 100, 0, 256);
			
			break;
			
		case 1:
			
			break;
			
		case -1:
		
			break;
		}
	}
	
	private void runGeneratorOre(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
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
	
	private void runGeneratorHerbs(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 60 || maxHeight > 75) throw new IllegalArgumentException("Herbs generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = maxHeight;
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	
	private void runGeneratorHerb(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
            throw new IllegalArgumentException("Ore generated out of bounds");
        for (int i = 0; i < chance; i++)
        {
            int x = chunkX + rand.nextInt(16);
            int z = chunkZ + rand.nextInt(16);
            int y = 128;
            int direction = 1;
            if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.AIR)
                direction = -1;
            for (int yChunk = 8; yChunk < 16 && yChunk > 0; yChunk += direction)
            {
                int direction2 = 1;
                if (world.getBlockState(new BlockPos(x, yChunk + 4, z)).getBlock() == Blocks.AIR)
                    direction2 = -1;
                for (int yOffset = 8; yOffset < 16 && yOffset > 0; yOffset += direction2)
                    if (world.getBlockState(new BlockPos(x, yChunk * 16 + yOffset, z)).getBlock() == Blocks.GRASS &&
                            (yChunk * 16 + yOffset + 1 < 256 || world.getBlockState(new BlockPos(x, yChunk * 16 +
                                    yOffset + 1, z))
                                    .getBlock() == Blocks.AIR))
                    {
                        y = yChunk * 16 + yOffset;
                        break;
                    }
                if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.GRASS &&
                        (y + 1 < 255 || world.getBlockState(new BlockPos(x, y + 1, z))
                                .getBlock() == Blocks.AIR))
                    break;
            }

            gen.generate(world, rand, new BlockPos(x, y+1, z));
        }
    }
}
