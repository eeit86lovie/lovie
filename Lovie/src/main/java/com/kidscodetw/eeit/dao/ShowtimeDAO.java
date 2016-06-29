package com.kidscodetw.eeit.dao;

import java.util.List;

import com.kidscodetw.eeit.entity.ShowtimeBean;

public interface ShowtimeDAO {
	
	ShowtimeBean select(Integer id);

	List<ShowtimeBean> selectBoth(String movieName, String theaterName);
	
	List<ShowtimeBean> selectMovie(String movieName);

	List<ShowtimeBean> selectTheater(String theaterName);

	Integer deleteDateBefore(String showtimeDate);

	ShowtimeBean insert(ShowtimeBean bean);
	
	ShowtimeBean update(ShowtimeBean bean);

}