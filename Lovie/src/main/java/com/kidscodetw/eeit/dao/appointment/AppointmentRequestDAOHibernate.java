package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentRequestBean;

public class AppointmentRequestDAOHibernate implements AppointmentRequestDAO {
	private static final String UPDATESTATUS_BY_ID = "update AppointmentRequestBean set status=:status where appointmentID=:appointmentID";

	private SessionFactory sessionFactory;

	public AppointmentRequestDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Integer updatestatus(Integer appointmentID, Integer status) {
		   Query query = getSession().createQuery(UPDATESTATUS_BY_ID);
		   query.setParameter("appointmentID", appointmentID);
		   query.setParameter("status", status);
		   int updateCount = query.executeUpdate();
		   return updateCount;
	}
}
