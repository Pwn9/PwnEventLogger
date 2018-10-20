package com.pwn9.PwnEventLogger.BlockEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;

import com.pwn9.PwnEventLogger.PwnEventLogger;

public class EntityBlockFormListener implements Listener
{
	
	//private final PwnEventLogger plugin;
	
	public EntityBlockFormListener(PwnEventLogger plugin) 
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);    
	    //this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = false)
	public void entityBlockForm(EntityBlockFormEvent e) 
	{
		// return if config not set
		if (!PwnEventLogger.EntityBlockFormEvent) return;
		
		String curBlock = String.valueOf(e.getBlock().getType());	
		
		String entity = String.valueOf(e.getEntity().getName());
		
		String curBiome = String.valueOf(e.getBlock().getBiome());

		String coords = String.valueOf(e.getBlock().getLocation());
		
		PwnEventLogger.logToFile("EntityBlockFormEvent: " + curBlock + ", Biome: " + curBiome + ", Created By: " + entity + ", Coords: " + coords, "EntityBlockForm");
	}
	
}