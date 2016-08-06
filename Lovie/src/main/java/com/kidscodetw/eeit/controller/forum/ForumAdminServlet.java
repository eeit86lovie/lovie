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


	
	@RequestMapping(value = "forumsAdmin", method = RequestMethod.GET)
	@ResponseBody
	public List getAdminForum() {
		String pubTime= new String();
		String id= new String();
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


