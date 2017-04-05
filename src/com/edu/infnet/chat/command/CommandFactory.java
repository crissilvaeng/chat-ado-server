package com.edu.infnet.chat.command;

import com.edu.infnet.chat.model.request.LoginRequest;
import com.edu.infnet.chat.model.request.ReceiveRequest;
import com.edu.infnet.chat.model.request.SendRequest;
import com.google.gson.Gson;

public class CommandFactory {

	public Command build(String command, String request) {
		Gson gson = new Gson();
		
		switch (command) {
		case "enviar":
			return new SendCommand(gson.fromJson(request, SendRequest.class));
//		case "logout":
//			return new Logout(request);
		case "login":
			return new LoginCommand(gson.fromJson(request, LoginRequest.class));
		case "receber":
			return new ReceiveCommand(gson.fromJson(request, ReceiveRequest.class));
		}
		return null;
	}
	
}
