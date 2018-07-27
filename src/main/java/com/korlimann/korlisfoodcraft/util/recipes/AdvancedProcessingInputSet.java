package com.korlimann.korlisfoodcraft.util.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.minecraft.item.ItemStack;

public class AdvancedProcessingInputSet {

	private List<ItemStack> inputs;
	private List<ItemStack> results;
	private float exp;
	private boolean specificOrder;
	private IMetaCondition metaCondition;
	
	public AdvancedProcessingInputSet(float exp,boolean order,ItemStack[] inputs,ItemStack[] results,IMetaCondition condition)
	{
		this.inputs = new ArrayList<ItemStack>(inputs.length);
		
		for(ItemStack it: inputs)
		{
			this.inputs.add(it);
		}
		this.specificOrder = order;
		this.results = new ArrayList<ItemStack>();
		for(ItemStack it: results)
		{
			this.results.add(it);
		}
		this.exp = exp;
		this.metaCondition = condition;
	}
	public AdvancedProcessingInputSet(float exp,ItemStack[] inputs,ItemStack[] results)
	{
		this(exp,false,inputs,results,new IMetaCondition() {
			@Override
			public boolean isFullfilled() {
				return true;
			}});
	}
	public AdvancedProcessingInputSet(float exp,ItemStack[] inputs,ItemStack[] results,IMetaCondition condition)
	{
		this(exp,false,inputs,results,condition);
	}
	
	public float getExp() {
		return exp;
	}
	public List<ItemStack> getInputs() {
		return inputs;
	}
	public List<ItemStack> getResults() {
		return results;
	}
	
	public boolean isSpecificOrder() {
		return specificOrder;
	}
	
	public boolean isCorrectRecipe(ItemStack... inputs)
	{
		if(inputs.length != this.inputs.size()||!metaCondition.isFullfilled())
		{
			return false;
		}
		
		if(specificOrder)
		{
			for (int i =0;i<inputs.length;i++)
			{
				if(!(compareItemStacks(inputs[i], this.inputs.get(i))))
				{
					return false;
				}
			}
		}
		else
		{
			List<ItemStack> actList = new ArrayList<ItemStack>(this.inputs);
			for (int i =0;i<inputs.length;i++)
			{
				boolean flag =false;
				for(int x=0;x<actList.size();x++)
				{
					if(compareItemStacks(inputs[i], actList.get(x)))
					{
						flag =true;
						actList.remove(x);
						break;
					}
				}
				if(!flag)
				{
					return false;
				}
			}
		}
		return true;
	}
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
}
