package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.forum.ArticleRankBean;

public class ArticleRankDAOHibernate implements ArticleRankDAO {

	private static final String SELECT_ALL = "FROM ArticleRankBean";
	private static final String SELECT_ID = "FROM ArticleRankBean WHERE id=?";
	private static final String SELECT_NAME = "FROM ArticleRankBean WHERE memberAccount=?";
	private static final String SELECT_ARTICLEID = "FROM ArticleRankBean WHERE articleID=?";
	private static final String INSERT = "INSERT INTO ArticleRank(articleID,memberAccount,content,photo) VALUES (?,?,?,?)";
	private static final String UPDATE = "UPDATE ArticleReplyBean SET content=?, photo=? ,editTime=? WHERE id =?";
	private static final String DELETE = "DELETE FROM ArticleRankBean WHERE id=?";
	private SessionFactory sessionFactory;

	public ArticleRankDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<ArticleRankBean> select_ALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleRankBean select_id(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleRankBean> select_memberAccount(String memberAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleRankBean> select_totle_good(int articleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleRankBean> select_totle_bad(int articleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleRankBean> select_articleID(int articleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleRankBean insert(ArticleRankBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleRankBean update(ArticleRankBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int articleID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
