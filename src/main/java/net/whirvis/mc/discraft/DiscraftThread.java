package net.whirvis.mc.discraft;

import java.net.URL;
import java.util.logging.Logger;

import net.whirvis.mc.discraft.settings.DiscraftSettings;

public class DiscraftThread extends Thread {
	
	private final Logger log;
	private final DiscraftPlugin plugin;
	
	public DiscraftThread(DiscraftPlugin plugin) {
		this.plugin = plugin;
		this.log = plugin.getLogger();
	}
	
	@Override
	public void run() {
		DiscraftSettings settings = plugin.getSettings();
		
		URL botAddress = settings.getBotAddress();
		if(botAddress == null) {
			log.severe("No bot address! Shutting down");
			return;
		}
	}
	
}
