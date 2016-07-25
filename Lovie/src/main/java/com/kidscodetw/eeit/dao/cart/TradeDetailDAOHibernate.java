package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.cart.TradeDetailBean;

public class TradeDetailDAOHibernate implements TradeDetailDAO {

	private static final String SELECT_ALL = "SELECT * FROM TradeDetail";
	private static final String SELECT_ID = "SELECT * FROM TradeDetail WHERE id=?";
	private static final String INSERT = "INSERT INTO TradeDetail(productid,title,amount)VALUES(?,?,?)";
	private static final String UPDATE = "UPDATE TradeDetail SET productid=COALESCE(?,productid),title =COALESCE(?, title),amount =COALESCE(?, amount)WHERE id=?";
	private static final String DELETE = "DELETE FROM TradeDetail WHERE id=?";
	private SessionFactory sessionFactory;

	public TradeDetailDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<TradeDetailBean> select_ALL() {
		List<TradeDetailBean> ltdb = null;
		Query query = getSession().createQuery(SELECT_ALL);
		ltdb = query.list();
		return ltdb;
	}

	@Override
	public TradeDetailBean select_id(int id) {
		TradeDetailBean tdb = null;
		tdb = (TradeDetailBean) getSession().get(TradeDetailBean.class, id);
		return tdb;
	}

	@Override
	public TradeDetailBean insert(TradeDetailBean bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	public TradeDetailBean update(TradeDetailBean bean) {
		getSession().update(bean);	
		return bean;
	}

	@Override
	public int delete(int id) {
		int count = 0;
		Query query = getSession().createQuery(DELETE);
		query.setParameter(0, id);
		count = query.executeUpdate();
		return count;
	}
}
