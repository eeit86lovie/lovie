package com.kidscodetw.eeit.service.appointment;

import java.sql.Date;
import java.util.List;

import com.kidscodetw.eeit.dao.appointment.AppointmentDAO2;
import com.kidscodetw.eeit.dao.appointment.AppointmovieDAO;
import com.kidscodetw.eeit.entity.appointment.AppointmentBean2;
import com.kidscodetw.eeit.entity.appointment.AppointmentaBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentaeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentbBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentsBean;
import com.kidscodetw.eeit.entity.appointment.AppointmovieBean;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;

public class AppointmovieService {
	
	private AppointmovieDAO appointmovieDAO;
	public AppointmovieService(AppointmovieDAO appointmovieDAO){
		this.appointmovieDAO = appointmovieDAO;
	}
	
	public List<GenreBean> select_genre_list(){
		List<GenreBean> result = null;
		result = appointmovieDAO.select_genre_list();
		return result;
	}

	public List<String> select_movienames_list(){
		List<String> result = null;
		result = appointmovieDAO.select_movienames_list();
		return result;
	}

	public List<String> select_theaternames_list(){
		List<String> result = null;
		result = appointmovieDAO.select_theaternames_list();
		return result;
	}

	public ShowtimeBean select_showtime(Integer id) {
		return appointmovieDAO.select_showtime(id);
	}
	
	public List<AppointmovieBean> select_movieshowtime_list(
			String[] citysels,
			String theatersels,
			String[] genresels,
			String moviesels,
			String showtimeDatebeg,
			String showtimeDateend
			) {
		List<AppointmovieBean> result = null;
		result = appointmovieDAO.select_movieshowtime_list(genresels, showtimeDateend, genresels, showtimeDateend, showtimeDateend, showtimeDateend);
		return result;		
	}

}
