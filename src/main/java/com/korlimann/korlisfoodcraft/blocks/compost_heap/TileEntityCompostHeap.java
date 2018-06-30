package com.korlimann.korlisfoodcraft.blocks.compost_heap;

import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityCompostHeap extends TileEntity implements ITickable {

	private int fill;
	private int age;
	private int time;
	
	private static final int tickTime = 100;
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.fill = compound.getInteger("Fill");
		this.age = compound.getInteger("Age");
		this.time = compound.getInteger("Time");
		
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("Fill", this.fill);
		compound.setInteger("Age", this.age);
		compound.setInteger("Time", this.time);
		return compound;
	}
	/*@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}*/
	private int incrementAge()
	{
		this.age++;
		//markDirty();
		return this.age;
	}
	
	public int incrementFill()
	{
		if(this.fill<7)
		{
			this.fill++;
			setBlockToUpdate();
		}
		return this.fill;
	}
	public int getAge() {
		return age;
	}
	public int getFill() {
		return fill;
	}
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}
	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		world.notifyBlockUpdate(pos, getState(), getState(), 3);
		handleUpdateTag(pkt.getNbtCompound());
	}
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	private void setBlockToUpdate() {
		sendUpdates();
		//shouldUpdate = true;
	}
	
	private void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, pos);
		world.notifyBlockUpdate(pos, getState(), getState(), 3);
		//world.scheduleBlockUpdate(pos,this.getBlockType(),0,0);
		markDirty();
	}
	private IBlockState getState() {
		return world.getBlockState(pos);
	}

	@Override
	public void update() {
		if(fill==7) 
			if(age<3)
				if(this.canAge())
					this.incrementAge();
	}
	private boolean canAge() {
		if(time ==  tickTime)
		{
			time=0;
			return true;
		}
		else
		{
			time++;
			return false;
		}
	}

	public void clear()
	{
		fill = 0;
		age = 0;
		time = 0;
		setBlockToUpdate();
	}
}
