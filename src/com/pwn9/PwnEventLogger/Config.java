package com.pwn9.PwnEventLogger;

public class Config
{
	public static void LoadConfig() 
	{
		PwnEventLogger.BlockGrowEvent = PwnEventLogger.instance.getConfig().getBoolean("BlockGrowEvent", false);
		PwnEventLogger.CancelBlockGrowEvent = PwnEventLogger.instance.getConfig().getBoolean("CancelBlockGrowEvent", false);
		PwnEventLogger.BlockSpreadEvent = PwnEventLogger.instance.getConfig().getBoolean("BlockSpreadEvent", false);
		PwnEventLogger.CancelBlockSpreadEvent = PwnEventLogger.instance.getConfig().getBoolean("CancelBlockSpreadEvent", false);
		PwnEventLogger.StructureGrowEvent = PwnEventLogger.instance.getConfig().getBoolean("StructureGrowEvent", false);
		PwnEventLogger.CancelStructureGrowEvent = PwnEventLogger.instance.getConfig().getBoolean("CancelStructureGrowEvent", false);
		PwnEventLogger.BlockFormEvent = PwnEventLogger.instance.getConfig().getBoolean("BlockFormEvent", false);
		PwnEventLogger.CancelBlockFormEvent = PwnEventLogger.instance.getConfig().getBoolean("CancelBlockFormEvent", false);
		PwnEventLogger.EntityBlockFormEvent = PwnEventLogger.instance.getConfig().getBoolean("EntityBlockEvent", false);
		PwnEventLogger.CancelEntityBlockFormEvent = PwnEventLogger.instance.getConfig().getBoolean("CancelEntityBlockEvent", false);
		PwnEventLogger.BlockFertilizeEvent = PwnEventLogger.instance.getConfig().getBoolean("BlockFertilizeEvent", false);
		PwnEventLogger.CancelBlockFertilizeEvent = PwnEventLogger.instance.getConfig().getBoolean("CancelBlockFertilizeEvent", false);
		
	}
}