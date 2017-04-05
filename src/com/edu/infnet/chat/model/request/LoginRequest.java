package com.edu.infnet.chat.model.request;

// {"cmd":"login","id":"nohai","msgNr":1}
public class LoginRequest {
	private String cmd;
	private String id;
	private int msgNr;

	public LoginRequest(String cmd, String id, int msgNr) {
		this.cmd = cmd;
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
	
	public String getCmd() {
		return this.cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
