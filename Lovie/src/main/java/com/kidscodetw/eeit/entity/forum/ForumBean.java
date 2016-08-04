package com.kidscodetw.eeit.entity.forum;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

public class ForumBean {
	
	private Integer id;
	private String memberAccount;
	private String title;
	private byte[] photo;
	private String content;
	private String genre;
	private java.util.Date pubTime;  
    private java.util.Date editTime;
	
    
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public java.util.Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(java.util.Date pubTime) {
		this.pubTime = pubTime;
	}
	public java.util.Date getEditTime() {
		return editTime;
	}
	public void setEditTime(java.util.Date editTime) {
		this.editTime = editTime;
	}
	
	@Override
	public String toString() {
		return "ForumBean [id=" + id + ", memberAccount=" + memberAccount
				+ ", title=" + title + ", photo=" + Arrays.toString(photo)
				+ ", content=" + content + ", genre=" + genre + ", pubTime="
				+ pubTime + ", editTime=" + editTime + "]";
	}
   
	
	
   
	
}