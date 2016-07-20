package com.kidscodetw.eeit.service.movie;

import java.util.List;

import com.kidscodetw.eeit.dao.movie.MovieGenreDAO;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;

public class MovieGenreService implements MovieGenreDAO{
	
	private MovieGenreDAO movieGenreDao;
	public MovieGenreService(MovieGenreDAO movieGenreDAOHibernate){
		this.movieGenreDao = movieGenreDAOHibernate;
	}
	
	public List<MovieGenreBean> select(){
		List<MovieGenreBean> result = null;
		result = movieGenreDao.select();
		return result;
	}
	

	public List<MovieGenreBean> selectByMovieId(Integer movieId){
		List<MovieGenreBean> result = null;
		if(movieId != 0){
			result = movieGenreDao.selectByMovieId(movieId);
		}
		return result;
	}

	public List<MovieGenreBean> selectByGenreId(Integer genreId){
		List<MovieGenreBean> result = null;
		if(genreId !=0){
			result = movieGenreDao.selectByGenreId(genreId);
		}
		return result;
	}

	public MovieGenreBean insert(MovieGenreBean bean){
		MovieGenreBean result = null;
		if(bean !=null){
			result = movieGenreDao.insert(bean);
		}
		return result;
	}

	public boolean delete(MovieGenreBean bean){
		boolean result = false;
		if(bean != null){
			result = movieGenreDao.delete(bean);
		}
		return result;
	}

}
