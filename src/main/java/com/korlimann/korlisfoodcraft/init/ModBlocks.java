package com.korlimann.korlisfoodcraft.init;


import java.util.ArrayList;
import java.util.List;

import com.korlimann.korlisfoodcraft.blocks.BlockBaseCake;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseFruit;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSaltOre;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSeaweed;
import com.korlimann.korlisfoodcraft.blocks.BlockFruitSapling;
import com.korlimann.korlisfoodcraft.blocks.BlockHerbgarden;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropCorn;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropCucumber;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropGarlic;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropHops;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropMalt;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropOnion;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropRice;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;

public class ModBlocks {
	
	/*
	 * In this class, all our blocks get initalized before they then get registered by our ObjectRegistry class. Hereby, the
	 * name every block at least has, is the one that you will need to set all your textures/models-files to.
	 * */
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Crafting Tables
	
	//Crops
	public static final BlockBaseCropCorn CROP_CORN = new BlockBaseCropCorn();
	public static final BlockBaseCropRice CROP_RICE = new BlockBaseCropRice();
	public static final BlockBaseCropHops CROP_HOPS = new BlockBaseCropHops();
	public static final BlockBaseCropMalt CROP_MALT = new BlockBaseCropMalt();
	public static final BlockBaseCropOnion CROP_ONION = new BlockBaseCropOnion();
	public static final BlockBaseCropCucumber CROP_CUCUMBER = new BlockBaseCropCucumber();
	public static final BlockBaseCropGarlic CROP_GARLIC = new BlockBaseCropGarlic();
	
	
	//"Cakes"
	static int[] pt1 = {10};
	static int[] ptD1 = {60};
	static int[] ptS1 = {2};
	public static final Block BEER = new BlockBaseCake("beer", false, pt1, ptD1, ptS1,true);
	static int[] pt = {9, 17};
	static int[] ptD = {100, 200};
	static int[] ptS = {1, 2};
	public static final Block BEER_AND_LEMONADE = new BlockBaseCake("radler", true, pt, ptD, ptS,true); 
	
	//Ores
	public static final Block SALT_ORE = new BlockBaseSaltOre("salt_ore");
	
	//Flowers/Plants
	public static final BlockBaseSeaweed SEAWEED_BLOCK = new BlockBaseSeaweed("seaweed_block");
	//public static final Block SUNFLOWER = new BlockBaseSunflower("sunflower");
	

	public static final BlockBush HERBGARDEN = new BlockHerbgarden("herbs");
	
	//Fruits
	public static final BlockBaseFruit AVOCADO_BLOCK = new BlockBaseFruit("avocado_block", Material.PLANTS, ModItems.AVOCADO);
	public static final BlockBaseFruit OLIVE_BLOCK = new BlockBaseFruit("olive_block", Material.PLANTS, ModItems.OLIVE);
	public static final BlockBaseFruit ORANGE_BLOCK = new BlockBaseFruit("orange_block", Material.PLANTS, ModItems.ORANGE);
	public static final BlockBaseFruit APPLE_BLOCK = new BlockBaseFruit("apple_block", Material.PLANTS, Items.APPLE);
	//Fruit Saplings
	public static final BlockFruitSapling AVOCADO_SAPLING = ModBlocks.AVOCADO_BLOCK.createFruitTreeAndSapling();
	public static final BlockFruitSapling OLIVE_SAPLING = ModBlocks.OLIVE_BLOCK.createFruitTreeAndSapling();
	public static final BlockFruitSapling ORANGE_SAPLING = ModBlocks.ORANGE_BLOCK.createFruitTreeAndSapling();
	public static final BlockFruitSapling APPLE_SAPLING = ModBlocks.APPLE_BLOCK.createFruitTreeAndSapling();
}
