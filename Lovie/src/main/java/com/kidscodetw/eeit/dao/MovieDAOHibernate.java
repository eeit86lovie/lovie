package com.kidscodetw.eeit.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.MovieBean;

public class MovieDAOHibernate implements MovieDAO {

	private static final String SELECT_NAMES = "SELECT name FROM MovieBean";
	private static final String SELECT_ALL = "from MovieBean";
	private static final String SELECT_PHOTO = "SELECT id,photo FROM MovieBean";
	private static final String UPDATE_PHOTO = "update MovieBean set photo=? where id=:id";
	private static final String SELECT_BY_NAME = "from MovieBean where name=:name";


	private SessionFactory sessionFactory;

	public MovieDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Map<Integer, byte[]> selectPhotos() {
		Map<Integer, byte[]> photos = new HashMap<Integer, byte[]>();
		Query query = this.getSession().createQuery(SELECT_PHOTO);
		List<Object[]> list = (List<Object[]>) query.list();
		for (Object[] bean : list) {
			photos.put((Integer) bean[0], (byte[]) bean[1]);
		}
		return photos;
	}

	@Override
	public void updatePhotos(String link, Integer id) {
		
		MovieBean movieBean = (MovieBean)this.getSession().get(MovieBean.class, id);
		InputStream is;
		try {
			System.out.println(link);
			is = new java.net.URL(link).openStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buffer = new byte[8096];
//			for (int len; (len = is.read(buffer)) != -1;)
//				os.write(buffer, 0, len);
			int length = -1;
	        while((length = is.read(buffer)) != -1) { 
	            os.write(buffer, 0, length);
	        } 
			os.flush();
			os.close();
			
			
			movieBean.setPhoto(buffer);
			getSession().save(movieBean);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<String> select_movienames() {
		Query query = this.getSession().createQuery(SELECT_NAMES);
		return query.list();
	}

	@Override
	public MovieBean select(Integer id) {
		return (MovieBean) this.getSession().get(MovieBean.class, id);
	}

	@Override
	public MovieBean select(String name) {
		Query query = this.getSession().createQuery(SELECT_BY_NAME);
		query.setParameter("name", name);
		if (query.list().size() != 0) {
			return (MovieBean) query.list().get(0);
		}
		return null;
	}

	@Override
	public List<MovieBean> select() {
		Query query = this.getSession().createQuery(SELECT_ALL);
		return query.list();
	}

	@Override
	public boolean delete(Integer ID) {
		MovieBean bean = (MovieBean) this.getSession().get(MovieBean.class, ID);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public MovieBean insert(MovieBean bean) {
		this.getSession().save(bean);
		return bean;
	}

	@Override
	public MovieBean update(MovieBean bean) {
		if (bean != null && bean.getId() != 0) {
			this.getSession().saveOrUpdate(bean);
		}
		return (MovieBean) this.getSession().get(MovieBean.class, bean.getId());
	}

}
