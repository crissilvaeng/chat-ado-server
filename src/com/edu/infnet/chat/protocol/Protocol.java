package com.edu.infnet.chat.protocol;

import java.util.HashMap;
import java.util.Map;

import com.edu.infnet.chat.command.Command;
import com.edu.infnet.chat.command.CommandFactory;
import com.edu.infnet.chat.storage.Storage;
import com.google.gson.Gson;

public class Protocol {
	
	private Storage storage;
	private CommandFactory factory;

	public Protocol(Storage storage) {
		this.storage = storage;
		this.factory = new CommandFactory();
	}
	
	@SuppressWarnings("unchecked") // Obrigada, compilador... mas quero fazer merda mesmo. Deixa eu.
	public String response(String request){
		Gson gson = new Gson();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(request, map.getClass());
		
		if (map.isEmpty()) {
			return "Ops!";
		}
		
		Command command = this.factory.build(map.get("cmd").toString(), request);
		return command.execute(storage);
	}
	
}
