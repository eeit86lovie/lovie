package com.kidscodetw.eeit.service.movie;

import java.util.List;

import com.kidscodetw.eeit.dao.movie.ShowtimeDAO;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;


public class ShowtimeService implements ShowtimeDAO{
	
	private ShowtimeDAO showtimeDao;
	public ShowtimeService(ShowtimeDAO showtimeDAOHibernate){
		this.showtimeDao = showtimeDAOHibernate;
	}
	
	public ShowtimeBean select(Integer id){
		ShowtimeBean result = null;
		if(id != null && id!=0){
			result = showtimeDao.select(id);
		}
		return result;
	}
	
	
	public List<ShowtimeBean> selectBoth(String movieName,String theaterName){
		List<ShowtimeBean> result = null;
		if(movieName != null && movieName.length()!=0 && theaterName != null && theaterName.length()!=0){
			result = showtimeDao.selectBoth(movieName, theaterName);
		}
		return result;
	}
	
	public List<ShowtimeBean> selectMovie(String movieName){
		List<ShowtimeBean> result = null;
		if(movieName != null && movieName.length()!=0){
			result = showtimeDao.selectMovie(movieName);
		}
		return result;
	}

	public List<ShowtimeBean> selectTheater(String theaterName){
		List<ShowtimeBean> result = null;
		if(theaterName!=null && theaterName.length()!=0){
			result = showtimeDao.selectTheater(theaterName);
		}
		return result;
	}


	public Integer deleteDateBefore(String showtimeDate){
		int result = 0;
		if(showtimeDate!=null && showtimeDate.length()!=0){
			result = showtimeDao.deleteDateBefore(showtimeDate);
		}
		return result;
	}

	public ShowtimeBean insert(ShowtimeBean bean){
		ShowtimeBean result = null;
		if(bean!=null){
			result = showtimeDao.insert(bean);
		}
		return result;
	}
	
	public ShowtimeBean update(ShowtimeBean bean){
		ShowtimeBean result = null;
		if(bean!=null){
			result = showtimeDao.update(bean);
		}
		return result;
	}

}
