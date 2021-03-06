package com.kidscodetw.eeit.entity.cart;

public class TradeCheckoutBean{
	
	
	private Integer id;
	private Integer memberid;
	private String memberaccount;
	private String memberaddress;
	private String memberphone;
	private String productname;
	private java.util.Date checktradeTime;
	private Integer amount;
	private Integer totalcost;
	
	public Integer getId(){
		return id;
		
	}
	public void setId(Integer id) {
		this.id =id;
	}
	
	
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getMemberaccount() {
		return memberaccount;
	}
	public void setMemberaccount(String memberaccount) {
		this.memberaccount = memberaccount;
	}
	public String getMemberaddress() {
		return memberaddress;
	}
	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public java.util.Date getChecktradeTime() {
		return checktradeTime;
	}
	public void setChecktradeTime(java.util.Date checktradeTime) {
		this.checktradeTime = checktradeTime;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}
	
	@Override
	public String toString() {
		return "TradeCheckout [id="+id+",memberid=" + memberid + ", memberaccount="
				+ memberaccount + ", memberaddress=" + memberaddress
				+ ", memberphone=" + memberphone + ", productname="
				+ productname + ", checktradeTime=" + checktradeTime
				+ ", amount=" + amount + ", totalcost=" + totalcost + "]";
	}

	
	
	
}