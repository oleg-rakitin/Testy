package com.testy.blocks;

import java.util.ArrayList;

import com.testy.handlers.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRegistry 
{
	public static ArrayList<Block> BLOCKS = new ArrayList<Block>();
	public static final Block TESTBLOCK = new BaseBlock("testblock", Material.ROCK);
	public static final Block INFECTEDGRASSBLOCK = new BlockInfectedGrass("infectedgrassblock", Material.GRASS);
	public static final Block INFECTEDDIRT = new BaseBlock("infecteddirt", Material.GRASS).setHardness(1);
	public static final Block INFECTEDSTONE = new BlockInfectedStone("infectedstone", Material.ROCK);
	public static final Block INFECTEDCOBBLESTONE = new BaseBlock("infectedcobblestone", Material.ROCK);
	
	
	public static void registry()
	{
		for(Block block : BLOCKS)
		{
			//System.out.println(2);
			ForgeRegistries.BLOCKS.register(block);
			RegistryHandler.ITEMS.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}

	}
	@SideOnly(Side.CLIENT)
	public static void registryModels()
	{
		for(Block block : BLOCKS)
		{
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

		}
	}

}
