package com.pwn9.PwnEventLogger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class BlockSpreadListener implements Listener
{
	
	//private final PwnEventLogger plugin;
	
	public BlockSpreadListener(PwnEventLogger plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    //this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void blockGrow(BlockSpreadEvent e) 
	{
		String curBlock = String.valueOf(e.getBlock().getType());	
		
		String sourceBlock = String.valueOf(e.getSource().getType());
		
		String curBiome = String.valueOf(e.getBlock().getBiome());

		String coords = String.valueOf(e.getBlock().getLocation());
		
		PwnEventLogger.logToFile("BlockSpreadEvent: " + curBlock + ", Biome: " + curBiome + ", SourceBlock: " + sourceBlock + ", Coords: " + coords, "BlockSpread");
	}
	
}