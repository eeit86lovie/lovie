package com.kidscodetw.eeit.service.cart;

import java.util.List;

import com.kidscodetw.eeit.dao.cart.TradeDetailDAO;
import com.kidscodetw.eeit.entity.cart.TradeDetailBean;





public class TradeDetailService implements TradeDetailDAO{

	//private TradeDetailDAO  tradeDetailDAO = new TradeDetailDAOjdbc();
	//private TradeDetailDAOHibernate tradeDetailDAO = new TradeDetailDAOHibernate();
	private TradeDetailDAO tradeDetailDAO;
	public TradeDetailService(TradeDetailDAO tradeDetailHibernate){
		this.tradeDetailDAO = tradeDetailHibernate;
	}
	
	

	public List<TradeDetailBean> select_ALL(){
		List<TradeDetailBean> result = null;
		result = tradeDetailDAO.select_ALL();
		return result;
	}
	public TradeDetailBean select_id(Integer id){
		TradeDetailBean result = null;
		if(id!=0){
			result = tradeDetailDAO.select_id(id);
		}
		return result;
	}

	@Override
	public List<TradeDetailBean> select_billid(Integer billid) {
		List<TradeDetailBean> result = null;
		if(billid!=0 && billid!=null){
		result = tradeDetailDAO.select_billid(billid);
	}
		return result;
	}
	
	
	public TradeDetailBean insert(TradeDetailBean td){
		TradeDetailBean result = null;
		if(td!=null){
			result = tradeDetailDAO.insert(td);
		}
		return result;
	}

	public int delete(Integer id){
		int result = 0;
		if(id!=0){
			result = tradeDetailDAO.delete(id);
		}
		return result;
	}

	
	public TradeDetailBean update(TradeDetailBean td){
		TradeDetailBean result = null;
		if(td!=null && td.getId()!=0){
			result = tradeDetailDAO.update(td);
		}
		return result;
	}



}
