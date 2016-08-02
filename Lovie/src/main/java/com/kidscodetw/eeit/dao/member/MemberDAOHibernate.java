package com.kidscodetw.eeit.dao.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.member.MemberBean;

public class MemberDAOHibernate implements MemberDAO {

	private SessionFactory sessionFactory;

	public MemberDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public List<MemberBean> select() {
		Query query = getSession().createQuery("from MemberBean");
		return query.list();
	}

	@Override
	public MemberBean select(String account) {
		Query query = getSession().createQuery(
				"from MemberBean where account=:account");
		query.setParameter("account", account);
		return (MemberBean) query.list().get(0);
	}

	@Override
	public MemberBean select(Integer id) {
		return (MemberBean) getSession().get(MemberBean.class, id);
	}

	@Override
	public MemberBean insert(MemberBean bean) {
		this.getSession().save(bean);
		return bean;
	}

	@Override
	public boolean delete(Integer id) {
		MemberBean bean = (MemberBean) this.getSession().get(MemberBean.class,
				id);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String account) {
		Query query = getSession().createQuery(
				"from MemberBean where account=:account");
		query.setParameter("account", account);
		MemberBean bean = (MemberBean) query.list().get(0);
		if(bean==null){
			return false;
		}
		return delete(bean.getId());
	}

	@Override
	public MemberBean update(MemberBean bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (MemberBean) this.getSession().get(MemberBean.class,
				bean.getId());
	}

	@Override
	public void updatePhotos(String link, Integer id) {

	}

	@Override
	public MemberBean updatePhotos(byte[] file, MemberBean bean) {
		if (bean != null && bean.getId()!= 0) {
			bean.setPhoto(file);
			this.getSession().saveOrUpdate(bean);
		}
		MemberBean a= (MemberBean) this.getSession().get(MemberBean.class,
				bean.getId());
		return a;
		
	}

}
