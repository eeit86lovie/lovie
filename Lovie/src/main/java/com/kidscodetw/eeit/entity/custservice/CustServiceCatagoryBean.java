package com.kidscodetw.eeit.entity.custservice;
import java.io.Serializable;
public class CustServiceCatagoryBean {

	private Integer id;
	private String category;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString(){
		return "CustServiceCatagoryBean: id:"+id+" ,category:"+category;
	}
	
}
