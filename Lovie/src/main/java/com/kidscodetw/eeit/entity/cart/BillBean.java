package com.kidscodetw.eeit.entity.cart;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;



public class BillBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer memberid;
    private String address;
    private Integer phone;
	private java.util.Date tradeTime;
	private Integer creditnum;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public java.util.Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(java.util.Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public Integer getCreditnum() {
		return creditnum;
	}
	public void setCreditnum(Integer creditnum) {
		this.creditnum = creditnum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BillBean [id=" + id + ", memberid=" + memberid + ", address="
				+ address + ", phone=" + phone + ", tradeTime=" + tradeTime
				+ ", creditnum=" + creditnum + ", status=" + status + "]";
	}
	
	
	
}
