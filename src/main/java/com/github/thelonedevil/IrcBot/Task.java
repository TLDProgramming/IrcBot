package com.github.thelonedevil.IrcBot;

import java.io.IOException;
import java.util.*;

class Task extends TimerTask {

	MyBot bot = MyBotMain.bot;

	// run is a abstract method that defines task performed at scheduled time.
	public void run() {
		try{
		String message = MyBotMain.getSubject();
		if (message.contains("Subject:")) {
			System.out.println(message);
			bot.sendMessage("#general", message);
		}
		}catch(IOException e){
			e.printStackTrace(System.out);
		}
	}
}