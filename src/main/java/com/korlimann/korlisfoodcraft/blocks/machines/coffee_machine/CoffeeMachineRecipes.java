package com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine;

import java.util.ArrayList;
import java.util.List;
import com.korlimann.korlisfoodcraft.util.ProcessingInputSet;

import net.minecraft.item.ItemStack;

public class CoffeeMachineRecipes {

	private static final CoffeeMachineRecipes INSTANCE = new CoffeeMachineRecipes();
	//private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
		//private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
		private final List<ProcessingInputSet> processList = new ArrayList<ProcessingInputSet>();
		public static CoffeeMachineRecipes getInstance()
		{
			return INSTANCE;
		}
		
		public CoffeeMachineRecipes() {
			// Add Recipes Here
		}

		
		public void addSinteringRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
		{
			if(getIceResult(input1, input2) != ItemStack.EMPTY) return;
			this.processList.add(new ProcessingInputSet(result, experience, input1,input2));
		}
		
		public ItemStack getIceResult(ItemStack input1, ItemStack input2) 
		{
			for(ProcessingInputSet set: processList)
			{
				if(set.isCorrectRecipe(input1,input2))
				{
					return set.getResult();
				}
			}
			return ItemStack.EMPTY;
		}
		
		private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
		{
			return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
		}
		
		/*public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
		{
			return this.smeltingList;
		}
		*/
		public float getSinteringExperience(ItemStack stack)
		{
			for (ProcessingInputSet set: processList) 
			{
				if(this.compareItemStacks(stack, set.getResult())) 
				{
					return set.getExp();
				}
			}
			return 0.0F;
		}
}
