package com.korlimann.korlisfoodcraft.util.handlers;

import com.korlimann.korlisfoodcraft.blocks.compost_heap.TileEntityCompostHeap;
import com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine.TileEntityCoffeeMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.TileEntityIceMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.smoothie_maker.TileEntitySmoothieMaker;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityIceMachine.class, "ice_machine");
		GameRegistry.registerTileEntity(TileEntityCoffeeMachine.class, "coffee_machine");
		GameRegistry.registerTileEntity(TileEntitySmoothieMaker.class, "smoothie_maker");
		GameRegistry.registerTileEntity(TileEntityCompostHeap.class, "compost_heap");
	}
	
	//this is a default private constructor to prevent object initialisation
	private TileEntityHandler() {}
}
