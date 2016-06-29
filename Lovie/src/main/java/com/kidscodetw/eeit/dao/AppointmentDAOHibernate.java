package com.kidscodetw.eeit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.AppointmentBean;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.util.HibernateUtil;

public class AppointmentDAOHibernate implements AppointmentDAO {

	private static final String SELECT_ALL = "from AppointmentBean";
	private static final String SELECT_BY_MEMBER = "from AppointmentBean where memberId=:memberId";
	private static final String SELECT_BY_SHOWTIME = "from AppointmentBean where showtimeId=:showtimeId";

	private SessionFactory sessionFactory;

	public AppointmentDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<AppointmentBean> select() {
		Query query = getSession().createQuery(SELECT_ALL);
		return query.list();
	}

	@Override
	public AppointmentBean select(Integer id) {
		return (AppointmentBean) getSession().get(AppointmentBean.class, id);
	}

	@Override
	public List<AppointmentBean> selectByMemberId(Integer memberId) {

		Query query = getSession().createQuery(SELECT_BY_MEMBER);
		query.setParameter("memberId", memberId);
		return query.list();
	}

	@Override
	public List<AppointmentBean> selectByShowtimeId(Integer showtimeId) {
		Query query = getSession().createQuery(SELECT_BY_SHOWTIME);
		query.setParameter("showtimeId", showtimeId);
		return query.list();
	}

	@Override
	public boolean delete(Integer id) {
		AppointmentBean bean = (AppointmentBean) this.getSession().get(AppointmentBean.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public AppointmentBean insert(AppointmentBean bean) {
		this.getSession().save(bean);
		return bean;
	}

	@Override
	public AppointmentBean update(AppointmentBean bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (AppointmentBean) this.getSession().get(AppointmentBean.class, bean.getId());
	}

}
