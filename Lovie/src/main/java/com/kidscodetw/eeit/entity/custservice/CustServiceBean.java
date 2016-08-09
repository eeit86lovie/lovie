package com.kidscodetw.eeit.entity.custservice;
import java.io.Serializable;

import com.kidscodetw.eeit.entity.movie.TheaterBean;
public class CustServiceBean implements Serializable{
	
	private Integer memberId;
	private Integer catagory;
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
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getCatagory() {
		return catagory;
	}
	public void setCatagory(Integer catagory) {
		this.catagory = catagory;
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
		return "model CustServiceBean[ id:"+id+" ,memberId:"+memberId+" ,catagory:"+catagory+" ,message:"+message+" ,status:"+status;
	}
	public TheaterBean update(CustServiceBean custServiceBean) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
