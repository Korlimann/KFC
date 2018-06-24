package com.korlimann.korlisfoodcraft.blocks.machines.ice_machine;

import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.slots.SlotIceMachineFuel;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.slots.SlotIceMachineOutput;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerIceMachine extends Container {

	private final TileEntityIceMachine tileentity;
	private int cookTime, totalCookTime, burnTime, currentBurnTime;
	
	public ContainerIceMachine(InventoryPlayer player, TileEntityIceMachine tileentity) {
		this.tileentity = tileentity;
		//add different coordinates to make it fitting to the bg texture
		this.addSlotToContainer(new Slot(tileentity, 0, 30, 16));
		this.addSlotToContainer(new Slot(tileentity, 1, 53, 16));
		this.addSlotToContainer(new Slot(tileentity,2,79,16));
		this.addSlotToContainer(new SlotIceMachineFuel(tileentity, 3, 56, 53));
		this.addSlotToContainer(new SlotIceMachineOutput(player.player, tileentity, 4, 116, 35));
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x <9; x++) {
				this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for(int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}

	@Override
	public void addListener(IContainerListener listener) 
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileentity);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.listeners.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			
			if(this.cookTime != this.tileentity.getField(2)) listener.sendWindowProperty(this, 2, this.tileentity.getField(2));
			if(this.burnTime != this.tileentity.getField(0)) listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
			if(this.currentBurnTime != this.tileentity.getField(1)) listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
			if(this.totalCookTime != this.tileentity.getField(3)) listener.sendWindowProperty(this, 3, this.tileentity.getField(3));
		}
		
		this.cookTime = this.tileentity.getField(2);
		this.burnTime = this.tileentity.getField(0);
		this.currentBurnTime = this.tileentity.getField(1);
		this.totalCookTime = this.tileentity.getField(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) 
	{
		this.tileentity.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.tileentity.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()) 
		{
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(index == 4) 
			{
				if(!this.mergeItemStack(stack1, 5, 41, true)) return ItemStack.EMPTY;
				slot.onSlotChange(stack1, stack);
			}
			else if(index != 2 && index != 1 && index != 0 && index!=3) 
			{		
				
				//???  Don't know how to handle this
				Slot slot1 = (Slot)this.inventorySlots.get(index + 1);
				
				if(!IceMachineRecipes.getInstance().getIceResult(stack1, slot1.getStack()).isEmpty())
				{
					if(!this.mergeItemStack(stack1, 0, 2, false)) 
					{
						return ItemStack.EMPTY;
					}
					else if(TileEntityIceMachine.isItemFuel(stack1))
					{
						if(!this.mergeItemStack(stack1, 3, 4, false)) return ItemStack.EMPTY;
					}
					else if(TileEntityIceMachine.isItemFuel(stack1))
					{
						if(!this.mergeItemStack(stack1, 3, 4, false)) return ItemStack.EMPTY;
					}
					else if(TileEntityIceMachine.isItemFuel(stack1))
					{
						if(!this.mergeItemStack(stack1, 3, 4, false)) return ItemStack.EMPTY;
					}
					else if(index >= 4 && index < 32)
					{
						if(!this.mergeItemStack(stack1, 32, 41, false)) return ItemStack.EMPTY;
					}
					else if(index >= 32 && index < 41 && !this.mergeItemStack(stack1, 5, 32, false))
					{
						return ItemStack.EMPTY;
					}
				}
			} 
			else if(!this.mergeItemStack(stack1, 5, 41, false)) 
			{
				return ItemStack.EMPTY;
			}
			if(stack1.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();

			}
			if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
			slot.onTake(playerIn, stack1);
		}
		return stack;
	}
}
