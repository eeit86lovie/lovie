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

import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.TheaterBean;
import com.kidscodetw.eeit.service.TheaterService;

@WebServlet("/admin/movie/theaterEdit.do")
public class TheaterEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name =null;
		String city =null;
		String district =null;
		String address =null;
		String phone =null;
		String websiteUrl =null;
		request.setCharacterEncoding("UTF-8");
		String tID_row = request.getParameter("id");
		int tID = 0;
		if (tID_row == "") {
			return;
		}
		tID = Integer.parseInt(tID_row);
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		switch(type){
		case "name": name = value;break;
		case "city": city = value;break;
		case "district": district = value;break;
		case "address": address = value;break;
		case "phone": phone = value;break;
		case "websiteUrl": websiteUrl = value;break;
		}
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		TheaterDAO theaterDAO = (TheaterDAO)context.getBean("theaterDAO");
		TheaterBean theaterBean = new TheaterBean();
		theaterBean.setName(name);
		theaterBean.setCity(city);
		theaterBean.setDistrict(district);
		theaterBean.setAddress(address);
		theaterBean.setPhone(phone);
		theaterBean.setWebsiteUrl(websiteUrl);
		theaterBean.setId(tID);
		TheaterBean tb = theaterDAO.update(theaterBean);
		PrintWriter out = response.getWriter();
		if (tb!=null) {
			out.write("true");
		}
		return;
	}
}
