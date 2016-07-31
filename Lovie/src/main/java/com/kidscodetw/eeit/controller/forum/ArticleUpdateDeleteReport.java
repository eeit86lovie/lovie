package com.kidscodetw.eeit.controller.forum;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ForumBean;



@Controller
public class ArticleUpdateDeleteReport {

	@Autowired
	private ForumDAO forumDAO;
	
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
	
	
	
}
