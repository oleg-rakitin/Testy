package com.testy.blocks;



import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class InfectedFlower extends BlockBush
{
	
	protected static final AxisAlignedBB FLOWER_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 1.0D, 0.699999988079071D);
	
	public InfectedFlower(String name) 
	{
		super(Material.PLANTS);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		BlockRegistry.BLOCKS.add(this);
		//this.setDefaultState(this.blockState.getBaseState().withProperty(Props.FLOWER_TYPE, EnumFlowers.INFECTED));
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return FLOWER_AABB;
	}
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		Block block = worldIn.getBlockState(pos.down()).getBlock();
		return block == BlockRegistry.INFECTEDGRASSBLOCK || block == BlockRegistry.INFECTEDDIRT || block == BlockRegistry.INFECTEDSTONE || block == Blocks.GRASS;
	}
	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) 
	{
		return true;
	}
	@Override
	public EnumOffsetType getOffsetType() 
	{
		return EnumOffsetType.XYZ;
	}
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		Block block = worldIn.getBlockState(pos.down()).getBlock();
		return block == BlockRegistry.INFECTEDGRASSBLOCK || block == BlockRegistry.INFECTEDDIRT || block == BlockRegistry.INFECTEDSTONE || block == Blocks.GRASS;
	}


}
