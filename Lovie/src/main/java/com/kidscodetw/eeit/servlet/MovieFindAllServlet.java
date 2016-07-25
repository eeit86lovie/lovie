package com.kidscodetw.eeit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.movie.GenreDAO;
import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.dao.movie.MovieGenreDAO;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;

@WebServlet("/movies.do")
public class MovieFindAllServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		selectAllMovies(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		selectAllMovies(request, response);
	}

	public void selectAllMovies(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext( this.getServletContext());
		MovieDAO mdj = (MovieDAO) context.getBean("movieDAO");
		List<MovieBean> listmb;
		listmb = mdj.select();
		for(MovieBean mb : listmb){
			if(mb.getOnline()==0){
				listmb.remove(mb);
			}
		}
		// 一次把Genre列表讀進genreNameList省去重複dao查詢，Genre序號為list.get(i-1)
		GenreDAO genre_dao = (GenreDAO) context.getBean("genreDAO");
		List<GenreBean> lgb = genre_dao.select();
		List<String> genreNameList = new ArrayList<String>();
		for (GenreBean gb : lgb) {
			genreNameList.add(gb.getName());
		}
		

		// 建立Map為(movieID : 串在一起的genreName)
		MovieGenreDAO movie_genre_dao = (MovieGenreDAO) context.getBean("movieGenreDAO");
		Map<Integer, String> genre_map = new HashMap<Integer, String>();
		List<MovieGenreBean> lmgb = movie_genre_dao.select();

		String genre_name = "";
		String temp = "";

		for (MovieBean mb : listmb) {
			for (MovieGenreBean mgb : lmgb) {
				if (mgb.getMovieId() == mb.getId()) {
					temp = genreNameList.get(mgb.getGenreId() - 1) + ",";
					genre_name = genre_name.concat(temp);
					temp = "";
				}
				genre_map.put((Integer) mb.getId(), concatGenreName(genre_name));
			}
		}
		

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("movies", listmb);
		request.setAttribute("genres", genre_map);

		RequestDispatcher rd = request
				.getRequestDispatcher("movie/allmovies.jsp");
		rd.forward(request, response);
		return;
	}

	public String concatGenreName(String genre_name) {
		if (genre_name != null && genre_name.length() > 0
				&& genre_name.charAt(genre_name.length() - 1) == ',') {
			genre_name = genre_name.substring(0, genre_name.length() - 1);
		}
		return genre_name;
	}
}
