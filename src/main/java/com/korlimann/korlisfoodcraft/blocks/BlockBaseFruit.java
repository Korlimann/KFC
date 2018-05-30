package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBaseFruit extends Block implements IGrowable, IHasModel {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
	public static AxisAlignedBB AABB;
	public Item fruit;
	public boolean canGrow;
	public boolean canUseBonemeal;
	private String type;
	
	
	public BlockBaseFruit(String name, Material materialIn, double x1, double y1, double z1, double x2, double y2, double z2, Item fruit, boolean grow, boolean bonemeal) {
		super(materialIn);
		this.fruit = fruit;
		this.canGrow = grow;
		this.canUseBonemeal = bonemeal;
		this.type=name;
		AABB = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
	}

	public BlockBaseFruit(String name, Material materialIn, Item fruit)
	{
		this(name,materialIn,0.25D, 0.25D, 0.25D, 0.75D, 1D, 0.75D, fruit, true, true);
	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return canGrow;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return canUseBonemeal;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(((Integer)state.getValue(AGE)).intValue() + 1)), 2);
	}
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return NULL_AABB;
	}
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlock(worldIn, pos, state);
        }
        else
        {
            int i = ((Integer)state.getValue(AGE)).intValue();

            if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0))
            {
                worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
            }
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos.up());
        return iblockstate.getBlock() == Blocks.LEAVES;
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlock(worldIn, pos, state);
        }
    }

    private void dropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }
    
    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        if(((Integer)state.getValue(AGE)).intValue()==3)
        {
        	drops.add(new ItemStack(fruit));
        }
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(fruit);
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf((meta & 15) >> 2));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((Integer)state.getValue(AGE)).intValue() << 2;
        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
        return AABB;
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(((Integer)state.getValue(AGE)).intValue()==3) {
			playerIn.addItemStackToInventory(new ItemStack(fruit));
			worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 2);
			return true;
		}
		return false;
		
	}
	
	//Only Call When a Value for this already exists in BlockBaseFruit.EnumType
	//Automatically Creates Sapling that creates a FruitTree
	//Only Call once for each Fruit
	public BlockFruitSapling createFruitTreeAndSapling()
	{
		BlockFruitSapling ret = new BlockFruitSapling(this.getTypeName()+"_sapling",this);
		
		return ret;
	}
	
	public String getTypeName()
	{
		return type;
	}
	
	
}
