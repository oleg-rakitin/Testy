package com.testy.blocks;


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInfectedGrass extends BaseBlock
{
	//public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockInfectedGrass(String name, Material materialIn) 
	{
		super(name, materialIn);
		this.setHardness(1);
		this.setSoundType(SoundType.GROUND);
		this.setTickRandomly(true);
	}
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return (Item.getItemFromBlock(BlockRegistry.INFECTEDDIRT));
    }
    
    @Override
    public int tickRate(World worldIn) 
    {
    	return 10;
    }
    

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
	{
		//System.out.println(12);
		if(!worldIn.isRemote)
		{
			Block block = worldIn.getBlockState(pos.up()).getBlock();
			if(block != Blocks.AIR)
			{
					worldIn.setBlockState(pos, BlockRegistry.INFECTEDDIRT.getDefaultState());
			}else {
				for (int i = 0; i < 4; i++) 
				{
					
					int x = rand.nextInt(5) - 2;
					int y = rand.nextInt(3) == 2 ? -1 : 1;
					int z = rand.nextInt(5) - 2;
					BlockPos pos1 = pos.add(x, y, z);
					if(!worldIn.isBlockLoaded(pos1)) return;
					IBlockState state1 = worldIn.getBlockState(pos1);
					if(state1.getBlock() == BlockRegistry.INFECTEDDIRT || state1.getBlock() == Blocks.GRASS)
					{
						if(state1.getBlock() == BlockRegistry.INFECTEDDIRT && worldIn.getBlockState(pos1.up()).getBlock() != Blocks.AIR)// != Blocks.AIR)
						{
							worldIn.setBlockState(pos1, BlockRegistry.INFECTEDDIRT.getDefaultState());
							
						} else
						{
							worldIn.setBlockState(pos1, BlockRegistry.INFECTEDGRASSBLOCK.getDefaultState());
						}
						worldIn.setBlockState(pos1, BlockRegistry.INFECTEDGRASSBLOCK.getDefaultState());	
					} else if(state1.getBlock() == Blocks.DIRT)
					{
							worldIn.setBlockState(pos1, BlockRegistry.INFECTEDDIRT.getDefaultState());	
					}
				}
			}
		}

	}
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) 
	{
		if(entityIn instanceof EntityLiving)
		{
		
		}
	}

	
}
