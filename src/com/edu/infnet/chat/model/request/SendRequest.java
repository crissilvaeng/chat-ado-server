package com.edu.infnet.chat.model.request;

// {"cmd":"enviar","id":"nohai","dst":"marques","data":"teste","msgNr":68}
public class SendRequest {
	private String cmd;
	private String id;
	private String dst;
	private String data;
	private int msgNr;
	
	public SendRequest(String cmd, String id, String dst, String data, int msgNr) {
		this.cmd = cmd;
		this.id = id;
		this.dst = dst;
		this.data = data;
		this.msgNr = msgNr;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getMsgNr() {
		return msgNr;
	}

	public void setMsgNr(int msgNr) {
		this.msgNr = msgNr;
	}	
}
