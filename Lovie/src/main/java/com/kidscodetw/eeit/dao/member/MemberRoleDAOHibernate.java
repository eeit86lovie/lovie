package com.kidscodetw.eeit.dao.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.member.MemberRoleBean;

public class MemberRoleDAOHibernate implements MemberRoleDAO{
	
	private static final String SELECT_ALL = "from MemberRoleBean";
	private static final String SELECT_BY_NAME = "from MemberRoleBean where role=:role";
	
	private SessionFactory sessionFactory;
	public MemberRoleDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	

	@Override
	public List<MemberRoleBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}


	@Override
	public MemberRoleBean select(Integer privilege) {
		return (MemberRoleBean)this.getSession().get(MemberRoleBean.class, privilege);
	}


	@Override
	public MemberRoleBean select(String role) {
		Query query = this.getSession().createQuery(SELECT_BY_NAME);
		query.setParameter("role", role);
		List<MemberRoleBean> list = query.list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	

}
