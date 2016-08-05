package com.kidscodetw.eeit.entity.cart;

import java.io.Serializable;
import java.sql.Blob;

public class ProductBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private Integer productid;
	private Integer cost;
	private double discount;
	private Integer inventory;
	private Blob productphoto;
	private Integer category;
	private String content;
	
	private transient int amount =0;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Blob getProductphoto() {
		return productphoto;
	}
	public void setProductphoto(Blob productphoto) {
		this.productphoto = productphoto;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProductBean [name=" + name + ", productid=" + productid
				+ ", cost=" + cost + ", discount=" + discount + ", inventory="
				+ inventory + ", productphoto=" + productphoto + ", category="
				+ category + ", content=" + content + "]";
	}


	
}
