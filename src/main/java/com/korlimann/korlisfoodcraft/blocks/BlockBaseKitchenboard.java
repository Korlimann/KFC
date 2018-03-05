package com.korlimann.korlisfoodcraft.blocks;

import javax.annotation.Nullable;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.blocks.kitchenboard.TileEntityKitchenboard;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import com.korlimann.korlisfoodcraft.util.handlers.GuiHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockBaseKitchenboard extends BlockTileEntity<TileEntityKitchenboard> {
	
	public BlockBaseKitchenboard() {
        super(Material.ROCK, "kitchenboard_block");
        String name = "kitchenboard_block";
        this.setUnlocalizedName(name);
    }


    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	return false;
    }
    
    @Override
    public boolean isFullBlock(IBlockState state) {
    	return false;
    }
    
    public static final AxisAlignedBB AABB = new AxisAlignedBB(0D, 0D, 0.0625D, 1D, 0.125D, 0.9375D);
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    	return AABB;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
            ItemStack heldItem = player.getHeldItem(hand);
            TileEntityKitchenboard tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {
                if (heldItem.isEmpty()) {
                    player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                } else {
                    player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
                }
                tile.markDirty();
            } else {
                player.openGui(Main.instance, GuiHandler.KITCHENBOARD, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }       

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityKitchenboard tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        ItemStack ped = new ItemStack(ModBlocks.KITCHENBOARD_BLOCK);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            EntityItem pedestal = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), ped);
            world.spawnEntity(item);
            world.spawnEntity(pedestal);
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityKitchenboard> getTileEntityClass() {
        return TileEntityKitchenboard.class;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntityKitchenboard createTileEntity(World world, IBlockState state) {
        return new TileEntityKitchenboard();
    }

}
