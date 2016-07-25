package com.kidscodetw.eeit.servlet;

import java.io.IOException;

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
import com.kidscodetw.eeit.service.movie.MovieService;

@WebServlet("/moviename.do")
public class MovieFindByNameServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	
	public void selectMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String mName;
		mName = request.getParameter("mName");
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MovieDAO movie_dao = (MovieDAO) context.getBean("movieDAO");
		MovieBean mb;
		mb = movie_dao.select(mName);
		int mID = mb.getId();
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("movie.do?mID="+mID);
		rd.forward(request, response);
		return;
	}
}


