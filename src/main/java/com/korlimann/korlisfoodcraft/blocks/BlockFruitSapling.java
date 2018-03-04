package com.korlimann.korlisfoodcraft.blocks;

import java.util.Random;

import com.korlimann.korlisfoodcraft.Main;
import com.korlimann.korlisfoodcraft.util.IHasModel;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockFruitSapling extends BlockSapling implements IHasModel {

	public static final PropertyEnum<BlockPlanks.EnumType> TYPE = PropertyEnum.<BlockPlanks.EnumType>create("fruitType", BlockPlanks.EnumType.class);
	
	public BlockFruitSapling(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.korlissushicraft);
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
	        WorldGenerator worldgenerator = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true));
	        int i = 0;
	        int j = 0;
	        boolean flag = false;

	        switch ((BlockPlanks.EnumType)state.getValue(TYPE))
	        {
	            case SPRUCE:
	                label68:

	                for (i = 0; i >= -1; --i)
	                {
	                    for (j = 0; j >= -1; --j)
	                    {
	                        if (this.isTwoByTwoOfType(worldIn, pos, i, j, BlockPlanks.EnumType.SPRUCE))
	                        {
	                            worldgenerator = new WorldGenMegaPineTree(false, rand.nextBoolean());
	                            flag = true;
	                            break label68;
	                        }
	                    }
	                }

	                if (!flag)
	                {
	                    i = 0;
	                    j = 0;
	                    worldgenerator = new WorldGenTaiga2(true);
	                }

	                break;
	            case BIRCH:
	                worldgenerator = new WorldGenBirchTree(true, false);
	                break;
	            case JUNGLE:
	                IBlockState iblockstate = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
	                IBlockState iblockstate1 = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	                label82:

	                for (i = 0; i >= -1; --i)
	                {
	                    for (j = 0; j >= -1; --j)
	                    {
	                        if (this.isTwoByTwoOfType(worldIn, pos, i, j, BlockPlanks.EnumType.JUNGLE))
	                        {
	                            worldgenerator = new WorldGenMegaJungle(true, 10, 20, iblockstate, iblockstate1);
	                            flag = true;
	                            break label82;
	                        }
	                    }
	                }

	                if (!flag)
	                {
	                    i = 0;
	                    j = 0;
	                    worldgenerator = new WorldGenTrees(true, 4 + rand.nextInt(7), iblockstate, iblockstate1, false);
	                }

	                break;
	            case ACACIA:
	                worldgenerator = new WorldGenSavannaTree(true);
	                break;
	            case DARK_OAK:
	                label96:

	                for (i = 0; i >= -1; --i)
	                {
	                    for (j = 0; j >= -1; --j)
	                    {
	                        if (this.isTwoByTwoOfType(worldIn, pos, i, j, BlockPlanks.EnumType.DARK_OAK))
	                        {
	                            worldgenerator = new WorldGenCanopyTree(true);
	                            flag = true;
	                            break label96;
	                        }
	                    }
	                }

	                if (!flag)
	                {
	                    return;
	                }

	            case OAK:
	        }

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
	
	private boolean isTwoByTwoOfType(World worldIn, BlockPos pos, int p_181624_3_, int p_181624_4_, BlockPlanks.EnumType type)
    {
        return this.isTypeAt(worldIn, pos.add(p_181624_3_, 0, p_181624_4_), type) && this.isTypeAt(worldIn, pos.add(p_181624_3_ + 1, 0, p_181624_4_), type) && this.isTypeAt(worldIn, pos.add(p_181624_3_, 0, p_181624_4_ + 1), type) && this.isTypeAt(worldIn, pos.add(p_181624_3_ + 1, 0, p_181624_4_ + 1), type);
    }
}
