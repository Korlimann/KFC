package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHerbgarden extends BlockBush implements IHasModel {

	public BlockHerbgarden(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		Random r = new Random();
		int rand = r.nextInt(4)+1;
		int r1 = 0;
		int r2 = 0;
		BlockPos posNew = pos.up();
		if(rand == 4) {
			for(int i = 0; i<4; i++) {
				r1 = r.nextInt(10)+1;
				if(r1 == 1) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.CORN_SEED)));
				if(r1 == 2) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.EISBERGSALAT)));
				if(r1 == 3) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.HOPS)));
				if(r1 == 4) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.LEEK)));
				if(r1 == 5) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.MALT)));
				if(r1 == 6) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.OLIVE)));
				if(r1 == 7) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.OREGANO)));
				if(r1 == 8) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.PARSLEY)));
				if(r1 == 9) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.PEPPER)));
				if(r1 == 10) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.TOMATOSEEDS)));
			}
		}
		else if(rand < 4) {
			for(int i = 0; i<3; i++) {
				r2 = r.nextInt(10)+1;
				if(r2 == 1) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.CORN_SEED)));
				if(r2 == 2) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.EISBERGSALAT)));
				if(r2 == 3) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.HOPS)));
				if(r2 == 4) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.LEEK)));
				if(r2 == 5) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.MALT)));
				if(r2 == 6) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.OLIVE)));
				if(r2 == 7) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.OREGANO)));
				if(r2 == 8) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.PARSLEY)));
				if(r2 == 9) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.PEPPER)));
				if(r2 == 10) worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), posNew.getY(), pos.getZ(), new ItemStack(ModItems.TOMATOSEEDS)));
			}
		}
	}
	
	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
