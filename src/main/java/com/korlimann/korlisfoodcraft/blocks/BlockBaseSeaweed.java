package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.blocks.material.MaterialSeaweed;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBaseSeaweed extends Block implements IHasModel, IPlantable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
	
	public static MaterialSeaweed seaweed = new MaterialSeaweed(MapColor.DIRT);
	
	public BlockBaseSeaweed(String name) {
		super(seaweed);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
	}
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		//Gets the block where the seaweed is going to be placed on top of
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        //Gets the block where the seaweed actually is going to be
        IBlockState state2 = worldIn.getBlockState(pos);
        //Block block2 = state.getBlock();
        //Gets the block above the seaweed
        IBlockState state3 = worldIn.getBlockState(pos.up());
        //Block block3 = state.getBlock();
        //Checks if the block where the seaweed is going to be is water and if the block above is also water
        if(state2.getMaterial() == Material.WATER && state3.getMaterial() == Material.WATER) {
        	//Checks if the block where the seaweed is going to be placed can sustain the seaweed
        	//if (block.canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this)) return true;
        	//Checks if the block where the seaweed is going to be placed IS already seaweed (just like how you can place a reed block on top of another)
	        if (block == this)
	        {
	            return true;
	        }
	        //Checks if the block where the seaweed is going to be placed is anything BUT the given blocks
	        else if (block != Blocks.GRASS && block != Blocks.DIRT && block != Blocks.SAND)
	        {
	            return false;
	        }
	        else
	        {
	            BlockPos blockpos = pos.down();
	
	            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
	            {
	                IBlockState iblockstate = worldIn.getBlockState(blockpos.offset(enumfacing));
	
	                if (iblockstate.getMaterial() == Material.WATER || iblockstate.getBlock() == Blocks.FROSTED_ICE)
	                {
	                    return true;
	                }
	            }
	
	            return true;
	        }
        } else {
        	return false;
        }
    }
	
	/*@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		if();
	}*/
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		//Gets the block above the seaweed
		IBlockState state2 = worldIn.getBlockState(pos.up());
        //Checks if the block is seaweed
        if (worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.SEAWEED_BLOCK || this.checkForDrop(worldIn, pos, state))
        {
            if (this.canPlaceBlockAt(worldIn, pos.up()))
            {
                int i;

                for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i)
                {
                    ;
                }

                if (i < 3)
                {
                    int j = ((Integer)state.getValue(AGE)).intValue();

                    if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true))
                    {
                    if (j == 15)
                    {
                        worldIn.setBlockState(pos.up(), this.getDefaultState());
                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 4);
                    }
                    else
                    {
                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
                    }
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    }
                }
            }
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        this.checkForDrop(worldIn, pos, state);
    }

    protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canBlockStay(worldIn, pos))
        {
            return true;
        }
        else
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
            return false;
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
    	//Gets the block where the seaweed is going to be placed on top of
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        //Gets the block where the seaweed actually is going to be
        //IBlockState state2 = worldIn.getBlockState(pos);
        //Block block2 = state.getBlock();
        //Gets the block above the seaweed
        IBlockState state3 = worldIn.getBlockState(pos.up());
        //Block block3 = state.getBlock();
        //Checks if the block where the seaweed is going to be is water and if the block above is also water
     if(state3.getMaterial() == Material.WATER||state3.getMaterial() == seaweed)
     {
        	//Checks if the block where the seaweed is going to be placed can sustain the seaweed
        	//if (block.canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this)) return true;
        	//Checks if the block where the seaweed is going to be placed IS already seaweed (just like how you can place a reed block on top of another)
	        if (block == this)
	        {
	            return true;
	        }
	        //Checks if the block where the seaweed is going to be placed is anything BUT the given blocks
	        else if (block != Blocks.GRASS && block != Blocks.DIRT && block != Blocks.SAND)
	        {
	            return false;
	        }
	        
        
        	return true;
     }
     return false;

    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.SEAWEED;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModItems.SEAWEED);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this, new IProperty[] {AGE});
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Water;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.getDefaultState();
	}

}
