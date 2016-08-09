package com.kidscodetw.eeit.dao.appointment;

import java.util.List;

import com.kidscodetw.eeit.entity.appointment.AppointmovieBean;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;

public interface AppointmovieDAO {

	List<GenreBean> select_genre_list();
	List<String> select_movienames_list();
	List<String> select_theaternames_list();
	List<AppointmovieBean> select_movieshowtime_list(
			String[] citysels,String theatersels,
			String[] genresels,String moviesels,
			String showtimeDatebeg,String showtimeDateend);
	ShowtimeBean select_showtime(Integer id);

}