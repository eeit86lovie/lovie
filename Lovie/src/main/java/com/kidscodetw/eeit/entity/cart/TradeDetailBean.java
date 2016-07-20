package com.kidscodetw.eeit.entity.cart;

public class TradeDetailBean  {

private Integer id;
private Integer productid;
private Integer amount;//����?
private Integer title;//?��賡�?����
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
public Integer getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public Integer getTitle() {
	return title;
}
public void setTitle(int title) {
	this.title = title;
}
@Override
public String toString() {
	return "TradeDetailBean [id=" + id + ", productid=" + productid
			+ ", amount=" + amount + ", title=" + title + "]";
}






}
