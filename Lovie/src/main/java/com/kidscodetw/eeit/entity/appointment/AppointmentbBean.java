package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentbBean implements Serializable{
	private static final long serialVersionUID = 1L;
   
	@Id
	private Integer id;
	private Integer mId;
	private Integer showtimeId;
	private String pubTime;
	private String requestAppointmentTime;
	private Integer bstatus;
	private Integer gender;
	private String nickname;
	private java.sql.Date showtimeDate;
	private String showtimeData;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
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
	public void setPubTime(java.sql.Timestamp pubTime) {
		if (pubTime == null)
		{ this.pubTime = "";}
		else
		{ this.pubTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(pubTime);}
	}
	public Integer getBstatus() {
		return bstatus;
	}
	public void setBstatus(Integer bstatus) {
		this.bstatus = bstatus;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public java.sql.Date getShowtimeDate() {
		return showtimeDate;
	}
	public void setShowtimeDate(java.sql.Date showtimeDate) {
		this.showtimeDate = showtimeDate;
	}
	public String getRequestAppointmentTime() {
		return requestAppointmentTime;
	}
	public void setRequestAppointmentTime(java.sql.Timestamp requestAppointmentTime) {
		if (requestAppointmentTime == null)
		{ this.requestAppointmentTime = "";}
		else
		{this.requestAppointmentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(requestAppointmentTime);}
	}
	public String getShowtimeData() {
		return showtimeData;
	}
	public void setShowtimeData(String showtimeData) {
		this.showtimeData = showtimeData;
	}
	@Override
	public String toString() {
		return "AppointmentbBean [id=" + id + ", mId=" + mId + ", showtimeId=" + showtimeId + ", pubTime=" + pubTime
				+ ", requestAppointmentTime=" + requestAppointmentTime + ", bstatus=" + bstatus + ", gender=" + gender
				+ ", nickname=" + nickname + ", showtimeDate=" + showtimeDate + ", showtimeData=" + showtimeData + "]";
	}
}
