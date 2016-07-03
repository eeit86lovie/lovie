package com.kidscodetw.eeit.admin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.dao.TheaterDAO;

@WebServlet("/admin/movie/showtime.do")
public class ShowtimeAdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		TheaterDAO theaterDAO = (TheaterDAO)context.getBean("theaterDAO");
		List<String> movie_names = movieDAO.select_movienames();
		List<String> theater_names = theaterDAO.select_theaternames();
		request.setAttribute("movienames", movie_names);
		request.setAttribute("theaternames", theater_names);
		RequestDispatcher rd = request.getRequestDispatcher("admin_showtime.jsp");
		rd.forward(request, response);
		return;
		
	}
}
