package com.kidscodetw.eeit.controller;

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

import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.TheaterBean;


@WebServlet("/theaters.do")
public class TheaterFindAllServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		selectAllTheater(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		selectAllTheater(req, resp);
	}
	
	public void selectAllTheater(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		TheaterDAO theater_dao = (TheaterDAO) context.getBean("theaterDAO");
		List<TheaterBean> theater_list =  theater_dao.select();
		List<String> city_list = new ArrayList<String>();
		for(TheaterBean theater: theater_list){
			if(!city_list.contains(theater.getCity())){
				city_list.add(theater.getCity());
			}
		}
		
		request.setAttribute("citys", city_list);
		request.setAttribute("theaters", theater_list);
		RequestDispatcher rd = request.getRequestDispatcher("theater/alltheaters.jsp");
		rd.forward(request, response);
		return;
		
	}

}
