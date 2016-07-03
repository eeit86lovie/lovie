package com.kidscodetw.eeit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kidscodetw.eeit.dao.GenreDAO;
import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.dao.MovieGenreDAO;
import com.kidscodetw.eeit.dao.ShowtimeDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.entity.MovieGenreBean;
import com.kidscodetw.eeit.entity.ShowtimeBean;


@Controller
@RequestMapping("/movie.mvc")
public class MovieFindOneMVC {
	
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private MovieGenreDAO movieGenreDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private ShowtimeDAO showtimeDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getGenreList(@RequestParam("mID")Integer mID, Model model){
		MovieBean movieBean = movieDAO.select(mID);
		model.addAttribute("movie", movieBean);
		List<ShowtimeBean> showtimeBeans = showtimeDAO.selectMovie(movieBean.getName());
		model.addAttribute("showtime_list", showtimeBeans);
		List<MovieGenreBean> listMovieGenre = movieGenreDAO.selectByMovieId(mID);
		List<String> listGenre = new ArrayList<String>();
		for(MovieGenreBean movieGenreBean : listMovieGenre){
			String genreName = (genreDAO.select(movieGenreBean.getGenreId())).getName();
			listGenre.add(genreName);
		}
		model.addAttribute("genre_list", listGenre);
		return "movie/movie.jsp";
	}
	
}
