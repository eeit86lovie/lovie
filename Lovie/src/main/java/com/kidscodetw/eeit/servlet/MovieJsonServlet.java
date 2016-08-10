package com.kidscodetw.eeit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.kidscodetw.eeit.dao.movie.MovieDAO;
import com.kidscodetw.eeit.entity.movie.MovieBean;

@WebServlet("/moviejson.do")
public class MovieJsonServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	
	public void selectMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String mName;
		mName = request.getParameter("mName");
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MovieDAO movie_dao = (MovieDAO)context.getBean("movieDAO");
		MovieBean mb=null;
		mb = movie_dao.select(mName);
		if(mb == null){
			return;
		}
		System.out.println("mID:"+mb.getId());
		String json = new Gson().toJson(mb);
		PrintWriter out = response.getWriter();
		
		out.write(json);
		
	}
}


