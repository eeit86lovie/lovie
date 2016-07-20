package com.kidscodetw.eeit.controller.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.dao.movie.MovieGenreDAO;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;

@Controller
@RequestMapping("movies")
public class MovieFindAllMVC {
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private MovieGenreDAO movieGenreDAO;
	
	@Autowired
	private MovieDAO movieDAO;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getMovieGenres(Model model){
		List<MovieBean> movieBeans = movieDAO.select();
		model.addAttribute("movies", movieBeans);
		Map<Integer, String> genreMap = new HashMap<Integer, String>();
		List<MovieGenreBean> lmgb = movieGenreDAO.select();
		List<String> genreNames = getGenreNames();
		String genre_name = "";
		String temp = "";
		for (MovieBean mb : movieBeans) {
			for (MovieGenreBean mgb : lmgb) {
				if (mgb.getMovieId() == mb.getId()) {
					temp = genreNames.get(mgb.getGenreId() - 1) + ",";
					genre_name = genre_name.concat(temp);
					temp = "";
				}
				genreMap.put((Integer) mb.getId(), concatGenreName(genre_name));
			}
		}
		model.addAttribute("genres", genreMap);
		return "movie/allmovies.jsp";
	}
	
	//get Genre String type instead of Bean type
		public List<String> getGenreNames(){
			List<GenreBean> genreBeans = genreDAO.select();
			List<String> genreNames = new ArrayList<String>();
			for (GenreBean genreBean : genreBeans) {
				genreNames.add(genreBean.getName());
			}
			return genreNames;
		}
	
	public String concatGenreName(String genreName) {
		if (genreName != null && genreName.length() > 0
				&& genreName.charAt(genreName.length() - 1) == ',') {
			genreName = genreName.substring(0, genreName.length() - 1);
		}
		return genreName;
	}
	
	
}
