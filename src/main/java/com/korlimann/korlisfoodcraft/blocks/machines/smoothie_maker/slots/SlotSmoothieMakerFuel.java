package com.korlimann.korlisfoodcraft.blocks.machines.smoothie_maker.slots;

import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.TileEntityIceMachine;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSmoothieMakerFuel extends Slot {

	public SlotSmoothieMakerFuel(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityIceMachine.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}
}
