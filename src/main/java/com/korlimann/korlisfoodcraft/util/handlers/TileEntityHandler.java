package com.korlimann.korlisfoodcraft.util.handlers;

import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.TileEntityIceMachine;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityIceMachine.class, "ice_machine");
	}
}
