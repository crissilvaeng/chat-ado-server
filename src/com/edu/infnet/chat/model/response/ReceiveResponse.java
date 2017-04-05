package com.edu.infnet.chat.model.response;

import java.util.List;

// {"id":"0","msgNr":15,"data":[{"data":"teste","src":"marques"}]}
public class ReceiveResponse {
	private String id;
	private int msgNr;
	private List<Data> data;

	public ReceiveResponse(String id, int msgNr, List<Data> data) {
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
	
	public List<Data> getData() {
		return data;
	}
	
	public void setData(List<Data> data) {
		this.data = data;
	}
}
