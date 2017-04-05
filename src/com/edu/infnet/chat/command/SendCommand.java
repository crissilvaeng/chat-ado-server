package com.edu.infnet.chat.command;

import com.edu.infnet.chat.model.request.SendRequest;
import com.edu.infnet.chat.model.response.Data;
import com.edu.infnet.chat.model.response.SendResponse;
import com.edu.infnet.chat.storage.Storage;
import com.google.gson.Gson;

public class SendCommand implements Command {
	
	private SendRequest request;
	
	public SendCommand(SendRequest request) {
		this.request = request;
	}
	
	@Override
	public String execute(Storage storage) {
		storage.addData(this.request.getDst(), new Data(this.request.getData(), this.request.getId()));
		SendResponse resp = new SendResponse("0", this.request.getMsgNr() + 1);
		
		Gson gson = new Gson();
		return gson.toJson(resp);
	}
}
