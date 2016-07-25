package com.kidscodetw.eeit.dao.custservice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.custservice.CustServiceBean;



public class CustServiceDAOHibernate implements CustServiceDAO {
	
	private static final String SELECT_ALL = "from CustServiceBean";
	private static final String SELECT_BY_MEMBERACCOUNT = "from CustServiceBean where memberAccount=:memberAccount";
	private SessionFactory sessionFactory;
	
	public CustServiceDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public List<CustServiceBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}

	
	@Override
	public CustServiceBean select(Integer id) {
		return (CustServiceBean)this.getSession().get(CustServiceBean.class, id);
	}

	
	@Override
	public List<CustServiceBean> select(String memberAccount) {
		Query query = this.getSession().createQuery(SELECT_BY_MEMBERACCOUNT);
		query.setParameter("memberAccount", memberAccount);
		return query.list();
	}
	
	@Override
	public boolean delete(Integer id) {
		CustServiceBean bean = (CustServiceBean)this.getSession().get(CustServiceBean.class, id);
		if(bean!=null){
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}


	@Override
	public CustServiceBean insert(CustServiceBean bean) {
		this.getSession().save(bean);
		return bean;
	}


	@Override
	public CustServiceBean update(CustServiceBean bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (CustServiceBean) this.getSession().get(CustServiceBean.class, bean.getId());
	}
	

}
