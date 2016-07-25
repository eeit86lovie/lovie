package com.kidscodetw.eeit.dao.movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.movie.ShowtimeBean;

public class ShowtimeDAOHibernate implements ShowtimeDAO {
	private static final String SELECT_BY_BOTH = "from ShowtimeBean where movieName=:movieName and theaterName=:theaterName order by showtimeDate";
	private static final String SELECT_BY_MOVIE = "from ShowtimeBean where movieName=:movieName";
	private static final String SELECT_BY_THEATER = "from ShowtimeBean where theaterName=:theaterName";
	private static final String DELETE = "delete from ShowtimeBean where showtimeDate<:showtimeDate";
	private SessionFactory sessionFactory;
	
	public ShowtimeDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public ShowtimeBean select(Integer id) {
		return (ShowtimeBean) this.getSession().get(ShowtimeBean.class, id);
	}

	@Override
	public List<ShowtimeBean> selectMovie(String movieName) {
		Query query = this.getSession().createQuery(SELECT_BY_MOVIE);
		query.setParameter("movieName", movieName);
		return query.list();
	}

	@Override
	public List<ShowtimeBean> selectBoth(String movieName, String theaterName) {
		Query query = this.getSession().createQuery(SELECT_BY_BOTH);
		query.setParameter("movieName", movieName);
		query.setParameter("theaterName", theaterName);
		return query.list();
	}

	@Override
	public List<ShowtimeBean> selectTheater(String theaterName) {
		Query query = this.getSession().createQuery(SELECT_BY_THEATER);
		query.setParameter("theaterName", theaterName);
		return query.list();
	}

	@Override
	public Integer deleteDateBefore(String showtimeDate) {
		Query query = this.getSession().createQuery(DELETE);
		query.setParameter("showtimeDate", showtimeDate);
		return query.executeUpdate();
	}

	@Override
	public ShowtimeBean insert(ShowtimeBean bean) {
		Integer generatedId = (Integer) this.getSession().save(bean);
		return (ShowtimeBean) this.getSession().get(ShowtimeBean.class,
				generatedId);
	}

	@Override
	public ShowtimeBean update(ShowtimeBean bean) {
		if(bean!=null && bean.getId()!=0)
		this.getSession().update(bean);
		return (ShowtimeBean) this.getSession().get(ShowtimeBean.class,bean.getId());
	}

}
