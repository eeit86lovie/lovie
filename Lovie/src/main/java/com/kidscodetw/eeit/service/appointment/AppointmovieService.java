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
import com.kidscodetw.eeit.entity.movie.GenreBean;

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

}
