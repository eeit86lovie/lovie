package com.kidscodetw.eeit.service.forum;

import java.util.List;

import com.kidscodetw.eeit.dao.forum.ForumDAO;
import com.kidscodetw.eeit.entity.forum.ForumBean;




public class ForumService {

	private ForumDAO forumDAO;
	public ForumService(ForumDAO forumDAOHibernate){
		this.forumDAO = forumDAOHibernate;
	}
	
	public List<ForumBean> select_ALL(){
		List<ForumBean> result = null;
		result = forumDAO.select_ALL();
		return result;
	}

	public ForumBean select_memberAccount(String account){
		ForumBean result = null;
		if(account!=null && account.length()!=0){
			result = forumDAO.select_memberAccount(account);
		}
		return result;
	}

	public ForumBean select_id(int id){
		ForumBean result = null;
		if(id!=0){
			result = forumDAO.select_id(id);
		}
		return result;
	}

	public ForumBean insert(ForumBean fb){
		ForumBean result = null;
		if(fb!=null){
			result = forumDAO.insert(fb);
		}
		return result;
	}

	public int delete(int id){
		int result = 0;
		if(id!=0){
			result = forumDAO.delete(id);
		}
		return result;
	}

	
	public ForumBean update(ForumBean fb){
		ForumBean result = null;
		if(fb!=null && fb.getId()!=0){
			result = forumDAO.update(fb);
		}
		return result;
	}

}
