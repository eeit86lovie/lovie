package com.kidscodetw.eeit.service;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kidscodetw.eeit.dao.ShowtimeDAO;
import com.kidscodetw.eeit.entity.ShowtimeBean;


@Service
public class ShowtimeJsonByMovieMVC {
	
	@RequestMapping(value="/showtimeJsonByMovie.mvc", produces=MediaType.APPLICATION_JSON)
	public List<ShowtimeBean> showtimeJson(@RequestParam("MovieName") String movieName, ShowtimeDAO showtimeDAO){
		return showtimeDAO.selectMovie(movieName);
	}

}
