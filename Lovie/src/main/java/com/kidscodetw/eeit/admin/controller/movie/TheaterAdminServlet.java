package com.kidscodetw.eeit.admin.controller.movie;

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

import com.kidscodetw.eeit.dao.movie.TheaterDAO;
import com.kidscodetw.eeit.entity.movie.TheaterBean;
import com.kidscodetw.eeit.service.movie.TheaterService;

@WebServlet("/admin/movie/theater.do")
public class TheaterAdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		TheaterDAO theaterDAO = (TheaterDAO)context.getBean("theaterDAO");
		List<TheaterBean> theater_list = theaterDAO.select();
		request.setAttribute("theaters", theater_list);
		RequestDispatcher rd = request.getRequestDispatcher("admin_theater.jsp");
		rd.forward(request, response);
		return;
		
	}
}
