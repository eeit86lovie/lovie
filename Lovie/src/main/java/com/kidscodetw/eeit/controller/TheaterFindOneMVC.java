package com.kidscodetw.eeit.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.dao.ShowtimeDAO;
import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.entity.ShowtimeBean;
import com.kidscodetw.eeit.entity.TheaterBean;

@Controller
@RequestMapping("theater")
public class TheaterFindOneMVC {
	
	@Autowired
	private TheaterDAO theaterDAO;
	
	@Autowired
	private ShowtimeDAO showtimeDAO;
	
	@Autowired
	private MovieDAO movieDAO;
	
	@RequestMapping(method=RequestMethod.GET, path="{tID}")
	public String getMovies(@PathVariable("tID")Integer tID, Model model){
		TheaterBean theaterBean = theaterDAO.select(tID);
		model.addAttribute("theater", theaterBean); 
		List<ShowtimeBean> showtimeBeans = showtimeDAO.selectTheater(theaterBean.getName());
		model.addAttribute("showtimes", showtimeBeans);
		Set<String> movieSet = new HashSet<String>();
		List<MovieBean> listAllMovieBean = new ArrayList<MovieBean>();
		listAllMovieBean = movieDAO.select();
		List<MovieBean> movieBeans = new ArrayList<MovieBean>();
		for(ShowtimeBean sb : showtimeBeans){
			movieSet.add(sb.getMovieName());
		}
		for(MovieBean movieBean : listAllMovieBean){
			if(movieSet.contains(movieBean.getName())){
				movieBeans.add(movieBean);
			}
		}
		model.addAttribute("movies", movieBeans);
		return "theater/theater.jsp";
	}

}
