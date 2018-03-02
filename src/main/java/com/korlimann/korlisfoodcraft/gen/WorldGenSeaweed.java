package com.korlimann.korlisfoodcraft.gen;

import java.util.Random;

import com.korlimann.korlisfoodcraft.blocks.BlockBaseSeaweed;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSeaweed extends WorldGenerator{

	private final BlockBaseSeaweed block;

    public WorldGenSeaweed(BlockBaseSeaweed blockIn)
    {
        this.block = blockIn;
    }

    public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
    	IBlockState state2 = worldIn.getBlockState(pos.up());
        
        for (int i = 0; i < 20; ++i)
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
