package com.kidscodetw.eeit.entity.cart;

public class TradeDetailBean  {

private Integer id;
private Integer billid;
private Integer productid;
private int amount;//嚙踐嚙踝蕭嚙�?
private int totalcost;//?嚙踝蕭鞈∴蕭?嚙踝蕭嚙踝蕭
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getBillid() {
	return billid;
}
public void setBillid(Integer billid) {
	this.billid = billid;
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
	return "TradeDetailBean [id=" + id + ", billid=" + billid + ", productid="
			+ productid + ", amount=" + amount + ", totalcost=" + totalcost
			+ "]";
}






}
