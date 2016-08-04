package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.movie.GenreBean;

public class AppointmovieDAOHibernate implements AppointmovieDAO {

	private static final String SELECT_ALL_GENRE = "from GenreBean";
	private static final String SELECT_NAMES_MOVIE = "SELECT name FROM MovieBean";
	private static final String SELECT_NAMES_THEATER = "SELECT name from TheaterBean";

	private SessionFactory sessionFactory;
	
	public AppointmovieDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<GenreBean> select_genre_list() {
		Query query = this.getSession().createQuery(SELECT_ALL_GENRE);
		return query.list();
	}
	
	@Override
	public List<String> select_movienames_list() {
		Query query = this.getSession().createQuery(SELECT_NAMES_MOVIE);
		return query.list();
	}

	@Override
	public List<String> select_theaternames_list() {
		Query query = this.getSession().createQuery(SELECT_NAMES_THEATER);
		return query.list();
	}
}
