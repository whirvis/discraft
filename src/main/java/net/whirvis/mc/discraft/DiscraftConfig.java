package net.whirvis.mc.discraft;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

public class DiscraftConfig {

	private static final String BOT_TOKEN = "bot-token";
	private static final Map<String, Object> DEFAULTS = new HashMap<>();
	static {
		DEFAULTS.put(BOT_TOKEN, "BOT-TOKEN-HERE");
	}

	private final DiscraftPlugin plugin;
	private final Logger log;
	private final FileConfiguration config;

	private String botToken;

	public DiscraftConfig(DiscraftPlugin plugin) {
		this.plugin = plugin;
		this.log = plugin.getLogger();
		this.config = plugin.getConfig();
	}
	
	public boolean hasBotToken() {
		return botToken != null;
	}

	public String getBotToken() {
		return this.botToken;
	}

	private boolean isDefault(String key) {
		if (!DEFAULTS.containsKey(key)) {
			return false;
		}
		Object configDefault = DEFAULTS.get(key);
		Object current = config.getObject(key, configDefault.getClass());	
		return Objects.equals(configDefault, current);
	}

	public void load() {
		log.info("Loading config");

		log.fine("Setting configuration defaults");
		config.addDefaults(DEFAULTS);
		config.options().copyHeader(true).copyDefaults(true);
		plugin.saveConfig();

		log.fine("Fetching bot token");
		String botToken = config.getString(BOT_TOKEN);
		if (botToken != null && !this.isDefault(BOT_TOKEN)) {
			this.botToken = botToken;
		}
	}

}
