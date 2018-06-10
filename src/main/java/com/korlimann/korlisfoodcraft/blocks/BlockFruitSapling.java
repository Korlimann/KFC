package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.gen.WorldGenFruitTree;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockFruitSapling extends BlockBush implements IHasModel, IGrowable {

	
	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	public BlockBaseFruit fruit;
	public BlockBaseFruitLeaves leaves;
	public BlockFruitSapling(String name, BlockBaseFruit fruit,boolean CreativeTab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		if(CreativeTab)
			setCreativeTab(Main.korlissushicraft);
		this.fruit=fruit;
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
	}
	public BlockFruitSapling(String name, BlockBaseFruitLeaves fruitLeaves,boolean CreativeTab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		if(CreativeTab)
			setCreativeTab(Main.korlissushicraft);
		this.fruit=fruit;
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	
	@Override
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this, new IProperty[] {STAGE});
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return SAPLING_AABB;
		
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return NULL_AABB;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		// TODO Auto-generated method stub
		return this.getDefaultState().withProperty(STAGE, Integer.valueOf(meta & 8) >> 3);
	}
	
	@Override
	public void onPlantGrow(IBlockState state, World world, BlockPos pos, BlockPos source) {
		// TODO Auto-generated method stub
		super.onPlantGrow(state, world, pos, source);
	}

	
		public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;

	        WorldGenerator worldgenerator;
	        if(fruit==null)
	        {
	        	worldgenerator = new WorldGenTrees(true, 5,Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK) , ModBlocks.OLIVE_BLOCK.getDefaultState().withProperty(BlockBaseFruitLeaves.AGE, Integer.valueOf(0)), false);
	        }
	        else
	        {
	        	worldgenerator = new WorldGenFruitTree(true, 5, fruit);
	        }
	        

	        int i = 0;
	        int j = 0;
	        boolean flag = false;
	        
	        
	        

	        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();

	        if (flag)
	        {
	            worldIn.setBlockState(pos.add(i, 0, j), iblockstate2, 4);
	            worldIn.setBlockState(pos.add(i + 1, 0, j), iblockstate2, 4);
	            worldIn.setBlockState(pos.add(i, 0, j + 1), iblockstate2, 4);
	            worldIn.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate2, 4);
	        }
	        else
	        {
	            worldIn.setBlockState(pos, iblockstate2, 4);
	        }

	        if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j)))
	        {
	            if (flag)
	            {
	                worldIn.setBlockState(pos.add(i, 0, j), state, 4);
	                worldIn.setBlockState(pos.add(i + 1, 0, j), state, 4);
	                worldIn.setBlockState(pos.add(i, 0, j + 1), state, 4);
	                worldIn.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
	            }
	            else
	            {
	                worldIn.setBlockState(pos, state, 4);
	            }
	        }
	    }

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn,rand, pos,state);
            }
        }
    }
	@Override
	public int getMetaFromState(IBlockState state) {
		// TODO Auto-generated method stub
		int i = 0;
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
}
