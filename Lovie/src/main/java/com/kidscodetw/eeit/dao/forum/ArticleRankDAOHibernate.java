package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.forum.ArticleRankBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;



public class ArticleRankDAOHibernate implements ArticleRankDAO {

	private static final String SELECT_ALL = "FROM ArticleRankBean";
	private static final String SELECT_RANK_PRIMARYKEY = "FROM ArticleRankBean WHERE articleID=? AND memberAccount=?";
	private static final String SELECT_NAME = "FROM ArticleRankBean WHERE memberAccount=?";
	private static final String SELECT_ARTICLEID = "FROM ArticleRankBean WHERE articleID=?";
	private static final String SELECT_GOOD = "FROM ArticleRankBean WHERE articleID=? AND good=?";	
	private static final String SELECT_BAD = "FROM ArticleRankBean WHERE articleID=? AND bad=?";	
	private static final String SELECT_REPORT = "FROM ArticleRankBean WHERE report=?";	
	private static final String DELETE = "DELETE FROM ArticleRankBean WHERE articleID=?";
	private SessionFactory sessionFactory;

	public ArticleRankDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<ArticleRankBean> select_ALL() {
		List<ArticleRankBean> lrank = null;
		Query query = getSession().createQuery(SELECT_ALL);
		lrank = query.list();
		return lrank;
	}

	@Override
	public List<ArticleRankBean> select_Rank_Primarykey(int article, String memberAccount) {
		List<ArticleRankBean> larb = null;
		Query query = this.getSession().createQuery(SELECT_RANK_PRIMARYKEY);
		query.setParameter(0, article);
		query.setParameter(1, memberAccount);
		larb = query.list();
			
		return larb;
	
	
	
	}
	
	@Override
	public List<ArticleRankBean> select_memberAccount(String memberAccount) {
    	 List<ArticleRankBean> rank = null;
		 Query query = getSession().createQuery(SELECT_NAME);
		 query.setParameter(0, memberAccount);
		 rank = query.list();
		 return rank;
	}

	@Override
	public List<ArticleRankBean> select_totle_good(int articleID,int good) {
		 List<ArticleRankBean> rank = null;
		 Query query = getSession().createQuery(SELECT_GOOD);
		 query.setParameter(0, articleID);
		 query.setParameter(1, good);
		 rank = query.list();
		 return rank;
	}

	@Override
	public List<ArticleRankBean> select_totle_bad(int articleID,int bad) {
		 List<ArticleRankBean> rank = null;
		 Query query = getSession().createQuery(SELECT_BAD);
		 query.setParameter(0, articleID);
		 query.setParameter(1, bad);
		 rank = query.list();
		 return rank;
	}

	@Override
	public List<ArticleRankBean> select_articleID(int articleID) {
		List<ArticleRankBean> rank = null;
		Query query = getSession().createQuery(SELECT_ARTICLEID);
		query.setParameter(0, articleID);
		rank = query.list();
		return rank;
	}

	@Override
	public List<ArticleRankBean> select_report(int report) {
		 List<ArticleRankBean> rank = null;
		 Query query = getSession().createQuery(SELECT_REPORT);
		 query.setParameter(0, report);
		 rank = query.list();
		 return rank;
	}
	
	@Override
	public ArticleRankBean insert(ArticleRankBean bean) {
		getSession().save(bean);
	    return bean;
	}

	@Override
	public ArticleRankBean update(ArticleRankBean bean) {
		getSession().update(bean);	
		return bean;
	}

	@Override
	public int delete(int articleID) {
		int count = 0;
		Query query = getSession().createQuery(DELETE);
		query.setParameter(0, articleID);
		count = query.executeUpdate();
		return count;
	}
}
