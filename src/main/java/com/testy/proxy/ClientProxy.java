package com.testy.proxy;

import com.testy.blocks.BlockRegistry;
import com.testy.handlers.RegistryHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preinit(FMLPreInitializationEvent event) {
        super.preinit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        BlockRegistry.registryModels();
        RegistryHandler.registerItemRenderers();
    }

    @Override
    public void postinit(FMLPostInitializationEvent event) {
        super.postinit(event);
    }
}
