package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import com.kidscodetw.eeit.entity.forum.ArticleRankBean;



public interface ArticleRankDAO {

	List<ArticleRankBean> select_ALL();
	
	List<ArticleRankBean> select_Rank_Primarykey(int article, String memberAccount);

	List<ArticleRankBean> select_memberAccount(String memberAccount);

	List<ArticleRankBean> select_totle_good(int articleID, int good);

	List<ArticleRankBean> select_totle_bad(int articleID, int bad);

	List<ArticleRankBean> select_articleID(int articleID);

	ArticleRankBean insert(ArticleRankBean bean);

	ArticleRankBean update(ArticleRankBean bean);

	int delete(int articleID);

	List<ArticleRankBean> select_report(int report);
	
}
