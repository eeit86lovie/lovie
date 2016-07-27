package com.kidscodetw.eeit.entity.report;

import java.sql.Timestamp;

public class ReportBean2 {
	private Integer id;
	private String account;
	private Boolean gender;
	private String email;
	private String nickname;
	private Integer privilege;
	private String birthday;
	private String registeredTime;
	private String lastOnTime;
	
	@Override
	public String toString() {
		return "ReportBean [id=" + id + ", account=" + account + ", gender=" + gender + ", email=" + email
				+ ", nickname=" + nickname + ", privilege=" + privilege + ", birthday=" + birthday + ", registeredTime="
				+ registeredTime + ", lastOnTime=" + lastOnTime + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		   this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRegisteredTime() {
		return registeredTime;
	}
	public void setRegisteredTime(String registeredTime) {
		this.registeredTime = registeredTime;
	}
	public String getLastOnTime() {
		return lastOnTime;
	}
	public void setLastOnTime(String lastOnTime) {
		this.lastOnTime = lastOnTime;
	}
}
