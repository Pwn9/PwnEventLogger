package com.pwn9.PwnEventLogger.BlockEvents;

import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.pwn9.PwnEventLogger.PwnEventLogger;

public class StructureGrowListener implements Listener
{
	
	//private final PwnEventLogger plugin;
	
	public StructureGrowListener(PwnEventLogger plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    //this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void structureGrow(StructureGrowEvent e) 
	{
		// return if config not set
		if (!PwnEventLogger.StructureGrowEvent) return;
		
		String eventBlock = String.valueOf(e.getSpecies());

		String coords = String.valueOf(e.getLocation());
		
		String curBlock = String.valueOf(e.getLocation().getBlock().getType());		
		
		String downBlock = String.valueOf(e.getLocation().getBlock().getRelative(BlockFace.DOWN).getType());
		
		String curBiome = String.valueOf(e.getLocation().getBlock().getBiome());
		
		PwnEventLogger.logToFile("StructureGrowEvent: " + curBlock + ", Biome: " + curBiome + ", DownBlock: " + downBlock + ", Species: " + eventBlock + ", Coords: " + coords, "StructureGrow");
		
		if(PwnEventLogger.CancelStructureGrowEvent)e.setCancelled(true);
	}
	
}