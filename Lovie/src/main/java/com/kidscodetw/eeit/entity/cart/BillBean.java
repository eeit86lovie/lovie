package com.kidscodetw.eeit.entity.cart;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;



public class BillBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer memberid;
	private String account;
	private String membername;
	private Integer productid;
	private String productname;
	private Integer amount;
    private String address;
    private Integer title;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTitle() {
		return title;
	}
	public void setTitle(Integer title) {
		this.title = title;
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
		return "BillBean [id=" + id + ", memberid=" + memberid + ", account="
				+ account + ", membername=" + membername + ", productid="
				+ productid + ", productname=" + productname + ", amount="
				+ amount + ", address=" + address + ", title=" + title
				+ ", tradeTime=" + tradeTime + ", creditnum=" + creditnum
				+ ", status=" + status + "]";
	}

	
	
	
}
