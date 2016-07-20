package com.kidscodetw.eeit.entity.member;

import java.io.Serializable;


public class MemberBean implements Serializable{
	
	private Integer id;
	private String account;
	private String password;
	private Integer gender;
	private String email;
	private String nickname;
	private String city;
	private String district;
	private String phone;
	private Integer privilege;
	private String photoUrl;
	private byte[] photo;
	private String birthday;
	private Integer friendNum;
	private Integer commentPoint;
	private String intro;
	private String constellation;
	private String registeredTime;
	private String lastOnTime;
	
	public MemberBean(){
		
	}
	
	public String toString(){
		return "model.MemberBean[id:"+id+", "+"account:"+account+ ", "+"password:"+password+ ", "+"gender:"+gender+ ", "+"email:"+email+ ", "+"nickname:"+nickname+ ", "+"city:"+city+ ", "+"district:"+district+ ", "+"phone:"+phone+ ", "+"privilege:"+privilege+ ", "+"photoUrl:"+photoUrl+ ", "+"birthday:"+birthday+ ", "+"friendNum:"+friendNum+ ", "+"commentPoint:"+commentPoint+ ", "+"intro:"+intro+ ", "+"constellation:"+constellation+ ", "+"registeredTime:"+registeredTime+ ", "+"lastOnTime:"+lastOnTime;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Integer privilege) {
		this.privilege = privilege;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getFriendNum() {
		return friendNum;
	}
	public void setFriendNum(Integer friendNum) {
		this.friendNum = friendNum;
	}
	public Integer getCommentPoint() {
		return commentPoint;
	}
	public void setCommentPoint(Integer commentPoint) {
		this.commentPoint = commentPoint;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	

}
