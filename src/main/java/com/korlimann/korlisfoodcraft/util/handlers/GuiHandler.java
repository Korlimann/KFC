package com.korlimann.korlisfoodcraft.util.handlers;

import com.korlimann.korlisfoodcraft.gui.GuiKitchenboard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int KITCHENBOARD = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
        case KITCHENBOARD:
            return new ContainerKitchenboard(player.inventory, (TileEntityKitchenboard) world.getTileEntity(new BlockPos(x, y, z)));
        default:
            return null;
    }
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
        case KITCHENBOARD:
            return new GuiKitchenboard((Container) getServerGuiElement(ID, player, world, x, y, z), player.inventory);
        default:
            return null;
    }
	}

}
