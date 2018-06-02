package com.korlimann.korlisfoodcraft.blocks.crops;

import com.korlimann.korlisfoodcraft.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropCucumber extends BlockCrops {

	public BlockBaseCropCucumber() {
		setUnlocalizedName("crop_cucumber");
		setRegistryName("crop_cucumber");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.CUCUMBER;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.CUCUMBER;
	}
}
