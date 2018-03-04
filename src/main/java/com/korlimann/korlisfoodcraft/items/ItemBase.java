package com.korlimann.korlisfoodcraft.items;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

	/*
	 * This class creates custom items with no special function. 
	 * */
	
	public ItemBase(String name) {
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
