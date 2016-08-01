package com.kidscodetw.eeit.controller.forum;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;



@Controller
public class ArticleUpdateDeleteReport {

	@Autowired
	private ForumDAO forumDAO;
	
	@Autowired
	private ArticleRankDAO articleRankDAO;
	
	@RequestMapping(value = "forumsDelete", method = RequestMethod.GET)
	public String forumAUR() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsSelectUpdate", method = RequestMethod.GET)
	public String forumAUR1() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsUpdateArticle", method = RequestMethod.GET)
	public String forumAUR2() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsReport", method = RequestMethod.GET)
	public String forumAUR3() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsHaveReport", method = RequestMethod.GET)
	public String forumAUR4() {
		return "forum/NewTestForum.jsp";
	}
	
	
	@RequestMapping(value = "forumsDelete", params = { "Article_ID" }, method = RequestMethod.POST)
	@ResponseBody
	public int deleteArticle(
			@RequestParam("Article_ID") int Article_ID){		
		int deleteCount = forumDAO.delete(Article_ID);
		//System.out.println(Article_ID);
		return deleteCount;
	}
	
	
	
	@RequestMapping(value = "forumsSelectUpdate", params = { "Article_ID" }, method = RequestMethod.POST)
	@ResponseBody
	public ForumBean selectUpdate(
			@RequestParam("Article_ID") Integer Article_ID) {
	
		ForumBean selectUpdateArticlejson = forumDAO.select_id(Article_ID);
		System.out.println(selectUpdateArticlejson);
		return selectUpdateArticlejson;
	}
	
	
	
	
	
	
		@RequestMapping(value = "forumsUpdateArticle", params = {"UpdateArticleId","UpdateMember","UpdateTitle" ,"UpdateGenre","UpdateContent"}, method = RequestMethod.POST)
		@ResponseBody
		public ForumBean PublicationArticle(
				@RequestParam("UpdateArticleId") int UpdateArticleId,
				@RequestParam("UpdateMember") String UpdateMember,
				@RequestParam("UpdateTitle") String UpdateTitle,
				@RequestParam("UpdateGenre") String UpdateGenre,
				@RequestParam("UpdateContent") String UpdateContent){
			System.out.println(UpdateMember);
			System.out.println(UpdateTitle);
			System.out.println(UpdateGenre);
			System.out.println(UpdateContent);
		
			ForumBean fb = new ForumBean();
			
			fb.setId(UpdateArticleId);
			fb.setMemberAccount(UpdateMember);
			fb.setTitle(UpdateTitle);
			fb.setGenre(UpdateGenre);
			fb.setContent(UpdateContent);
			
			//fb.setPubTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			//fb.setEditTime(new java.sql.Timestamp(new java.util.Date().getTime()));
			ForumBean UpdateArticle = forumDAO.update(fb);
			return UpdateArticle;
		}
	
	
		@RequestMapping(value = "forumsReport", params = { "Report_Member","Report_Article_ID","Report_content" }, method = RequestMethod.POST)
		@ResponseBody
		public int forumsReport(
				@RequestParam("Report_Member") String Report_Member,
				@RequestParam("Report_Article_ID") Integer Report_Article_ID,
				@RequestParam("Report_content") String Report_content) {
		
			ArticleRankBean arb = new ArticleRankBean();
			arb.setArticleID(Report_Article_ID);
			arb.setMemberAccount(Report_Member);
			arb.setReport(1);
			arb.setReportReason(Report_content);

			int haveReport = 0;
			if(!Report_Member.isEmpty()){
				if(articleRankDAO.select_Rank_Primarykey(Report_Article_ID, Report_Member).isEmpty()){						
					articleRankDAO.insert(arb);
					haveReport = 1;
				}else{
					articleRankDAO.update(arb);
					haveReport = 1;
				}		
				
					
			}
			return haveReport;
		}
		
	
		
		@RequestMapping(value = "forumsHaveReport", params = { "Report_Have_Member" }, method = RequestMethod.POST)
		@ResponseBody
		public  List<ArticleRankBean> forumsHaveReport(
				@RequestParam("Report_Have_Member") String Report_Have_Member) {
		
				List<ArticleRankBean> haveReportResult = articleRankDAO.select_memberAccount(Report_Have_Member);						
				return haveReportResult;
		}
}
