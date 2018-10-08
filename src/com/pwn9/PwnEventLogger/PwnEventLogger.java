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

public class PwnEventLogger extends JavaPlugin
{
	public static PwnEventLogger instance;
	
	public static File dataFolder;
	
	public void onEnable()
	{
		instance = this;
		
		new BlockGrowListener(this);
		new StructureGrowListener(this);
		
		PwnEventLogger.dataFolder = getDataFolder();
		
	}
	
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