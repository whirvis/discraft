package net.whirvis.mc.discraft;

import java.net.URL;

public class DiscraftBotSession {
	
	private URL botAddress;
	
	public DiscraftBotSession(URL botAddress) {
		this.botAddress = botAddress;
	}
	
	public URL getBotAddress() {
		return this.botAddress;
	}
	
}
