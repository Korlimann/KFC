package com.korlimann.korlisfoodcraft.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.korlimann.korlisfoodcraft.blocks.fruits.BlockBaseFruit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class WorldGenFruitTree extends WorldGenTrees {

	private static final IBlockState DEFAULT_TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;
    
    private ArrayList<BlockPos> fruitPlaces = new ArrayList<BlockPos>();
    
    private final Block fruit;

	public WorldGenFruitTree(boolean notify, int minTreeHeightIn, Block fruit)
    {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        this.metaWood = DEFAULT_TRUNK;
        this.metaLeaves = DEFAULT_LEAF;
        this.fruit = fruit;
    }
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(2) + this.minTreeHeight;
        boolean flag = true;

        //DEBUG
        //int checkY =0;
        
        
        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight())
        {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
            {
            	//DEBUG
            	//checkY++;
            	
            	
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < worldIn.getHeight())
                        {
                            if (!this.isReplaceable(worldIn,blockpos$mutableblockpos.setPos(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }
            //DEBUG
            //System.out.println("CheckY: " + checkY);
            if (!flag)
            {
                return false;
            }
            else
            {
            	//DEBUG
            	//System.out.println("Check x");
            	
            	
                IBlockState state = worldIn.getBlockState(position.down());

                if (state.getBlock().canSustainPlant(state, worldIn, position.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING) && position.getY() < worldIn.getHeight() - i - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);

                    for (int i3 = position.getY() - 3 + i; i3 <= position.getY() + i; ++i3)
                    {
                        int i4 = i3 - (position.getY() + i);
                        int j1 = 1 - i4 / 2;

                        for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1)
                        {
                            int l1 = k1 - position.getX();

                            for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2)
                            {
                                int j2 = i2 - position.getZ();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(k1, i3, i2);
                                    state = worldIn.getBlockState(blockpos);

                                    if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos) || state.getMaterial() == Material.VINE)
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, this.metaLeaves);
                                        IBlockState canPlaceFruit = worldIn.getBlockState(blockpos.down());                                        
                                        if(canPlaceFruit.getMaterial() == Material.AIR) {
                                        	fruitPlaces.add(blockpos.down());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int j3 = 0; j3 < i; ++j3)
                    {
                        BlockPos upN = position.up(j3);
                        state = worldIn.getBlockState(upN);

                        if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN) || state.getMaterial() == Material.VINE)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.metaWood);                            
                        }
                    }
                    
                    //DEBUG
                    //System.out.println("pass NoFruit");
                    
                    List<BlockPos> toRem = new ArrayList<BlockPos>();
                    for(BlockPos blockpos:fruitPlaces) {
                    	
                    	IBlockState canPlaceFruit = worldIn.getBlockState(blockpos);                                        
                        if(!(canPlaceFruit.getMaterial() == Material.AIR)) {
                        	toRem.add(blockpos);
                        }
                    }
                    fruitPlaces.removeAll(toRem);
                    toRem.clear();
                    for(int index = 0; index < 5; index++) {
                    	if(!(fruitPlaces.size()<3))
                    	{
                    		int place = rand.nextInt(fruitPlaces.size());
                    		placeFruit(worldIn, rand.nextInt(3),fruitPlaces.get(place));
                    		fruitPlaces.remove(fruitPlaces.get(place));    
                    	}
                    }
                }
        	}
            	fruitPlaces.clear();
                return true;
            }
            else
            {
                return false;
            }
        }
	 
	public void placeFruit(World worldIn, int p_181652_2_, BlockPos pos) {
		this.setBlockAndNotifyAdequately(worldIn, pos, fruit.getDefaultState().withProperty(BlockBaseFruit.AGE, Integer.valueOf(p_181652_2_)));
	}
}
