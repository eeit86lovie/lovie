package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentamBean implements Serializable{
	private static final long serialVersionUID = 1L;
    		
	@Id
	private Integer id;
	private String pubTime;
	private Integer showtimeId;
	private String acontent;
	private Integer astatus;
	private Integer requestcnt;
	private java.sql.Date showtimeDate;
	private String showtimeData;
	private Integer memberId;
	private String nickname;
	private Integer gender;	
	private Integer age;
	private String gendertxt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public Integer getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
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
	public Integer getRequestcnt() {
		return requestcnt;
	}
	public void setRequestcnt(Integer requestcnt) {
		this.requestcnt = requestcnt;
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
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGendertxt() {
		return gendertxt;
	}
	public void setGendertxt(String gendertxt) {
		this.gendertxt = gendertxt;
	}
	@Override
	public String toString() {
		return "AppointmentamBean [id=" + id + ", pubTime=" + pubTime + ", showtimeId=" + showtimeId + ", acontent="
				+ acontent + ", astatus=" + astatus + ", requestcnt=" + requestcnt + ", showtimeDate=" + showtimeDate
				+ ", showtimeData=" + showtimeData + ", memberId=" + memberId + ", nickname=" + nickname + ", gender="
				+ gender + ", age=" + age + ", gendertxt=" + gendertxt + "]";
	}
	
}
