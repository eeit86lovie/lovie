package com.kidscodetw.eeit.dao.cart;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.cart.BillBean;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.movie.MovieBean;

public class BillDAOHibernate implements BillDAO {

	private static final String SELECT_ALL = "FROM BillBean";
	private static final String SELECT_ID = "FROM BillBean WHERE id=?";
	private static final String SELECT_MEMBERID = "FROM BillBean WHERE memberid=:memberid";
	private static final String INSERT = "INSERT INTO BillBean(memberid, tradeTime, ,address, phone, status, creditnum) VALUES(?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE BillBean SET account =COALESCE(?, account),creditnum =COALESCE(?, creditnum)WHERE id=?";
	private static final String DELETE = "DELETE FROM BillBean WHERE id=?";
	private SessionFactory sessionFactory;

	public BillDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<BillBean> select_ALL() {
		Query query = getSession().createQuery(SELECT_ALL);
		return query.list();
	}

	@Override
	public BillBean select_id(Integer id) {
		BillBean bb = null;
		bb = (BillBean) getSession().get(BillBean.class, id);
		return bb;
	}

	@Override
	public List<BillBean> select_memberid(Integer memberid) {
		Query query  =getSession().createQuery(SELECT_MEMBERID);
		query.setParameter("memberid", memberid);
		return query.list();
	}
	


	@Override
	public BillBean insert(BillBean bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	public BillBean update(BillBean bean) {
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