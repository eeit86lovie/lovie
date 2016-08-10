package com.kidscodetw.eeit.service.custservice;

import java.util.List;

import com.kidscodetw.eeit.dao.custservice.CustServiceDAO;
import com.kidscodetw.eeit.entity.custservice.CustServiceBean;



public class CustServiceService {
	private CustServiceDAO custServiceDAO;
	public CustServiceService(CustServiceDAO custServiceDAOHibernate){
		this.custServiceDAO = custServiceDAOHibernate;
	}
	
	public List<CustServiceBean> select(){
		List<CustServiceBean> result = null;
		result = custServiceDAO.select();
		return result;
	}

	public CustServiceBean select(Integer id){
		CustServiceBean result = null;
		if(id!=0){
			result = custServiceDAO.select(id);
		}
		return result;
	}

	
	public List<CustServiceBean> select(String memberAccount){
		List<CustServiceBean> result = null;
		if(memberAccount!=null && memberAccount.length()!=0){
			result = custServiceDAO.select(memberAccount);
		}
		return result;
	}

	public boolean delete(Integer id){
		boolean result = false;
		if(id!=0){
			result = custServiceDAO.delete(id);
		}
		return result;
	}
	
	public CustServiceBean insert(CustServiceBean csb){
		CustServiceBean result = null;
		if(csb!=null){
			result = custServiceDAO.insert(csb);
		}
		return result;
	}
	
	public CustServiceBean update(CustServiceBean csb){
		CustServiceBean result = null;
		if(csb!=null && csb.getId()!=0){
			result = custServiceDAO.update(csb);
		}
		return result;
	}
}
