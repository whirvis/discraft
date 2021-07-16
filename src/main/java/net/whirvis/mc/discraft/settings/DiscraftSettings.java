package net.whirvis.mc.discraft.settings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

import net.whirvis.mc.discraft.DiscraftPlugin;

public class DiscraftSettings {

	private final Logger log;
	private final FileConfiguration config;

	private boolean loaded;
	private URL botAddress;

	public DiscraftSettings(DiscraftPlugin plugin) {
		this.log = plugin.getLogger();
		this.config = plugin.getConfig();
	}

	public URL getBotAddress() {
		return this.botAddress;
	}

	private void fetchBotAddress() {
		log.fine("Fetching bot address");

		/*
		 * Discraft has a central bot at the address found below. However, since
		 * the bot is also open source, we allow server owners to specify their
		 * own bot address. If unspecified, default to the central server.
		 */
		String botAddress = config.getString("bot-address");
		if (botAddress == null) {
			botAddress = "https://discraft.whirvis.net/";
		}

		try {
			this.botAddress = new URL(botAddress);
			log.info("Using Discraft bot at address: " + botAddress);
		} catch (MalformedURLException e) {
			log.severe("Invalid URL for Discraft bot: " + botAddress);
		}
	}
	
	public boolean areLoaded() {
		return this.loaded;
	}

	public void load() {
		if (loaded) {
			log.severe("Settings already loaded");
			return;
		}

		log.info("Loading settings");
		this.fetchBotAddress();
		this.loaded = true;
	}

}
