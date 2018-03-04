package com.korlimann.korlisfoodcraft.blocks;

import com.korlimann.korlisfoodcraft.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropCorn extends BlockCrops {

	public BlockBaseCropCorn() {
		setUnlocalizedName("crop_corn");
		setRegistryName("crop_corn");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.CORN_SEED;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.CORN;
	}
}
