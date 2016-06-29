package com.kidscodetw.eeit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.kidscodetw.eeit.dao.ShowtimeDAO;
import com.kidscodetw.eeit.entity.ShowtimeBean;

@WebServlet("/showtimeJsonByMovie.do")
public class ShowtimeJsonByMovie extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		selectMovie(request, response);
	}
	
	public void selectMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String movieName;
		movieName = request.getParameter("MovieName");
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		ShowtimeDAO showtime_dao = (ShowtimeDAO)context.getBean("showtimeDAO");
		List<ShowtimeBean> list_bean = null;
		PrintWriter out = response.getWriter();
		list_bean = showtime_dao.selectMovie(movieName);
		
		String json = new Gson().toJson(list_bean);
		out.write(json);
	}
}


