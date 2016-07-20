package com.kidscodetw.eeit.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.dao.movie.ShowtimeDAO;
import com.kidscodetw.eeit.dao.movie.TheaterDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;
import com.kidscodetw.eeit.entity.movie.TheaterBean;

@WebServlet("/theater.do")
public class TheaterFindOneServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectTheater(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectTheater(request, response);
	}
	
	public void selectTheater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String tID_row = request.getParameter("tID");
		if(tID_row==null || tID_row.length()==0){
			return;
		}
		int tID = Integer.parseInt(tID_row);
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		TheaterDAO theater_dao = (TheaterDAO) context.getBean("theaterDAO");
		TheaterBean tb = theater_dao.select(tID);
		ShowtimeDAO showtime_dao = (ShowtimeDAO)context.getBean("showtimeDAO");
		MovieDAO movie_dao = (MovieDAO)context.getBean("movieDAO");
		List<ShowtimeBean> showtime_list = showtime_dao.selectTheater(tb.getName());
		List<MovieBean> movie_list = new ArrayList<MovieBean>();
		List<String> movieListTemp = new ArrayList<String>();
		MovieBean mb;
		for(int i=0; i<showtime_list.size();i++){
//			if(showtime_list.get(i).getShowtimeDate()){
//				showtime_list.remove(i);
//			}
		}
		for(ShowtimeBean sb : showtime_list){
			if(!movieListTemp.contains(sb.getMovieName())){
				movieListTemp.add(sb.getMovieName());
			}
		}
		
		for(String movieName : movieListTemp){
			mb = movie_dao.select(movieName);
			if(mb!=null){
			movie_list.add(mb);
			}
		}
		
		request.setAttribute("movies", movie_list);
		request.setAttribute("theater", tb);
		request.setAttribute("showtimes", showtime_list);
		RequestDispatcher rd = request.getRequestDispatcher("theater/theater.jsp");
		rd.forward(request, response);
		return;
	}
}


