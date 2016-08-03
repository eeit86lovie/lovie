package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import com.kidscodetw.eeit.entity.forum.ForumBean;







public interface ForumDAO {
	
	List<ForumBean> select_ALL();
	
	List<ForumBean> select_NEXT(int count);
	
	List<ForumBean> select_genre(String genre);
	
	List<ForumBean> select_title(String searchKey);
	
	List<ForumBean> select_content(String searchKey);
	
	ForumBean select_id(Integer id);
	
	List<ForumBean> select_memberAccount(String memberAccount);
	
	ForumBean insert(ForumBean bean);

	ForumBean update(ForumBean bean);
	
	int delete(Integer id);
	
	
}
