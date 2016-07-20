package com.kidscodetw.eeit.dao.movie;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.TheaterBean;
import com.kidscodetw.eeit.util.HibernateUtil;

public class TheaterDAOHibernate implements TheaterDAO{
	
	private static final String SELECT_ALL = "from TheaterBean";
	private static final String SELECT_NAMES = "SELECT name from TheaterBean";
	private static final String SELECT_BY_NAME = "from TheaterBean where name=:name";
	
	private SessionFactory sessionFactory;
	public TheaterDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<String> select_theaternames() {
		Query query = this.getSession().createQuery(SELECT_NAMES);
		return query.list();
	}

	@Override
	public TheaterBean select(Integer id) {
		return (TheaterBean)this.getSession().get(TheaterBean.class, id);
	}
	
	@Override
	public TheaterBean select(String name){
		Query query = this.getSession().createQuery(SELECT_BY_NAME);
		query.setParameter("name", name);
		List<TheaterBean> list = query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<TheaterBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}

	@Override
	public boolean delete(Integer id) {
		TheaterBean bean = (TheaterBean)this.getSession().get(TheaterBean.class, id);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public TheaterBean insert(TheaterBean bean) {
		TheaterBean result = (TheaterBean) this.getSession().get(TheaterBean.class,
				bean.getId());
		if (result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public TheaterBean update(TheaterBean bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (TheaterBean) this.getSession().get(TheaterBean.class, bean.getId());
	}
}
