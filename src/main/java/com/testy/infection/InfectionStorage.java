package com.testy.infection;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class InfectionStorage implements Capability.IStorage<IInfectionHandler>
{
	public static final String INFECTION = "infection";
	

	@Override
	public NBTBase writeNBT(Capability<IInfectionHandler> capability, IInfectionHandler instance, EnumFacing side) 
	{
		final NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger(INFECTION, instance.getInfection());
		return tag;
	}

	@Override
	public void readNBT(Capability<IInfectionHandler> capability, IInfectionHandler instance, EnumFacing side,
			NBTBase nbt)
	{
		final NBTTagCompound tag = (NBTTagCompound) nbt;
		instance.setInfection(tag.getInteger(INFECTION));
		
	}
	
}
