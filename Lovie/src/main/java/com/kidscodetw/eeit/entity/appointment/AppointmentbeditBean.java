package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentbeditBean implements Serializable{
	private static final long serialVersionUID = 1L;
   
	@Id
	private Integer id;
	@Id
	private Integer mId;
	private Integer showtimeId;
	private String showtimeData;
	private String nickname;
	private Integer gender;
	private String birthday;
	private String constellation;	
	private String city;
	private String district;	
	private String bcontent;	
	private Integer bstatus;
	private String acontent;	
	private Integer astatus;
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
	public String getShowtimeData() {
		return showtimeData;
	}
	public void setShowtimeData(String showtimeData) {
		this.showtimeData = showtimeData;
	}
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
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
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public Integer getBstatus() {
		return bstatus;
	}
	public void setBstatus(Integer bstatus) {
		this.bstatus = bstatus;
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
	@Override
	public String toString() {
		return "AppointmentbeditBean [id=" + id + ", showtimeId=" + showtimeId + ", showtimeData=" + showtimeData
				+ ", mId=" + mId + ", nickname=" + nickname + ", gender=" + gender + ", birthday=" + birthday
				+ ", constellation=" + constellation + ", city=" + city + ", district=" + district + ", bcontent="
				+ bcontent + ", bstatus=" + bstatus + ", acontent=" + acontent + ", astatus=" + astatus + "]";
	}
}
