package com.korlimann.korlisfoodcraft.tabs;

import com.korlimann.korlisfoodcraft.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class KorlisSushiCraft extends CreativeTabs {

	/*
	 * In this class, our custom Creative Tabs gets implemented. With getTabIconItem, we reference to an Item in our ModItems
	 * class which gets set as the TabIcon
	 * */
	public KorlisSushiCraft(String label) {
		super("korlissushicraft");
		//this.setBackgroundImageName("nameyougivehere.png"); Don't forget to add tab_ for the image
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.LACHSSUSHI);
	}

}
