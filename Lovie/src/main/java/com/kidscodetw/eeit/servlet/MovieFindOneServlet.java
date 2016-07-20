package com.kidscodetw.eeit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.kidscodetw.eeit.dao.movie.ShowtimeDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.MovieGenreBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;

@WebServlet("/movie.do")
public class MovieFindOneServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	
	public void selectMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MovieDAO movie_dao = (MovieDAO) context.getBean("movieDAO");
		String mID;
		mID = request.getParameter("mID");
		int intID = Integer.parseInt(mID);
		MovieBean mb;
		mb = movie_dao.select(intID);
		
		MovieGenreDAO mgdj = (MovieGenreDAO)context.getBean("movieGenreDAO");
		GenreDAO gdj = (GenreDAO)context.getBean("genreDAO");
		List<MovieGenreBean> lmgb = mgdj.selectByMovieId(Integer.parseInt(mID));
		List<String> genre_list = new ArrayList<String>();
		for(MovieGenreBean mgb : lmgb){
			String genreName = (gdj.select(mgb.getGenreId())).getName();
			genre_list.add(genreName);
		}
		
		ShowtimeDAO showtime_dao = (ShowtimeDAO)context.getBean("showtimeDAO");
		List<ShowtimeBean> showtime_list = showtime_dao.selectMovie(mb.getName());
		
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("movie", mb);
		request.setAttribute("genre_list", genre_list);
		request.setAttribute("showtime_list", showtime_list);
		
		RequestDispatcher rd = request.getRequestDispatcher("movie/movie.jsp");
		rd.forward(request, response);
		return;
	}
}


