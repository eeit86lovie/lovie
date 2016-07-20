package com.kidscodetw.eeit.entity.forum;

import java.util.Arrays;

public class ArticleReplyBean {

	private int id;
	private int articleID;
	private String memberAccount;
	private String content;
	private byte[] photo;
	private java.util.Date pubTime;  
    private java.util.Date editTime;
	
	@Override
	public String toString() {
		return "ArticlereplyBean [id=" + id + ", articleID=" + articleID
				+ ", memberAccount=" + memberAccount + ", content=" + content
				+ ", photo=" + Arrays.toString(photo) + ", pubTime=" + pubTime
				+ ", editTime=" + editTime + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
	
	
}
