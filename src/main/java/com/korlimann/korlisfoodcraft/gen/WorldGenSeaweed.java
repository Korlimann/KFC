package com.korlimann.korlisfoodcraft.gen;

import java.util.Random;

import com.korlimann.korlisfoodcraft.blocks.BlockBaseSeaweed;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSeaweed extends WorldGenerator{

	private final BlockBaseSeaweed block;
	
	private int patchSize =1;

    public WorldGenSeaweed(BlockBaseSeaweed blockIn,int patchSize)
    {
        this.block = blockIn;
        setPatchSize(patchSize);
    }

    public void setPatchSize(int patchSize)
    {
    	if(patchSize>0)
    	this.patchSize = patchSize;
    	else
    		throw new IllegalArgumentException("Illegal PatchSize");
    }
    public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
    	IBlockState state2 = worldIn.getBlockState(pos.up());
        //if("beach".equalsIgnoreCase(worldIn.getBiome(pos).getBiomeName())||"ocean".equalsIgnoreCase(worldIn.getBiome(pos).getBiomeName()))
        for (int i = 0; i < patchSize; ++i)
        {
            BlockPos blockpos = pos.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));

            if (state2.getMaterial() == Material.WATER)
            {
                BlockPos blockpos1 = blockpos.up();

                if (worldIn.getBlockState(blockpos1).getMaterial() == Material.WATER)
                {
                    int j = 2 + rand.nextInt(rand.nextInt(3) + 1);

                    for (int k = 0; k < j; ++k)
                    {
                        if (block.canPlaceBlockAt(worldIn, blockpos.up(k)))
                        {
                            worldIn.setBlockState(blockpos.up(k), block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }

}
