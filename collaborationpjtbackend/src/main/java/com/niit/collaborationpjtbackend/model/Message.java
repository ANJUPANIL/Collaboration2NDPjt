package com.niit.collaborationpjtbackend.model;

public class Message {
	
	private int id;
	
	public int getId() {
		return id;
	}
	
	public Message(int id,String message){
		this.id = id;
		this.message = message;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
	

}
