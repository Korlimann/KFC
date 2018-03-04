package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.gen.WorldGenFruitTree;
import com.korlimann.korlisfoodcraft.util.IHasModel;
import com.korlimann.korlisfoodcraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockFruitSapling extends BlockSapling implements IHasModel {

	public static final PropertyEnum<BlockFruitSapling.EnumType> TYPE = PropertyEnum.<BlockFruitSapling.EnumType>create("fruitType", BlockFruitSapling.EnumType.class);
	
	
	public BlockFruitSapling(String name, BlockBaseFruit fruit) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockFruitSapling.EnumType.getByName(fruit.getUnlocalizedName())).withProperty(STAGE, Integer.valueOf(0)));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	
	@Override
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this, new IProperty[] {TYPE, STAGE, BlockSapling.TYPE});
	}
	@Override
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
	        WorldGenerator worldgenerator = new WorldGenFruitTree(true, 3, Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK), Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), ((BlockFruitSapling.EnumType)state.getValue(TYPE)).getFruit());
	        int i = 0;
	        int j = 0;
	        boolean flag = false;
	        
	        
	        

	        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();

	        if (flag)
	        {
	            worldIn.setBlockState(pos.add(i, 0, j), iblockstate2, 4);
	            worldIn.setBlockState(pos.add(i + 1, 0, j), iblockstate2, 4);
	            worldIn.setBlockState(pos.add(i, 0, j + 1), iblockstate2, 4);
	            worldIn.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate2, 4);
	        }
	        else
	        {
	            worldIn.setBlockState(pos, iblockstate2, 4);
	        }

	        if (!worldgenerator.generate(worldIn, rand, pos.add(i, 0, j)))
	        {
	            if (flag)
	            {
	                worldIn.setBlockState(pos.add(i, 0, j), state, 4);
	                worldIn.setBlockState(pos.add(i + 1, 0, j), state, 4);
	                worldIn.setBlockState(pos.add(i, 0, j + 1), state, 4);
	                worldIn.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
	            }
	            else
	            {
	                worldIn.setBlockState(pos, state, 4);
	            }
	        }
	    }
	
	
	
	public static enum EnumType implements IStringSerializable
    {
		//---------------------------------------------------------------------------
		//Alle Fruits die Einen Sapling brauchen müssen hier eingetragen werden:
        AVOCADO(0, MapColor.WOOD,ModBlocks.AVOCADO_BLOCK);
        

		
		//------------------------------------------------------------------------------
        private static final BlockFruitSapling.EnumType[] META_LOOKUP = new BlockFruitSapling.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        /** The color that represents this entry on a map. */
        private final MapColor mapColor;
        private final BlockBaseFruit fruit;

       

        public Block getFruit() {
			return fruit;
		}

		private EnumType(int metaIn, MapColor mapColorIn, Block fruit)
        {
			if(!(fruit instanceof BlockBaseFruit))
				fruit = ModBlocks.AVOCADO_BLOCK;
            this.meta = metaIn;
            this.name = fruit.getUnlocalizedName();
            this.unlocalizedName = fruit.getUnlocalizedName();;
            this.mapColor = mapColorIn;
            
            this.fruit = (BlockBaseFruit)fruit;
            
        }

        public int getMetadata()
        {
            return this.meta;
        }

        /**
         * The color which represents this entry on a map.
         */
        public MapColor getMapColor()
        {
            return this.mapColor;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockFruitSapling.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (BlockFruitSapling.EnumType fruits$enumtype : values())
            {
                META_LOOKUP[fruits$enumtype.getMetadata()] = fruits$enumtype;
            }
        }
        public static BlockFruitSapling.EnumType getByName(String name)
        {
        	for(BlockFruitSapling.EnumType e : META_LOOKUP)
        	{
        		if(e.getName().equals(name))
        		{
        			return e;
        		}
        	}
        	return META_LOOKUP[0];
        }
    }
}
