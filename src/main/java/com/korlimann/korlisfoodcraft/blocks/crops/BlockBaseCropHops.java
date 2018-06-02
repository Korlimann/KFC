package com.korlimann.korlisfoodcraft.blocks;

import com.korlimann.korlisfoodcraft.init.ModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropHops extends BlockCrops {

	public BlockBaseCropHops() {
		setUnlocalizedName("crop_hops");
		setRegistryName("crop_hops");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.HOPS;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.HOPS;
	}
}