package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.forum.ForumBean;



public class ForumDAOHibernate implements ForumDAO {

	private static final String SELECT_ALL = "FROM ForumBean ORDER BY id DESC";
	private static final String SELECT_BY_ID = "FROM ForumBean WHERE id = ?";
	private static final String SELECT_BY_NAME = "FROM ForumBean WHERE memberAccount = ?";
	private static final String INSERT = "INSERT INTO Article(memberAccount,title,photo,content,genre) VALUES (?,?,?,?,?)";
	private static final String UPDATE = "UPDATE ForumBean SET title =COALESCE(?, title),photo =COALESCE(?, photo), content = COALESCE(?, content) ,genre = COALESCE(?, genre) , editTime =? WHERE id=?";
	private static final String DELETE = "DELETE FROM ForumBean WHERE id=?";
	private SessionFactory sessionFactory;
	
	
	public ForumDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	
	
	@Override
	public List<ForumBean> select_ALL() {
		List<ForumBean> lfb = null;
		Query query = getSession().createQuery(SELECT_ALL);			 		
	    lfb = query.setMaxResults(10).list();
	    //lfb = query.setFirstResult(10).list();
	    //lfb = query.list();
	
		return lfb;
	}

	
	@Override
	public List<ForumBean> select_NEXT(int next_count) {
		
			List<ForumBean> lfb = null;
				 Query query = getSession().createQuery(SELECT_ALL);			 		
				 //lfb = query.setMaxResults(10).list();
				 //lfb = query.setFirstResult(next_count).list();
				  query.setFirstResult(next_count);
			      query.setMaxResults(next_count + 10 );
			      lfb = query.list();
				 //lfb = query.list();
				 return lfb;	
	}
	

	
	@Override
	public ForumBean select_id(Integer id) {
		ForumBean fb = null;
		fb = (ForumBean) getSession().get(ForumBean.class, id);
		
		return fb;
	}

	
	
	
	@Override
	public ForumBean select_memberAccount(String memberAccount) {
		ForumBean fb = null;
		Query query = getSession().createQuery(SELECT_BY_NAME);
		query.setParameter(0, memberAccount);
		List<ForumBean> fbs = query.list();
		for(ForumBean forumbean :fbs){
			fb = forumbean;
			}
			
		
		return fb;
	}

	
	@Override
	public ForumBean insert(ForumBean bean) {
		getSession().save(bean);
		return bean;
	}

	
	@Override
	public ForumBean update(ForumBean bean) {
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
