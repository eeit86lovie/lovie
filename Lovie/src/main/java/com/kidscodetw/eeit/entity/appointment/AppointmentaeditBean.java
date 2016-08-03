package com.kidscodetw.eeit.entity.appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class AppointmentaeditBean implements Serializable{
	private static final long serialVersionUID = 1L;
   
	@Id
	private Integer id;
	private Integer mId;
	private Integer showtimeId;
	private String pubTime;
	private String showtimeData;
	private String nickname;
	private Integer gender;
	private String birthday;
	private String constellation;	
	private String city;
	private String district;
	private Integer age;
	private String gendertxt;
	private String acontent;	
	private Integer astatus;
	@Transient
	private List<AppointmentareditBean> appointmentareditBeans = new ArrayList<AppointmentareditBean>();

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
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
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
	public List<AppointmentareditBean> getAppointmentareditBeans() {
		return appointmentareditBeans;
	}
	public void setAppointmentareditBeans(List<AppointmentareditBean> appointmentareditBeans) {
		this.appointmentareditBeans = appointmentareditBeans;
	}
	@Override
	public String toString() {
		return "AppointmentaeditBean [id=" + id + ", mId=" + mId + ", showtimeId=" + showtimeId + ", pubTime=" + pubTime
				+ ", showtimeData=" + showtimeData + ", nickname=" + nickname + ", gender=" + gender + ", birthday="
				+ birthday + ", constellation=" + constellation + ", city=" + city + ", district=" + district+ "," + age + "," + gendertxt
				+ ", acontent=" + acontent + ", astatus=" + astatus + ", AppointmentareditBeans="  
				+ (appointmentareditBeans==null?"":appointmentareditBeans.toString())
				+ "]";
	}

}
