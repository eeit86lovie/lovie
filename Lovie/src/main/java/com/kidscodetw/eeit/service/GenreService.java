package com.kidscodetw.eeit.service;

import java.util.List;

import com.kidscodetw.eeit.dao.GenreDAO;
import com.kidscodetw.eeit.entity.GenreBean;

public class GenreService implements GenreDAO{
	
	private GenreDAO genreDao;
	public GenreService(GenreDAO genreDAOHibernate){
		this.genreDao = genreDAOHibernate;
	}
	
	public List<GenreBean> select(){
		List<GenreBean> result = null;
		result = genreDao.select();
		return result;
	}

	public GenreBean select(Integer id){
		GenreBean result = null;
		if(id!=null && id!=0){
			result = genreDao.select(id);
		}
		return result;
	}

	public GenreBean select(String name){
		GenreBean result = null;
		if(name!=null && name.length()!=0){
			result = genreDao.select(name);
		}
		return result;
	}

}
