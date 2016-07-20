package com.kidscodetw.eeit.admin.service;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/admin/movie/movieEdit.do")
public class MovieEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name =null;
		String rank =null;
		String startTime =null;
		String filmLength =null;
		String intro =null;
		String photoUrl =null;
		String trailer =null;
		request.setCharacterEncoding("UTF-8");
		String mID_row = request.getParameter("mID");
		int mID = 0;
		if (mID_row == "") {
			return;
		}
		mID = Integer.parseInt(mID_row);
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		MovieBean movieBean = movieDAO.select(mID);
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		switch(type){
		case "mName": name = value;movieBean.setName(name);break;
		case "mRank": rank = value;movieBean.setRank(rank);break;
		case "mStartTime": startTime = value;movieBean.setStartTime(startTime);break;
		case "mFilmLength": filmLength = value;movieBean.setFilmLength(filmLength);break;
		case "mIntro": intro = value;movieBean.setIntro(intro);break;
		case "mPhotoUrl": photoUrl = value;movieBean.setPhotoUrl(photoUrl);break;
		case "mTrailer": trailer = value;movieBean.setTrailer(trailer);break;
		}
		
		MovieBean tb = movieDAO.update(movieBean);
		PrintWriter out = response.getWriter();
		if (tb!=null) {
			out.write("true");
		}
		return;
	}
}
