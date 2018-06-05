package com.korlimann.korlisfoodcraft.crafting.kitchenboard;

import com.korlimann.korlisfoodcraft.init.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KitchenBoardContainer extends Container {

	private World world;
    private BlockPos table;
    private InventoryCrafting matrix;
    private InventoryCraftResult craftResult;
    private EntityPlayer player;

    public KitchenBoardContainer(InventoryPlayer playerInventory, World world, BlockPos table) {
        this.world = world;
        this.table = table;
        this.matrix = new InventoryCrafting(this, 3, 3);
        this.craftResult = new InventoryCraftResult();
        this.player = playerInventory.player;
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.world.getBlockState(this.table).getBlock().equals(ModBlocks.KITCHENBOARD) && playerIn.getDistanceSq(this.table) <= 8 * 8;
	}

}
