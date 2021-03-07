package com.pwn9.PwnEventLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.bukkit.event.block.BlockGrowEvent;
//import org.bukkit.event.world.StructureGrowEvent;
//import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.pwn9.PwnEventLogger.BlockEvents.BlockFertilizeListener;
import com.pwn9.PwnEventLogger.BlockEvents.BlockFormListener;
import com.pwn9.PwnEventLogger.BlockEvents.BlockGrowListener;
import com.pwn9.PwnEventLogger.BlockEvents.BlockSpreadListener;
import com.pwn9.PwnEventLogger.BlockEvents.EntityBlockFormListener;
import com.pwn9.PwnEventLogger.BlockEvents.StructureGrowListener;

public class PwnEventLogger extends JavaPlugin
{
	public static PwnEventLogger instance;
	
	// get the plugin data folder
	public static File dataFolder;
	
	// config values
	public static Boolean BlockGrowEvent;
	public static Boolean BlockSpreadEvent;
	public static Boolean StructureGrowEvent;
	public static Boolean BlockFormEvent;
	public static Boolean EntityBlockFormEvent;
	public static Boolean BlockFertilizeEvent;
	
	public static Boolean CancelBlockGrowEvent;
	public static Boolean CancelBlockSpreadEvent;
	public static Boolean CancelStructureGrowEvent;
	public static Boolean CancelBlockFormEvent;
	public static Boolean CancelEntityBlockFormEvent;
	public static Boolean CancelBlockFertilizeEvent;	
	
	public void onEnable()
	{
		instance = this;
		
		this.saveDefaultConfig();
		
		// Setup listener classes
		new BlockGrowListener(this);
		new StructureGrowListener(this);
		new BlockSpreadListener(this);
		new BlockFormListener(this);
		new EntityBlockFormListener(this);
		new BlockFertilizeListener(this);
		
		// Get plugin data folders
		PwnEventLogger.dataFolder = getDataFolder();
		
		// Load configurable values
		Config.LoadConfig();
		
	}
	
	// function to log a message to a file
    public static void logToFile(String message, String fileName) 
    {   
    	try
    	{
		    
		    if(!dataFolder.exists()) 
		    {
		    	dataFolder.mkdir();
		    }
		     
		    File saveTo = new File(dataFolder, fileName+".log");
		    if (!saveTo.exists())  
		    {
		    	saveTo.createNewFile();
		    }
		    
		    FileWriter fw = new FileWriter(saveTo, true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println(getDate() +" "+ message);
		    pw.flush();
		    pw.close();
	    } 
	    catch (IOException e) 
	    {
	    	e.printStackTrace();
	    }
    }    
    
    // makes a pretty date
    public static String getDate() 
    {
    	  String s;
    	  Format formatter;
    	  Date date = new Date(); 
    	  formatter = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
    	  s = formatter.format(date);
    	  return s;
    }	
}