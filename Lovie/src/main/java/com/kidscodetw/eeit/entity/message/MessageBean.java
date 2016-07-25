package com.kidscodetw.eeit.entity.message;

public class MessageBean {
	
	private Integer id;
	private String sender;
	private String receiver;
	private String message;
	private java.util.Date timestamp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public java.util.Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(java.util.Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String toString(){
		return "model.EntityBean["+
				"id: " +id+ ", sender: "+ sender+", receiver: "+ receiver+", message: "+ message+", timestamp: "+ timestamp+"]";
	}

}
