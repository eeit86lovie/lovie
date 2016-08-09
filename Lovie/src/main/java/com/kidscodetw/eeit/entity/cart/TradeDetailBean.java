package com.kidscodetw.eeit.entity.cart;

public class TradeDetailBean  {

private Integer id;
private Integer billid;
private Integer productid;
private int amount;
private int totalcost;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public Integer getProductid() {
	return productid;
}
public void setProductid(Integer productid) {
	this.productid = productid;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getTotalcost() {
	return totalcost;
}
public void setTotalcost(int totalcost) {
	this.totalcost = totalcost;
}
@Override
public String toString() {
	return "TradeDetailBean [id=" + id + ", memberid=" + billid
			+ ", productid=" + productid + ", amount=" + amount
			+ ", totalcost=" + totalcost + "]";
}
public Integer getBillid() {
	return billid;
}
public void setBillid(Integer billid) {
	this.billid = billid;
}





}
