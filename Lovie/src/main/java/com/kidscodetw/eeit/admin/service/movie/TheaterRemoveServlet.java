package com.kidscodetw.eeit.admin.service.movie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.movie.TheaterDAO;
import com.kidscodetw.eeit.service.movie.TheaterService;

@WebServlet("/admin/movie/theaterRemove.do")
public class TheaterRemoveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id_raw = request.getParameter("id");
		int id = 0;
		if (id_raw == "") {
			return;
		}
		id = Integer.parseInt(id_raw);
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		TheaterDAO theaterDAO = (TheaterDAO)context.getBean("beans.config.xml");
		boolean result = theaterDAO.delete(id);
		PrintWriter out = response.getWriter();
		if (result) {
			out.write("true");
		}
		return;
	}
}
