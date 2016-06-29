package com.kidscodetw.eeit.dao;

import java.util.List;

import com.kidscodetw.eeit.entity.MovieGenreBean;

public interface MovieGenreDAO {
	
	List<MovieGenreBean> select();

	List<MovieGenreBean> selectByMovieId(Integer movieId);

	List<MovieGenreBean> selectByGenreId(Integer genreId);

	MovieGenreBean insert(MovieGenreBean bean);

	boolean delete(MovieGenreBean bean);

}