package com.korlimann.korlisfoodcraft.items;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

public class ItemBaseSeedFood extends ItemSeedFood implements IHasModel {

	/*
	 * This class creates custom seeds for plants, crops, etc. 
	 * */
	
	public ItemBaseSeedFood(String name, Block crops, Block soil, int healAmount, float potionEffectProbability) {
		super(healAmount, potionEffectProbability, crops, soil);
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
