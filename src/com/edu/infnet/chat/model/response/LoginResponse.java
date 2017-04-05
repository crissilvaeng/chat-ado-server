package com.edu.infnet.chat.model.response;

import java.util.ArrayList;

// {"id":"0","msgNr":2}
public class LoginResponse {
	private String id;
	private int msgNr;
	private ArrayList<Data> data;
	
	public LoginResponse(String id, int msgNr, ArrayList<Data> data) {
		this.id = id;
		this.msgNr = msgNr;
		this.data = data;
	}
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMsgNr() {
		return this.msgNr;
	}

	public void setMsgNr(int msgNr) {
		this.msgNr = msgNr;
	}
	
	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
}
