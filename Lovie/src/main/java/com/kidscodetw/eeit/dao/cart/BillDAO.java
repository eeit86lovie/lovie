package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import com.kidscodetw.eeit.entity.cart.BillBean;

public interface BillDAO {

	public abstract List<BillBean> select_ALL();

	public abstract BillBean select_id(Integer id);

	public abstract List<BillBean> select_memberid(Integer memberid);

	public abstract BillBean insert(BillBean bb);

	public abstract BillBean update(BillBean bb);

	public abstract int delete(Integer id);

}