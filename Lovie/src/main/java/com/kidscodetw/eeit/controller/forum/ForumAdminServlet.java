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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kidscodetw.eeit.entity.forum.ArticleRankBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;
import com.kidscodetw.eeit.service.forum.ArticleRankService;
import com.kidscodetw.eeit.service.forum.ForumService;



//@WebServlet("/admin/forum/forum.do")
public class ForumAdminServlet  extends HttpServlet {

	private ForumService forumService;
	private ArticleRankService articleRankService;
	
	@Override
//	public void init() throws ServletException {
//		ServletContext application = this.getServletContext(); 
//		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
//		forumService =(ForumService) context.getBean("forumService");
//		articleRankService =(ArticleRankService) context.getBean("articleRankService");
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");		
		List<ArticleRankBean> reportBean = articleRankService.select_report(1);
		List report = new ArrayList();
		Map<String,Object> all = new HashMap<String,Object>();
		for(int i = 0; i<reportBean.size();i++){
						
			ForumBean reportArticle = forumService.select_id(reportBean.get(i).getArticleID());
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
	}
}
