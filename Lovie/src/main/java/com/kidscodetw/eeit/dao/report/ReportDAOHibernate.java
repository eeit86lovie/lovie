package com.kidscodetw.eeit.dao.report;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.kidscodetw.eeit.entity.report.ReportBean;

public class ReportDAOHibernate implements ReportDAO {
	
	private SessionFactory sessionFactory;

	public ReportDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ReportBean> report1select(Integer p_privilege, Byte p_gender,Timestamp p_lastOnTime) {
		Criteria query = getSession().createCriteria(ReportBean.class);
		query.addOrder( Order.asc("privilege") );
		query.addOrder( Order.asc("gender") );
		query.addOrder( Order.asc("id") );
		if (p_privilege == 1 || p_privilege == 2 || p_privilege==3)
			query.add(Restrictions.eq("privilege", p_privilege));
		if (p_gender == 0 || p_gender == 1 )
			query.add(Restrictions.eq("gender", p_gender));
		if (p_lastOnTime != null)
			query.add(Restrictions.lt("lastOnTime", new java.sql.Timestamp(p_lastOnTime.getTime())));
		List<ReportBean> list = query.list();
//		for (ReportBean aEmp : list) {
//			System.out.print("dao=>"+aEmp.getId() + ",");
//			System.out.print(aEmp.getAccount()+ ",");
//			System.out.println();
//		}
	
		return list;
	}
	
}
