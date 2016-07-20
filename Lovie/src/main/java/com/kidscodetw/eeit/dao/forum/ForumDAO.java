package com.kidscodetw.eeit.dao.forum;

import java.util.List;

import com.kidscodetw.eeit.entity.forum.ForumBean;







public interface ForumDAO {
	
	List<ForumBean> select_ALL();
	
	List<ForumBean> select_NEXT(int count);
	
	ForumBean select_id(Integer id);
	
	ForumBean select_memberAccount(String memberAccount);
	
	ForumBean insert(ForumBean bean);

	ForumBean update(ForumBean bean);
	
	int delete(Integer id);
	
	
}
