package com.kidscodetw.eeit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kidscodetw.eeit.dao.GenreDAO;
import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.dao.MovieGenreDAO;
import com.kidscodetw.eeit.dao.ShowtimeDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.entity.MovieGenreBean;
import com.kidscodetw.eeit.entity.ShowtimeBean;


@Controller
public class MovieFindOneMVC {
	
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private MovieGenreDAO movieGenreDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private ShowtimeDAO showtimeDAO;
	
	
	@RequestMapping(value="movie/{id}",method=RequestMethod.GET)
	public String getMovieByid(@PathVariable("id")Integer mID, Model model){
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
	
	@RequestMapping(value="movie/{name}",method=RequestMethod.GET)
	public String getMovieByName(@PathVariable("name")String name, Model model){
		MovieBean movieBean = movieDAO.select(name);
		model.addAttribute("movie", movieBean);
		List<ShowtimeBean> showtimeBeans = showtimeDAO.selectMovie(movieBean.getName());
		model.addAttribute("showtime_list", showtimeBeans);
		List<MovieGenreBean> listMovieGenre = movieGenreDAO.selectByMovieId(movieBean.getId());
		List<String> listGenre = new ArrayList<String>();
		for(MovieGenreBean movieGenreBean : listMovieGenre){
			String genreName = (genreDAO.select(movieGenreBean.getGenreId())).getName();
			listGenre.add(genreName);
		}
		model.addAttribute("genre_list", listGenre);
		return "movie/movie.jsp";
	}
	
}
