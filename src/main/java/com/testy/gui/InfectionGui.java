package com.testy.gui;


import com.testy.events.CapabilityAddIvents;
import com.testy.main.TestyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class InfectionGui extends Gui
{
	
	public static final ResourceLocation INFECTION_SCREEN = new ResourceLocation(TestyMod.MODID, "textures/gui/infection_screen.png");
	public Minecraft mc;	
	public int inf = 0;
	public InfectionGui(Minecraft mc) 
	{
		this.mc = mc;

	}
	public void draw()
	{
		ScaledResolution res = new ScaledResolution(mc);
		int w = res.getScaledWidth() / 2;
		int h = res.getScaledWidth() / 2;
		if(CapabilityAddIvents.getHandler(mc.thePlayer) != null)
		{
				mc.renderEngine.bindTexture(INFECTION_SCREEN);
				Gui.drawModalRectWithCustomSizedTexture(w + 125, h + 150, 0, 0, 8, 8, 8, 8);
				drawCenteredString(mc.fontRendererObj, Integer.toString(inf), w + 100, h + 150, 0xFF4500);
		}
	}
	public void Update()
	{
		if(CapabilityAddIvents.getHandler(mc.thePlayer) != null)
		this.inf = CapabilityAddIvents.getHandler(mc.thePlayer).getInfection();
	}
}
