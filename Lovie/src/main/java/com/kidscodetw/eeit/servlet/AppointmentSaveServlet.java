package com.kidscodetw.eeit.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kidscodetw.eeit.dao.MovieDAO;
import com.kidscodetw.eeit.dao.TheaterDAO;
import com.kidscodetw.eeit.entity.MemberBean;
import com.kidscodetw.eeit.entity.MovieBean;
import com.kidscodetw.eeit.entity.TheaterBean;
import com.kidscodetw.eeit.service.TheaterService;

@WebServlet("/new_appointment.do")
public class AppointmentSaveServlet extends HttpServlet{
	
	MemberBean myBean = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processExample(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processExample(request, response);
	}
	
	public void processExample(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Object loginOk = session.getAttribute("LoginOK");
		if(loginOk!=null){
			myBean = (MemberBean)loginOk;
			loginExample(request, response);
		}else{
			logoutExample(request, response);
		}
	}
	
	public void loginExample(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		if(myBean.getBirthday().length()>4){
			String age = getAge(myBean.getBirthday());
			myBean.setBirthday(age);
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		MovieDAO movieDAO = (MovieDAO)context.getBean("movieDAO");
		TheaterDAO theaterDAO = (TheaterDAO)context.getBean("theaterDAO");
		List<MovieBean> movies = movieDAO.select();
		List<TheaterBean> theaters = theaterDAO.select();
		List<String> citys = new ArrayList<String>();
		for(TheaterBean theater: theaters){
			if(!citys.contains(theater.getCity())){
				citys.add(theater.getCity());
			}
		}
		
		
		request.setAttribute("movies", movies);
		request.setAttribute("citys", citys);
		request.setAttribute("theaters", theaters);
		request.setAttribute("myBean", myBean);
		RequestDispatcher rd = request.getRequestDispatcher("appointment/new_appointment.jsp");
		rd.forward(request, response);
	}
	public void logoutExample(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("appointment/new_appointment.jsp");
		rd.forward(request, response);
	}
	
	public String getAge(String birthday){
		System.out.println(birthday);
		if(birthday!=null && birthday.length()>4){
			int birthYear = Integer.parseInt(birthday.substring(0,4));
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			int nowYear = Integer.parseInt(df.format(new Date()));
			Integer age = nowYear - birthYear;
			return age.toString();
		}
		return null;
	}
	

}
