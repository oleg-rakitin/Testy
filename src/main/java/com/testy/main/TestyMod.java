package com.testy.main;

import com.testy.events.CapabilityAddIvents;
import com.testy.events.OverlayEvents;
import com.testy.infection.InfectionEvents;
import com.testy.messages.InfectionUpdateHandler;
import com.testy.messages.InfectionUpdateMessage;
import com.testy.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = TestyMod.MODID, version = TestyMod.VERSION)
public class TestyMod
{
    public static final String MODID = "testy";
    public static final String VERSION = "1.0";
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
    public static int id = 0;
    
    @Mod.Instance
    public static TestyMod instance;

    @SidedProxy(clientSide = "com.testy.proxy.ClientProxy", serverSide = "com.testy.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        proxy.preinit(event);
        INSTANCE.registerMessage(InfectionUpdateHandler.class, InfectionUpdateMessage.class, id++, Side.CLIENT);
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    	MinecraftForge.EVENT_BUS.register(new CapabilityAddIvents());
    	MinecraftForge.EVENT_BUS.register(new InfectionEvents());


    }
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
        proxy.postinit(event);
    	MinecraftForge.EVENT_BUS.register(new OverlayEvents());
gf
    }
}
