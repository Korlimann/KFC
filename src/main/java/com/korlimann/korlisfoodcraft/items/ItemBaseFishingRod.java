package com.korlimann.korlisfoodcraft.items;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.item.ItemFishingRod;

public class ItemBaseFishingRod extends ItemFishingRod implements IHasModel{

	public ItemBaseFishingRod(String name, int maxDamage) {
		setMaxDamage(maxDamage);
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
