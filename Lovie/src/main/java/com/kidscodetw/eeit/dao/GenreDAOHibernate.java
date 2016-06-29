package com.kidscodetw.eeit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.GenreBean;
import com.kidscodetw.eeit.util.HibernateUtil;

public class GenreDAOHibernate implements GenreDAO{
	
	private static final String SELECT_ALL = "from GenreBean";
	private static final String SELECT_BY_NAME = "from GenreBean where name=:name";
	
	private SessionFactory sessionFactory;
	public GenreDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<GenreBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}

	@Override
	public GenreBean select(Integer id) {
		return (GenreBean)this.getSession().get(GenreBean.class, id);
	}

	@Override
	public GenreBean select(String name) {
		Query query = this.getSession().createQuery(SELECT_BY_NAME);
		query.setParameter("name", name);
		List<GenreBean> list = query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	

}
