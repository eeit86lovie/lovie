package com.kidscodetw.eeit.dao.member;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.member.InterestedMoviesBean;

public class InterestedMoviesDAOHibernate implements InterestedMoviesDAO {
	private SessionFactory sessionFactory;
	
	private static final String SELECT_ALL= "FROM InterestedMoviesBean";
	private static final String SELECT_BY_MEMBER= "FROM InterestedMoviesBean where memberId =:memberId";
	private static final String SELECT_BY_GENRE= "FROM InterestedMoviesBean where genreId =:genreId";
	private static final String SELECT_BY_BOTH= "FROM InterestedMoviesBean where genreId =:genreId and movieId =:movieId";


	public InterestedMoviesDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public List<InterestedMoviesBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}


	@Override
	public List<InterestedMoviesBean> selectByMemberId(Integer memberId) {
		Query query = this.getSession().createQuery(SELECT_BY_MEMBER);
		query.setParameter("memberId", memberId);
		return query.list();
	}


	@Override
	public List<InterestedMoviesBean> selectByGenreId(Integer genreId) {
		Query query = this.getSession().createQuery(SELECT_BY_GENRE);
		query.setParameter("genreId", genreId);
		return query.list();
	}


	@Override
	public InterestedMoviesBean insert(InterestedMoviesBean bean) {
		Query query = this.getSession().createQuery(SELECT_BY_BOTH);
		query.setParameter("movieId", bean.getMemberId());
		query.setParameter("genreId", bean.getGenreId());
		List<InterestedMoviesBean> list = query.list();
		if(list.size()==0){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}


	@Override
	public boolean delete(InterestedMoviesBean bean) {
		this.getSession().delete(bean);
		Query query = this.getSession().createQuery(SELECT_BY_BOTH);
		query.setParameter("movieId", bean.getMemberId());
		query.setParameter("genreId", bean.getGenreId());
		List<InterestedMoviesBean> list = query.list();
		if(list.size()==0){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
}
