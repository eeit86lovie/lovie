package com.kidscodetw.eeit.admin.controller;

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

import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;

@WebServlet("/admin/movie/movie.do")
public class MovieAdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		request.setCharacterEncoding("UTF-8");
		List<MovieBean> movie_list = movieDAO.select();
		request.setAttribute("movies", movie_list);
		RequestDispatcher rd = request.getRequestDispatcher("admin_movie.jsp");
		rd.forward(request, response);
		return;
		
	}
}
