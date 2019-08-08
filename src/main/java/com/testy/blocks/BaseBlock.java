package com.testy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BaseBlock extends Block {

	public BaseBlock(String name, Material materialIn) 
	{
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		BlockRegistry.BLOCKS.add(this);
	}

}
