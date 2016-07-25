package com.kidscodetw.eeit.service.forum;

import java.util.List;

import com.kidscodetw.eeit.dao.forum.ArticleReplyDAO;
import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ArticleReplyBean;





public class ArticleReplyService {

	private ArticleReplyDAO articleReplyDAO;
	public ArticleReplyService(ArticleReplyDAO ArticleReplyDAOHibernate){
		this.articleReplyDAO = ArticleReplyDAOHibernate;
	}

	public List<ArticleReplyBean> select_ALL(){
		List<ArticleReplyBean> result = null;
		result = articleReplyDAO.select_ALL();
		return result;
	}

	public List<ArticleReplyBean> select_memberAccount(String account){
		List<ArticleReplyBean> result = null;
		if(account!=null && account.length()!=0){
			result = articleReplyDAO.select_memberAccount(account);
		}
		return result;
	}

	public ArticleReplyBean select_id(int id){
		ArticleReplyBean result = null;
		if(id!=0){
			result = articleReplyDAO.select_id(id);
		}
		return result;
	}

	public ArticleReplyBean insert(ArticleReplyBean fb){
		ArticleReplyBean result = null;
		if(fb!=null){
			result = articleReplyDAO.insert(fb);
		}
		return result;
	}

	public int delete(int id){
		int result = 0;
		if(id!=0){
			result = articleReplyDAO.delete(id);
		}
		return result;
	}

	
	public ArticleReplyBean update(ArticleReplyBean fb){
		ArticleReplyBean result = null;
		if(fb!=null && fb.getId()!=0){
			result = articleReplyDAO.update(fb);
		}
		return result;
	}

}
