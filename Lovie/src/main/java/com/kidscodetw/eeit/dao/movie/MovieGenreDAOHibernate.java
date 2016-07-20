package com.kidscodetw.eeit.dao.movie;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.movie.MovieGenreBean;

public class MovieGenreDAOHibernate implements MovieGenreDAO{
	
	private static final String SELECT_ALL= "FROM MovieGenreBean";
	private static final String SELECT_BY_MOVIE= "FROM MovieGenreBean where movieId =:movieId";
	private static final String SELECT_BY_GENRE= "FROM MovieGenreBean where genreId =:genreId";
	private static final String SELECT_BY_BOTH= "FROM MovieGenreBean where genreId =:genreId and movieId =:movieId";

	private SessionFactory sessionFactory;
	
	public MovieGenreDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<MovieGenreBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}


	@Override
	public List<MovieGenreBean> selectByMovieId(Integer movieId) {
		Query query = this.getSession().createQuery(SELECT_BY_MOVIE);
		query.setParameter("movieId", movieId);
		return query.list();
	}

	@Override
	public List<MovieGenreBean> selectByGenreId(Integer genreId) {
		Query query = this.getSession().createQuery(SELECT_BY_GENRE);
		query.setParameter("genreId", genreId);
		return query.list();
	}

	@Override
	public MovieGenreBean insert(MovieGenreBean bean) {
		Query query = this.getSession().createQuery(SELECT_BY_BOTH);
		query.setParameter("movieId", bean.getMovieId());
		query.setParameter("genreId", bean.getGenreId());
		List<MovieGenreBean> list = query.list();
		if(list.size()==0){
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(MovieGenreBean bean) {
		this.getSession().delete(bean);
		Query query = this.getSession().createQuery(SELECT_BY_BOTH);
		query.setParameter("movieId", bean.getMovieId());
		query.setParameter("genreId", bean.getGenreId());
		List<MovieGenreBean> list = query.list();
		if(list.size()==0){
			return true;
		}
		return false;
	}

}
