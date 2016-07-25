package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import com.kidscodetw.eeit.entity.forum.ArticleReplyBean;



public interface ArticleReplyDAO {
	
	List<ArticleReplyBean> select_ALL();	
	
	ArticleReplyBean select_id(Integer id);

	List<ArticleReplyBean> select_memberAccount(String memberAccount);
	
	List<ArticleReplyBean> select_articleID(int articleID); 
		
	ArticleReplyBean insert(ArticleReplyBean bean);

	ArticleReplyBean update(ArticleReplyBean bean);
	
	int delete(Integer id);

	
	
}
