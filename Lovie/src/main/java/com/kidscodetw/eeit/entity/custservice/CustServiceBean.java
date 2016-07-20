package com.kidscodetw.eeit.entity.custservice;
import java.io.Serializable;
public class CustServiceBean implements Serializable{
	
	private String memberAccount;
	private Integer category;
	private String message;
	private byte[] photo;
	private Integer status;
	private Integer id;
	
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
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}	
	
	public String toString(){
		return "model CustServiceBean[ id:"+id+" ,memberAccount:"+memberAccount+" ,category:"+category+" ,message:"+message+" ,status:"+status;
	}
}
