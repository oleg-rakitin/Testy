package com.testy.infection;

import com.testy.events.CapabilityAddIvents;
import com.testy.main.TestyMod;
import com.testy.main.myDamageSource;
import com.testy.messages.InfectionUpdateMessage;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.relauncher.Side;

public class InfectionEvents 
{
	public static int tickforsun = 0;
	public static int tick = 0;
	public static int tickfordamage = 0;
	
	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event)
	{

			EntityPlayer player = event.player;
			World world = player.worldObj;
			if(world.provider.getDimensionType() == DimensionType.OVERWORLD)
			{
				if(world.provider.isDaytime())
				{
					if(!world.isRaining())
					{
						if(world.canSeeSky(player.getPosition()))
						{
							if(!player.capabilities.isCreativeMode)
							{
								if(!player.isDead)
								{
									if(tickforsun == 10)
									{
										CapabilityAddIvents.getHandler(player).addInfection(InfectionConstants.INFECTION_FROM_SUN);
										if(event.side == Side.SERVER)
										{
											EntityPlayerMP player1 = (EntityPlayerMP) event.player;
											if(player1 != null)
											{
												TestyMod.INSTANCE.sendTo(new InfectionUpdateMessage(CapabilityAddIvents.getHandler(player1).getInfection()), player1);
											}
											
										}
										tickforsun = 0;
										return;
									} else {
										tickforsun++;
										return;
									}
									
								}
		
							}

						}
					}
				}
			}
			tickforsun = 0;
	}
	@SubscribeEvent
	public void decreasetick(TickEvent.PlayerTickEvent event)
	{
		if(tick == 10)
		{
			tick = 0;
			CapabilityAddIvents.getHandler(event.player).removeInfection((2));
			if(event.side == Side.SERVER)
			{
				EntityPlayerMP player1 = (EntityPlayerMP) event.player;
				if(player1 != null)
				{
					TestyMod.INSTANCE.sendTo(new InfectionUpdateMessage(CapabilityAddIvents.getHandler(player1).getInfection()), player1);
				}
				
			}
		} else {
			tick--;
		}
	}
	@SubscribeEvent
	public void damage(TickEvent.PlayerTickEvent event)
	{
		if(CapabilityAddIvents.getHandler(event.player).getInfection() > 20)
		{
			if(tickfordamage >= 40)
			{
				event.player.attackEntityFrom(myDamageSource.infection, CapabilityAddIvents.getHandler(event.player).getInfection()/250);
				tickfordamage = 0;
			} else {
				tickfordamage++;

			}
		}

	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent e)
	{
		if(e.getEntity() instanceof EntityPlayer)
		{
			CapabilityAddIvents.getHandler(((EntityPlayer)e.getEntityLiving())).clearInfection();

				EntityPlayerMP player = (EntityPlayerMP)e.getEntityLiving();
				if(player != null)
				{
					TestyMod.INSTANCE.sendTo(new InfectionUpdateMessage(CapabilityAddIvents.getHandler(player).getInfection()), player);
				}
		}
		
	}
	@SubscribeEvent
	public void onRespawn(PlayerRespawnEvent e)
	{
		EntityPlayer player = e.player;
		BlockPos pos =  player.getBedLocation(player.dimension);
		if(player.worldObj.canSeeSky(pos))
		{
			for(int i = -4; i < 4; i++)
			{
				for(int j = -4; j < 4; j++)
				{
					player.worldObj.setBlockState(pos.add(i, 4, j), Blocks.DIRT.getDefaultState());

				}
			}
		}
	}
	@SubscribeEvent
	public void damaged(LivingAttackEvent e)
	{
		if(e.getSource().getSourceOfDamage() != null)
		{
			if(e.getSource().getSourceOfDamage() instanceof EntityZombie)
			{
				if(e.getEntity() instanceof EntityPlayer)
				{
			CapabilityAddIvents.getHandler(((EntityPlayer)e.getEntity())).addInfection(50);

				EntityPlayerMP player1 = (EntityPlayerMP) e.getEntity();
				if(player1 != null)
				{
					TestyMod.INSTANCE.sendTo(new InfectionUpdateMessage(CapabilityAddIvents.getHandler(player1).getInfection()), player1);
				}
		
	
				}
				
			}
		}
	}
	

}
