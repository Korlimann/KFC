package com.korlimann.korlisfoodcraft.util.handlers;

import com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine.TileEntityCoffeeMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.TileEntityIceMachine;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityIceMachine.class, "ice_machine");
		GameRegistry.registerTileEntity(TileEntityCoffeeMachine.class, "coffee_machine");
	}
}
