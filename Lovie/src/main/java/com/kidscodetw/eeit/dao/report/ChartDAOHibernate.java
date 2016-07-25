package com.kidscodetw.eeit.dao.report;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.report.Chart1Bean;
import com.kidscodetw.eeit.entity.report.Chart2Bean;
import com.kidscodetw.eeit.entity.report.Chart3Bean;

public class ChartDAOHibernate implements ChartDAO {
	private static final String SELECT_CHART1 = "from Chart1Bean";
	private static final String SELECT_CHART2 = "from Chart2Bean";
	private static final String SELECT_CHART3 = "from Chart3Bean";
	
	private SessionFactory sessionFactory;

	public ChartDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Chart1Bean> chart1select() {
		 Query query = getSession().createQuery(SELECT_CHART1);
		 List<Chart1Bean> list = query.list();
		return list;
	}

	@Override
	public List<Chart2Bean> chart2select() {
		 Query query = getSession().createQuery(SELECT_CHART2);
		 List<Chart2Bean> list = query.list();
		return list;
	}

	@Override
	public List<Chart3Bean> chart3select() {
		 Query query = getSession().createQuery(SELECT_CHART3);
		 List<Chart3Bean> list = query.list();
		return list;
	}
	
}
