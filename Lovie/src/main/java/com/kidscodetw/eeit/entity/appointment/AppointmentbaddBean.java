package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentbaddBean implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@Id
	private Integer id;
	@Id
	private Integer mId;
	private String pubTime;
	private Integer showtimeId;
	private java.sql.Date showtimeDate;
	private String showtimeData;
	private String nickname;
	private Integer gender;
	private String birthday;
	private Integer age;
	private String gendertxt;
	private String constellation;	
	private String city;
	private String district;	
	private String acontent;	
	private Integer astatus;
	private Integer requestcnt;

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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
	@Override
	public String toString() {
		return "AppointmentbaddBean [id=" + id + ", mId=" + mId + ", pubTime=" + pubTime + ", showtimeId=" + showtimeId
				+ ", showtimeDate=" + showtimeDate + ", showtimeData=" + showtimeData + ", nickname=" + nickname
				+ ", gender=" + gender + ", birthday=" + birthday + ", age=" + age + ", gendertxt=" + gendertxt
				+ ", constellation=" + constellation + ", city=" + city + ", district=" + district + ", acontent="
				+ acontent + ", astatus=" + astatus + ", requestcnt=" + requestcnt + "]";
	}

}
