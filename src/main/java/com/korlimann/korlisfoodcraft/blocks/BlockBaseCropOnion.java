package com.korlimann.korlisfoodcraft.blocks;

import com.korlimann.korlisfoodcraft.init.ModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockBaseCropOnion extends BlockCrops {

	public BlockBaseCropOnion() {
		setUnlocalizedName("crop_onion");
		setRegistryName("crop_onion");
	}
	
	@Override
	protected Item getSeed() {
		return ModItems.ONION;
	}
	
	@Override
	protected Item getCrop() {
		return ModItems.ONION;
	}
}