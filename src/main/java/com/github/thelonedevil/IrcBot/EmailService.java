package com.github.thelonedevil.IrcBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class EmailService {
	SSLSocket socket;
	BufferedReader input;
	PrintWriter output;

	public EmailService(String server, int port) {
		try {
			SSLSocketFactory sslsocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			socket = (SSLSocket) sslsocketFactory.createSocket(server, port);
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// After each println you MUST flush the buffer, or it won't work
			// properly.
			// The true argument makes an automatic flush after each println.
			output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readOneLine() throws IOException {
		return input.readLine();
	}

	public ArrayList<String> connect(String username, String password) throws IOException {
		System.out.print("Greeting message: ");
		String response = readOneLine();
		System.out.println(response);

		// Username
		output.println("USER " + username);
		response = readOneLine();
		System.out.println(response);

		// Password
		output.println("PASS " + password);
		response = readOneLine();
		System.out.println(response+ " default");
		output.println("STAT");
	
		response = readOneLine();
		System.out.println(response);
		String[] messages = response.split(" ");
		String message = messages[1]; 
		System.out.println(message+" STAT");
		int new1 = Integer.parseInt(message);
		System.out.println(new1);
		ArrayList<String> content = new ArrayList<String>();
		while (MyBotMain.last < new1) {
			output.println("RETR " + message);
			while (!response.equals(".")) {
				response = readOneLine();
				System.out.println(response);
				content.add(response);
			}
			MyBotMain.last = Integer.parseInt(message);
			System.out.println(MyBotMain.last);
			return content;
		}return content;

		
	
	}

}
