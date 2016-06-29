package com.kidscodetw.eeit.service;

import java.util.List;

import javax.ws.rs.Path;

import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.TheaterBean;

@Path("/theater")
public class TheaterService implements TheaterDAO{

	private TheaterDAO theaterDao;
	
	public TheaterService(TheaterDAO theaterDAOHibernate){
		this.theaterDao = theaterDAOHibernate;
	}

	public List<String> select_theaternames(){
		List<String> result = null;
		result = theaterDao.select_theaternames();
		return result;
	}

	public TheaterBean select(Integer id){
		TheaterBean result = null;
		if(id!=0){
			result = theaterDao.select(id);
		}
		return result;
	}

	public List<TheaterBean> select(){
		List<TheaterBean> result = null;
		result = theaterDao.select();
		return result;
	}

	public boolean delete(Integer id){
		boolean result = false;
		if(id!=0){
			result = theaterDao.delete(id);
		}
		return result;
	}

	public TheaterBean insert(TheaterBean bean){
		TheaterBean result = null;
		if(bean !=null){
			result = theaterDao.insert(bean);
		}
		return result;
	}

	public TheaterBean update(TheaterBean bean){
		TheaterBean result = null;
		if(bean!=null){
			result = theaterDao.update(bean);
		}
		return result;
	}
	
	public TheaterBean select(String name){
		TheaterBean result = null;
		if(name!=null && name.length()!=0){
			result = theaterDao.select(name);
		}
		return result;
	}

	

}
