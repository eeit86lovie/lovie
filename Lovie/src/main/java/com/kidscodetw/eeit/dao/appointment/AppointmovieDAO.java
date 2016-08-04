package com.kidscodetw.eeit.dao.appointment;

import java.util.List;
import com.kidscodetw.eeit.entity.movie.GenreBean;

public interface AppointmovieDAO {

	List<GenreBean> select_genre_list();
	List<String> select_movienames_list();
	List<String> select_theaternames_list();

}