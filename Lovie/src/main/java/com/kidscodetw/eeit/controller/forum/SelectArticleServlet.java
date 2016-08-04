package com.kidscodetw.eeit.controller.forum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.forum.ArticleReplyDAO;
import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.dao.member.MemberDAO;
import com.kidscodetw.eeit.entity.forum.ArticleReplyBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;
import com.kidscodetw.eeit.entity.member.MemberBean;



@Controller
// @RequestMapping("forum")
public class SelectArticleServlet {

	@Autowired
	private ForumDAO forumDAO;

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ArticleReplyDAO articleReplyDAO;

	@RequestMapping(value = "forums", method = RequestMethod.GET)
	public String forumJsp() {
		return "forum/NewTestForum.jsp";
	}

	@RequestMapping(value = "forumsMember", method = RequestMethod.GET)
	public String forumJsp1() {
		return "forum/NewTestForum.jsp";
	}

	
	@RequestMapping(value = "forumsAddarticle.mvc", method = RequestMethod.GET)
	public String forumJsp2() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsAddreply.mvc", method = RequestMethod.GET)
	public String forumJsp3() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsSelectreply.mvc", method = RequestMethod.GET)
	public String forumJsp4() {
		return "forum/NewTestForum.jsp";
	}

	@RequestMapping(value = "forumsPublicationArticle.mvc", method = RequestMethod.GET)
	public String forumJsp5() {
		return "forum/NewTestForum.jsp";
	}

	
    //顯示1~10筆文章
	@RequestMapping(value = "forums", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ForumBean> getArticle() {
		List<ForumBean> articlejson = forumDAO.select_ALL();
		return articlejson;
	}
    
	//顯示留言
	@RequestMapping(value = "forumsSelectreply", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ArticleReplyBean> selectReply() {
		List<ArticleReplyBean> selectReplyjson = articleReplyDAO.select_ALL();
		return selectReplyjson;
	}
	
	//顯示下10筆文章
	@RequestMapping(value = "forumsAddarticle", params = { "addcontent" }, method = RequestMethod.GET)
	@ResponseBody
	public List<ForumBean> addArticle(
			@RequestParam("addcontent") Integer addcontent) {
		System.out.println(addcontent);
		List<ForumBean> addarticlejson = forumDAO.select_NEXT(addcontent);
		System.out.println(addarticlejson);
		return addarticlejson;
	}

	//顯示會員資料
	@RequestMapping(value = "forumsMember", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<MemberBean> getMember() {
		List<MemberBean> memberjson = memberDAO.select();
		return memberjson;
	}
	
	//發表留言
	@RequestMapping(value = "forumsAddreply", params = { "ReplyMember","ReplyContent","ReplyArticle_ID"}, method = RequestMethod.POST)
	@ResponseBody
	public ArticleReplyBean addreply(
			@RequestParam("ReplyMember") String ReplyMember,
			@RequestParam("ReplyContent") String ReplyContent,
			@RequestParam("ReplyArticle_ID") int ReplyArticle_ID){
		
		ArticleReplyBean arb = new ArticleReplyBean();
		arb.setArticleID(ReplyArticle_ID);
		arb.setMemberAccount(ReplyMember);
		arb.setContent(ReplyContent);
		arb.setPubTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		arb.setEditTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		ArticleReplyBean articleReplyResult = articleReplyDAO.insert(arb);
	
		return articleReplyResult;
	}
	
	
	//發表文章
	@RequestMapping(value = "forumsPublicationArticle", params = {"PublicationMember","PublicationTitle" ,"PublicationGenre","PublicationContent"}, method = RequestMethod.POST)
	@ResponseBody
	public List<ForumBean> PublicationArticle(
			@RequestParam("PublicationMember") String PublicationMember,
			@RequestParam("PublicationTitle") String PublicationTitle,
			@RequestParam("PublicationGenre") String PublicationGenre,
			@RequestParam("PublicationContent") String PublicationContent){
		System.out.println(PublicationMember);
		System.out.println(PublicationTitle);
		System.out.println(PublicationGenre);
		System.out.println(PublicationContent);
	
		ForumBean fb = new ForumBean();
		
		fb.setMemberAccount(PublicationMember);
		fb.setTitle(PublicationTitle);
		fb.setGenre(PublicationGenre);
		fb.setContent(PublicationContent);
		
		fb.setPubTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		fb.setEditTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		ForumBean PublicationArticle = forumDAO.insert(fb);
		List<ForumBean> PublicationArticleResult = new ArrayList<ForumBean>();
		PublicationArticleResult.add(PublicationArticle);
		return PublicationArticleResult;
	}
}
