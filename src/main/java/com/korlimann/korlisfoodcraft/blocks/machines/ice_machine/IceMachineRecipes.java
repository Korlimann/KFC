package com.korlimann.korlisfoodcraft.blocks.machines.ice_machine;

import java.util.ArrayList;
import java.util.List;
import com.korlimann.korlisfoodcraft.util.ProcessingInputSet;

import net.minecraft.item.ItemStack;

public class IceMachineRecipes {

	private static final IceMachineRecipes INSTANCE = new IceMachineRecipes();
	//private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	//private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	private final List<ProcessingInputSet> processList = new ArrayList<ProcessingInputSet>();
	public static IceMachineRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private IceMachineRecipes() 
	{
		//addSinteringRecipe(new ItemStack(ModBlocks.BLOCK_COPPER), new ItemStack(ModBlocks.ORE_OVERWORLD), new ItemStack(Blocks.ACACIA_FENCE), 5.0F);
		//addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(ModBlocks.ICE_MACHINE), 5.0F);
	}

	
	public void addSinteringRecipe(ItemStack input1, ItemStack input2,ItemStack input3, ItemStack result, float experience) 
	{
		if(getIceResult(input1, input2,input3) != ItemStack.EMPTY) return;
		this.processList.add(new ProcessingInputSet(result, experience, input1,input2,input3));
	}
	
	public ItemStack getIceResult(ItemStack input1, ItemStack input2, ItemStack input3) 
	{
		for(ProcessingInputSet set: processList)
		{
			if(set.isCorrectRecipe(input1,input2,input3))
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
