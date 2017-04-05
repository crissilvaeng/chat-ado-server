package com.edu.infnet.chat.storage;

import java.util.ArrayList;
import java.util.Hashtable;

import com.edu.infnet.chat.model.response.Data;

public class Storage {
	
	private Hashtable<String, ArrayList<Data>> data;
	
	public Storage() {
		this.data = new Hashtable<String, ArrayList<Data>>();
	}

	public void addUser(String user) {
		if (this.data.containsKey(user) == false) {
			this.data.put(user, new ArrayList<Data>());
		}
	}
	
	public ArrayList<Data> getDataTo(String user){
		if (this.data.containsKey(user)) {
			ArrayList<Data> content = new ArrayList<Data>(this.data.get(user));
			this.data.get(user).clear();
			return content;
		}
		return new ArrayList<Data>();
	}
	
	public void addData(String user, Data data){
		if (this.data.containsKey(user) == false) {
			addUser(user);
		}
		this.data.get(user).add(data);
	}
}
