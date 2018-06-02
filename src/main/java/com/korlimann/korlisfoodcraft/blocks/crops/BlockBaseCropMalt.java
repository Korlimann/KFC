package com.korlimann.korlisfoodcraft.blocks;

import com.korlimann.korlisfoodcraft.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropMalt extends BlockCrops {

	public BlockBaseCropMalt() {
		setUnlocalizedName("crop_malt");
		setRegistryName("crop_malt");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.MALT;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.MALT;
	}
}
