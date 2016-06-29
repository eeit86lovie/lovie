package com.kidscodetw.eeit.entity;

import java.io.Serializable;

public class AppointmentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer memberId;
	private Integer showtimeId;
	private java.util.Date pubTime;
	private String content;
	private Integer acceptedMemberId;
	private java.util.Date acceptedTime;
	private Integer type;
	private Integer status;
	
	public String toString(){
		return "model.AppointmentBean [id:"+id +" , "+"memberId:"+ memberId + ", showtimeId:"+ showtimeId+ ", pubTime:"
				+ pubTime+ ", content:"+ content +", acceptedMemberId:"+ acceptedMemberId+ ", acceptedTime:"+ acceptedTime +", status:"+ status+"]";
	}
	
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}
	public java.util.Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(java.util.Date pubTime) {
		this.pubTime = pubTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAcceptedMemberId() {
		return acceptedMemberId;
	}
	public void setAcceptedMemberId(Integer acceptedMemberId) {
		this.acceptedMemberId = acceptedMemberId;
	}
	public java.util.Date getAcceptedTime() {
		return acceptedTime;
	}
	public void setAcceptedTime(java.util.Date acceptedTime) {
		this.acceptedTime = acceptedTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

	
	
	

}
