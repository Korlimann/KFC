package com.korlimann.korlisfoodcraft.init;


import java.util.ArrayList;
import java.util.List;

import com.korlimann.korlisfoodcraft.blocks.BlockBaseCake;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseCropCorn;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseCropRice;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseFruit;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSaltOre;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSeaweed;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSunflower;
import com.korlimann.korlisfoodcraft.blocks.BlockFruitSapling;
import com.korlimann.korlisfoodcraft.blocks.BlockHerbgarden;
import com.korlimann.korlisfoodcraft.blocks.kitchenboard.BlockBaseKitchenboard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	/*
	 * In this class, all our blocks get initalized before they then get registered by our ObjectRegistry class. Hereby, the
	 * name every block at least has, is the one that you will need to set all your textures/models-files to.
	 * */
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Crafting Tables
	public static final Block KITCHENBOARD_BLOCK = new BlockBaseKitchenboard();
	
	//Crops
	public static final BlockBaseCropCorn CROP_CORN = new BlockBaseCropCorn();
	public static final BlockBaseCropRice CROP_RICE = new BlockBaseCropRice();
	
	
	//"Cakes"
	public static final Block BEER = new BlockBaseCake("beer");
	
	//Ores
	public static final Block SALT_ORE = new BlockBaseSaltOre("salt_ore");
	
	//Flowers/Plants
	public static final BlockBaseSeaweed SEAWEED_BLOCK = new BlockBaseSeaweed("seaweed_block");
	public static final Block SUNFLOWER = new BlockBaseSunflower("sunflower");
	public static final BlockBaseFruit AVOCADO_BLOCK = new BlockBaseFruit("avocado_block", Material.PLANTS, 0.25D, 0.25D, 0.25D, 0.75D, 1D, 0.75D, ModItems.AVOCADO, true, true);
	public static final BlockFruitSapling AVOCADO_SAPLING = ModBlocks.AVOCADO_BLOCK.createFruitTreeAndSapling();
	public static final BlockBush HERBGARDEN = new BlockHerbgarden("herbs");
}
