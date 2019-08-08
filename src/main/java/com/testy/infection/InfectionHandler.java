package com.testy.infection;


public class InfectionHandler implements IInfectionHandler
{
	public static final int MAX = 100000;
	private int infection;

	
	@Override
	public int getInfection()
	{
		return infection;
	}

	@Override
	public void setInfection(int inf) 
	{
		this.infection = inf;

	}

	@Override
	public void addInfection(int inf) 
	{
		if(this.infection + inf/2 != MAX)
		{
			this.infection += inf/2	;
		}
	}

	@Override
	public void removeInfection(int inf) 
	{
		this.infection -= inf/2;
		if(getInfection() < 0) setInfection(0);

	}

	@Override
	public void clearInfection() 
	{
		this.infection = 0;

	}




}
