package com.korlimann.korlisfoodcraft.blocks.compost_heap;

import com.korlimann.korlisfoodcraft.blocks.BlockTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityCompostHeap extends TileEntity {

	private int fill;
	private int age;
	private EnumFacing facing;
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.fill = compound.getInteger("Fill");
		this.age = compound.getInteger("Age");
		this.facing = EnumFacing.getFront(compound.getInteger("Facing"));
		
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeToNBT(compound);
		compound.setInteger("Fill", this.fill);
		compound.setInteger("Age", this.age);
		compound.setInteger("Facing", this.facing.getIndex());
		
		return compound;
	}
	/*@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		// TODO Auto-generated method stub
		return false;
	}*/
	

}
