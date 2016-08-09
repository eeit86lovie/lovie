package com.kidscodetw.eeit.service.custservice;

import java.util.List;

import com.kidscodetw.eeit.dao.custservice.CustServiceCatagoryDAO;
import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.entity.custservice.CustServiceCatagoryBean;

public class CustServiceCatagoryService implements CustServiceCatagoryDAO{

	private CustServiceCatagoryDAO custservicecatagoryDao;
	public CustServiceCatagoryService(CustServiceCatagoryDAO CustServiceCatagoryDAOHibernate){
		this.custservicecatagoryDao = CustServiceCatagoryDAOHibernate;
	}
	
	public List<CustServiceCatagoryBean> select() {
		List<CustServiceCatagoryBean> result = null;
		result = custservicecatagoryDao.select();
		return result;
	}

	@Override
	public CustServiceCatagoryBean select(Integer id) {
		CustServiceCatagoryBean result = null;
		if(id!=null && id!=0){
			result = custservicecatagoryDao.select(id);
		}
		return result;
	}

	@Override
	public CustServiceCatagoryBean select(String category) {
		CustServiceCatagoryBean result = null;
		if(category!=null && category.length()!=0){
			result = custservicecatagoryDao.select(category);
		}
		return result;
	}

	@Override
	public CustServiceCatagoryBean insert(CustServiceCatagoryBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustServiceCatagoryBean delet(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
