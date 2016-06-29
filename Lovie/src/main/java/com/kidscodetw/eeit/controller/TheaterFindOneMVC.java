package com.kidscodetw.eeit.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.dao.ShowtimeDAO;
import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.entity.ShowtimeBean;
import com.kidscodetw.eeit.entity.TheaterBean;

@Controller
@RequestMapping("theater.mvc")
public class TheaterFindOneMVC {
	
	@Autowired
	WebApplicationContext context;
	
	@ModelAttribute("theater")
	public TheaterBean getTheater(@RequestParam("tID")Integer tID){
		TheaterDAO theaterDAO = (TheaterDAO)context.getBean("theaterDAO");
		return theaterDAO.select(tID);
	}
	
	@ModelAttribute("showtimes")
	public List<ShowtimeBean> getShowtimes(@ModelAttribute("theater")TheaterBean theaterBean){
		ShowtimeDAO showtimeDAO = (ShowtimeDAO)context.getBean("showtimeDAO");
		return showtimeDAO.selectTheater(theaterBean.getName());
	}
	
	@ModelAttribute("movies")
	public List<MovieBean> getMovies(@ModelAttribute("showtimes")List<ShowtimeBean> listShowtimeBean){
		Set<String> movieSet = new HashSet<String>();
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		List<MovieBean> listAllMovieBean = new ArrayList<MovieBean>();
		listAllMovieBean = movieDAO.select();
		List<MovieBean> movie_list = new ArrayList<MovieBean>();
		for(ShowtimeBean sb : listShowtimeBean){
			movieSet.add(sb.getMovieName());
		}
		for(MovieBean movieBean : listAllMovieBean){
			if(movieSet.contains(movieBean.getName())){
				movie_list.add(movieBean);
			}
		}
		return movie_list;
	}
	
	@RequestMapping(method=RequestMethod.GET, params={"tID"})
	public String goToTheater(@RequestParam("tID")Integer tID){
		return "theater/theater.jsp";
	}

}
