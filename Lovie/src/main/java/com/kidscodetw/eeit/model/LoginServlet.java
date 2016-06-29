package com.kidscodetw.eeit.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kidscodetw.eeit.entity.MemberBean;
import com.kidscodetw.eeit.entity.MemberDB;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session!=null){
			session.invalidate();
		}
		session = request.getSession();
		Map<String, String> loginMsgs = new HashMap<String, String>();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String currentUri = request.getParameter("uri");
		String referer = request.getHeader("referer");
		String[] temp = referer.split("/");
		String uri = temp[temp.length-1];
		System.out.println(uri);
		if(account==null || account.trim().length()==0){
			loginMsgs.put("AccountEmptyError", "帳號欄必須輸入");
		}
		if(password==null || password.trim().length()==0){
			loginMsgs.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		if(!loginMsgs.isEmpty()){
			out = response.getWriter();
			String json = new Gson().toJson(loginMsgs);
			System.out.println(json);
			out.write(json);
			return;
		}
		
		MemberDB loginDb = new MemberDB();
		MemberBean memberBean = loginDb.checkAccountPassword(account, password);
		if(memberBean!=null){
			session.setAttribute("LoginOK", memberBean);
			loginMsgs.put("LoginSuccess", referer);
			String json = new Gson().toJson(loginMsgs);
			out.write(json);
			return;
			
		}else{
			loginMsgs.put("LoginFailError", "無此帳號或密碼不正確");
			String json = new Gson().toJson(loginMsgs);
			out.write(json);
			return;
		}
		
		
	}
	
	

}
