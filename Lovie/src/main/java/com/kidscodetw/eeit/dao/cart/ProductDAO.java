package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import com.kidscodetw.eeit.entity.cart.ProductBean;

public interface ProductDAO {

	public abstract List<ProductBean> select_ALL();

	public abstract ProductBean select_id(int productid);

	public abstract ProductBean select_name(String name);

	public abstract List<ProductBean> select_category(int category);

	public abstract ProductBean insert(ProductBean pb);

	public abstract ProductBean update(ProductBean pb);

	public abstract int delet(int productid);

}