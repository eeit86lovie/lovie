package com.kidscodetw.eeit.admin.controller.broadcast;

public class SendToRoleMessage {
	
	public SendToRoleMessage(String message){
		this.message = message;
		
	}
	
	private String message;
	private String style;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
