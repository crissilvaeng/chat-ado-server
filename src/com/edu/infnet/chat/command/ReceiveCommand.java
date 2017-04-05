package com.edu.infnet.chat.command;

import com.edu.infnet.chat.model.request.ReceiveRequest;
import com.edu.infnet.chat.model.response.ReceiveResponse;
import com.edu.infnet.chat.storage.Storage;
import com.google.gson.Gson;

public class ReceiveCommand implements Command {
	
	private ReceiveRequest request;

	public ReceiveCommand(ReceiveRequest request) {
		this.request = request;
	}
	
	@Override
	public String execute(Storage storage) {
		ReceiveResponse resp = new ReceiveResponse("0", this.request.getMsgNr() + 1, storage.getDataTo(request.getId()));
		
		Gson gson = new Gson();
		return gson.toJson(resp);
	}
}
