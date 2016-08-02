package com.kidscodetw.eeit.service.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.movie.MovieBean;

@WebServlet("/member/profile/memberEdit.do")
public class MemberEditServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname;
		String city;
		String district;
		String intro;
		
		request.setCharacterEncoding("UTF-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
		MemberBean memberBean = memberDAO.select(id);
		String type = request.getParameter("type");
		String value = request.getParameter("value");
		
		String type1 =request.getParameter("type1");
		String value1 =request.getParameter("value1");

		switch(type){
		case "nickname": nickname = value;memberBean.setNickname(nickname);break;
		case "city": city = value;memberBean.setCity(city);break;
		case "intro": intro = value;memberBean.setIntro(intro);break;
//		case "mTrailer": trailer = value;memberBean.setTrailer(trailer);break;
		}
		if (type1 != null&& type1.length() != 0) {
			district = value1;memberBean.setDistrict(district);
		}

		MemberBean tb = memberDAO.update(memberBean);
		PrintWriter out = response.getWriter();
		if (tb!=null) {
			out.write("true");
		}
		return;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}


}
