package com.kidscodetw.eeit.websocket;

import java.util.List;

public class FromBackendMessge {
	
	public FromBackendMessge(){
		
	}

	public FromBackendMessge(String message) {
		this.message = message;
	}

	private String message;
	private List<String> group;
	private String style;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List getGroup(){
		return group;
	}
	
	public void setGroup(List<String> group){
		this.group=group;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	

}
