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

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.service.MovieService;

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
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		switch(type){
		case "mName": name = value;break;
		case "mRank": rank = value;break;
		case "mStartTime": startTime = value;break;
		case "mFilmLength": filmLength = value;break;
		case "mIntro": intro = value;break;
		case "mPhotoUrl": photoUrl = value;break;
		case "mTrailer": trailer = value;break;
		}
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		MovieBean movieBean = new MovieBean();
		movieBean.setName(name);
		movieBean.setRank(rank);
		movieBean.setStartTime(startTime);
		movieBean.setIntro(intro);
		movieBean.setPhotoUrl(photoUrl);
		movieBean.setTrailer(trailer);
		movieBean.setFilmLength(filmLength);
		movieBean.setId(mID);
		MovieBean tb = movieDAO.update(movieBean);
		PrintWriter out = response.getWriter();
		if (tb!=null) {
			out.write("true");
		}
		return;
	}
}
