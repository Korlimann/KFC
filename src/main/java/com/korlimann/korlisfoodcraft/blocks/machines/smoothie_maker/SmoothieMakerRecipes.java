package com.korlimann.korlisfoodcraft.blocks.machines.smoothie_maker;

import java.util.ArrayList;
import java.util.List;

import com.korlimann.korlisfoodcraft.util.recipes.ProcessingInputSet;

import net.minecraft.item.ItemStack;

public class SmoothieMakerRecipes {

	private static final SmoothieMakerRecipes INSTANCE = new SmoothieMakerRecipes();
	//private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
		//private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
		private final List<ProcessingInputSet> processList = new ArrayList<ProcessingInputSet>();
		public static SmoothieMakerRecipes getInstance()
		{
			return INSTANCE;
		}
		
		public SmoothieMakerRecipes() {
			//addSmoothieRecipe(new ItemStack(ModItems.WATER_CUP), new ItemStack(ModItems.COFFEE_BEAN), new ItemStack(ModItems.COFFEE), 0.0F);
			//addSmoothieRecipe(new ItemStack(ModItems.MILK_CUP), new ItemStack(Blocks.COCOA), new ItemStack(ModItems.CACAO), 0.0F);
		}

		
		public void addSmoothieRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
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
