package com.korlimann.korlisfoodcraft.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class BrewingRecipes implements IBrewingRecipe {

	public BrewingRecipes(ItemStack input, ItemStack ingredient, ItemStack output) {
		
	}
	
	@Override
	public boolean isInput(ItemStack input) {
		return false;
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

}
