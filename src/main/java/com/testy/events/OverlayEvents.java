package com.testy.events;



import org.lwjgl.opengl.GL11;

import com.testy.gui.InfectionGui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OverlayEvents
{
	private int tick = 0;
	final Minecraft mc = Minecraft.getMinecraft();
	private InfectionGui gui = new InfectionGui(mc);
	//final EntityPlayer player = mc.thePlayer;
	
	@SubscribeEvent
	public void renderInfection(RenderGameOverlayEvent.Post e)
	{
		if(e.getType() == ElementType.TEXT)
		{
			if(tick >= 20)
			{
				GL11.glPushMatrix();
				
				gui.Update();
				
				GL11.glPopMatrix();
				tick = 0;
			}chechevica
			gui.draw();
			tick++;
		}	
	}
	//@SubscribeEvent
	//public void renderInfection2(RenderGameOverlayEvent.Post e)
	//{
	//}

}
