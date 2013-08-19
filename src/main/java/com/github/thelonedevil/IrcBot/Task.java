package com.github.thelonedevil.IrcBot;

import java.io.IOException;
import java.util.*;

class Task extends TimerTask {

	MyBot bot = MyBotMain.bot;

	// run is a abstract method that defines task performed at scheduled time.
	@Override
	public void run() {
		try {
			HashMap<String, String> messages = MyBotMain.getMessages();
			if (messages != null) {
				String subject = messages.get("Subject");
				String build = messages.get("Build");
				String author = "Author:" + messages.get("Author");
				String branch = "Branch:" + messages.get("Branch");
				String message = "Commit Message: " + messages.get("Message");
				bot.sendMessage(MyBotMain.channel, subject);

				bot.sendMessage(MyBotMain.channel, build);

				bot.sendMessage(MyBotMain.channel, author);

				bot.sendMessage(MyBotMain.channel, branch);

				bot.sendMessage(MyBotMain.channel, message);

			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}
}
