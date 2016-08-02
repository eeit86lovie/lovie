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

	public List<ForumBean> select_memberAccount(String account){
		List<ForumBean> result = null;
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

	public List<ForumBean> select_genre(String genre){
		List<ForumBean> result = null;
		if(genre!=null && genre.length()!=0){
			result = forumDAO.select_genre(genre);
		}
		return result;
	}
	
	public List<ForumBean> select_title(String searchKey){
		List<ForumBean> result = null;
		if(searchKey!=null && searchKey.length()!=0){
			result = forumDAO.select_title(searchKey);
		}
		return result;
	}
	
	public List<ForumBean> select_content(String searchKey){
		List<ForumBean> result = null;
		if(searchKey!=null && searchKey.length()!=0){
			result = forumDAO.select_content(searchKey);
		}
		return result;
	}
	
}
