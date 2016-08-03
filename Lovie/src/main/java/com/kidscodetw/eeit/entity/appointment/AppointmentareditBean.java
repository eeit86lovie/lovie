package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppointmentareditBean implements Serializable{
	private static final long serialVersionUID = 1L;
   
	@Id
	private Integer appointmentID;
	@Id
	private Integer requestMemberId;
	private String requestAppointmentTime;
	private String bcontent;	
	private Integer bstatus;
	private String nickname;
	private Integer gender;
	private String birthday;
	private String constellation;	
	private String city;
	private String district;
	private Integer age;
	private String gendertxt;
	
	public Integer getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(Integer appointmentID) {
		this.appointmentID = appointmentID;
	}
	public Integer getRequestMemberId() {
		return requestMemberId;
	}
	public void setRequestMemberId(Integer requestMemberId) {
		this.requestMemberId = requestMemberId;
	}
	public String getRequestAppointmentTime() {
		return requestAppointmentTime;
	}
	public void setRequestAppointmentTime(String requestAppointmentTime) {
		this.requestAppointmentTime = requestAppointmentTime;
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
		return "AppointmentareditBean [appointmentID=" + appointmentID + ", requestMemberId=" + requestMemberId
				+ ", requestAppointmentTime=" + requestAppointmentTime + ", bcontent=" + bcontent + ", bstatus="
				+ bstatus + ", nickname=" + nickname + ", gender=" + gender + ", birthday=" + birthday
				+ ", constellation=" + constellation + ", city=" + city + ", district=" + district + "," + age + "," + gendertxt+ "]";
	}	
}
