package com.kidscodetw.eeit.dao.movie;

import java.util.List;
import java.util.Map;

import com.kidscodetw.eeit.entity.movie.MovieBean;

public interface MovieDAO {

	Map selectPhotos();
	
	void updatePhotos(String link, Integer id);
	
	List<String> select_movienames();

	MovieBean select(Integer ID);

	MovieBean select(String Name);

	List<MovieBean> select();

	boolean delete(Integer ID);

	MovieBean insert(MovieBean bean);

	MovieBean update(MovieBean bean);

}