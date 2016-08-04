package com.kidscodetw.eeit.controller.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;


//@WebServlet("/admin/movie/movie.do")
public class ForumAdminServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(getServletContext()) ;
		ForumDAO forumDAO = (ForumDAO)context.getBean("forumDAO");
		ArticleRankDAO articleRankDAO = (ArticleRankDAO)context.getBean("articleRankDAO");
		request.setCharacterEncoding("UTF-8");
		
		List<ArticleRankBean> reportBean = articleRankDAO.select_report(1);
		List report = new ArrayList();
		Map<String,Object> all = new HashMap<String,Object>();
		for(int i = 0; i<reportBean.size();i++){
						
			ForumBean reportArticle = forumDAO.select_id(reportBean.get(i).getArticleID());
			String reportMember = reportBean.get(i).getMemberAccount();
			String reportReason = reportBean.get(i).getReportReason();
			report.add(reportMember);
			report.add(reportReason);
			all.put("ForumBean", reportArticle);
			all.put("reportBean", report);
		}
		request.setAttribute("reports", all);
		RequestDispatcher rd = request.getRequestDispatcher("admin_forum.jsp");
		rd.forward(request, response);
		return;
		
	}
}
