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

@WebServlet("/member/memberEdit.do")
public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password;
		Integer gender;
		String email;
		String nickname;
		String city;
		String district;
		String phone;
//		String photoUrl;
		byte[] photo;
		String birthday;
//		String intro;

//		-------------------------------------------------------------------
		String name =null;
		String rank =null;
		String startTime =null;
		String filmLength =null;
		String intro =null;
		String photoUrl =null;
		String trailer =null;
		request.setCharacterEncoding("UTF-8");
		String mID_row = request.getParameter("mID");
		Integer memberID = null;
		if (mID_row == "") {
			return;
		}
		memberID = Integer.parseInt(mID_row);
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAO");
		MemberBean memberBean = memberDAO.select(memberID);
		String type = request.getParameter("type");
		String value = request.getParameter("value");
//		switch(type){
//		case "mName": name = value;memberBean.setName(name);break;
//		case "mRank": rank = value;memberBean.setRank(rank);break;
//		case "mStartTime": startTime = value;memberBean.setStartTime(startTime);break;
//		case "mFilmLength": filmLength = value;memberBean.setFilmLength(filmLength);break;
//		case "mIntro": intro = value;memberBean.setIntro(intro);break;
//		case "mPhotoUrl": photoUrl = value;memberBean.setPhotoUrl(photoUrl);break;
//		case "mTrailer": trailer = value;memberBean.setTrailer(trailer);break;
//		}
//		
//		MovieBean tb = memberDAO.update(memberBean);
		PrintWriter out = response.getWriter();
//		if (tb!=null) {
//			out.write("true");
//		}
		return;
	}


}
