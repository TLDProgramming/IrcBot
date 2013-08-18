package com.github.thelonedevil.IrcBot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class MyBotMain {
	static MyBot bot;
	static int last = 0;
	static File config = new File("config.txt");
	static String server;
	static int port;
	static String username;
	static String password;

	public static void main(String[] args) throws Exception {

		// Now start our bot up.
		bot = new MyBot();

		// Enable debugging output.
		bot.setVerbose(true);

		// Connect to the IRC server.
		bot.connect("irc.justin-wiblin.tk");

		// Join the #pircbot channel.
		bot.joinChannel("#general");
		loadConfig();

		Timer timer = new Timer();
		timer.schedule(new Task(), 1000, 60000);
	}

	static void loadConfig() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(config));

			String line;

			while ((line = br.readLine()) != null) {
				if (line.startsWith("Server:")) {
					server = line.split(":")[1].trim();
				} else if (line.startsWith("Port:")) {
					port = Integer.parseInt(line.split(":")[1].trim());
				} else if (line.startsWith("Username:")) {
					username = line.split(":")[1].trim();
				} else if (line.startsWith("Password:")) {
					password = line.split(":")[1].trim();
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static String getSubject() throws IOException {
		EmailService email = new EmailService(server, port);
		ArrayList<String> message = email.connect(username, password);
		String sub = null;
		for (String s : message)
			if (s.startsWith("Subject:")) {
				System.out.println(s);
				sub = s;
			}
		if (sub != null) {
			return sub;
		} else {
			return "null";
		}
	}
}
