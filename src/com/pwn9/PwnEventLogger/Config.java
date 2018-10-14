package com.pwn9.PwnEventLogger;

public class Config
{
	public static void LoadConfig() 
	{
		PwnEventLogger.BlockGrowEvent = PwnEventLogger.instance.getConfig().getBoolean("BlockGrowEvent", false);
		PwnEventLogger.BlockSpreadEvent = PwnEventLogger.instance.getConfig().getBoolean("BlockSpreadEvent", false);
		PwnEventLogger.StructureGrowEvent = PwnEventLogger.instance.getConfig().getBoolean("StructureGrowEvent", false);
		
	}
}