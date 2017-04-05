package com.edu.infnet.chat.command;

import com.edu.infnet.chat.model.request.LoginRequest;
import com.edu.infnet.chat.model.response.LoginResponse;
import com.edu.infnet.chat.storage.Storage;
import com.google.gson.Gson;

public class LoginCommand implements Command {

	private LoginRequest request;
	
	public LoginCommand(LoginRequest request) {
		this.request = request;
	}
	
	@Override
	public String execute(Storage storage) {
		storage.addUser(request.getId());
		LoginResponse resp = new LoginResponse("0", this.request.getMsgNr() + 1, storage.getDataTo(request.getId()));
		
		Gson gson = new Gson();
		return gson.toJson(resp);
	}
}
