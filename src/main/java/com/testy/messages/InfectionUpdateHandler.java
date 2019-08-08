package com.testy.messages;

import com.testy.events.CapabilityAddIvents;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class InfectionUpdateHandler implements IMessageHandler<InfectionUpdateMessage, IMessage>
{

	@Override
	public IMessage onMessage(InfectionUpdateMessage message, MessageContext ctx)
	{
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		if(CapabilityAddIvents.getHandler(player) != null)
		{
			CapabilityAddIvents.getHandler(player).setInfection(message.updatedinf);
		}
		return null;
	}

}
