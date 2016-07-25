package com.kidscodetw.eeit.entity.movie;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TheaterBean {
	private int id;
	private String name;
	private String city;
	private String district;
	private String address;
	private String phone;
	private String websiteUrl;
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getWebsiteUrl() {
		return websiteUrl;
	}


	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}


	@Override
	public String toString(){
		return "model.TheaterBean ["+
				id+ ","+ name + ","+ city+ ","+ district+ ","+ address+ ","+ 
				phone+","+websiteUrl+","+"]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && (obj instanceof TheaterBean)) {
			TheaterBean temp = (TheaterBean) obj;
			if(this.id == temp.id) {
				return true;
			}
		}
		return false;
	}


	
	
	
}
