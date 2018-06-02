package com.korlimann.korlisfoodcraft.blocks.crops;

import com.korlimann.korlisfoodcraft.init.ModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropRice extends BlockCrops {

	public BlockBaseCropRice() {
		setUnlocalizedName("crop_rice");
		setRegistryName("crop_rice");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.RICE;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.RICE;
	}
}