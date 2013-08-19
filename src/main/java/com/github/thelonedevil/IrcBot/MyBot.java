package com.github.thelonedevil.IrcBot;

import org.jibble.pircbot.PircBot;

public class MyBot extends PircBot {

	public MyBot(String name) {
		this.setName(name);
	}

	@Override
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		if (message.equalsIgnoreCase("!Stop")) {
			MyBotMain.shutdown();
		}
	}

}
