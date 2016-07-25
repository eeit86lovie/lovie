package com.kidscodetw.eeit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kidscodetw.eeit.entity.member.MemberBean;
import com.kidscodetw.eeit.entity.member.MemberDB;

@WebServlet("/appointments.do")
public class AppointmentFindAllServlet extends HttpServlet {

	MemberBean myBean = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processAppoint(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processAppoint(request, response);
	}

	public void processAppoint(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Object loginOk = session.getAttribute("LoginOK");
		if (loginOk != null) {
			myBean = (MemberBean) loginOk;
			loginAppoint(request, response);
		} else {
			logoutAppoint(request, response);
		}
	}

	public void loginAppoint(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		MemberDB memberDb = new MemberDB();
		List<MemberBean> allMembers = memberDb.getAllMembers();
		List<MemberBean> allGirls = null;
		List<MemberBean> allBoys = null;
		if (myBean.getGender() == 1) {
			allGirls = memberDb.getAllGirls();
			request.setAttribute("members", allGirls);
			RequestDispatcher rd = request.getRequestDispatcher("appointment/appointments.jsp");
			rd.forward(request, response);
			return;
		}else if(myBean.getGender() == 0) {
			allBoys = memberDb.getAllBoys();
			request.setAttribute("members", allBoys);
			RequestDispatcher rd = request.getRequestDispatcher("appointment/appointments.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

	public void logoutAppoint(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		MemberDB memberDb = new MemberDB();
		List<MemberBean> allMembers = memberDb.getAllMembers();
		request.setAttribute("members", allMembers);
		RequestDispatcher rd = request.getRequestDispatcher("appointment/appointments.jsp");
		rd.forward(request, response);
		return;
	}

}
