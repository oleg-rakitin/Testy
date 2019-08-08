package com.testy.handlers;

import com.testy.items.ItemBase;
import com.testy.main.TestyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;

public class RegistryHandler
{
    public static ArrayList<Item> ITEMS = new ArrayList<Item>();
    public static final Item testitem = new ItemBase("testitem");

    public static void registerItems()
    {
        for(Item item : ITEMS)
        {
           ForgeRegistries.ITEMS.register(item);
        }
    }
    
    public static void registerItemRenderers()
    {
        for(Item item : ITEMS)
        {
        	System.out.println("Add item: " + item.getUnlocalizedName());
             Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(TestyMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
        }
    }




}
