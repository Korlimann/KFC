package com.korlimann.korlisfoodcraft.blocks.compost_heap;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.blocks.BlockTileEntity;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCompostHeap extends Block implements IHasModel {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyInteger FILL = PropertyInteger.create("fill", 0, 3);
	
	public BlockCompostHeap(String name, boolean creativeTab) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FILL, Integer.valueOf(0)).withProperty(FACING, EnumFacing.NORTH));
		if(creativeTab)
		setCreativeTab(Main.korlissushicraft);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = (EnumFacing)state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FILL, FACING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront(meta & 3);
		if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FILL, meta & 3)/*.withProperty(FACING, facing)*/;
		}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((Integer)state.getValue(FILL)).intValue();
		//i = i | ((EnumFacing)state.getValue(FACING)).getIndex() << 2;
        return i;

	}

	/*@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		ItemStack hhi = playerIn.getHeldItemMainhand();
		IBlockState state = worldIn.getBlockState(pos);
		
		if(((Integer)state.getValue(FILL)).intValue()==7) {
			if(hhi.getItem() != null) {
				if(hhi.getItem() == ModItems.BANANA_PEEL) {
					worldIn.setBlockState(pos, state.withProperty(FILL, Integer.valueOf(((Integer)state.getValue(FILL)).intValue() + 1)), 2);
				}
			}
		} else {
				playerIn.addItemStackToInventory(new ItemStack(ModItems.FERTILIZER));
				worldIn.setBlockState(pos, state.withProperty(FILL, Integer.valueOf(0)), 2);
		}
	}*/
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack hhi = playerIn.getHeldItem(hand);
			
		if(!worldIn.isRemote) {
			if(((Integer)state.getValue(FILL)).intValue()<3) {
				if(hhi.getItem() != null) {
					if(hhi.getItem() == ModItems.BANANA_PEEL) {
						worldIn.setBlockState(pos, state.withProperty(FILL, Integer.valueOf(((Integer)state.getValue(FILL)).intValue() + 1)), 2);
						
						if(!playerIn.isCreative()) {
							playerIn.getHeldItem(hand).shrink(1);
						}
						return true;
					}
				} else {return false;}
			} else{
				worldIn.setBlockState(pos, ModBlocks.FILLED_COMPOST_HEAP.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
				if(!playerIn.isCreative()) {
					playerIn.getHeldItem(hand).shrink(1);
				}
			}
			return false;
		}
		return false;
	}
	
	/*@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(!worldIn.isRemote) {
			if(((Integer)state.getValue(FILL)).intValue()==7) {	
				int i = ((Integer)state.getValue(AGE)).intValue();

	            if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0))
	            {
	                worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
	                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
	            }
			}
		}
	}*/
	
	/*public boolean fillHeap(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		
	}*/
	
	 /*public IBlockState getStateFromMeta(int meta)
	    {
	        return this.getDefaultState().withProperty(FILL, Integer.valueOf((meta & 15)));
	    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    /*public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((Integer)state.getValue(FILL)).intValue();
        return i;
    }*/
	    
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public boolean hasTileEntity() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new TileEntityCompostHeap();
	}
}
