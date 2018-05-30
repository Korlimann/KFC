package com.korlimann.korlisfoodcraft.blocks;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IHasModel {

	/* 
	 * This class is for basic blocks without any function. (e.g. decoration blocks, blocks for crafting, etc.)
	 * */
	
	public BlockBase(String name, Material material, boolean CreativeTab) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		if(CreativeTab)
		setCreativeTab(Main.korlissushicraft);
		
		//ModBlocks.BLOCKS.add(this);
		//ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
