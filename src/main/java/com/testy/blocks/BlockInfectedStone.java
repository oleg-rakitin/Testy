package com.testy.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInfectedStone extends BaseBlock {

	public BlockInfectedStone(String name, Material materialIn) 
	{
		super(name, materialIn);
		this.setSoundType(SoundType.STONE);
		this.setHardness(3);
		this.setTickRandomly(true);
	}
	@Override
	public int tickRate(World worldIn) 
	{
		return 10;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(BlockRegistry.INFECTEDCOBBLESTONE);
	}
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) 
	{
		
		if(!worldIn.isRemote)
		{
			//System.out.println(4);]
			int r = RANDOM.nextInt(15);
			if(r == 0)
			{
				System.out.println("spawned");
				EntityZombie zomb = new EntityZombie(worldIn);
				zomb.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
				worldIn.spawnEntityInWorld(zomb);
			}
		}
		
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if(!worldIn.isRemote)
		{
			for (int i = 0; i < 6; i++) 
			{
				int x = rand.nextInt(5) - 2;
				int y = rand.nextInt(3) == 2 ? -1 : 1;
				int z = rand.nextInt(5) - 2;
				BlockPos pos1 = pos.add(x, y, z);
				if(!worldIn.isBlockLoaded(pos1)) return;
				IBlockState state1 = worldIn.getBlockState(pos1);
				if(state1.getBlock() == Blocks.STONE)
				{
						worldIn.setBlockState(pos1, BlockRegistry.INFECTEDSTONE.getDefaultState());
				}
			}
		}
	}

}
