package com.testy.messages;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class InfectionUpdateMessage implements IMessage
{
	
	public InfectionUpdateMessage() {}
	
	public int updatedinf;
	
	public InfectionUpdateMessage(int inf)
	{
		this.updatedinf = inf;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.updatedinf = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(updatedinf);
	}

}
