package com.kidscodetw.eeit.controller.forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;


@Controller
public class ForumAdminServlet{
	@Autowired
	private ForumDAO forumDAO;
	
	@Autowired
	private ArticleRankDAO articleRankDAO;

	
	
	
	
//	@RequestMapping(value="forumsAdmin")
//	public String forumsAdmin(Model model){
//		String reportMember;
//		String reportReason;
//		
//		List<ArticleRankBean> reportBean = articleRankDAO.select_report(1);
//		List report = new ArrayList();
//		List forum = new ArrayList();
//		for(int i = 0; i<reportBean.size();i++){									
//			
//			ForumBean reportArticle = forumDAO.select_id(reportBean.get(i).getArticleID());						
//			forum.add(reportArticle); 
//			reportMember = reportBean.get(i).getMemberAccount();
//			 reportReason = reportBean.get(i).getReportReason();			 
//			 report.add(reportMember);
//			 report.add(reportReason);
//			
//		}
//		model.addAttribute("ArticleBean",forum);
//		model.addAttribute("ReportBean",report);
//		return "admin/forum/admin_forum.jsp";
//	}
	
	
	
	
	
	
	
//	@RequestMapping(value = "forumsAdmin", method = RequestMethod.GET)
//	public String forumAdmin() {
//		return "admin/forum/admin_forum.jsp";
//	}
	
	@RequestMapping(value = "forumsAdmin", method = RequestMethod.GET)
	@ResponseBody
	public List getAdminForum() {
		String pubTime= new String();
		String reportReason = new String();
		List<ArticleRankBean> reportBeans = articleRankDAO.select_report(1);
		List report = new ArrayList();
		
		Map<String,Object> all = new HashMap<String,Object>();
		for(int i = 0; i<reportBeans.size();i++){
		
            Map<String, String> reportMapObject = new HashMap<String,String>();
			ForumBean reportArticle = forumDAO.select_id(reportBeans.get(i).getArticleID());
			reportMapObject.put("id", reportArticle.getId().toString());
			reportMapObject.put("memberAccount", reportArticle.getMemberAccount().toString());
			reportMapObject.put("title", reportArticle.getTitle().toString());
			reportMapObject.put("content", reportArticle.getContent().toString());
			reportMapObject.put("genre", reportArticle.getGenre().toString());
			if(reportArticle.getPubTime()!=null){
				pubTime = reportArticle.getPubTime().toString();
			}
			reportMapObject.put("pubTime", pubTime);
			reportMapObject.put("editTime", reportArticle.getEditTime().toString());
			reportMapObject.put("reportMember", reportBeans.get(i).getMemberAccount());
			if(reportBeans.get(i).getReportReason()!=null){
				reportReason = reportBeans.get(i).getReportReason();
			}
			reportMapObject.put("reportReason", reportReason);
			report.add(reportMapObject);
		}
		return report;
	}
	
	
	
}


//
////@WebServlet("/admin/movie/movie.do")
//public class ForumAdminServlet  extends HttpServlet {
//
//	private ForumService forumService;
//	private ArticleRankService articleRankService;
//	
//	@Override
////	public void init() throws ServletException {
////		ServletContext application = this.getServletContext(); 
////		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
////		forumService =(ForumService) context.getBean("forumService");
////		articleRankService =(ArticleRankService) context.getBean("articleRankService");
////	}
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.setCharacterEncoding("UTF-8");		
//		List<ArticleRankBean> reportBean = articleRankService.select_report(1);
//		List report = new ArrayList();
//		Map<String,Object> all = new HashMap<String,Object>();
//		for(int i = 0; i<reportBean.size();i++){
//						
//			ForumBean reportArticle = forumService.select_id(reportBean.get(i).getArticleID());
//			String reportMember = reportBean.get(i).getMemberAccount();
//			String reportReason = reportBean.get(i).getReportReason();
//			report.add(reportMember);
//			report.add(reportReason);
//			all.put("ForumBean", reportArticle);
//			all.put("reportBean", report);
//		}
//		request.setAttribute("reports", all);
//		RequestDispatcher rd = request.getRequestDispatcher("admin_forum.jsp");
//		rd.forward(request, response);
//	}
//}
