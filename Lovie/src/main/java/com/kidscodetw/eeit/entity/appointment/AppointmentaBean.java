package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentaBean implements Serializable{
	private static final long serialVersionUID = 1L;
   
	@Id
	private Integer id;
	private Integer showtimeId;
	private String pubTime;
	private String acontent;
	private Integer astatus;
	private java.sql.Date showtimeDate;
	private String showtimeData;
	private Integer requestcnt;
	private Integer acceptedMemberId;
	private String acceptedTime;
	private String nickname;
	private Integer gender;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Integer getAstatus() {
		return astatus;
	}
	public void setAstatus(Integer astatus) {
		this.astatus = astatus;
	}
	public java.sql.Date getShowtimeDate() {
		return showtimeDate;
	}
	public void setShowtimeDate(java.sql.Date showtimeDate) {
		this.showtimeDate = showtimeDate;
	}
	public String getShowtimeData() {
		return showtimeData;
	}
	public void setShowtimeData(String showtimeData) {
		this.showtimeData = showtimeData;
	}
	public Integer getRequestcnt() {
		return requestcnt;
	}
	public void setRequestcnt(Integer requestcnt) {
		this.requestcnt = requestcnt;
	}
	public Integer getAcceptedMemberId() {
		return acceptedMemberId;
	}
	public void setAcceptedMemberId(Integer acceptedMemberId) {
		this.acceptedMemberId = acceptedMemberId;
	}
	public String getAcceptedTime() {
		return acceptedTime;
	}
	public void setAcceptedTime(String acceptedTime) {
		this.acceptedTime = acceptedTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "AppointmentaBean [id=" + id + ", showtimeId=" + showtimeId + ", pubTime=" + pubTime + ", acontent="
				+ acontent + ", astatus=" + astatus + ", showtimeDate=" + showtimeDate + ", showtimeData="
				+ showtimeData + ", requestcnt=" + requestcnt + ", acceptedMemberId=" + acceptedMemberId
				+ ", acceptedTime=" + acceptedTime + ", nickname=" + nickname + ", gender=" + gender + "]";
	}
}
