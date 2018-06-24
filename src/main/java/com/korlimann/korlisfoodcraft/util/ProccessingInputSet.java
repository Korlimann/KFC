package com.korlimann.korlisfoodcraft.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ProccessingInputSet {

	private List<ItemStack> inputs;
	private ItemStack result;
	private float exp;
	private boolean specificOrder;
	
	public ProccessingInputSet(ItemStack result,float exp,boolean order,ItemStack... inputs)
	{
		this.inputs = new ArrayList<ItemStack>(inputs.length);
		
		for(ItemStack it: inputs)
		{
			this.inputs.add(it);
		}
		this.specificOrder = order;
		this.result = result;
		this.exp = exp;
	}
	public ProccessingInputSet(ItemStack result,float exp,ItemStack... inputs)
	{
		this(result,exp,false,inputs);
	}
	
	public float getExp() {
		return exp;
	}
	public List<ItemStack> getInputs() {
		return inputs;
	}
	public ItemStack getResult() {
		return result;
	}
	
	public boolean isSpecificOrder() {
		return specificOrder;
	}
	
	public boolean isCorrectRecipe(ItemStack... inputs)
	{
		if(inputs.length != this.inputs.size())
		{
			return false;
		}
		
		if(specificOrder)
		{
			for (int i =0;i<inputs.length;i++)
			{
				if(!(inputs[i].equals(this.inputs.get(i))))
				{
					return false;
				}
			}
		}
		else
		{
			List<ItemStack> actList = new ArrayList<ItemStack>(this.inputs);
			for (ItemStack it : inputs)
			{
				if(!(actList.contains(it)))
				{
					return false;
				}
				else
				{
					actList.remove(it);
				}
			}
		}
		return true;
	}
}
