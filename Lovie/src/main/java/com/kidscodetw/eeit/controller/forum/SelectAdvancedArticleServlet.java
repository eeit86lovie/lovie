package com.kidscodetw.eeit.controller.forum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;
import com.kidscodetw.eeit.entity.forum.ForumBean;

@Controller
public class SelectAdvancedArticleServlet {
	
	@Autowired
	private ForumDAO forumDAO;
	
	@Autowired
	private ArticleRankDAO articleRankDAO;
	
	@RequestMapping(value = "forumsSelectOneMember", method = RequestMethod.GET)
	public String forumAdvanced1() {
		return "/forum/OneMemberForum.jsp";
	}
	
	@RequestMapping(value = "forumsSelectTitle", method = RequestMethod.GET)
	public String forumAdvanced4() {
		return "/forum/selectTitleForum.jsp";
	}
	
	@RequestMapping(value = "forumsSelectILike", method = RequestMethod.GET)
	public String forumAdvanced2() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsSelectIDisLike", method = RequestMethod.GET)
	public String forumAdvanced3() {
		return "forum/NewTestForum.jsp";
	}
	
	
	
	
	
	//在OneMemberForum.jsp做ajax
	@RequestMapping(value = "forumsSelectOneMember", params = { "MemberAccount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<ForumBean> selectOneMember(
			@RequestParam("MemberAccount") String MemberAccount) {	
		List<ForumBean> selectMemberArticlejson = forumDAO.select_memberAccount(MemberAccount);
		return selectMemberArticlejson;
	}
	
	//導向OneMemberForum.jsp
	@RequestMapping(value = "forumsOneMember/{MemberAccount}", method = RequestMethod.GET)
	public String selectOneMember(@PathVariable("MemberAccount") String MemberAccount, Model model) {
		model.addAttribute("memberAccount", MemberAccount);
		return "/forum/OneMemberForum.jsp";
	}
	

	//在selectTitleForum.jsp做ajax
	@RequestMapping(value = "forumsSelectTitle", params = { "Title" }, method = RequestMethod.POST)
	@ResponseBody
	public List<ForumBean> selectTitle(
			@RequestParam("Title") String Title) {	
		List<ForumBean> selectTitleArticlejson = forumDAO.select_title(Title);
		return selectTitleArticlejson;
	}
	
	//導向selectTitleForum.jsp
	@RequestMapping(value = "forumsTitle/{Title}", method = RequestMethod.GET)
	public String selectTitle(@PathVariable("Title") String Title, Model model) {
		model.addAttribute("title", Title);
		return "/forum/selectTitleForum.jsp";
	}

	
	
	
	


	
	@RequestMapping(value = "forumsSelectILike", params = { "MemberAccount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<ArticleRankBean> select_I_Like(
			@RequestParam("MemberAccount") String MemberAccount) {
	
		 List<ArticleRankBean> selectmemberjson = articleRankDAO.select_memberAccount(MemberAccount);
		 List<ArticleRankBean> selectILikejson = new ArrayList();
		 
		 for(int i =0;i<selectmemberjson.size();i++){
			 if(selectmemberjson.get(i).getGood()==1){
				 selectILikejson.add(selectmemberjson.get(i));
			 }
		 }
		 
		return selectILikejson;
	}

	
	
	@RequestMapping(value = "forumsSelectIDisLike", params = { "MemberAccount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<ArticleRankBean> select_I_Dis_Like(
			@RequestParam("MemberAccount") String MemberAccount) {
	
		 List<ArticleRankBean> selectmemberjson = articleRankDAO.select_memberAccount(MemberAccount);
		 List<ArticleRankBean> selectIDisLikejson = new ArrayList();
		 
		 for(int i =0;i<selectmemberjson.size();i++){
			 if(selectmemberjson.get(i).getBad()==1){
				 selectIDisLikejson.add(selectmemberjson.get(i));
			 }
		 }
		 
		return selectIDisLikejson;
	}
}
