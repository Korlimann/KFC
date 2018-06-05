package com.korlimann.korlisfoodcraft.items;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.init.ModItems;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemBaseFoodPotion extends ItemFood implements IHasModel {

	/*
	 * This class creates custom food with potion effects when eaten.
	 * */
	
	public int[] potionEffects;
	public boolean potionEffect;
	public int amount;
	public float saturation;
	
	public ItemBaseFoodPotion(String name, int amount, float saturation, boolean isWolfFood, boolean potionEffect, int[] potionEffects) {
		super(amount, saturation, isWolfFood);
		this.potionEffect = potionEffect;
		this.potionEffects = potionEffects;
		this.amount = amount;
		this.saturation = saturation;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
		
		//ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!player.canEat(false))
        {
        }
        else
        {
            player.getFoodStats().addStats(amount, saturation);
            if(potionEffect) {
            	if(potionEffects.length %3==0)
            	for(int i=0; i<potionEffects.length; i+=3) {
            		player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionEffects[i]), potionEffects[i+1], potionEffects[i+2]));
            	}
            }
        }
	}
}
