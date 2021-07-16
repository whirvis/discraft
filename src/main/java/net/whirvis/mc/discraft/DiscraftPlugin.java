package net.whirvis.mc.discraft;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.whirvis.mc.discraft.settings.DiscraftSettings;

public class DiscraftPlugin extends JavaPlugin {

	private final DiscraftThread thread;
	private final DiscraftSettings settings;

	public DiscraftPlugin() {
		this.thread = new DiscraftThread(this);
		this.settings = new DiscraftSettings(this);
	}
	
	public DiscraftSettings getSettings() {
		return this.settings;
	}
	
	public void registerListener(Listener listener) {
		this.getServer().getPluginManager().registerEvents(listener, this);
	}

	@Override
	public void onEnable() {
		settings.load();
		thread.start();
	}

}
