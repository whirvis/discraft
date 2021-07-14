package net.whirvis.mc.discraft;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class DiscraftPlugin extends JavaPlugin {

	private final Logger log;
	private final DiscraftConfig config;
	private boolean enabled;

	public DiscraftPlugin() {
		this.log = this.getLogger();
		this.config = new DiscraftConfig(this);
	}

	@Override
	public void onEnable() {
		config.load();
		if (!config.hasBotToken()) {
			log.severe("Failed to fetch bot token!");
			return;
		}
		this.enabled = true;
	}

	@Override
	public void onDisable() {
		if (!enabled) {
			return;
		}
	}

}
