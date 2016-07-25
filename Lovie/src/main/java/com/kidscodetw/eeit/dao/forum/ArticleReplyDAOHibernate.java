package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kidscodetw.eeit.entity.forum.ArticleReplyBean;




public class ArticleReplyDAOHibernate implements ArticleReplyDAO{

	private static final String SELECT_ALL = "FROM ArticleReplyBean";
	private static final String SELECT_ID = "FROM ArticleReplyBean WHERE id=?";
	private static final String SELECT_NAME = "FROM ArticleReplyBean WHERE memberAccount=?";
	private static final String SELECT_ARTICLEID ="FROM ArticleReplyBean WHERE articleID=?";
	private static final String INSERT = "INSERT INTO ArticleReply(articleID,memberAccount,content,photo) VALUES (?,?,?,?)";
	private static final String UPDATE = "UPDATE ArticleReplyBean SET content=?, photo=? ,editTime=? WHERE id =?";
	private static final String DELETE = "DELETE FROM ArticleReplyBean WHERE id=?";
    private SessionFactory sessionFactory;
	
	
	public ArticleReplyDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<ArticleReplyBean> select_ALL() {
		List<ArticleReplyBean> larb = null;
		Query query = getSession().createQuery(SELECT_ALL);
		larb = query.list();
		return larb;
	}

	@Override
	public ArticleReplyBean select_id(Integer id) {
		ArticleReplyBean arb = null;
		arb = (ArticleReplyBean) getSession().get(ArticleReplyBean.class,id);
		return arb;
	}

	@Override
	public List<ArticleReplyBean> select_memberAccount(String memberAccount) {
		 List<ArticleReplyBean> arb = null;
		 Query query = getSession().createQuery(SELECT_NAME);
		 query.setParameter(0, memberAccount);
		 arb = query.list();
		 return arb;
	}

	@Override
	public List<ArticleReplyBean> select_articleID(int articleID) {
		List<ArticleReplyBean> lab = null;
		Query query = getSession().createQuery(SELECT_ARTICLEID);
		query.setParameter(0, articleID);
		lab = query.list();
		return lab;
	}
	
	@Override
	public ArticleReplyBean insert(ArticleReplyBean bean) {
		getSession().save(bean);
	    return bean;
	}

	@Override
	public ArticleReplyBean update(ArticleReplyBean bean) {
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
