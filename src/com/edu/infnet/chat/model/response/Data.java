package com.edu.infnet.chat.model.response;

public class Data {
	private String data;
	private String src;
	
	public Data(String data, String src) {
		super();
		this.data = data;
		this.src = src;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}
