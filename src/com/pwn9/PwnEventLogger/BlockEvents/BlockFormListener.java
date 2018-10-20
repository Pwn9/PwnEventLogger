package com.pwn9.PwnEventLogger.BlockEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import com.pwn9.PwnEventLogger.PwnEventLogger;

public class BlockFormListener implements Listener
{
	
	//private final PwnEventLogger plugin;
	
	public BlockFormListener(PwnEventLogger plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    //this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void blockForm(BlockFormEvent e) 
	{
		// return if config not set
		if (!PwnEventLogger.BlockFormEvent) return;
		
		String curBlock = String.valueOf(e.getBlock().getType());	
		
		String newBlock = String.valueOf(e.getNewState().getType());
		
		String curBiome = String.valueOf(e.getBlock().getBiome());

		String coords = String.valueOf(e.getBlock().getLocation());
		
		PwnEventLogger.logToFile("BlockFormEvent: " + curBlock + ", Biome: " + curBiome + ", NewBlock: " + newBlock + ", Coords: " + coords, "BlockForm");
	}
	
}