package com.kidscodetw.eeit.service.cart;

import java.util.List;

import com.kidscodetw.eeit.dao.cart.BillDAO;
import com.kidscodetw.eeit.entity.cart.BillBean;


public class BillService {

	//private BillDAO billDao = new BillDAOjdbc();
	//private BillDAOHibernate orderDao = new BillDAOHibernate();
	private BillDAO billDAO;
	public BillService(BillDAO billDAOHibernate){
	this.billDAO = billDAOHibernate;
	}
	

	public List<BillBean> select_ALL(){
		List<BillBean> result = null;
		result = billDAO.select_ALL();
		return result;
	}
	public List<BillBean> select_MEMBERID(int memberid){
		List<BillBean> result = null;
		if(memberid!=0){
			result = billDAO.select_memberid(memberid);
		}
		return result;
	}
	
	
	
	public BillBean select_id(int id){
		BillBean result = null;
		if(id!=0){
			result = billDAO.select_id(id);
		}
		return result;
	}

	public BillBean insert(BillBean bb){
		BillBean result = null;
		if(bb!=null){
			result = billDAO.insert(bb);
		}
		return result;
	}

	public int delete(int id){
		int result = 0;
		if(id!=0){
			result = billDAO.delete(id);
		}
		return result;
	}

	
	public BillBean update(BillBean bb){
		BillBean result = null;
		if(bb!=null && bb.getId()!=0){
			result = billDAO.update(bb);
		}
		return result;
	}

}
