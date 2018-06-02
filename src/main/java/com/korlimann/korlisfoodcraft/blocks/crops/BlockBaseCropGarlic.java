package com.korlimann.korlisfoodcraft.blocks.crops;

import com.korlimann.korlisfoodcraft.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropGarlic extends BlockCrops {

	public BlockBaseCropGarlic() {
		setUnlocalizedName("crop_garlic");
		setRegistryName("crop_garlic");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.GARLIC;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.GARLIC;
	}
}
