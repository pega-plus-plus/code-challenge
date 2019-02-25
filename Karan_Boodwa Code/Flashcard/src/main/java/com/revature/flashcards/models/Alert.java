package com.revature.flashcards.models;

public class Alert {
	private String type = "info";
	private String message;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Alert(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	public Alert() {
		super();
	}
	@Override
	public String toString() {
		return "Alert [type=" + type + ", message=" + message + "]";
	}
	
}
