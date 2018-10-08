package com.pwn9.PwnEventLogger;

import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class BlockGrowListener implements Listener
{
	
	//private final PwnEventLogger plugin;
	
	public BlockGrowListener(PwnEventLogger plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    //this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void blockGrow(BlockGrowEvent e) 
	{
		String curBlock = String.valueOf(e.getBlock().getType());	
		
		String downBlock = String.valueOf(e.getBlock().getRelative(BlockFace.DOWN).getType());
		
		String curBiome = String.valueOf(e.getBlock().getBiome());

		String coords = String.valueOf(e.getBlock().getLocation());
		
		PwnEventLogger.logToFile("Block Event for: " + curBlock + " - In biome: " + curBiome + " - Downblock: " + downBlock + " - at: " + coords, "BlockGrow");
	}
	
}