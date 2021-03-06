package com.korlimann.korlisfoodcraft.init;


import java.util.ArrayList;
import java.util.List;

import com.korlimann.korlisfoodcraft.blocks.BlockBaseCake;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseCoffeeBean;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSaltOre;
import com.korlimann.korlisfoodcraft.blocks.BlockBaseSeaweed;
import com.korlimann.korlisfoodcraft.blocks.BlockHerbgarden;
import com.korlimann.korlisfoodcraft.blocks.compost_heap.BlockCompostHeap;
import com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine.BlockCoffeeMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.BlockIceMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.smoothie_maker.BlockSmoothieMaker;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropCorn;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropCucumber;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropGarlic;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropHops;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropMalt;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropOnion;
import com.korlimann.korlisfoodcraft.blocks.crops.BlockBaseCropRice;
import com.korlimann.korlisfoodcraft.blocks.fruits.BlockBaseFruit;
import com.korlimann.korlisfoodcraft.blocks.fruits.BlockBaseFruitLeaves;
import com.korlimann.korlisfoodcraft.blocks.fruits.BlockFruitSapling;

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
	
	//Crops
	public static final BlockBaseCropCorn CROP_CORN = new BlockBaseCropCorn();
	public static final BlockBaseCropRice CROP_RICE = new BlockBaseCropRice();
	public static final BlockBaseCropHops CROP_HOPS = new BlockBaseCropHops();
	public static final BlockBaseCropMalt CROP_MALT = new BlockBaseCropMalt();
	public static final BlockBaseCropOnion CROP_ONION = new BlockBaseCropOnion();
	public static final BlockBaseCropCucumber CROP_CUCUMBER = new BlockBaseCropCucumber();
	public static final BlockBaseCropGarlic CROP_GARLIC = new BlockBaseCropGarlic();
	
	//Random?
	public static final Block COMPOST_HEAP = new BlockCompostHeap("compost_heap", true);
	
	//"Cakes"
	static int[] pt1 = {10, 60, 2};
	public static final Block BEER = new BlockBaseCake("beer", false, pt1,true);
	static int[] pt = {9,100,1, 17, 200, 2};
	public static final Block BEER_AND_LEMONADE = new BlockBaseCake("beer_and_lemonade", true, pt,true); 
	
	//Ores
	public static final Block SALT_ORE = new BlockBaseSaltOre("salt_ore");
	
	//Flowers/Plants
	public static final BlockBaseSeaweed SEAWEED_BLOCK = new BlockBaseSeaweed("seaweed_block");
	//public static final Block SUNFLOWER = new BlockBaseSunflower("sunflower");
	

	public static final BlockHerbgarden HERBGARDEN = new BlockHerbgarden("herbs");
	
	//Fruits

	public static final BlockBaseFruit AVOCADO_BLOCK = new BlockBaseFruit("avocado_block", Material.PLANTS, ModItems.AVOCADO);
	public static final BlockBaseFruitLeaves OLIVE_LEAVES = new BlockBaseFruitLeaves("olive_leaves","olive", Material.PLANTS, ModItems.OLIVE);
	public static final BlockBaseFruit ORANGE_BLOCK = new BlockBaseFruit("orange_block", Material.PLANTS, 0.390625D, 0.671875D, 0.390625D, 0.609375D, 1D, 0.609375D, ModItems.ORANGE, true, true, false);
	public static final BlockBaseFruit APPLE_BLOCK = new BlockBaseFruit("apple_block", Material.PLANTS, 0.390625D, 0.75D, 0.390625D, 0.609375D, 1D, 0.609375D, Items.APPLE, true, true, false);
	
	public static final Block COFFEE_BEAN = new BlockBaseCoffeeBean("coffee_bean", false);

	//Fruit Saplings
	public static final BlockFruitSapling AVOCADO_SAPLING = ModBlocks.AVOCADO_BLOCK.createFruitTreeAndSapling();
	public static final BlockFruitSapling OLIVE_SAPLING = OLIVE_LEAVES.createFruitTreeAndSapling();
	public static final BlockFruitSapling ORANGE_SAPLING = ModBlocks.ORANGE_BLOCK.createFruitTreeAndSapling();
	public static final BlockFruitSapling APPLE_SAPLING = ModBlocks.APPLE_BLOCK.createFruitTreeAndSapling();
	

	
	//Special Workbenches, Furnaces, etc.
	public static final Block ICE_MACHINE = new BlockIceMachine("ice_machine");
	public static final Block COFFEE_MACHINE = new BlockCoffeeMachine("coffee_machine");
	public static final Block SMOOTHIE_MAKER = new BlockSmoothieMaker("smoothie_maker");
	
	//this is a default private constructor to prevent object initialisation
	private ModBlocks() {}
}
