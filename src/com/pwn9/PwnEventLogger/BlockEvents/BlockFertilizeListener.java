package com.pwn9.PwnEventLogger.BlockEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFertilizeEvent;

import com.pwn9.PwnEventLogger.PwnEventLogger;

public class BlockFertilizeListener implements Listener
{
	
	//private final PwnEventLogger plugin;
	
	public BlockFertilizeListener(PwnEventLogger plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    //this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void blockFertilize(BlockFertilizeEvent e) 
	{
		// return if config not set
		if (!PwnEventLogger.BlockFertilizeEvent) return;
		
		String curPlayer = e.getPlayer().getName();
		
		String curBiome = String.valueOf(e.getBlock().getBiome());

		String coords = String.valueOf(e.getBlock().getLocation());
		
		String curBlock = String.valueOf(e.getBlock().getType());
		
		PwnEventLogger.logToFile("BlockFertilizeEvent: Player " + curPlayer + ", Coords: " + coords + ", Biome: " + curBiome + ", Block: " + curBlock, "BlockFertilize");
	}
	
}