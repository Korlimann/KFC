package com.korlimann.korlisfoodcraft.blocks.machines.smoothie_maker.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSmoothieMakerOutput extends Slot {

	@SuppressWarnings("unused")
	private final EntityPlayer player;
	@SuppressWarnings("unused")
	private int removeCount;
	
	public SlotSmoothieMakerOutput(EntityPlayer player, IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		this.player = player;
	}
	
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
		this.onCrafting(stack);
		super.onTake(thePlayer, stack);
		return stack;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) {
		if(this.getHasStack()) this.removeCount += Math.min(amount,  this.getStack().getCount());
		return super.decrStackSize(amount);
	}

}
