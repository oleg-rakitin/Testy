package com.testy.infection;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class Provider implements ICapabilitySerializable<NBTTagCompound>
{
	//sdasdasdaszxzss23z
	   @CapabilityInject(IInfectionHandler.class)
	    public static final Capability<IInfectionHandler> CAPABILITY_INFECTION = null;
	   
	   IInfectionHandler instance = CAPABILITY_INFECTION.getDefaultInstance();


	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		return capability == CAPABILITY_INFECTION;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
	  return hasCapability(capability, facing) ? CAPABILITY_INFECTION.<T>cast(instance) : null;
	}

	@Override
	public NBTTagCompound serializeNBT() 
	{
        return (NBTTagCompound) CAPABILITY_INFECTION.getStorage().writeNBT(CAPABILITY_INFECTION, instance, null);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) 
	{
		CAPABILITY_INFECTION.getStorage().readNBT(CAPABILITY_INFECTION, instance, null, nbt);

	}
	

}
