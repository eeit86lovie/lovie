package com.kidscodetw.eeit.controller.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;





@Controller
public class ArticleRankServlet {

	@Autowired
	private ArticleRankDAO articleRankDAO;
	
	
	@RequestMapping(value = "forumsAllLike", method = RequestMethod.GET)
	public String forumAllLikeJsp() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsLike", method = RequestMethod.GET)
	public String forumLikeJsp() {
		return "forum/NewTestForum.jsp";
	}
	
	@RequestMapping(value = "forumsDisLike", method = RequestMethod.GET)
	public String forumDisLikeJsp() {
		return "forum/NewTestForum.jsp";
	}
	
	
	
	
	
	@RequestMapping(value = "forumsAllLike", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ArticleRankBean> selectAllLike() {
		List<ArticleRankBean> allLikejson = articleRankDAO.select_ALL();
		return allLikejson;
	}
	
	
	@RequestMapping(value = "forumsLike", params = { "LikeMember","LikeArticleId","Like" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ArticleRankBean> clickLike(
			@RequestParam("LikeMember") String LikeMember,
			@RequestParam("LikeArticleId") int LikeArticleId,
			@RequestParam("Like") int Like){
		
			ArticleRankBean arb = new ArticleRankBean();
			arb.setArticleID(LikeArticleId);
			arb.setMemberAccount(LikeMember);
			arb.setGood(Like);
		
		if(articleRankDAO.select_Rank_Primarykey(LikeArticleId, LikeMember).isEmpty()){						
			articleRankDAO.insert(arb);
		}else{
			
			List<ArticleRankBean> LikeResult = articleRankDAO.select_Rank_Primarykey(LikeArticleId, LikeMember);
			LikeResult.get(0).setArticleID(LikeArticleId);
			LikeResult.get(0).setBad(LikeResult.get(0).getBad());
			LikeResult.get(0).setGood(Like);
			LikeResult.get(0).setMemberAccount(LikeMember);
			LikeResult.get(0).setReport(LikeResult.get(0).getReport());
			LikeResult.get(0).setReportReason(LikeResult.get(0).getReportReason());			
			articleRankDAO.update(LikeResult.get(0));
		
		}		
		List<ArticleRankBean> articleLikeResult = articleRankDAO.select_totle_good(LikeArticleId, 1);
		return articleLikeResult;
	}
	
	
	@RequestMapping(value = "forumsDisLike", params = { "DisLikeMember","DisLikeArticleId","DisLike" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ArticleRankBean> clickDisLike(
			@RequestParam("DisLikeMember") String DisLikeMember,
			@RequestParam("DisLikeArticleId") int DisLikeArticleId,
			@RequestParam("DisLike") int DisLike){
		
		ArticleRankBean arb = new ArticleRankBean();
		arb.setArticleID(DisLikeArticleId);
		arb.setMemberAccount(DisLikeMember);
		arb.setBad(DisLike);

		if(articleRankDAO.select_Rank_Primarykey(DisLikeArticleId, DisLikeMember).isEmpty()){						
			articleRankDAO.insert(arb);
		}else{
			List<ArticleRankBean> disLikeResult = articleRankDAO.select_Rank_Primarykey(DisLikeArticleId, DisLikeMember);
			disLikeResult.get(0).setArticleID(DisLikeArticleId);
			disLikeResult.get(0).setBad(DisLike);
			disLikeResult.get(0).setGood(disLikeResult.get(0).getGood());
			disLikeResult.get(0).setMemberAccount(DisLikeMember);
			disLikeResult.get(0).setReport(disLikeResult.get(0).getReport());
			disLikeResult.get(0).setReportReason(disLikeResult.get(0).getReportReason());			
			articleRankDAO.update(disLikeResult.get(0));
		}		
		
		List<ArticleRankBean> articleDisLikeResult = articleRankDAO.select_totle_bad(DisLikeArticleId, 1);
		return articleDisLikeResult;
	}

	
}
