package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.kidscodetw.eeit.entity.cart.TradeDetailBean;
public class TradeDetailDAOHibernate implements TradeDetailDAO {

	private static final String SELECT_ALL = "FROM TradeDetailBean";
	private static final String SELECT_ID = "FROM TradeDetailBean WHERE id=?";
	private static final String SELECT_BILLID = "FROM TradeDetailBean WHERE billid=:billid";
	private static final String INSERT = "INSERT INTO TradeDetailBean(memberid,billid,productid,totalcost,amount)VALUES(?,?,?,?,?)";
	private static final String UPDATE = "UPDATE TradeDetailBean SET memberid=COALESCE(?,memberid),productid=COALESCE(?,productid),totalcost =COALESCE(?, totalcost),amount =COALESCE(?, amount)WHERE id=?";
	private static final String DELETE = "DELETE FROM TradeDetailBean WHERE id=?";
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
	public TradeDetailBean select_id(Integer id) {
		TradeDetailBean tdb = null;
		tdb = (TradeDetailBean) getSession().get(TradeDetailBean.class, id);
		return tdb;
	}
	@Override
	public List<TradeDetailBean> select_billid(Integer billid){
		Query query  =getSession().createQuery(SELECT_BILLID);
		query.setParameter("billid", billid);
		return query.list();
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
	public int delete(Integer id) {
		int count = 0;
		Query query = getSession().createQuery(DELETE);
		query.setParameter(0, id);
		count = query.executeUpdate();
		return count;
	}


}
