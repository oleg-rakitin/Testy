package com.testy.handlers;

import net.minecraft.util.IStringSerializable;

public enum EnumFlowers implements IStringSerializable
{
	INFECTED();

	
	private String name;
	
	EnumFlowers()
	{
		this.name = toString().toLowerCase().substring(2);
	}

	@Override
	public String getName() 
	{
		return name;
	}

	public String getID()
	{
		return "flower_type";
	}
	public EnumFlowers getByOrdinal(int id)
	{
		return EnumFlowers.values()[id];
	}
	
	public int getOrdinal()
	{
		return this.ordinal();	
	}

}
