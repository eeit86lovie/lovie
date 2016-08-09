package com.kidscodetw.eeit.dao.custservice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.custservice.CustServiceCatagoryBean;

public class CustServiceCatagoryDAOHibernate implements CustServiceCatagoryDAO{
	
	private static final String SELECT_ALL = "from CustServiceCatagoryBean";
	private static final String SELECT_BY_CATEGORY = "from CustServiceCatagoryBean where category=:category";
	
	private SessionFactory sessionFactory;
	public CustServiceCatagoryDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<CustServiceCatagoryBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL	);
		return query.list();
	}

	@Override
	public CustServiceCatagoryBean select(Integer id) {
	
		return (CustServiceCatagoryBean)this.getSession().get(CustServiceCatagoryBean.class, id);
	}

	@Override
	public CustServiceCatagoryBean select(String category) {
		Query query = this.getSession().createQuery(SELECT_BY_CATEGORY);
		query.setParameter("category", category);
		List<CustServiceCatagoryBean> list = query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
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
