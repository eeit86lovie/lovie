package com.kidscodetw.eeit.entity.custservice;
import java.io.Serializable;
public class CustServiceCatagoryBean {

	private Integer id;
	private String catagory;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String category) {
		this.catagory = category;
	}
	
	public String toString(){
		return "CustServiceCatagoryBean: id:"+id+" ,catagory:"+catagory;
	}
	
}
