package com.kidscodetw.eeit.entity.report;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class ReportBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String account;
	private Byte gender;
	private String email;
	private String nickname;
	private Integer privilege;
	private Date  birthday;
	private Timestamp registeredTime;
	private Timestamp lastOnTime;
	
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
	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Timestamp getRegisteredTime() {
		return registeredTime;
	}
	public void setRegisteredTime(Timestamp registeredTime) {
		this.registeredTime = registeredTime;
	}
	public Timestamp getLastOnTime() {
		return lastOnTime;
	}
	public void setLastOnTime(Timestamp lastOnTime) {
		this.lastOnTime = lastOnTime;
	}
}
