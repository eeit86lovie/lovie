package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import com.kidscodetw.eeit.entity.cart.TradeDetailBean;

public interface TradeDetailDAO {

	public abstract List<TradeDetailBean> select_ALL();

	public abstract TradeDetailBean insert(TradeDetailBean td);

	public abstract TradeDetailBean update(TradeDetailBean td);

	public abstract int delete(Integer id);

	public abstract TradeDetailBean select_id(Integer id);

	public abstract List<TradeDetailBean> select_billid(Integer billid);

}