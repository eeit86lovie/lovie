package com.kidscodetw.eeit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

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
	
	@ModelAttribute("movie")
	public MovieBean findOneMovie(@RequestParam("mID")Integer mID, MovieDAO movieDAO){
		return movieDAO.select(mID);
	}
	
	@ModelAttribute("genre_list")
	public List<String> getGenreList(@RequestParam("mID")Integer mID, MovieGenreDAO movieGenreDAO, GenreDAO genreDAO){
		List<MovieGenreBean> listMovieGenre = movieGenreDAO.selectByMovieId(mID);
		List<String> listGenre = new ArrayList<String>();
		for(MovieGenreBean movieGenreBean : listMovieGenre){
			String genreName = (genreDAO.select(movieGenreBean.getGenreId())).getName();
			listGenre.add(genreName);
		}
		return listGenre;
	}
	
	@ModelAttribute("showtime_list")
	public List<ShowtimeBean> getShowtimeList(@ModelAttribute("movie")MovieBean movieBean, ShowtimeDAO showtimeDAO){
		return showtimeDAO.selectMovie(movieBean.getName());
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String dispatch(){
		return "movie/movie.jsp";
	}
	
	
}
