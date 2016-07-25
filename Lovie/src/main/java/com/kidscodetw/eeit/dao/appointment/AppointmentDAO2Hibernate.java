package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;

public class AppointmentDAO2Hibernate implements AppointmentDAO2 {

	private static final String SELECT_ALL = "from AppointmentBean2";
	private static final String SELECT_BY_MEMBER = "from AppointmentBean2 where memberId=:memberId";
	private static final String SELECT_BY_SHOWTIME = "from AppointmentBean2 where showtimeId=:showtimeId";

	private SessionFactory sessionFactory;

	public AppointmentDAO2Hibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<AppointmentBean2> select() {
		List<AppointmentBean2> result = null;
		try {
			result = getSession().createQuery(SELECT_ALL).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public AppointmentBean2 select(Integer id) {
		return (AppointmentBean2) getSession().get(AppointmentBean2.class, id);
	}

	@Override
	public List<AppointmentBean2> selectByMemberId(Integer memberId) {
		Query query = getSession().createQuery(SELECT_BY_MEMBER);
		query.setParameter("memberId", memberId);
		return query.list();
	}

	@Override
	public List<AppointmentBean2> selectByShowtimeId(Integer showtimeId) {
		Query query = getSession().createQuery(SELECT_BY_SHOWTIME);
		query.setParameter("showtimeId", showtimeId);
		return query.list();
	}

	@Override
	public boolean delete(Integer id) {
		AppointmentBean2 bean = (AppointmentBean2) this.getSession().get(AppointmentBean2.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public AppointmentBean2 insert(AppointmentBean2 bean) {
		this.getSession().save(bean);
		return bean;
	}

	@Override
	public AppointmentBean2 update(AppointmentBean2 bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (AppointmentBean2) this.getSession().get(AppointmentBean2.class, bean.getId());
	}

}
