package com.testy.items;

import com.testy.events.CapabilityAddIvents;
import com.testy.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBase extends Item
{
    public ItemBase(String name)
    {
       // super();
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MISC);
        RegistryHandler.ITEMS.add(this);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
    		EnumHand hand) {
    	System.out.println(CapabilityAddIvents.getHandler(playerIn).getInfection());
    	return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
