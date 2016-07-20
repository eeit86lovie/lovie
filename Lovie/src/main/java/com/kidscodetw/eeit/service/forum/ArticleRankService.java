package com.kidscodetw.eeit.service.forum;

import java.util.List;

import com.kidscodetw.eeit.dao.forum.ArticleRankDAO;
import com.kidscodetw.eeit.entity.forum.ArticleRankBean;


public class ArticleRankService {
	
	private ArticleRankDAO articleRankDAO;
	public ArticleRankService(ArticleRankDAO ArticleRankDAOHibernate){
		this.articleRankDAO = ArticleRankDAOHibernate;
	}

	public List<ArticleRankBean> select_ALL(){
		List<ArticleRankBean> result = null;
		result = articleRankDAO.select_ALL();
		return result;
	}

	public List<ArticleRankBean> select_memberAccount(String account){
		List<ArticleRankBean> result = null;
		if(account!=null && account.length()!=0){
			result = articleRankDAO.select_memberAccount(account);
		}
		return result;
	}
	
	public List<ArticleRankBean> select_totle_good(int articleID, int good){
		
		List<ArticleRankBean> result = null;
		result = articleRankDAO.select_totle_good(articleID, good);		
		return result;
	}
	
	
	public List<ArticleRankBean> select_totle_bad(int articleID, int bad){
		
		List<ArticleRankBean> result = null;
		result = articleRankDAO.select_totle_bad(articleID, bad);		
		return result;
	}
	
	
	public List<ArticleRankBean> select_report(int report){
		
		List<ArticleRankBean> result = null;
		result = articleRankDAO.select_report(report);
		
		return result;
	}
	
	
	public ArticleRankBean insert(ArticleRankBean arb){
		ArticleRankBean result = null;
		if(arb!=null){
			result = articleRankDAO.insert(arb);
		}
		return result;
	}

	public int delete(int articleID){
		int result = 0;
		if(articleID!=0){
			result = articleRankDAO.delete(articleID);
		}
		return result;
	}

	
	public ArticleRankBean update(ArticleRankBean arb){
		ArticleRankBean result = null;
		if(arb!=null){
			result = articleRankDAO.update(arb);
		}
		return result;
	}
}
