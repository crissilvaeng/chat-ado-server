package com.edu.infnet.chat.model.response;

// {"id":"0","msgNr":69}
public class SendResponse {
	private String id;
	private int msgNr;

	public SendResponse(String id, int msgNr) {
		this.id = id;
		this.msgNr = msgNr;
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
}
