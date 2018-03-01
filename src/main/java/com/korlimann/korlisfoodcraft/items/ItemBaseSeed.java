package com.korlimann.korlisfoodcraft.items;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class ItemBaseSeed extends ItemSeeds implements IHasModel {

	/*
	 * This class creates custom seeds for plants, crops, etc. 
	 * */
	
	public ItemBaseSeed(Block crops, Block soil, String name) {
		super(crops, soil);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
		
		//ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	

}
