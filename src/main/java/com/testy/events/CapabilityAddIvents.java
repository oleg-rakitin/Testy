package com.testy.events;

import com.testy.infection.IInfectionHandler;
import com.testy.infection.InfectionStorage;
import com.testy.infection.Provider;
import com.testy.main.TestyMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityAddIvents
{
	
	
	
	@SubscribeEvent
	public void add(AttachCapabilitiesEvent<Entity> event)
	{
		if(event.getObject() instanceof EntityPlayer)
		{
            event.addCapability(new ResourceLocation(TestyMod.MODID, InfectionStorage.INFECTION), new Provider());

		}
	}
	@SubscribeEvent
	public void cloneEntity(PlayerEvent.Clone event)
	{
		
		final IInfectionHandler original = getHandler(event.getOriginal());
		final IInfectionHandler clone = getHandler(event.getEntity());
		clone.setInfection(original.getInfection());
	}

	   public static IInfectionHandler getHandler(Entity entity) {
		   	if(entity != null)
		   	{
		        if (entity.hasCapability(Provider.CAPABILITY_INFECTION, EnumFacing.DOWN))
		        return entity.getCapability(Provider.CAPABILITY_INFECTION, EnumFacing.DOWN);

		   	}
	        return null;
	    }

}
