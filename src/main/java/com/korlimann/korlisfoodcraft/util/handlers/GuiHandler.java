package com.korlimann.korlisfoodcraft.util.handlers;

import com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine.ContainerCoffeeMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine.GuiCoffeeMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.coffee_machine.TileEntityCoffeeMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.ContainerIceMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.GuiIceMachine;
import com.korlimann.korlisfoodcraft.blocks.machines.ice_machine.TileEntityIceMachine;
import com.korlimann.korlisfoodcraft.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_ICE_MACHINE) return new ContainerIceMachine(player.inventory, (TileEntityIceMachine)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Reference.GUI_COFFEE_MACHINE) return new ContainerCoffeeMachine(player.inventory, (TileEntityCoffeeMachine)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_ICE_MACHINE) return new GuiIceMachine(player.inventory, (TileEntityIceMachine)world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Reference.GUI_COFFEE_MACHINE) return new GuiCoffeeMachine(player.inventory, (TileEntityCoffeeMachine)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

}
