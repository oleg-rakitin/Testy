package com.testy.proxy;

import com.testy.blocks.BlockRegistry;
import com.testy.handlers.RegistryHandler;
import com.testy.infection.IInfectionHandler;
import com.testy.infection.InfectionHandler;
import com.testy.infection.InfectionStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy
{
    public void preinit(FMLPreInitializationEvent event)
    {
    	BlockRegistry.registry();
        RegistryHandler.registerItems();

        CapabilityManager.INSTANCE.register(IInfectionHandler.class, new InfectionStorage(), InfectionHandler.class);
    }
    public void init(FMLInitializationEvent event)
    {
    }
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    }
    public IThreadListener getListener(MessageContext ctx) {
    	return (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
    }
    public EntityPlayer getPlayer(MessageContext ctx)
    {
    	return ctx.getServerHandler().playerEntity;
    }
}
